package mx.santander.pacselector.dto.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO de respuesta base que extiende de ResponseMessageDTO.
 * 
 * Payload base
 * 
 * @param <T> Payload de respuesta
 */
public class ResponseBaseDTO<T> implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 1621082081219719657L;

	/**
	 * Estandar de codigo de respuesta
	 */
	private ResponseCodeDTO responseCode;
	/**
	 * Clase generica
	 */
	private transient T response;
	/**
	 * Define el exito de la peticion
	 */
	private boolean ok;
	/**
	 * Validaciones
	 */
	private List<String> validations;
	
	/**
	 * Constructor
	 */
	public ResponseBaseDTO() {
		validations = new ArrayList<>();
		responseCode = new ResponseCodeDTO();
	}
	
	/**
	 * Estandar de codigo de respuesta
	 * @return
	 */
	public ResponseCodeDTO getResponseCode() {
		return responseCode;
	}

	/**
	 * Estandar de codigo de respuesta
	 * @param responseCode
	 */
	public void setResponseCode(ResponseCodeDTO responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * Clase generica
	 * 
	 * @return
	 */
	public T getResponse() {
		return response;
	}

	/**
	 * Clase generica
	 * @param response
	 */
	public void setResponse(T response) {
		this.response = response;
	}

	/**
	 * Define el exito de la peticion
	 * 
	 * @return
	 */
	public boolean isOk() {
		return ok;
	}

	/**
	 * Define el exito de la peticion
	 * 
	 * @param ok
	 */
	public void setOk(boolean ok) {
		this.ok = ok;
	}

	/**
	 * Validaciones
	 * @return
	 */
	public List<String> getValidations() {
		List<String> tmp = new ArrayList<>();
		if (this.validations != null) {
			tmp.addAll(this.validations);
		}
		return tmp;
	}

	/**
	 * Validaciones
	 * @param validations
	 */
	public void setValidations(List<String> validations) {
		List<String> tmp = new ArrayList<>();
		if (validations != null) {
			tmp.addAll(validations);
		}
		this.validations = tmp;
	}
}
