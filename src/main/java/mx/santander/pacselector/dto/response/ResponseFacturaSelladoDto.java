package mx.santander.pacselector.dto.response;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResponseFacturaSelladoDto implements Serializable {

	/**
	 * Nombre: serialVersionUID Tipo: long Descripcion: Declaracion de variable
	 * serialVersionUID del tipo long
	 */
	private static final long serialVersionUID = -1280505398420246429L;

	/**
	 * Nombre: tipoProducto Tipo: String Descripcion: Declaracion de variable
	 * tipoProducto del tipo String
	 */
	@NotNull
	private String tipoProducto;

	/**
	 * Nombre: contador Tipo: Integer Descripcion: Declaracion de variable contador
	 * del tipo Integer
	 */
	@NotNull
	private Integer contador;

	/**
	 * Nombre: base64 Tipo: String Descripcion: Declaracion de variable base64 del
	 * tipo String
	 */
	@NotNull
	private String base64;

	/**
	 * Nombre: idFile Tipo: Long Descripcion: Declaracion de variable idFile del
	 * tipo Long
	 */
	@NotNull
	private Long idFile;
	/**
	 * Nombre: uuidInterno Tipo: String Descripcion: Declaracion de variable
	 * uuidInterno del tipo String
	 */
	@NotNull
	private String uuidInterno;
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("RequestFacturaSelladoDTO [base64=");
		buffer.append(base64);
		buffer.append(", tipoProducto=");
		buffer.append(tipoProducto);
		buffer.append(", idFile=");
		buffer.append(idFile);
		buffer.append(", uuidInterno=");
		buffer.append(", contador=");
		buffer.append(contador);
		buffer.append("]");		
		return buffer.toString();
	}

}
