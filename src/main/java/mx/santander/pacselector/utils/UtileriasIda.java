package mx.santander.pacselector.utils;

import mx.santander.pacselector.dto.request.RequestMessageDataBaseDTO;

public final class UtileriasIda {

    /**
     * Constructor de clase
     */
    private UtileriasIda() {
    }

    
    /**
	 * Descripcion   : Metodo para generar {@link RequestMessageDataBaseDTO} 
	 * Creado por    : Diego Colchado S.
	 * Fecha Creacion: 13 sep. 2020
	 * @param codeOperation codigo de operacion
	 * @param typeOperation tipo de operacion
	 * @return RequestMessageDataBaseDTO instanciado
	 */
	public static RequestMessageDataBaseDTO createRequestDTO(String codeOperation, int typeOperation) {
		RequestMessageDataBaseDTO requestDTO = new RequestMessageDataBaseDTO();
		// Llenado de datos generales
		requestDTO.setCodeOperation(codeOperation);
		requestDTO.setTypeOperation(typeOperation);
		
		return requestDTO;
	}


}
