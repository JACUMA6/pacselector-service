package mx.santander.pacselector.service;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import mx.santander.pacselector.utils.ValidationsAppConstants;


/**
 * Descripcion: Define una clase base para la factura timbrada
 *
 */

@Getter
@Setter
public class BaseFacturaPac implements Serializable {

	private static final long serialVersionUID = 1091745772949800194L;

	/**
     * Contador
     */
    @SerializedName("Contador")
    protected Long contador;

    /**
     * Folio generado por el SAT
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @SerializedName("FolioSat")
    @Pattern(regexp = ValidationsAppConstants.ALFANUMERICO_ESP+"{0,100}")
    protected String folioSat;
    /**
     * Identificador del archivo de carga
     */
    @NotNull
    @SerializedName("IdFile")
    protected Long idFile;
    /**
     * Identificador del registro para manejo interno
     */
    @NotNull
    @SerializedName("UUIDInterno")
    protected String uuidInterno;
    /**
     * XML sellado
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Pattern(regexp = ValidationsAppConstants.ALFANUMERICO_ESP+"{0,1000000}")
    @SerializedName("FacturaXMLSellada")
    protected String facturaXMLSellada;
    /**
     * Identificador del PAC que lo proceso
     */
    @NotNull
    @SerializedName("IdPac")
    protected String idPac;

    /**
     * Tipo de producto
     */
    @NotNull
    @SerializedName("TipoProducto")
    protected String tipoProducto;
}
