package com.synerzip.supplier.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.ExtensiveSearchRQ;
import com.synerzip.supplier.amadeus.model.flights.ExtensiveSearchRS;
import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRQ;
import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRS;

@Component
public class AmadeusFlightService extends AmadeusService {

	private Logger logger = LoggerFactory.getLogger(AmadeusFlightService.class);
	
	public LowFareFlightSearchRS fetchLowFareFlights(LowFareFlightSearchRQ request, boolean async) {
		String subUrl = "/flights/low-fare-search";
		return getResponseObject(subUrl, request, LowFareFlightSearchRS.class);
	}
	
	public ExtensiveSearchRS fetchExtensiveFlights(ExtensiveSearchRQ request) {
		String subUrl = "/flights/extensive-search";
		return getResponseObject(subUrl, request, ExtensiveSearchRS.class);
	}
}
