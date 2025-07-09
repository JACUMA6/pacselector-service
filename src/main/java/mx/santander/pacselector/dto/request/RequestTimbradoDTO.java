package mx.santander.pacselector.dto.request;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import mx.santander.pacselector.beans.CifrasControl;


@Getter
@Setter
public class RequestTimbradoDTO implements Serializable {


	private static final long serialVersionUID = 2564814497308200399L;

    /**
     * Identificador de la peticion
     */
    @SerializedName("IdPeticion")
    private String idPeticion;

    /**
     * Fecha en la que se realiza
     * la peticion
     */
    @SerializedName("Fecha")
    private String fecha;

    /**
     * Contador
     */
    @SerializedName("Contador")
    private Long contador;

    /**
     * Listado de respuesta del timbrado de las facturas
     */
    @Valid
    @NotNull
    @SerializedName("Facturas")
    private List<RequestFacturaPacDTO> facturas;

    /**
     *
     * Nombre: cifrasControl
     * Tipo: CifrasControlPacDTO
     * Descripcion: Cifras Control (Totalizador)
     */
    @Valid
    @NotNull
    @SerializedName("CifrasControl")
    private CifrasControl cifrasControl;

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("TimbradoDTO [");
        buffer.append(" IdPeticion=");
        buffer.append(idPeticion);
        buffer.append(" Fecha=");
        buffer.append(fecha);
        buffer.append(" Contador=");
        buffer.append(contador);
        buffer.append(" Facturas=");
        buffer.append(facturas.toString());
        buffer.append(" CifrasControl=");
        buffer.append(cifrasControl);
        buffer.append("]");
        return buffer.toString();
    }
}
