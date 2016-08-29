package com.synerzip.supplier.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRQ;
import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRS;

@Component
public class AmadeusFlightService extends AmadeusService {

	private Logger logger = LoggerFactory.getLogger(AmadeusFlightService.class);
	
	public LowFareFlightSearchRS fetchLowFareFlights(LowFareFlightSearchRQ request) {
		String subUrl = "/flights/low-fare-search";
		return getResponseObject(subUrl, request, LowFareFlightSearchRS.class);
	}
}
