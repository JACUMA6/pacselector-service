package mx.santander.pacselector.dto.response;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResponseSelladoDto implements Serializable {

	/**
	 * 
	 * Nombre: serialVersionUID Tipo: long Descripcion: Declaracion de variable
	 * serialVersionUID del tipo long
	 */
	private static final long serialVersionUID = 8796455965176007337L;
	
	/**
	 * 
	 * Nombre: idPeticion Tipo: String Descripcion: Declaracion el ID de la peticion
	 * de tipo String
	 */
	@NotNull
	private String idPeticion;

	/**
	 * 
	 * Nombre: fecha Tipo: String Descripcion: Define la Fecha de la peticion de
	 * tipo String
	 */
	@NotNull
	private String fecha;

	/**
	 * 
	 * Nombre: contador Tipo: Integer Descripcion: Define Contador de facturas que
	 * viajan dentro de la peticion de tipo Integer
	 */
	@NotNull
	private Integer contador;


	/**
	 * 
	 * Nombre: facturas Tipo: List<RequestFacturaSelladoDto> Descripcion: Define
	 * una lista de comprobantes dentro de la peticion que se timbraran, es de tipo
	 * List<RequestFacturaSelladoBean>
	 */
	@NotNull
	private List<ResponseFacturaSelladoDto> facturas;
	
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("RequestSelladoDTO [fecha=");
		buffer.append(fecha);
		buffer.append(", idPeticion=");
		buffer.append(idPeticion);
		buffer.append(", contador=");
		buffer.append(String.valueOf(contador));
		buffer.append(", facturas=");
		buffer.append(facturas);
		buffer.append("]");
		return buffer.toString();
	}

}
