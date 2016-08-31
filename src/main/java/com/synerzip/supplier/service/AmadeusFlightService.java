package com.synerzip.supplier.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.AffiliateFlightSearchRQ;
import com.synerzip.supplier.amadeus.model.flights.AffiliateFlightSearchRS;
import com.synerzip.supplier.amadeus.model.flights.AirportAutocompleteRQ;
import com.synerzip.supplier.amadeus.model.flights.AirportAutocompleteRS;
import com.synerzip.supplier.amadeus.model.flights.ExtensiveSearchRQ;
import com.synerzip.supplier.amadeus.model.flights.ExtensiveSearchRS;
import com.synerzip.supplier.amadeus.model.flights.FlightInspirationSearchRS;
import com.synerzip.supplier.amadeus.model.flights.FlightInspirationSearchRQ;
import com.synerzip.supplier.amadeus.model.flights.LocationInformationSearchRQ;
import com.synerzip.supplier.amadeus.model.flights.LocationInformationSearchRS;
import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRQ;
import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRS;
import com.synerzip.supplier.amadeus.model.flights.NearestAirportSearchRQ;
import com.synerzip.supplier.amadeus.model.flights.NearestAirportSearchRS;

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
	
	public FlightInspirationSearchRS fetchInspirationFlights(FlightInspirationSearchRQ request) {
		String subUrl = "/flights/inspiration-search";
		return getResponseObject(subUrl, request, FlightInspirationSearchRS.class);
	}
	
	public LocationInformationSearchRS fetchAiportLocation(LocationInformationSearchRQ request) {
		String subUrl = "/location/" + request.getCode();
		return getResponseObject(subUrl, request, LocationInformationSearchRS.class);
	}
	
	public AffiliateFlightSearchRS fetchAffiliateFlights(AffiliateFlightSearchRQ request) {
		String subUrl = "/flights/affiliate-search";
		return getResponseObject(subUrl, request, AffiliateFlightSearchRS.class);
	}
	
	public NearestAirportSearchRS[] fetchNearestAirport(NearestAirportSearchRQ request) {
		String subUrl = "/airports/nearest-relevant";
		return getResponseObject(subUrl, request, NearestAirportSearchRS[].class);
	}
	
	public AirportAutocompleteRS[] fetchAutocompleteAirport(AirportAutocompleteRQ request) {
		String subUrl = "/airports/autocomplete";
		return getResponseObject(subUrl, request, AirportAutocompleteRS[].class);
	}
}
