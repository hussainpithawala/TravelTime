package com.synerzip.supplier.sabre.model.flights;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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
    @SuppressWarnings("rawtypes")
    public String toRequestQuery() {
        StringBuilder requestQuery = new StringBuilder("?");
        try {
            Class c = Class.forName(this.getClass().getName());
            Method m[] = c.getDeclaredMethods();
            Object oo;
            for (int i = 0; i < m.length; i++)
                if (m[i].getName().startsWith("get")) {
                    oo = m[i].invoke(this, (Object[])null);
                    if (oo != null) {
                        requestQuery.append(m[i].getName().substring(3).toLowerCase() + "="
                                + String.valueOf(oo) + "&");
                    }
                }
        } catch (Throwable e) {
        	logger.error("An exception has occurred", e);
        }

        return requestQuery.deleteCharAt(requestQuery.lastIndexOf("&")).toString();
    }
}
