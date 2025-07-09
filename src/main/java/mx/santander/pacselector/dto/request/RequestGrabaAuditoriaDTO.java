package mx.santander.pacselector.dto.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO para el grabado de pista de auditoria, con anotaciones
 * de validacion JSR303 en sus atributos, que describen los
 * cambios realizados en los datos.
 *
 */

@Getter
@Setter
public class RequestGrabaAuditoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** Variable para el id de la tabla afectada*/
    @NotNull
    @Size(min = 1, max = 150)
    private String datoAfectado;
    /** Variable para el valor anterior*/
    @NotNull
    @Size(min = 1, max = 150)
    private String valorAnt;
    /** Variable para el nuevo valor*/
    @NotNull
    @Size(min = 1, max = 150)
    private String valorNvo;
    /** Variable para el nombre del atributo que cambio*/
    @NotNull
    @Size(min = 1, max = 150)
    private String pstrDatoFijo;
    /** Variable para el nombre del servicio*/
    @NotNull
    @Size(min = 1, max = 150)
    private String pstrServicio;
    /** Variable para el codigo de operacion*/
    @NotNull
    @Size(min = 1, max = 150)
    private String pstrCodOper;
    /** Variable para el tipo de operacion*/
    @NotNull
    @Size(min = 1, max = 150)
    private String pstrTipoOper;
    /** Variable para el nombre de la tabla afectada*/
    @NotNull
    @Size(min = 1, max = 150)
    private String pstrTabla;
    /** Variable para el canal de la aplicacion*/
    @NotNull
    @Size(min = 1, max = 150)
    private String pstrCanalApp;
}
