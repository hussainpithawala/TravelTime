package com.synerzip.supplier.sabre.rest.interceptor;

import java.io.IOException;

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

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		request.getHeaders().add("Authorization", "Bearer " + sabreTokenService.getTokenString());
		ClientHttpResponse response = execution.execute(request, body);
		return response;
	}
}
