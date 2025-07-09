package mx.santander.pacselector.service;

import java.util.List;

import mx.santander.pacselector.dto.request.RequestFacturaPacDTO;
import mx.santander.pacselector.dto.request.RequestSelladoDTO;
import mx.santander.pacselector.dto.response.ResponseAplicadoDTO;
import mx.santander.pacselector.exceptions.ExceptionDataAccess;


public interface IServicePac {

    /**
     * Descripcion : Metodo para guardar registro en tabla LogPac para los errores y
     * reproceso
     *
     * @param idFile      Identificador del archivo
     * @param uuidInterno UuidInterno para la factura
     * @param jsonCfdi    Datos en json de la peticion original
     * @param mensaje     Mensaje proporcionado por el PAC
     */
	ResponseAplicadoDTO insertaLogPacErrores(Long idFile, String uuidInterno, String jsonCfdi,
                              String mensaje);
	

    /**
     * Descripcion : Metodo para actualiza el regisro de la factura cuando fue
     * timbrado exitosamente
     * @param jsonCfdi json original de la peticion
     * @return dto con la respuesta {@link Boolean}
     */
    ResponseAplicadoDTO actualizaCFDICorrecto(RequestFacturaPacDTO factura, String jsonCfdi);

    /**
     *
     * Descripcion : Metodo que actualiza el proveedor en la tabla de CFD_MX_MAE_CFDI_DRO en el campo TXT_PAC_NAME.
     * @param requestData Bean de peticion recibida con los datos de los comprobantes que se enviara al PAC.
     * @param idPac Identificador o clave del proveedor del Pac a actualizar en el registro del comprobante.
     * @return Devuelve la propiedad del tipo ResponseAplicadoDTO
     */
    ResponseAplicadoDTO actualizaPacDeFactura(RequestSelladoDTO requestData, String idPac);

    /**
     *
     * Descripcion : Metodo para guardar las incidencias al tener un problema en la invocacion al PAC
     * @param requestData Bean de peticion recibida con los datos de los comprobantes que se enviara al PAC.
     * @param mensajeError Mensaje de error a insertar.
     */
    void insertaErrores(RequestSelladoDTO requestData, String mensajeError);
    
    /**
	 * Descripcion : Metodo para consultar el codigo de cliente y contrato de la factura para enviarse a ondemand
	 * @param asb     {@link ArchitechSessionBean} para arquitectura
	 * @param cfdi Bean del comprobante
	 * @return Lista con los datos consultados
	 * @throws ExceptionDataAccess para el manejo de errores
	 */
	List<String> consultarBucContrato(RequestFacturaPacDTO cfdi);

}
