package mx.santander.pacselector.dto.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ResponseAplicadoDTO implements Serializable {
	
	private static final long serialVersionUID = -1892314476236350974L;
	
	/**
	 * Indicador de aplicada la operacion
	 */
	private boolean applicado;
	/**
	 * Descripcion   : Obtiene el valor del atributo applicado
	 * Creado por    : [Diego Colchado S.]
	 * Fecha Creacion: 13 sep. 2020
	 * @return applicado
	 */
	public boolean isApplicado() {
		return applicado;
	}
	/**
	 * Descripcion   : Establece el valor del atributo  applicado
	 * Creado por    : [Diego Colchdo S.]
	 * Fecha Creacion: 13 sep. 2020
	 * @param nombre valor del nombre a establecer  applicado 
	 */
	public void setApplicado(boolean applicado) {
		this.applicado = applicado;
	}


}
