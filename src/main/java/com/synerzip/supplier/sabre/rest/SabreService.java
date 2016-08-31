package com.synerzip.supplier.sabre.rest;

import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.synerzip.supplier.sabre.model.flights.BaseDomainRequest;
import com.synerzip.supplier.service.SabreTokenService;

@Component
public class SabreService {
	private static final Logger logger = LoggerFactory.getLogger(SabreService.class);
	
	// Need to restrict number of concurrent calls to Sabre Test API, current limit is 2 calls per second
	private final Semaphore semaphore = new Semaphore(2, true); // A fair semaphore with only 2 permits

	@Autowired
	private SabreTokenService sabreTokenService;
	
	@Autowired
	@Qualifier("sabre")
	private RestTemplate restTemplate;

	/**
	 * @param clazz
	 *            Class of the response object.
	 * @return response object.
	 */
	public <RQ extends BaseDomainRequest, RS> RS doCall(String url, RQ request, Class<RS> clazz) {

		RS response = null;

		try {
			response = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			logger.error("An exception has occurred", e);
		}
		
		try {
			semaphore.acquire();
			logger.info("Acquired permit to place request to Sabre");
			String finalUrl = getRequestString(url, request);
			logger.info("Request to Sabre " + finalUrl);
			response = restTemplate.getForObject(finalUrl, clazz, new Object[] {});
			
			ObjectMapper objectMapper = new ObjectMapper();
			logger.info("Response from sabre " + objectMapper.writeValueAsString(response));
			
		} catch (HttpClientErrorException e) {
			if (e.getStatusCode().equals(HttpStatus.UNAUTHORIZED))
				sabreTokenService.setInvalid();
		} catch (InterruptedException e) {
			logger.error("Thread interrupted during permit acquisition", e);
		} catch (Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
		}finally {
			semaphore.release();
			logger.info("Released permit back");
		}
		return response;
	}

	private <RQ extends BaseDomainRequest> String getRequestString(String url, RQ request) {
		String result = new String(url);

		if (request != null) {
			result += request.toRequestQuery();
		}
		return result;
	}
}
