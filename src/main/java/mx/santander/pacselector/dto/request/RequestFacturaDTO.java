package mx.santander.pacselector.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/*
 * DTO de solicitud para obtener xml de factura en Ondemand,
 * agregando anotaciones requeridas para sus atributos.
* */

@Getter
@Setter
public class RequestFacturaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
     * Atributo de folioSat:String
     */
    @NotNull
    @Size(min = 1, max = 150)
    private String folioSat;
    /**
     * Atributo de version de Ondemand:Double
     */
    @NotNull
    @DecimalMin(value = "8.4", inclusive = true)
    @DecimalMax(value = "10.1", inclusive = true)
    private Double ondemandVersion;
    /**
     * Atributo de idOndemand:Long
     */
    @Min(value = 1)
    @Max(value = 999999999)
    private Long idCfdi;
    /**
     * Atributo de carpeta a buscar:String
     */
    @NotNull
    @Size(min = 1, max = 150)
    private String carpeta;

    @Override
    public String toString() {
        return "FacturaRequestBean [folioSat=" + folioSat + ", ondemandVersion=" + ondemandVersion + ", idCfdi="
                + idCfdi + ", carpeta=" + carpeta + "]";
    }
}
