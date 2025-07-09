/**
 *   Isban Mexico
 *   Clase: BeanPista.java
 *   Descripcion: Bean para almacenar los datos de las pistas de auditoria
 *
 *   Control de Cambios:
 *   1.0 29 Agosto, 2017 - Creacion LFER
 */
package mx.santander.pacselector.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * 
 * DTO contenedor de atributos necesarios para realizar
 * el grabado de pistas de auditoria, cuenta con anotaciones
 * de validacion JSR303 en sus atributos.
 */

public class RequestPistaDTO extends RequestPistaBaseDTO {

	private static final long serialVersionUID = 5611117606139259347L;
	
    /**variable para pstrDatoFijo**/
	@NotNull
	@Size(min = 1, max = 150)
    private String pstrDatoFijo;    
    /**variable para beanPistaCambio**/
	@NotNull
    private RequestPistaCambioBean pistaCambioBean;
    /**variable para beanPistaServicio**/
	@NotNull
    private RequestPistaServicioDTO pistaServicioBean;
	

    /**
     * @return pstrDatoFijo dato fijo para la bitacora.
     */
    public String getPstrDatoFijo() {
        return pstrDatoFijo;
    }

    /**
     * @param pstrDatoFijo dato fijo a establecer.
     */
    public void setPstrDatoFijo(String pstrDatoFijo) {
        this.pstrDatoFijo = pstrDatoFijo;
    }

	/**
	 * @return the beanPistaCambio
	 */
	public RequestPistaCambioBean getBeanPistaCambio() {
		return pistaCambioBean;
	}

	/**
	 * @param pistaCambioBean the beanPistaCambio to set
	 */
	public void setBeanPistaCambio(RequestPistaCambioBean pistaCambioBean) {
		this.pistaCambioBean = pistaCambioBean;
	}

	/**
	 * @return the beanPistaServicio
	 */
	public RequestPistaServicioDTO getBeanPistaServicio() {
		return pistaServicioBean;
	}

	/**
	 * @param pistaServicioBean the beanPistaServicio to set
	 */
	public void setBeanPistaServicio(RequestPistaServicioDTO pistaServicioBean) {
		this.pistaServicioBean = pistaServicioBean;
	}
    
}
