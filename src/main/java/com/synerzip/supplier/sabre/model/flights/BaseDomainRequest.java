package com.synerzip.supplier.sabre.model.flights;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Base class for GET requests domain objects. All request classes should extend this class.
 * It has a method, which builds a query string based on the properties of the extending
 * object.
 */
public class BaseDomainRequest {
    
    private static final Logger logger = LoggerFactory.getLogger(BaseDomainRequest.class);

    /**
     * Uses reflection mechanism to build a query string based on the extending
     * object's properties. Properties with null values are not included in
     * the string.
     * @return query string for GET call.
     */
    public String toRequestQuery() {
        StringBuilder requestQuery = new StringBuilder("?");
        try {
			Class<?> clazz = Class.forName(this.getClass().getName());

			for (Method method : clazz.getDeclaredMethods()) {
				Object fieldObject;
				if (method.getName().startsWith("get")) {
					JsonProperty jsonProperty = method.getDeclaredAnnotation(JsonProperty.class);
					if (jsonProperty != null) {
						try {
							fieldObject = method.invoke(this, (Object[]) null);
							if (fieldObject != null) {
								String name = jsonProperty.value();
								requestQuery.append(name).append("=").append(fieldObject).append("&");
							}
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
        } catch (Throwable e) {
        	logger.error("An exception has occurred", e);
        }
        return requestQuery.deleteCharAt(requestQuery.lastIndexOf("&")).toString();
    }
}
