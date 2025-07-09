package mx.santander.pacselector.dto.response;

import java.io.Serializable;

/**
 * 
 * DTO response de codigo, al momento de realizar un proceso en Pac Selector
 * contiene mensaje, nivel de codigo, descripcion y mas informacion
 * haciendo que la informacion sea mas detallada y util.
 * 
 * Response Code
 * 
 * @author Neoris
 *
 */
public class ResponseCodeDTO implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 332569712584872267L;

	/**
	 * Codigo de mensaje
	 */
	private String code;
	/**
	 * Mensaje
	 */
	private String message;
	/**
	 * Nivel del mensaje
	 */
	private String level;
	/**
	 * Descripcion del mensaje
	 */
	private String description;
	/**
	 * Mas informacion del codigo
	 */
	private String moreInfo;

	/**
	 * Mensaje
	 * @return
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * Mensaje
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Codigo de mensaje
	 * @return
	 */
	public String getCode() {
		return code;
	}
	/**
	 * Codigo de mensaje
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Nivel del mensaje
	 * @return
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * Nivel del mensaje
	 * @param level
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * Descripcion del mensaje
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Descripcion del mensaje
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Mas informacion del codigo
	 * @return
	 */
	public String getMoreInfo() {
		return moreInfo;
	}
	/**
	 * Mas informacion del codigo
	 * @param moreInfo
	 */
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
	
}
