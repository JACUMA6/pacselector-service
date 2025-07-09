package mx.santander.pacselector.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.santander.pacselector.dto.request.RequestSelladoDTO;
import mx.santander.pacselector.dto.request.RequestTimbradoDTO;
import mx.santander.pacselector.enums.CfdiErrorEnum;
import mx.santander.pacselector.exceptions.ExceptionDataAccess;
import mx.santander.pacselector.service.IServicePac;
import mx.santander.pacselector.service.PacComplementService;

@Slf4j
@Service
@RequiredArgsConstructor
public class PacComplementServiceImpl implements PacComplementService {

	private final Environment environment;
	private final IServicePac servicePac;

	@Override
	public RequestTimbradoDTO timbrar(RequestSelladoDTO requestData) {
		log.debug("Inicia proceso de timbrado hacia el PAC.");
		RequestTimbradoDTO cfdiTimbrado = null;

		try {
			// URL en String
			String pacUrl = environment.getProperty("pac.url");
			log.debug("URL Pac: " + pacUrl);
			
			// Se crea un builder para la URL
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(pacUrl);
			log.debug("URL builder Pac: " + builder.build().toUri().toString());

			/**
			 * Se crea RestTemplate
			 */
			RestTemplate restTemplate = new RestTemplate();
			String urlfinal = builder.build().toUri().toString();

			/**
			 * Google Parser para los procesamientos de los JSON.
			 */
			Gson gsonParser = new GsonBuilder().disableHtmlEscaping().create();

			// Se crea peticion para agregar los datos a enviar
			String jsonRequest = gsonParser.toJson(requestData);
			log.debug(String.format("Json Request al PAC-> %s", jsonRequest));
			/**
			 * Se configura la entidad para la peticion
			 */
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
			/**
			 * Se ajusta el timeout de 5s a 20s
			 */
			((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(20000);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<>(jsonRequest, headers);
			log.debug("Entity body: " + entity.getBody());
			/**
			 * Se hace la peticion.
			 */
			ResponseEntity<String> response = restTemplate.exchange(urlfinal, HttpMethod.POST, entity, String.class);

			log.debug("Response PAC Http: " + gsonParser.toJson(response));

			log.debug("Response EndPoint PAC StatusCode: " + response.getStatusCode());
			log.debug("Respuesta PAC JSON (Body): " + response.getBody());

			if (HttpStatus.OK.equals(response.getStatusCode())) {
				/**
				 * Deserializa el bean de Timbrado
				 */
				log.debug("Inicia el serializado del JSON Response al Bean de Timbrado.");
				cfdiTimbrado = gsonParser.fromJson(response.getBody(), RequestTimbradoDTO.class);
				log.debug("El serializado del JSON Response al Bean de Timbrado fue exitoso.");
				log.debug(String.format("CFDI Timbrado: %s", cfdiTimbrado));
			}
		} catch (RestClientException e) {
			log.error(String.format("Error de Conexion con el PAC. Detalle: %s", e.getMessage()), e);
			/**
			 * Modificado por: VASS Fecha: 17/05/2022 Se ajusta mensaje de error para
			 * guardar un codigo de error separado por pipe y su descripcion en la tabla de
			 * log pac (CFD_MX_LOG_PAC).
			 */
			 servicePac.insertaErrores(requestData, String.format("%s|%s", CfdiErrorEnum.PAC_ERROR_CONNECTION.getCode(),
					CfdiErrorEnum.PAC_ERROR_CONNECTION.getMessage()));
			/**
			 * Dispara el error.
			 */
			throw new ExceptionDataAccess(ServicePacImpl.class.getName(), CfdiErrorEnum.PAC_ERROR_CONNECTION.getCode(),
					CfdiErrorEnum.PAC_ERROR_CONNECTION.getMessage(), e);
		} catch (JsonSyntaxException e) {

			log.error(String.format("Error del parseo del JSON Response del PAC. Detalle: %s", e.getMessage()), e);
			/**
			 * Modificado por: VASS Fecha: 18/10/2022 Se ajusta mensaje de error para
			 * guardar un codigo de error separado por pipe y su descripcion en la tabla de
			 * log pac (CFD_MX_LOG_PAC).
			 */
			servicePac.insertaErrores(requestData, String.format("%s|%s", CfdiErrorEnum.PAC_ERROR_RESULT.getCode(),
					CfdiErrorEnum.PAC_ERROR_RESULT.getMessage()));

			/**
			 * Dispara el error.
			 */
			throw new ExceptionDataAccess(ServicePacImpl.class.getName(), CfdiErrorEnum.PAC_ERROR_RESULT.getCode(),
					CfdiErrorEnum.PAC_ERROR_RESULT.getMessage(), e);
		}

		log.debug("Finaliza proceso de timbrado hacia el PAC.");
		return cfdiTimbrado;
	}

}
