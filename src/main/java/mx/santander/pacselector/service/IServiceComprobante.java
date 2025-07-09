package mx.santander.pacselector.service;

import mx.santander.pacselector.dto.request.RequestSelladoDTO;


/**
 * Interface comprobante, declara el timbrado y almacenamiento del CFDI,
 * asi como el xml o xml's obtenidos en consulta a Ondemand.
 */

public interface IServiceComprobante {

    /**
     * Descripcion : Realiza el timbrado del cfdi y lo almacena en ondemand.
     */
    void timbrarGuardarCFDI(RequestSelladoDTO request);
    
}
