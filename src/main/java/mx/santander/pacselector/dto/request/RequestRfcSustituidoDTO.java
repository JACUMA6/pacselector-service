package mx.santander.pacselector.dto.request;

import com.google.gson.annotations.SerializedName;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RequestRfcSustituidoDTO implements Serializable {


	private static final long serialVersionUID = -461480341156033940L;
	
	/**
     * RFC original del comprobante
     */
    @NotNull
    @SerializedName("RfcOrigen")
    private String rfcOrigen;
    /**
     * RFC final del comprobante
     */
    @NotNull
    @SerializedName("RfcFinal")
    private String rfcFinal;
    /**
     * Detalle de lo procesado.
     */
    @NotNull
    @SerializedName("Detalle")
    private String detalle;

    @Override
    public String toString() {
        return "RfcSustituido [rfcOrigen=" + rfcOrigen + ", rfcFinal=" + rfcFinal + ", detalle=" + detalle + "]";
    }
}
