/******************************************************************
 *
 * This code is for the Complaints service project.
 *
 *
 * © 2018, Complaints Management All rights reserved.
 *
 *
 ******************************************************************/

package co.cpl.utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

/**
 * Utility for abstract complexity in the interactions with restful services
 *
 * @author jmunoz
 * @since 06/09/2018
 * @version 1.0
 */

public class RestTemplateHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateHelper.class.getCanonicalName());


	@Autowired
	private RestTemplate rt;

	private ObjectMapper om;

	/**
	 * empty constructor that configure the component responsible of the objects
	 * transformations processed by this class
	 *
	 */

	public RestTemplateHelper(RestTemplate rt) {
		om = new ObjectMapper();
		om.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
		VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY);
		this.rt = rt;
	}

	@Bean
	public RestTemplate getRestemplate() {
		return new RestTemplate();
	}

	public <T> ResponseEntity<T> processRequestBase(String url, Map<String, String> obj, Class<T> response,
													HttpMethod method) {

		LOGGER.info("request received");

		HttpHeaders headers = getBasicHeaders();
		HttpEntity<String> request;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		try {
			request = new HttpEntity<>(om.writeValueAsString(obj), headers);
			String uri = (obj == null) ? url : builder.buildAndExpand(obj).toUri().toString();
			LOGGER.info("rt status {}", rt);

			return rt.exchange(uri, method, request, response);

		} catch (HttpClientErrorException httpError) {
			return new ResponseEntity<>(httpError.getStatusCode());
		} catch (Exception e) {
			LOGGER.error("processRequest (String url, Map<String, String> obj, Class<T> response,HttpMethod method)",
					e);
			return null;
		}
	}

	public <T> ResponseEntity<T> processRequestBase(String url, Object request, Class<T> response, HttpMethod method) {

		HttpHeaders headers = getBasicHeaders();

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

		HttpEntity<?> req = new HttpEntity<>(request, headers);

		String uri = (request == null) ? url : builder.buildAndExpand(request).toUri().toString();
		return rt.exchange(uri, method, req, response);
	}

	public <T> ResponseEntity<T> processRequestBase(String url, Map<String, String> obj, Class<T> response,
													HttpMethod method, Map<String, String> queryParams) {

		HttpHeaders headers = getBasicHeaders();
		HttpEntity<String> request;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

		for (Map.Entry<String, String> entry : queryParams.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			builder.queryParam(key, value);
		}

		try {
			request = new HttpEntity<>(om.writeValueAsString(obj), headers);
			String uri = (obj == null) ? builder.toUriString() : builder.buildAndExpand(obj).toUri().toString();
			return rt.exchange(uri, method, request, response);

		} catch (HttpClientErrorException httpError) {
			return new ResponseEntity<>(httpError.getStatusCode());
		} catch (Exception e) {
			LOGGER.error("processRequest (String url, Map<String, String> obj, Class<T> response,HttpMethod method,"
					+ " Map<String, String> queryParams)", e);
			return null;
		}
	}

	public <T> ResponseEntity<T> processRequestBase(String url, List<Map<String, String>> obj, Class<T> response,
													HttpMethod method) {

		HttpHeaders headers = getBasicHeaders();

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		try {
			HttpEntity<String> request = new HttpEntity<>(om.writeValueAsString(obj), headers);
			String uri = (obj.isEmpty()) ? url : builder.buildAndExpand(obj).toUri().toString();
			return rt.exchange(uri, method, request, response);
		} catch (HttpClientErrorException httpError) {
			return new ResponseEntity<>(httpError.getStatusCode());
		} catch (Exception e) {
			LOGGER.error(
					"processRequest (String url, List<Map<String, String>> obj, Class<T> response,HttpMethod method)",
					e);
			return null;
		}
	}

	private HttpHeaders getBasicHeaders() {

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);

		return headers;
	}

	public <T> ResponseEntity<T> processRequestGet(String url, Class<T> response) {
		return processRequestBase(url, new HashMap<>(), response, HttpMethod.GET);
	}

	public <T> ResponseEntity<T> processRequestPost(String url, Map<String, String> obj, Class<T> response) {
		return processRequestBase(url, obj, response, HttpMethod.POST);
	}

	public <T> ResponseEntity<T> processRequestPostObject(String url, Map<String, Object> obj, Class<T> response) {
		return processRequestBase(url, obj, response, HttpMethod.POST);
	}

	public <T> ResponseEntity<T> processRequestPatch(String url, Map<String, String> obj, Class<T> response) {
		return processRequestBase(url, obj, response, HttpMethod.PATCH);
	}

	public <T> ResponseEntity<T> processRequestGet(String url, Map<String, String> obj, Class<T> response) {
		return processRequestBase(url, obj, response, HttpMethod.GET);
	}

	public <T> ResponseEntity<T> processRequestGet(String url, Map<String, String> obj, Class<T> response,
												   Map<String, String> queryParams) {
		return processRequestBase(url, obj, response, HttpMethod.GET, queryParams);
	}

	public <T> ResponseEntity<T> processRequestPut(String url, Map<String, String> obj, Class<T> response) {
		return processRequestBase(url, obj, response, HttpMethod.PUT);
	}

	public <T> ResponseEntity<T> processRequestPost(String url, List<Map<String, String>> obj, Class<T> response) {
		return processRequestBase(url, obj, response, HttpMethod.POST);
	}

	public <T> ResponseEntity<T> processRequestPostExtended(String url, Object body, Class<T> response) {
		return processRequestBase(url, body, response, HttpMethod.POST);
	}

	public <T> ResponseEntity<T> processRequestPatchExtended(String url, Object body, Class<T> response) {
		return processRequestBase(url, body, response, HttpMethod.PATCH);
	}
}
