package mx.santander.pacselector.dto.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO para las pista de auditoria
 * solo contiene las variables del
 * servicio de pista de auditoria, con
 * anotaciones de validacion JSR303.
 */

@Setter
@Getter
public class RequestPistaServicioDTO implements Serializable {

	
	private static final long serialVersionUID = -2534753757379437152L;
	
    /**variable para pstrServicio**/
	@NotNull
	@Size(min = 1, max = 150)
    private String pstrServicio;
    /**variable para pstrCodOper**/
	@NotNull
	@Size(min = 1, max = 150)
    private Long pstrCodOper;
    /**variable para pstrTipoOper**/
	@NotNull
	@Size(min = 1, max = 150)
    private int pstrTipoOper;
    /**variable para pstrTabla**/
	@NotNull
	@Size(min = 1, max = 150)
    private String pstrTabla;
    /**variable para pstrCanalApp**/
	@NotNull
	@Size(min = 1, max = 150)
    private String pstrCanalApp;
}
