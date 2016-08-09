package com.synerzip.supplier.amadeus.model.flights;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class AmadeusRequest {
	public <RQ> String generateQuery(RQ request) {
		
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
