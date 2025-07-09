package mx.santander.pacselector.dto.request;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * DTO de solicitud para obtener informacion de Ondemand,
 * los atributos contiene anotaciones de validacion JSR303
 * para que la informacion sea mas precisa,
 */

@Getter
@Setter
public class RequestOndemandDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
     * Atributo de nombre del folder:String
     */
    @NotNull
    @Size(min = 1, max = 150)
    private String folderName;
    /**
     * Atributo de version de ondemand
     */
    @NotNull
    private Double ondemand;
    /**
     * Atributo listas de criterios:List<CriteriaBean>
     */
    @NotNull
    private List<RequestCriteriaDTO> criterias;

    @Override
    public String toString() {
        return "ConsultaOndemandBean [folderName=" + folderName + ", ondemand=" + ondemand + ", criterias=" + criterias
                + "]";
    }
}
