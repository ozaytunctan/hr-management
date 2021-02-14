package com.tr.hr.interceptors;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class HrClientHttpRequestResponseInterceptor implements ClientHttpRequestInterceptor {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		
		requestLog(request, body);

		request.getHeaders().set("HARDWARE_CPU", "100");

		ClientHttpResponse response = execution.execute(request, body);

		responseLog(response);
		
		return response;
	}

	private void requestLog(HttpRequest request, byte[] body) throws IOException {
		if (logger.isDebugEnabled()) {
			logger.debug("===========================REQUEST BEGIN================================================");
			logger.debug("URI         : {}", request.getURI());
			logger.debug("Method      : {}", request.getMethod());
			logger.debug("Headers     : {}", request.getHeaders());
			logger.debug("Request body: {}", new String(body, StandardCharsets.UTF_8));
			logger.debug("==========================REQUEST END================================================");
		}
	}

	private void responseLog(ClientHttpResponse response) throws IOException {
		if (logger.isDebugEnabled()) {
			logger.debug("============================RESPONSE Begin==========================================");
			logger.debug("Status Code  : {}", response.getStatusCode());
			logger.debug("Status text  : {}", response.getStatusText());
			logger.debug("Headers      : {}", response.getHeaders());
//			logger.debug("Response body: {}", new String(response.getBody().toString()));
			logger.debug("=======================RESPONSE END=================================================");
		}
	}

}
