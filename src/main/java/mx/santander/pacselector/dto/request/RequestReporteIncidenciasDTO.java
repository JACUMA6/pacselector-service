package mx.santander.pacselector.dto.request;

import com.google.gson.annotations.SerializedName;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class RequestReporteIncidenciasDTO implements Serializable {

	private static final long serialVersionUID = 5741651017076708783L;

	/**
     * RFC emisor
     */
    @NotNull
    @SerializedName("RfcEmisor")
    private String rfcEmisor;

    /**
     * RFC Receptor
     */
    @NotNull
    @SerializedName("RfcReceptor")
    private String rfcReceptor;
    /**
     * Listado de incidentes presentados en el sellado
     */
    @NotNull
    @SerializedName("Incidentes")
    private List<String> incidentes;
}
