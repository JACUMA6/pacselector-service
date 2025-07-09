package mx.santander.pacselector.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponseComprobanteDatoXmlDTO implements Serializable {

    /**
     * Identidicador del XML
     */
    private Long id;
    /**
     * XML
     */
    private String xml;

    @Override
    public String toString() {
        return "ComprobanteXmlBean [id=" + id + ", xml=" + xml + "]";
    }
}
