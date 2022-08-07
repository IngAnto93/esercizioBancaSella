package com.esercizio.posillipo.antonio.esercizio.utils;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.bancasella.posillipo.antonio.esercizio.exception.RestTemplateResponseErrorHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpClient {

	private RestTemplate restTemplate;
	private ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(
			new SimpleClientHttpRequestFactory());
	static Logger logger = LoggerFactory.getLogger(HttpClient.class);

	public HttpClient() {
		restTemplate = new RestTemplate(factory);
		restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
	}

	public <R, T> T doRequest(String method, String url, Map<String, String> headers, R body, Class<T> responseType) {
		HttpMethod httpMethod = HttpMethod.resolve(method.toUpperCase());
		HttpHeaders header = new HttpHeaders();
		headers.forEach((String name, String value) -> {
			header.add(name, value);
		});
		header.add(HttpHeaders.CONTENT_TYPE, "application/json");
		header.add("Auth-Schema", "S2S");
		HttpEntity<R> httpEntity = new HttpEntity<>(body, header);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(body);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		logger.info("Request body: {}", jsonString);
		logger.info("Request headers: {}", header.toString());
		T response = restTemplate.exchange(url, httpMethod, httpEntity, responseType).getBody();
		String jsonStringResponse = null;
		try {
			jsonStringResponse = mapper.writeValueAsString(response);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		logger.info("Response body: {}", jsonStringResponse);
		return response;
	}
}
