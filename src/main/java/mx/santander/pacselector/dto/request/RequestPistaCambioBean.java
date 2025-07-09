package mx.santander.pacselector.dto.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * Bean para la pista de auditoria
 * solo contiene las variables de cambio, con anotaciones de validaciones JSR303.
 */

@Setter
@Getter
public class RequestPistaCambioBean implements Serializable  {


	private static final long serialVersionUID = 1L;
	
	/**variable para pstrObjAnt**/
    private transient Object pstrObjAnt;
    /**variable para pstrObjMod**/
    private transient Object pstrObjMod;
    /**variable para datoAfectado**/
    @NotNull
	@Size(min = 1, max = 150)
    private String datoAfectado;
    /**variable para valorAnt**/
    @NotNull
	@Size(min = 1, max = 150)
    private String valorAnt;
    /**variable para valorMod**/
    @NotNull
	@Size(min = 1, max = 150)
    private String valorMod;

}
