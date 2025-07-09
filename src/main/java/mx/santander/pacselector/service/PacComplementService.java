package mx.santander.pacselector.service;

import mx.santander.pacselector.dto.request.RequestSelladoDTO;
import mx.santander.pacselector.dto.request.RequestTimbradoDTO;

public interface PacComplementService {
	
	/**
	 * 
	 * Descripcion : Metodo ue se encarga de realizar el timbrado de los Comprobantes que se recibieron en el request.
	 * @param Bean de Arquitectura
	 * @param requestData Bean de peticion recibida con los datos de los comprobantes que se enviara al PAC.
	 * @return Devuelve los comprobantes timbrados de tipo RequestTimbradoBean
	 * @throws ErrorFactory Devuelve la propiedad del tipo RequestTimbradoBean
	 */
	
	RequestTimbradoDTO timbrar(RequestSelladoDTO requestData);

}
