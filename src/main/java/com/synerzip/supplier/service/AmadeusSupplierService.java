package com.synerzip.supplier.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

@Component
public class AmadeusSupplierService {

	private final String BaseURL = "GET /v1.2/flights";
	
	public String getLowFareFlightSearchResponse(Map<String, String[]> requestParams) {
		Iterator entries = requestParams.entrySet().iterator();
		String reqParams = "";
		while(entries.hasNext()) {
			Map.Entry<String, String[]> entry = (Entry<String, String[]>)entries.next();
			reqParams += entry.getKey() + "-" + entry.getValue()[0];
		}
		return "Trial" + reqParams;
	}
}
