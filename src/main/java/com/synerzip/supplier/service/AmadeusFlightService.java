package com.synerzip.supplier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.synerzip.supplier.amadeus.model.flights.AmadeusRequest;
import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRQ;
import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRS;

@Component
public class AmadeusFlightService {

	@Autowired
	private Environment env;

	@Autowired
	private AmadeusRequest amadeusRequest;
	
	@Autowired
	@Qualifier("basic")
	private RestTemplate restTemplate;

	public LowFareFlightSearchRS fetchLowFareFlights(LowFareFlightSearchRQ request) {
		String subUrl = "/flights/low-fare-search";
		StringBuilder urlBuilder = new StringBuilder(env.getProperty("amadeus.url")).append(subUrl)
				.append(amadeusRequest.generateQuery(request)).append("apikey=").append(env.getProperty("amadeus.api.key"));
		return restTemplate.getForObject(urlBuilder.toString(), LowFareFlightSearchRS.class, HttpStatus.OK);
	}
}
