package com.synerzip.supplier.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.synerzip.supplier.sabre.model.flights.auth.AuthResponse;

@Component
public class SabreTokenService {
	private Logger logger = LoggerFactory.getLogger(SabreTokenService.class);
	private final ReentrantLock lock = new ReentrantLock();

	@Autowired
	private Environment env;

	@Autowired
	@Qualifier("basic")
	private RestTemplate restTemplate;

	private Date expirationDate = null;

	private AtomicBoolean invalid = new AtomicBoolean(true);

	private AtomicReference<AuthResponse> token = new AtomicReference<AuthResponse>(null);

	public String getTokenString() {
		try {
			lock.lock(); // lock else block to proceed later
			if (expirationDate == null || invalid.get() || new Date().after(expirationDate)) {
				logger.info("Entered the critical section to update the Sabre Token");
				updateToken();
			} else {
				logger.info("Token no longer invalid.. proceed.");
			}
		} finally {
			logger.info("Freeing the Lock for other threads");
			lock.unlock();
		}

		return token.get().getAccessToken();
	}

	private void updateToken() {
		// Invoke the rest service and fetch new token
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("grant_type", "client_credentials");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Basic " + getCredentialsString());
		headers.add("Accept", "*/*");

		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(map, headers);
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		messageConverters.add(new FormHttpMessageConverter());
		messageConverters.add(new MappingJackson2HttpMessageConverter());

		restTemplate.setMessageConverters(messageConverters);

		String url = env.getProperty("sabre.url") + "/v2/auth/token";
		AuthResponse authToken = restTemplate.postForObject(url, requestEntity, AuthResponse.class);
		resetToken(authToken);
	}

	private void resetToken(AuthResponse token) {
		this.token.set(token);
		this.invalid.set(false);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, Integer.parseInt(token.getExpiresIn()));
		this.expirationDate = cal.getTime();
	}

	private String getCredentialsString() {
		String clientId = env.getProperty("sabre.clientId");
		String clientSecret = env.getProperty("sabre.clientSecret");
		String finalEncodedString = b64(b64(clientId) + ":" + b64(clientSecret));
		return finalEncodedString;
	}

	private String b64(String toEncode) {
		return Base64.encodeBase64String(toEncode.getBytes());
	}
	
	public void setInvalid() {
		this.invalid.set(true);
	}
}
