package mx.santander.pacselector.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;



@Getter
@Setter
public class RequestCriteriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
     * Atributo de campo a buscar:String
     */
    @NotNull
    @Size(min = 1, max = 150)
    private String campo;
    /**
     * Atributo de Operador para la consulta:String
     */
    @NotNull
    @Size(min = 1, max = 150)
    private String operador;
    /**
     * Atributo de valor1 para la consulta:String
     */
    @NotNull
    @Size(min = 1, max = 150)
    private String valor1;
    /**
     * Atributo de valor2 para la consulta, es opcional:String
     */
    @Size(min = 1, max = 150)
    private String valor2;

}
