package mx.santander.pacselector.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class RequestFacturaSelladoDTO implements Serializable {


	private static final long serialVersionUID = 8272720354199911773L;
	
    @NotNull
    private String tipoProducto;
    
    @NotNull
    private Integer contador;    

	@NotNull
    private String base64;

    @NotNull
    private Long idFile;

    @NotNull
    private String uuidInterno; 

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("RequestFacturaSelladoDTO [base64=");
        buffer.append(base64);
        buffer.append(", tipoProducto=");
        buffer.append(tipoProducto);
        buffer.append(", idFile=");
        buffer.append(idFile);
        buffer.append(", uuidInterno=");
        buffer.append(", contador=");
        buffer.append(contador);
        buffer.append("]");
        return buffer.toString();
    }

}
