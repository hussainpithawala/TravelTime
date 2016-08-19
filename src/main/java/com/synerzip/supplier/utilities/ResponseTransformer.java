package com.synerzip.supplier.utilities;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRS;
import com.synerzip.supplier.amadeus.model.flights.ResultItinerary;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.InstaFlightResponse;

@Component
public class ResponseTransformer {
	@Autowired
	private sabrePricedItinerariesTransformer pricedItineraryTransformer;
	
	public final Function<InstaFlightResponse, LowFareFlightSearchRS> convert = new Function<InstaFlightResponse, LowFareFlightSearchRS>() {
		@Override
		public LowFareFlightSearchRS apply(InstaFlightResponse instaFlightResponse) {
			LowFareFlightSearchRS lowFareFlightSearchRS = new LowFareFlightSearchRS();
			//map sabre currency with amadeus currency
			lowFareFlightSearchRS.setCurrency("INR");
			//map sabre result with amadeus result
			List<ResultItinerary> results = pricedItineraryTransformer.mappedPricedItinerarywithResult(instaFlightResponse);
			lowFareFlightSearchRS.setResults(results);
			return lowFareFlightSearchRS;
		}
	};
}
