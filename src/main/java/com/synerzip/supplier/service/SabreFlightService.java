package com.synerzip.supplier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.sabre.model.flights.instaflight_gen.InstaFlightRequest;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.InstaFlightResponse;
import com.synerzip.supplier.sabre.rest.SabreService;

@Component
public class SabreFlightService {
    
	@Autowired
    private SabreService call;
	
	@Autowired
	private Environment env;

	public InstaFlightResponse doInstaFlightSearch(InstaFlightRequest request) {
		StringBuilder urlBuilder = new StringBuilder(env.getProperty("sabre.url"));
		urlBuilder.append("/v1/shop/flights");	// sub-url for shopping flights
		return call.doCall(urlBuilder.toString(), request, InstaFlightResponse.class);
	}
}
