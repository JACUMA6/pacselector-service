package mx.santander.pacselector.dto.request;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import mx.santander.pacselector.service.BaseFacturaPac;

@Getter
@Setter
public class RequestFacturaPacDTO extends BaseFacturaPac implements Serializable {


	private static final long serialVersionUID = -932016341336981209L;

	/**
     * Lista de metadatos para guardar en ondemand el XML
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Valid
    @SerializedName("MetadatosOndemand")
    private List<RequestMetadatoOndemandDTO> metadatosOndemand;

    /**
     * Reporte de incidentes
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Valid
    @SerializedName("ReporteIncidentes")
    private RequestReporteIncidenciasDTO reporteIncidentes;

    /**
     * Datos de sellado
     */
    @Valid
    @SerializedName("Sellado")
    private RequestSelladoDTO sellado;
    /**
     * Datos de sustitucion de RFC
     */
    @Valid
    @SerializedName("RfcSustituido")
    private RequestRfcSustituidoDTO rfcSustituido;

    /**
     * Base64
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @SerializedName("Base64")
    private String base64;

    @Override
    public String toString() {
        return "FacturaDTO [contador= " + contador + ", folioSat=" + folioSat + ", idFile=" + idFile + ", uuidInterno="
                + uuidInterno + ", facturaXMLSellada=" + facturaXMLSellada + ", idPac=" + idPac + ", tipoProducto="
                + tipoProducto + ", metadatosOndemand=" + metadatosOndemand + ", reporteIncidentes=" + reporteIncidentes
                + ", sellado=" + sellado + ", rfcSustituido=" + rfcSustituido + ", base64=" + base64 + "]";
    }
}
