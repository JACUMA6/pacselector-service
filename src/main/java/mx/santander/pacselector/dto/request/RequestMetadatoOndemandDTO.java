package mx.santander.pacselector.dto.request;

import com.google.gson.annotations.SerializedName;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RequestMetadatoOndemandDTO implements Serializable {

	private static final long serialVersionUID = 2703242065336675935L;

	/**
     * Nombre del campo del metadato
     */
    @NotNull
    @SerializedName("GroupFieldName")
    private String groupFieldName;

    /**
     * Valor del campo del metadato
     */
    @NotNull
    @SerializedName("GroupFieldValue")
    private String groupFieldValue;

    @Override
    public String toString() {
        return "MetadatoOndemandDTO [groupFieldName=" + groupFieldName + ", groupFieldValue=" + groupFieldValue + "]";
    }
}
