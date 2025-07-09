package mx.santander.pacselector.enums;

/**
 * Contiene los codigos y mesnajes de error de PAC Selector,
 * como errores al obtener documentos xml, o realizar una
 * operacion correcta o satisfactoriamente, ademas de describir
 * los errores de conexion, configuracion o recuperacion de folders
 * de ondemand.
 * @author victor.hernandez
 */
public enum CfdiErrorEnum {

    GET_XML("PAC010","Error al obtener el documento"),
    RESP_OK("PACS200","La operaci\u00f3n result\u00f3 exitosa."),
    RESP_NOT_OK("PACS500","La operaci\u00f3n no se realiz\u00f3 correctamente"),
    GET_OD_SERVER("OD0001","Error al conectar con Ondemand"),
    GET_OD_FOLDER("OD0002","Error al recuperar el folder de Ondemand"),
    GET_OD_HITS("OD0003","Error al recuperar los registros del folder"),
    GET_CRIT("OD0004", "Error al configurar la consulta de Ondemand"),
    PAC_ERROR("PAC0400","Error al realizar el timbrado con el PAC"),
    BD_ERROR_UPD("BD0001","Error al actualizar en BD"),
    PAC_ERROR_CONN("PAC0401", "Error al conectar con el PAC"),
    PARSE_ERROR_DATE("PAC0501", "Error al parsear la fecha"),
    PAC_ERROR_RESULT("PAC0502", "Error al procesar respuesta del PAC"),
    PAC_ERROR_CONNECTION("PAC0503", "Error al conectar con el PAC."),
    PAC_ERROR_ACTUALIZAR_CFDI_BD("PAC0504", "Error al actualizar el timbrado en BD"),
    PAC_ERROR_URL_CONNECTION("PAC0505", "La URL del PAC esta incorrecta."),
    PAC_ERROR_HTTP_STATUS_NOOK("PAC0506", "El PAC respondio con htpp status diferente del esperado."),
    JSON_FORMAT_DATE_ERROR("PAC0507", "Error en el formato de la fecha."),
    JSON_PARSE_ERROR("PAC0508", "El formato JSON esta incorrecto."),
    PAC_CANC_ACTUALIZAR_CLAVE("PAC0509", "Error al actualizar la clave del PAC en la Cancelacion"),
    PAC_CANC_ACTUALIZAR_SOLICITUD("PAC0510", "Error al actualizar la Solicitud de las Cancelaciones"),
    PAC_CANC_ACTUALIZAR_CONSULTA("PAC0511", "Error al actualizar la Consulta de las Cancelaciones"),
    PAC_CANC_MATCH_ERROR_PET("PAC0512", "El UUID de la Peticion no coincide con el UUID de Respuesta del PAC"),
    PAC_ERROR_PETICION("PAC0512", "El PAC envio un error en la peticion como respuesta."),
    PAC_CANC_NOT_FOUND_PET("PAC0513", "La peticion de la cancelacion no existe en la BD."),
    PAC_ERROR_SOLICITUD("PAC0514", "El PAC envio un error en la solicitud como respuesta."),
    ERROR_DESCONOCIDO("PAC0700", "Ocurrio un error desconocido."),
    ONDEMAND_ERROR_SAVE("OD0005", "Error al guardar en OnDemand");

    /**
     * Codigo de error
     */
    private String code;
    /**
     * Mensaje de error
     */
    private String message;

    /**
     * Constructor
     * @param code Codigo de error
     * @param message Mensaje de error
     */
    CfdiErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Codigo de error
     * @return Codigo de error
     */
    public String getCode() {
        return code;
    }

    /**
     * Codigo de error
     * @return Codigo de error
     */
    public String getMessage() {
        return message;
    }

}
