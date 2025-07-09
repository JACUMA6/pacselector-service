package mx.santander.pacselector.utils;

import java.util.List;
import java.util.Optional;

import mx.santander.pacselector.dto.request.RequestMetadatoOndemandDTO;

public final class UtilMetadatosOndemand {

    /**
     * Constructor privado. No instanciar directamente.
     */
    private UtilMetadatosOndemand() {
    }

    /**
     * Metodo de utilería para validar que el BUC del cliente sea enviado a ondemand
     * @param metadatos Lista de información de datos de la factura que se envía a ondemand
     * @param campo Al que se le actualizará su valor
     * @param valor Cadena de texto que se enviara como ondemand para el metadato indicado
     * @return Lista de metadatos actualizada
     */
    public static List<RequestMetadatoOndemandDTO> agregarMetadato(List<RequestMetadatoOndemandDTO> metadatos, String campo, String valor) {

        Optional<RequestMetadatoOndemandDTO> optBean = metadatos.stream().filter(data -> campo.equals(data.getGroupFieldName()))
                .findFirst();
        if(optBean.isPresent()) {
            optBean.get().setGroupFieldValue(valor);
        } else {
            RequestMetadatoOndemandDTO nuevoBean = new RequestMetadatoOndemandDTO();
            nuevoBean.setGroupFieldName(campo);
            nuevoBean.setGroupFieldValue(valor);
            metadatos.add(nuevoBean);
        }

        return metadatos;
    }
}
