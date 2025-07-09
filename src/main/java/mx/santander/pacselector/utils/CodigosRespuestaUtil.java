package mx.santander.pacselector.utils;


import mx.santander.pacselector.dto.response.ResponseCodeDTO;
import mx.santander.pacselector.enums.CfdiErrorEnum;

/**
 * Clase contenedora de los codigos mas comunes de respuesta de la aplicacion.
 * 
 * @author victor.hernandez
 *
 */
public final class CodigosRespuestaUtil {

	/**
	 * Constructor privado
	 */
	private CodigosRespuestaUtil() {
		
	}
	
	/**
	 * Devuelve el codigo exitoso generico
	 * Agrega el codigo, el nivel, el mensaje y la descripcion
	 * Devuelve el codigo generado
	 * @return Codigo exitoso generico
	 */
	public static ResponseCodeDTO exitoGenerico() {
		ResponseCodeDTO response = new ResponseCodeDTO();
		
		response.setCode(CfdiErrorEnum.RESP_OK.getCode());
		response.setLevel("INFO");
		response.setDescription(CfdiErrorEnum.RESP_OK.getMessage());
		response.setMessage(CfdiErrorEnum.RESP_OK.getMessage());
		
		return response;
	}
	
	/**
	 * Devuelve el codigo fallido generico
	 * Agrega el codigo, el nivel, el mensaje y la descripcion
	 * Devuelve el codigo generado
	 * @return Codigo fallido generico
	 */
	public static ResponseCodeDTO fallidoGenerico() {
		ResponseCodeDTO response = new ResponseCodeDTO();
		
		response.setCode(CfdiErrorEnum.RESP_NOT_OK.getCode());
		response.setLevel("ERROR");
		response.setDescription(CfdiErrorEnum.RESP_NOT_OK.getMessage());
		response.setMessage(CfdiErrorEnum.RESP_NOT_OK.getMessage());
		
		return response;
	}
	/**
	 * Devuelve el codigo fallido generico
	 * Agrega el codigo, el nivel, el mensaje y la descripcion
	 * Devuelve el codigo generado
	 * @param code Codigo de respuesta
	 * @param message Mensaje de respuesta
	 * @return Codigo fallido generico
	 */
	public static ResponseCodeDTO fallidoGenericoConParametros(String code, String message) {
		ResponseCodeDTO response = new ResponseCodeDTO();
		
		response.setCode(code);
		response.setLevel("ERROR");
		response.setDescription(message);
		response.setMessage(message);
		
		return response;
	}
}
