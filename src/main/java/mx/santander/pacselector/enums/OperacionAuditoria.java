/**
 *   Isban Mexico
 *   Clase: OperacionAuditoria.java
 *   Descripcion: clase Enum para las operaciones de bitacorizacion
 *
 *   Control de Cambios:
 *   1.0 29 agosto, 2017 - Creacion LFER
 */
package mx.santander.pacselector.enums;
/**
 * Objetivo: Clase Enum para las operaciones de bitacorizacion
 * Justificacion: Creacion del Aplicativo Gestion de Administracion Fatca – Clase nueva
 */

public enum OperacionAuditoria {
	
    /**ACCESO_APLICACION*/
    ACCESO(1,"ACCESO_APLIC"),
    /**PRUEBA COMPROBANTE*/
    COMPROBANTE(2,"COMPROBANTE"),
    /** CONSULTA FOLDERS */
    CONSULTA_FOLDER(3, "CONS_FOLDERS"),
    /** ALTA DE FACTURA */
    ALTA_FACTURA(4, "ALTA_CFDI"),
    /** TIMBRADO */
    TIMBRADO(5,"TIMBRADO"),
    
    /** SOLICITUD DE CANCELACION DE FACTURAS */
    CANCELACION_SOLICITUD(6, "CANC_SOLICITUD"),
    
    /** CONSULTA DE CANCELACION DE FACTURAS */
    CANCELACION_CONSULTA(7, "CANC_CONSULTA");

    /**
     * Id de la operacion, este debe ser el mismo al registrado en el catalogo
     * de operaciones
     */
    private Integer idCodigoOperacion;
    /**
     * Descripcion del nombre de la pista de auditoria
     */
    private String descripcion;
    /**
     *
     * @param idCodigoOperacion id del codigo de operacion
     * @param descripcion descripcion de operacion
     */
    OperacionAuditoria(int idCodigoOperacion, String descripcion) {
        this.idCodigoOperacion = idCodigoOperacion;
        this.descripcion = descripcion;
    }

    /**
     * @return the idCodigoOperacion
     */
    public Integer getIdCodigoOperacion() {
        return idCodigoOperacion;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

}
