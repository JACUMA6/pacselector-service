package mx.santander.pacselector.dto.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CifrasControl implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String totalRecibidos;
    private String totalCorrectos;
    private String totalIncidencias;
}
