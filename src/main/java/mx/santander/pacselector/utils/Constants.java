package mx.santander.pacselector.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class Constants {

    /**
     * Variable de un String ERR_ADMIN para los codigos de error
     */
    public static final String ERR_ADMIN = "ERR_ADMIN";
    /**
     * Constante para el log
     */
    public static final String LOG_ERROR = "Error: ";
    /**
     * Constante para log de error de IDA
     */
    public static final String LOG_ERROR_IDA = "Error al ejecutar el query en BD";
    /**
     * Cadena vacia
     */
    public static final String CADENA_VACIA = "";
    /**
     * Nombre campo Folio SAT Viejo Ondemand.
     */
    public static final String OLD_ONDEMAND_FOLIO_SAT_FIELD = "FolioSAT";
    /**
     * Nombre campo Folio SAT Nuevo Ondemand.
     */
    public static final String NEW_ONDEMAND_FOLIO_SAT_FIELD = "FOLIO_SAT";
    /**
     * Constante de patron de fecha
     */
    public static final String DATE_PATTERN = "MM/dd/yyyy HH:mm:ss";

    /**Define un formato Fecha y Hora yyyy-MM-ddTHH:mm:ss del PAC*/
    public static final String PAC_FORMAT_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss";

    /**Define un formato Fecha y Hora yyyy-MM-dd HH:mm:ss para la BD*/
    public static final String BD_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * Constante de formato de fecha
     */
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_PATTERN);
    /**
     * Constante de codigo de actualizacion de pac en comprobante
     */
    public static final String CONSTANT_COD_UPDT_COMPROB_PAC_QUERY = "COD_UPDT_COMPROBANTE_PAC_QUERY";
    /**
     * Constante de codigo de actualizacion de pac en comprobante
     */
    public static final String CONSTANT_COD_SLCT_ID_CFDI_QUERY = "COD_SLCT_ID_CFDI_QUERY";
    /**
     * Constante de codigo de actualizacion de pac en comprobante
     */
    public static final String CONSTANT_COD_INSRT_LOG_PAC_QUERY = "COD_INSRT_LOG_PAC_QUERY";
    /**
     * Constante de codigo de actualizacion de esttus en comprobante
     */
    public static final String CONSTANT_COD_UPDT_CFDI_STATUS_QUERY = "COD_UPDT_CFDI_STATUS_QUERY";
    /**
     * Constante de codigo de actualizacion de folio sat en comprobante
     */
    public static final String CONSTANT_COD_UPDT_CFDI_FOLIO_SAT_QUERY = "COD_UPDT_CFDI_FOLIO_SAT_QUERY";
    /**
     * Constante de codigo de actualizacion de contador en archivo
     */
    public static final String CONSTANT_COD_UPDT_ARCH_COUNT_QUERY = "COD_UPDT_ARCH_COUNT_QUERY";
    /**
     * Constante de codigo de actualizacion de contador en archivo
     */
    public static final String CONSTANT_COD_UPDT_ARCH_STATUS_QUERY = "COD_UPDT_ARCH_STATUS_QUERY";
    /**
     * Constante de codigo de recuperar cifras control
     */
    public static final String CONSTANT_COD_CIFRAS_CONTROL_QUERY = "COD_CIFRAS_CONTROL_QUERY";

    /**
     * Constante de codigo de recuperar los detalles de una cancelacion
     */
    public static final String CONSTANT_COD_SLCT_CANC_DET_QUERY = "COD_SLCT_CANC_DET_QUERY";

    /**
     * Constante de codigo de recuperar una Peticion de cancelacion.
     */
    public static final String CONSTANT_COD_PET_CANC_QUERY = "COD_PET_CANC_QUERY";

    /**
     * Constante de codigo de recuperar un archivo de cancelacion
     */
    public static final String CONSTANT_COD_ARCH_CANC_QUERY = "COD_ARCH_CANC_QUERY";

    /**
     * Constante de codigo de asignacion del PAC que atendera la cancelacion.
     */
    public static final String CONSTANT_COD_UPDT_CANC_ASIGN_PAC_QUERY = "COD_UPDT_CANC_ASIGN_PAC_QUERY";

    /**
     * Constante de codigo de actualizacion de datos de la cancelacion.
     */
    public static final String CONSTANT_COD_UPDT_CANC_QUERY = "COD_UPDT_CANC_QUERY";

    /**
     * Constante de codigo de actualizacion de datos de la cancelacion para Estatus Vigente (EP).
     */
    public static final String CONSTANT_COD_UPDT_CANC_EP_QUERY = "COD_UPDT_CANC_EP_QUERY";

    /**
     * Constante de codigo de actualizacion de datos para la cancelacion rechazada (NC, SR).
     */
    public static final String CONSTANT_COD_UPDT_CANC_RECHAZADO_QUERY = "COD_UPDT_CANC_RECHAZADO_QUERY";

    /**
     * Constante de codigo de actualizacion de datos de la cancelacion para Estatus Cancelado (CA, PV, SA).
     */
    public static final String CONSTANT_COD_UPDT_CANC_CA_QUERY = "COD_UPDT_CANC_CA_QUERY";

    /**
     * Constante de codigo de actualizacion de datos de la cancelacion para Estatus No Encontrado (NE).
     */
    public static final String CONSTANT_COD_UPDT_CANC_NO_ENCONTRADO_QUERY = "COD_UPDT_CANC_NO_ENCONTRADO_QUERY";

    /**
     * Constante de codigo de actualizacion de la peticion de las cancelaciones (Cifras control, Estatus, Fecha Resp)
     * con los datos que devolvio el PAC.
     */
    public static final String CONSTANT_COD_UPDT_CANC_PET_PAC = "COD_UPDT_CANC_PET_PAC_QUERY";

    /**
     * Constante de codigo de actualizacion del archivo de las cancelaciones (Cifras control, Estatus, Fecha Resp)
     * con los datos que devolvio el PAC.
     */
    public static final String CONSTANT_COD_UPDT_CANC_ARCH_PAC_QUERY = "COD_UPDT_CANC_ARCH_PAC_QUERY";

    /**
     * Constante de codigo de actualizacion de datos de la factura de la cancelacion.
     */
    public static final String CONSTANT_COD_UPDT_CANC_FACT_QUERY = "COD_UPDT_CANC_FACT_QUERY";

    /**
     * Constante de codigo de actualizacion de datos de la factura de la cancelacion
     * y establece la fecha de cancelacion.
     */
    public static final String CONSTANT_COD_UPDT_CANC_FACT_CA_QUERY = "COD_UPDT_CANC_FACT_CA_QUERY";

    /**
     * Constante de codigo de insercion del log pac de Cancelaciones.
     */
    public static final String CONSTANT_COD_INSRT_CANC_LOG_PAC_QUERY = "COD_INSRT_CANC_LOG_PAC_QUERY";

    /**
     * Constante de codigo de actualizacion (reseteo) de las cancelaciones con un error de peticion.
     */
    public static final String CONSTANT_COD_UPDT_CANC_RESET_PET_QUERY = "COD_UPDT_CANC_RESET_PET_QUERY";

    /**
     * Nombre: CFDI_ESTATUS_ERROR
     * Tipo:   String
     * Descripcion: Declaracion de variable CFDI_ESTATUS_ERROR del tipo String
     */
    public static final String CFDI_ESTATUS_ERROR = "E";

    /**
     * Define una constante de Turbo PAC
     */
    public static final String CVE_TURBOPAC = "TPac";

    /**
     * Define una constante de COD_SOLICITUD_NO_ENCONTRADA
     */
    public static final String COD_SOLICITUD_NO_ENCONTRADA = "1003";

    /**
     * Nombre: TURBO_PAC_ID
     * Tipo:   long
     * Descripcion: Declaracion de variable TURBO_PAC_ID del tipo long
     */
    public static final long TURBO_PAC_ID = 1;

    /**
     * Nombre: TAG_CFG_CANC_PAC_SOLIC
     * Tipo:   String
     * Descripcion: Declaracion de variable TAG_CFG_CANC_PAC_SOLIC del tipo String
     */
    public static final String TAG_CFG_CANC_PAC_SOLIC = "PAC_CANC_SOLIC_URL";

    /**
     * Nombre: TAG_CFG_CANC_PAC_CONSULTA
     * Tipo:   String
     * Descripcion: Declaracion de variable TAG_CFG_CANC_PAC_CONSULTA del tipo String
     */
    public static final String TAG_CFG_CANC_PAC_CONSULTA = "PAC_CANC_CONSULTA_URL";

    /**
     * Nombre: CONSTANT_COD_TOTAL_COMPROBANTES_PENDIENTES_QUERY
     * Tipo:   String
     * Descripcion: Declaracion de variable CONSTANT_COD_TOTAL_COMPROBANTES_PENDIENTES_QUERY del tipo String
     */
    public static final String CONSTANT_COD_TOTAL_COMPROBANTES_PENDIENTES_QUERY = "COD_TOTAL_COMPROBANTES_PENDIENTES_QUERY";

    /**
     * Constructor privado sin par&aacute;metros
     * para evitar instanciar la clase.
     */
    private Constants() {
        throw new UnsupportedOperationException("Utility class");
    }
}
