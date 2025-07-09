package mx.santander.pacselector.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.santander.pacselector.dto.request.RequestFacturaPacDTO;
import mx.santander.pacselector.dto.request.RequestFacturaSelladoDTO;
import mx.santander.pacselector.dto.request.RequestGrabaAuditoriaDTO;
import mx.santander.pacselector.dto.request.RequestSelladoDTO;
import mx.santander.pacselector.dto.request.RequestTimbradoDTO;
import mx.santander.pacselector.dto.response.ResponseAplicadoDTO;
import mx.santander.pacselector.enums.CfdiErrorEnum;
import mx.santander.pacselector.enums.OperacionAuditoria;
import mx.santander.pacselector.exceptions.ExceptionDataAccess;
import mx.santander.pacselector.service.DAOOndemand;
import mx.santander.pacselector.service.IServiceComprobante;
import mx.santander.pacselector.service.IServicePac;
import mx.santander.pacselector.service.PacComplementService;
import mx.santander.pacselector.utils.ConstantesBita;
import mx.santander.pacselector.utils.Constants;
import mx.santander.pacselector.utils.UtilMetadatosOndemand;
import mx.santander.pacselector.utils.Utilerias;
import mx.santander.pacselector.utils.UtilsBitacora;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServiceComprobanteImpl implements IServiceComprobante {
	
	private final DAOOndemand daoOndemand;
	private final ServicePacImpl pacDao;
	private final PacComplementService pacComplementDao;
	

	@Override
    public void timbrarGuardarCFDI(RequestSelladoDTO request) {
        String threadName = Thread.currentThread().getName();
        long threadId = Thread.currentThread().getId();
        String idPeticion = request.getIdPeticion();

        log.info("[INFO] Start timbrarGuardarCFDI [{}][{}][{}]", threadName, threadId, idPeticion);


        ResponseAplicadoDTO result = new ResponseAplicadoDTO();
        RequestTimbradoDTO response = new RequestTimbradoDTO();

        try {
            // 1. Actualiza el PAC asociado a la factura
            ResponseAplicadoDTO dao = pacDao.actualizaPacDeFactura(request, Constants.CVE_TURBOPAC);

            if (dao.isApplicado()) {
                log.info("Inicia Proceso de Timbrado en BO");
                
                // 2. Envia al PAC
                response = pacComplementDao.timbrar(request);
                log.info("Finaliza Proceso de Timbrado en BO");

                // 3. Auditoría: primer registro
                RequestGrabaAuditoriaDTO audit = UtilsBitacora.generaBeanBitacoro(
                    ConstantesBita.ID_OPER_ALTA,
                    OperacionAuditoria.ALTA_FACTURA.getDescripcion(),Constants.CVE_TURBOPAC
                );
                
                // Pendiente de Resolver la Clase BitacoraUtil
                //BitacoraUtil.bitacora().grabaAuditoria(audit);

                // 4. Procesar la respuesta del PAC
                this.proccessResponse(response, request);

                // 5. Auditoría: segundo registro
                RequestGrabaAuditoriaDTO gab = UtilsBitacora.generaBeanBitacoro(
                    ConstantesBita.ID_OPER_ALTA,
                    OperacionAuditoria.ALTA_FACTURA.getDescripcion(), Constants.CVE_TURBOPAC
                );
                //log.info("Se va a guardar en bitácora");
                //BitacoraUtil.bitacora().grabaAuditoria(gab);

                result.setApplicado(true);
            } else {
                result.setApplicado(false);
            }

        } catch (ExceptionDataAccess e) {
            log.error(Constants.LOG_ERROR, e);
        }

        log.info("timbrarGuardarCFDI ------------------------- END");
    }
	
	/**
	 * Descripcion : Metodo para procesar la respuesta del pac 
	 * Modificacion : Se integra la nueva estructura del bean de peticion de los comprobantes del CFDI 4.0
	 * @param response {@link RequestTimbradoDTO} con lo procesado
	 } @param requestData Bean de peticion recibida con los datos de los comprobantes que se enviara al PAC.
	 * @return true si el proceso se completo correctamete y false si no lo fue 
	 */
	private ResponseAplicadoDTO proccessResponse(RequestTimbradoDTO response, RequestSelladoDTO request) {
		log.debug("Iniciando proccessResponse");
		ResponseAplicadoDTO result = new ResponseAplicadoDTO();
		for(RequestFacturaPacDTO cfdi : response.getFacturas()) {
			try {
				List<String> datos = pacDao.consultarBucContrato(cfdi);
				log.info("Ondemand - Factura UUID SAT: " + cfdi.getFolioSat());
				log.info("Ondemand - Factura UUID Interno: " + cfdi.getUuidInterno());
				log.info("Ondemand - CODIGO_CLIENTE: " + datos.get(0)); 
				log.info("Ondemand - CONTRATO: " + datos.get(1));
				log.info("Ondemand - PERIODO: " + datos.get(2));
				
				cfdi.setMetadatosOndemand(UtilMetadatosOndemand.agregarMetadato(cfdi.getMetadatosOndemand(), "CODIGO_CLIENTE", datos.get(0)));
				cfdi.setMetadatosOndemand(UtilMetadatosOndemand.agregarMetadato(cfdi.getMetadatosOndemand(), "CONTRATO", datos.get(1)));
				cfdi.setMetadatosOndemand(UtilMetadatosOndemand.agregarMetadato(cfdi.getMetadatosOndemand(), "PERIODO", datos.get(2)));
				result.setApplicado(this.procesaFactura(cfdi, request));
			} catch (ExceptionDataAccess e) {
				log.error(Constants.LOG_ERROR, e);
			}
		}
		log.debug("Finalizo proccessResponse");
		return result;
	}

	/**
	 * Descripcion   : Metodo para pocesar cada factura recibida 
	 * @param cfdi {@link RequestFacturaPacBean} con el contenido de lo procesado
	 * @param asb {@link ArchitechSessionBean} para arquitectura
	 * @param request Bean de peticion recibida con los datos de los comprobantes que se enviaron al PAC.
	 * @return Devuelve true si el procesado fue exitoso o false si hubo incidentes
	 * @throws ExceptionDataAccess Se dispara en caso de error.
	 */
	private boolean procesaFactura(RequestFacturaPacDTO cfdi, RequestSelladoDTO request) throws ExceptionDataAccess {
		log.debug("Inicia procesaFactura");
		String jsonOrig = null;
		try {
			List<RequestFacturaSelladoDTO> listSello = request.getFacturas().stream().filter(r -> r.getUuidInterno().equals(cfdi.getUuidInterno())).collect(Collectors.toList());
			RequestFacturaSelladoDTO sellado = listSello.get(0);
			
			// Se recupera el json original
			byte[] jsonByte = Base64.getDecoder().decode(sellado.getBase64());
			jsonOrig = new String(jsonByte, StandardCharsets.UTF_8);
			log.info("Json original: " + jsonOrig);
			
			// Revisa si hay uncidentes
			if (cfdi.getReporteIncidentes() != null) {
				log.info("Hubo incidentes");
				// Registrar incidentes en CFD_MX_LOG_PAC
				pacDao.insertaLogPacErrores(cfdi.getIdFile(), cfdi.getUuidInterno(), jsonOrig,
						Utilerias.unifyListStringIncidentes(cfdi.getReporteIncidentes().getIncidentes()));
				return false;
			} else {
				// Se actualiza en BD y guardar en ondemand
				daoOndemand.saveDocument(cfdi);
				pacDao.actualizaCFDICorrecto(cfdi, jsonOrig);
				log.info("Fue correcto, se actualiza y guarda en ondemand");
				log.debug("Finaliza procesaFactura devolviendo true");
				return true;
			}
		} catch (ExceptionDataAccess e) {
			/**
			 * Obtiene los bytes del XML en base64
			 */
			byte[] buffer = cfdi.getFacturaXMLSellada().getBytes(StandardCharsets.UTF_8);
			/**
			 * Decodifica los byte en base 64
			 */
			
			//buffer = Base64Utils.decode(buffer);
			
			/**
			 * Genera el String XML.
			 */
			String value = new String(buffer, StandardCharsets.UTF_8);
			pacDao.insertaLogPacErrores(cfdi.getIdFile(), cfdi.getUuidInterno(),
					value, 
					String.format("%s|%s",CfdiErrorEnum.ONDEMAND_ERROR_SAVE.getCode(), CfdiErrorEnum.ONDEMAND_ERROR_SAVE.getMessage()));			
			log.error(Constants.LOG_ERROR, e);
			log.debug("Finaliza procesaFactura devolviendo false");
			return false;
		}
	}

}
