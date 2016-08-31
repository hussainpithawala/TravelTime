package com.synerzip.supplier.sabre.rest.interceptor;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.service.SabreTokenService;

@Component
public class AuthenticatingGetInterceptor implements ClientHttpRequestInterceptor {

	@Autowired
	private SabreTokenService sabreTokenService;

	private static final Logger logger = LoggerFactory.getLogger(AuthenticatingGetInterceptor.class);
	
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		String sabreToken = sabreTokenService.getTokenString();
		logger.info("Sabre token Bearer " + sabreToken);
		request.getHeaders().add("Authorization", "Bearer " + sabreToken);
		ClientHttpResponse response = execution.execute(request, body);
		return response;
	}
}
