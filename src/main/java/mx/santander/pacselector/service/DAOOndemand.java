package mx.santander.pacselector.service;

import java.util.List;

import mx.santander.pacselector.dto.request.RequestFacturaPacDTO;
import mx.santander.pacselector.dto.request.RequestOndemandDTO;
import mx.santander.pacselector.dto.response.ResponseOndemandDTO;
import mx.santander.pacselector.exceptions.ExceptionDataAccess;

public interface DAOOndemand {

	/**
	 * 
	 * Descripcion   : Metodo para recuperar la informacion del folder
	 * @param consulta datos para la consulta de Ondemand: ConsultaOndemandBean
	 * @param asb  Bean de arquitectura:ArchitechSessionBean
	 * @return List<RespuestaOndemandDTO>
	 * @throws ExceptionDataAccess para le manejo de errores
	 * 
	 */
	List<ResponseOndemandDTO> consultaFolder(List<RequestOndemandDTO> consulta) throws ExceptionDataAccess;

	/**
	 * Descripcion   : Metodo para guardar el xml en Ondemand 
	 * @param factura Factura
	 * @param asb Bean de arquitectura:ArchitechSessionBean 
	 * @throws ExceptionDataAccess para el manejo de errorees
	 */
	void saveDocument(RequestFacturaPacDTO factura) throws ExceptionDataAccess;
	
}
