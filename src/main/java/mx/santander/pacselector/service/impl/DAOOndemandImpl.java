package mx.santander.pacselector.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.santander.pacselector.dto.request.RequestFacturaPacDTO;
import mx.santander.pacselector.dto.request.RequestOndemandDTO;
import mx.santander.pacselector.dto.response.ResponseOndemandDTO;
import mx.santander.pacselector.exceptions.ExceptionDataAccess;
import mx.santander.pacselector.service.DAOOndemand;
import mx.santander.pacselector.utils.UtilOnDemand;

/**
 * 
 * Clase de implementacion que incluye todos los metodos para
 * las consultas en Ondemand.
 *
 */

@Slf4j
@Service
public class DAOOndemandImpl implements DAOOndemand {
	
	/**
	 * 
	 * Nombre: utilOnDemand
	 * Tipo: UtilOnDemand
	 * Descripcion: Declaracion de variable utilOnDemand del tipo UtilOnDemand
	 */
	private UtilOnDemand utilOnDemand = new UtilOnDemand();

	@Override
	public List<ResponseOndemandDTO> consultaFolder(List<RequestOndemandDTO> consulta) throws ExceptionDataAccess {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveDocument(RequestFacturaPacDTO factura) throws ExceptionDataAccess {
		// TODO Auto-generated method stub
		
	}
		
	
}
