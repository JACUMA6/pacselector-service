package mx.santander.pacselector.controller;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.santander.pacselector.dto.request.RequestSelladoDTO;
import mx.santander.pacselector.dto.request.RequestTimbradoDTO;
import mx.santander.pacselector.service.impl.ServiceComprobanteImpl;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/comprobante")
public class ComprobanteControllerRestService {
	
	private final ServiceComprobanteImpl serviceComprobante;
	
	
	@GetMapping("/healhCheck")
	public ResponseEntity<String> healhCheck(){
		return new ResponseEntity<>("{\"status\":\"OK\"}", HttpStatus.OK);
	}
	
	
	 @ResponseBody
     @PostMapping(value = "/timbrar", produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<RequestTimbradoDTO> timbrarCFDI(@Valid @RequestBody RequestSelladoDTO request){
             log.info("[INFO] Se inicia proceso de timbrado, id peticion: " + request.getIdPeticion());

             HttpStatus status = HttpStatus.OK;
             log.debug(": " + ToStringBuilder.reflectionToString(request));

             // Se realiza la invocacion para Timbrar
             log.debug("Se realiza la invocacion para Timbrar al BO");
             RequestTimbradoDTO response = serviceComprobante.timbrarGuardarCFDI(request);

             log.debug("El timbrado se proceso con exito. Se envia respuesta al solicitante.");
             log.info(String.format("Response status: %s", status.value()));
             log.info("Finaliza proceso de timbrado de los comprobantes.");
             return ResponseEntity.status(status).body(response);
     }
}
