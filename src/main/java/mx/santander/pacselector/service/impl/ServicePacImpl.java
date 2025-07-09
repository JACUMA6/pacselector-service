package mx.santander.pacselector.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.santander.pacselector.dto.CifrasControlResumenDTO;
import mx.santander.pacselector.dto.request.RequestFacturaPacDTO;
import mx.santander.pacselector.dto.request.RequestFacturaSelladoDTO;
import mx.santander.pacselector.dto.request.RequestMessageDataBaseDTO;
import mx.santander.pacselector.dto.request.RequestSelladoDTO;
import mx.santander.pacselector.dto.response.ResponseAplicadoDTO;
import mx.santander.pacselector.enums.CfdiErrorEnum;
import mx.santander.pacselector.exceptions.ExceptionDataAccess;
import mx.santander.pacselector.model.CfdMxLogPac;
import mx.santander.pacselector.model.CfdMxMaeCfdiDro;
import mx.santander.pacselector.repository.ArchivoCifrasControlRepository;
import mx.santander.pacselector.repository.CfdMxMaeCfdiDroRepository;
import mx.santander.pacselector.repository.LogPacRepository;
import mx.santander.pacselector.service.IServicePac;
import mx.santander.pacselector.utils.Canal;
import mx.santander.pacselector.utils.Constants;
import mx.santander.pacselector.utils.UtileriasIda;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServicePacImpl implements IServicePac {

	private final CfdMxMaeCfdiDroRepository facturaRepository;
	private final ArchivoCifrasControlRepository archivoRepository;
	private final LogPacRepository logPacRepository;
	private final CfdMxMaeCfdiDroRepository cfdiRepository;
	
	@Override
	@Transactional
	public ResponseAplicadoDTO actualizaPacDeFactura(RequestSelladoDTO requestData, String idPac) {
		log.info("Inicia actualización de la Clave del PAC para todos los comprobantes.");
		log.info("Tipo Producto: {}, ID Petición: {}, Pac: {}", requestData.getTipoProducto(),
				requestData.getIdPeticion(), requestData.getPac());

		ResponseAplicadoDTO response = new ResponseAplicadoDTO();

		try {
			
			RequestMessageDataBaseDTO requestDto = UtileriasIda
					.createRequestDTO(Constants.CONSTANT_COD_UPDT_COMPROB_PAC_QUERY, 0);
			
			List<RequestFacturaSelladoDTO> facturas = requestData.getFacturas();
			int totalActualizados = 0;

			for (RequestFacturaSelladoDTO factura : facturas) {
				int updated = facturaRepository.updateCfdi(idPac, factura.getUuidInterno());
				totalActualizados += updated;
			}

			/*
			log.debug(String.format(
					"ID Peticion: %s, Total de Comprobantes Recibidos: %s, Total de Comprobantes actualizados en BD: %s",
					requestData.getIdPeticion(), requestData.getFacturas().size(), totalActualizados));

			response.setApplicado(totalActualizados == facturas.size());

			if (!response.isApplicado()) {
				throw new RuntimeException(CfdiErrorEnum.BD_ERROR_UPD.getCode());
			}
			*/

		} catch (Exception e) {
			log.error(Constants.LOG_ERROR_IDA, e);
		}

		return response;
	}
	


	@Override
	@Transactional
	public ResponseAplicadoDTO insertaLogPacErrores(Long idFile, String uuidInterno, String txtJsonFact,
			String txtMsgResp) {

		log.debug(String.format("Inicia insercion de registro en el Log PAC. IdFile: %s, UUID Interno: %s, JSON: %s",
				idFile, uuidInterno, txtJsonFact));
		ResponseAplicadoDTO applied = new ResponseAplicadoDTO();

		try {

			// Creando request para recuperar el id de la BD del comprobante
			Optional<CfdMxMaeCfdiDro> cfdiOpt = facturaRepository.findByUuidInterno(uuidInterno);
			if (cfdiOpt.isEmpty()) {
				throw new ExceptionDataAccess(getClass().getName(), Canal.CANAL_BD_ARQ.getCanal(),
						"No se encontró el CFDI con UUID: " + uuidInterno);
			}

			log.debug("Se encontro %s registro para UUID:", uuidInterno);

			CfdMxMaeCfdiDro cfdi = cfdiOpt.get();

			// 2. Insertar registro en tabla log
			CfdMxLogPac logPac = new CfdMxLogPac();
			logPac.setIdCfdi(Integer.parseInt((uuidInterno)));
			logPac.setIdFile(idFile);
			logPac.setTxtJsonFact(txtJsonFact);
			logPac.setTxtMsgResp(txtMsgResp);

			logPacRepository.save(logPac);

			// 3. Actualizar CFDI con estatus de error
			cfdi.setEstatus(Constants.CFDI_ESTATUS_ERROR);
			facturaRepository.save(cfdi);

			validaCifrasControl(idFile);

			applied.setApplicado(true);

		} catch (Exception e) {
			log.error("Error durante inserción del log PAC", e);
			applied.setApplicado(false);
			throw new ExceptionDataAccess(getClass().getName(), "ERR_LOG_INSERT", Constants.LOG_ERROR_IDA, e);
		}

		log.debug("Finaliza inserción de error en Log PAC.");
		return applied;

	}

	@Transactional
	private void validaCifrasControl(Long idFile) {
		log.debug("Inicia validacion de Cifras Control");

		boolean regOk = false;

		if (regOk) {
			// Actualiza el total de registros procesados del archivo
			int registroActualizado = archivoRepository.actualizarCifrasControl(idFile);
			log.debug(String.format("Se guarda cifra de control de registro OK, para idFile -> %s", idFile));
			log.debug(String.format("Total de registros actualizados en este registro -> %s", registroActualizado));

		} else {
			// Update Archivo agregando no procesando al contador
			int registroActualizado = archivoRepository.actualizarCifrasIncidencias(idFile);
			log.debug(
					String.format("Se guarda cifra de control de registro con INCIDENCIAS, para idFile -> %s", idFile));
			log.debug(String.format("Total de registros actualizados en este registro -> %s", registroActualizado));
		}

		log.debug(Constants.CONSTANT_COD_CIFRAS_CONTROL_QUERY);

		CifrasControlResumenDTO resumenRegistros = archivoRepository.obtenerResumenCifrasControl(idFile);
		int pendientes = archivoRepository.contarComprobantesPendientes(idFile);

		// Obtiene el total de comprobantes para saber si proceso todos o no para marcar
		// el archivo como Completado.
		log.info("Resumen archivo {}: Total Procesados = {}, Correctos = {}, Incidentes = {}, Pendientes = {}", idFile,
				resumenRegistros.getTotal(), resumenRegistros.getCorrectos(), resumenRegistros.getIncidentes(),
				pendientes);

		if (pendientes == 0) {
			int afectados = archivoRepository.actualizarEstatusArchivoFinalizado(idFile);
			log.debug("Archivo {} marcado como TERMINADO (estatus = 3), filas afectadas: {}", idFile, afectados);
		}

		log.debug("Finaliza validación de cifras de control para archivo {}", idFile);

	}

	@Override
	public ResponseAplicadoDTO actualizaCFDICorrecto(RequestFacturaPacDTO factura, String jsonCfdi) {
		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * @param idFile   id del archivo al que pertenece el comprobante
	 * @param idCfdi   id del comprobante
	 * @param jsonCfdi json original de la peticion
	 * @param mensaje  mensaje de incidencias
	 */

	@Override
	public void insertaErrores(RequestSelladoDTO requestData, String mensajeError) {

		log.debug("Inicia la insercion de Log PAC para todos los comprobantes.");

		// Se ajusto para que obtenga los comprobantes de la nueva estructura del
		// request.
		for (RequestFacturaSelladoDTO cfdi : requestData.getFacturas()) {
			this.insertaLogPacErrores(cfdi.getIdFile(), cfdi.getUuidInterno(),
					new String(Base64.getDecoder().decode(cfdi.getBase64()), StandardCharsets.UTF_8), mensajeError);
		}
		log.debug("Finaliza la insercion de Log PAC para todos los comprobantes.");

	}

	/**
	 * Descripcion : Metodo para consultar el codigo de cliente y contrato de la
	 * factura para enviarse a ondemand
	 * 
	 * @param cfdi Bean del comprobante
	 * @return Lista con los datos consultados
	 * @throws ExceptionDataAccess para el manejo de errores
	 */
	public List<String> consultarBucContrato(RequestFacturaPacDTO cfdi) throws ExceptionDataAccess {
		log.debug("Inicia consulta de Buc y Contrato para UUID: {}", cfdi.getUuidInterno());
		List<String> datos = Arrays.asList("", "", "");

		try {
			RequestMessageDataBaseDTO requestDTO = UtileriasIda
					.createRequestDTO(Constants.CONSTANT_COD_CIFRAS_CONTROL_QUERY, 0);
			Optional<CfdMxMaeCfdiDro> request = cfdiRepository.findContratoByUuid(cfdi.getUuidInterno());

			if (request.isPresent()) {
				CfdMxMaeCfdiDro item = request.get();
				return Arrays.asList(item.getCodCli(), item.getCntraToRec(), item.getPerioRec());
			}

		} catch (Exception e) {
			log.error(Constants.LOG_ERROR_IDA, e);
			throw new RuntimeException("Error al consultar contrato", e);
		}

		return datos;
	}
}
