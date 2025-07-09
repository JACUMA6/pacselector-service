package mx.santander.pacselector.dto.request;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.santander.pacselector.utils.Utilerias;


@Getter
@Setter
@NoArgsConstructor
public class RequestSelladoDTO implements Serializable {

    private static final long serialVersionUID = -554377682964731619L;

	@NotNull
    private String fecha;

    @NotNull
    private String pac;

    @NotNull
    private String tipoProducto;

    @NotNull
    private Integer contador;

    @NotNull
    private List<RequestFacturaSelladoDTO> facturas;

    @NotNull
    private String idPeticion;

    /**
     *
     * Descripcion : Obtiene los comprobantes o facturas
     * @return Devuelve la propiedad del tipo List<RequestFacturaSelladoBean>
     */
    public List<RequestFacturaSelladoDTO> getFacturas() {
        return Utilerias.clone(facturas);
    }

    /**
     *
     * Descripcion : Establece los comprobantes o facturas
     * @param facturas Lista de facturas o comprobantes de tipo List<RequestFacturaSelladoBean>
     */
    public void setFacturas(List<RequestFacturaSelladoDTO> facturas) {
        this.facturas = Utilerias.clone(facturas);
    }


    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("RequestSelladoDTO [fecha=");
        buffer.append(fecha);
        buffer.append(", idPeticion=");
        buffer.append(idPeticion);
        buffer.append(", tipoProducto=");
        buffer.append(tipoProducto);
        buffer.append(", contador=");
        buffer.append(String.valueOf(contador));
        buffer.append(", facturas=");
        buffer.append(facturas);
        buffer.append("]");
        return buffer.toString();
    }
}
