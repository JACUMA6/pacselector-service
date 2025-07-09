package mx.santander.pacselector.dto.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * DTO contenedor de atributos necesarios para realizar
 * el grabado de pistas de auditoria, con anotaciones de validacion JSR303.
 *
 */

@Setter
@Getter
public class RequestPistaBaseDTO implements Serializable {

	private static final long serialVersionUID = 5246564723929628988L;
	
    /**variable para nombreClase**/
    @NotNull
	@Size(min = 1, max = 150)
    private String nombreClase;
    
}
