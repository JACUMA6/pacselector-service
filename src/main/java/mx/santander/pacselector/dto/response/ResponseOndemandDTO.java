package mx.santander.pacselector.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseOndemandDTO implements Serializable {

	/**
	 * Atributo Serial version UID
	 */
	private static final long serialVersionUID = 3605596756762217000L;
	/**
	 * Artibuto de docId:String
	 */
	private String docId;
	/**
	 * Atributo de Document name: String
	 */
	private String documentName;
	/**
	 * RFC Emisor:String
	 */
	private String rfcEmisor;
	/**
	 * RFC Receptor:String
	 */
	private String rfcReceptor;
	/**
	 * Contrato:String
	 */
	private String contrato;
	/**
	 * Codigo cliente
	 */
	private String codigoCliente;
	/**
	 * Numero de cuenta
	 */
	private String numCuenta;
	/**
	 * Moneda
	 */
	private String moneda;
	/**
	 * Periodo
	 */
	private String periodo;
	/**
	 * Fecha timbrado
	 */
	private String fechaTimbrado;
	/**
	 * Fecha carga
	 */
	private String fechaCarga;
	/**
	 * Folio SAT
	 */
	private String folioSat;
	/**
	 * Tipo CFDI
	 */
	private String tipoCFDI;
	/**
	 * Atributo de folder:String
	 */
	private String folder;
	/**
	 * Atributo de Ondemand:Double
	 */
	private Double ondemand;
	

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RespuestaOndemandBean [docId=" + docId + ", documentName=" + documentName + ", rfcEmisor=" + rfcEmisor
				+ ", rfcReceptor=" + rfcReceptor + ", contrato=" + contrato + ", codigoCliente=" + codigoCliente
				+ ", numCuenta=" + numCuenta + ", moneda=" + moneda + ", periodo=" + periodo + ", fechaTimbrado="
				+ fechaTimbrado + ", fechaCarga=" + fechaCarga + ", folioSat=" + folioSat + ", tipoCFDI=" + tipoCFDI
				+ ", folder=" + folder + ", ondemand=" + ondemand + "]";
	}

}
