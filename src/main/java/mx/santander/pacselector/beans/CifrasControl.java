package mx.santander.pacselector.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CifrasControl implements Serializable {

	private static final long serialVersionUID = 5135136192145228309L;

	/**
     *
     * Nombre: totalRecibidos
     * Tipo: Integer
     * Descripcion: Total de comprobantes a timbrar recibidos en el pac
     */
    @NotNull
    @SerializedName("TotalRecibidos")
    private Integer totalRecibidos;

    /**
     *
     * Nombre: totalCorrectos
     * Tipo: Integer
     * Descripcion: Total de comprobantes que fueron timbrados correctamente en el pac
     */
    @NotNull
    @SerializedName("TotalCorrectos")
    private Integer totalCorrectos;

    /**
     *
     * Nombre: totalIncidentes
     * Tipo: Integer
     * Descripcion: Total de incidentes de los comprobantes que Integerentaron timbrarse
     * y tuvieron errores en el pac.
     */
    @NotNull
    @SerializedName("TotalIncidentes")
    private Integer totalIncidentes;

    /**
     *
     * Nombre: totalRFCSustituidos
     * Tipo: Integer
     * Descripcion: Total de RFC sustituidos que fueron reemplazados a los comprobantes
     * que tuvieron problemas para timbrarse con el Rfc que traia el comprobante en el pac.
     */
    @NotNull
    @SerializedName("TotalRFCSustituidos")
    private Integer totalRFCSustituidos;

    @Override
    public String toString() {
        return String.format(
                "CifrasControl[TotalRecibidos = %s, TotalCorrectos = %s, TotalIncidentes = %s, TotalRFCSustituidos = %s]",
                totalRecibidos, totalCorrectos, totalIncidentes, totalRFCSustituidos);
    }
}
