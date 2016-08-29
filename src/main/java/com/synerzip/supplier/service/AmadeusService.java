package com.synerzip.supplier.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AmadeusService {
	@Autowired
	private Environment env;

	@Qualifier("basic")
	@Autowired
	private RestTemplate restTemplate;

	private static final Logger logger = LoggerFactory.getLogger(AmadeusService.class);
	public <RQ,RS> RS getResponseObject(String subUrl, RQ request, Class<RS> response) {
		String url = prepareUrl(subUrl, request);
		logger.info("URL for request " + url);
		return restTemplate.getForObject(url, response);
	}
	
	private <RQ> String prepareUrl(String subUrl, RQ request) {
		return new StringBuilder(env.getProperty("amadeus.url")).append(subUrl)
				.append(generateQuery(request)).append("apikey=").append(env.getProperty("amadeus.api.key")).toString();
	}

	private <RQ> String generateQuery(RQ request) {
		
		@SuppressWarnings("unchecked")
		Class<RQ> clazz = (Class<RQ>) request.getClass();
		
		StringBuilder parameterBuilder = new StringBuilder("?");
		
		for(Method method : clazz.getDeclaredMethods()) {
			Object fieldObject;
			if(method.getName().startsWith("get")){
				try {
					fieldObject = method.invoke(request, (Object[])null);
					if (fieldObject != null) {
						JsonProperty jsonProperty = method.getDeclaredAnnotation(JsonProperty.class);
						if(jsonProperty != null) {
							String name = jsonProperty.value();
							parameterBuilder.append(name).append("=").append(fieldObject).append("&");
						}
					}
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return parameterBuilder.toString();
	}
}