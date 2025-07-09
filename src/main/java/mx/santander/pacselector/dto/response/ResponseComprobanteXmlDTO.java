package mx.santander.pacselector.dto.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResponseComprobanteXmlDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
     * Lista de XMLs
     */
    private List<ResponseComprobanteDatoXmlDTO> xmls;

    /**
     * Lista de XMLs
     * @return Lista de XMLs
     */
    public List<ResponseComprobanteDatoXmlDTO> getXmls() {
        List<ResponseComprobanteDatoXmlDTO> tmp = new ArrayList<>();
        if (this.xmls != null) {
            tmp.addAll(this.xmls);
        }
        return tmp;
    }

    /**
     * Lista de XMLs
     * @param xmls Lista de XMLs
     */
    public void setXmls(List<ResponseComprobanteDatoXmlDTO> xmls) {
        List<ResponseComprobanteDatoXmlDTO> tmp = new ArrayList<>();
        if(xmls != null) {
            tmp.addAll(xmls);
        }
        this.xmls = tmp;
    }
}
