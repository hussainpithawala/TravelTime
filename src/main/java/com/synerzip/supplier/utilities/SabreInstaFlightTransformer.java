package com.synerzip.supplier.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.Fare;
import com.synerzip.supplier.amadeus.model.flights.Itinerary;
import com.synerzip.supplier.amadeus.model.flights.ResultItinerary;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.InstaFlightResponse;

@Component
public class SabreInstaFlightTransformer {
	@Autowired
	private SabrePricedItinerariesTransformer pricedItineraryTransformer;
	
	//this function create resultItinerary object
	public List<ResultItinerary> mappedPricedItinerarywithResult(InstaFlightResponse instaFlightResponse) {
		List<ResultItinerary> resultItineraries = new ArrayList<ResultItinerary>();

		instaFlightResponse.getPricedItineraries().stream().map(pricedItinerary -> {
			ResultItinerary resultItinerary = new ResultItinerary();
			
			// mapped itinerary object
			List<Itinerary> itineraries = pricedItineraryTransformer.mappedPricedItinerarywithItineraries(pricedItinerary);
			resultItinerary.setItineraries(itineraries);
		
			//mapped fare object
			Fare fare = pricedItineraryTransformer.mappedPricedItinerarywithFare(pricedItinerary);
			resultItinerary.setFare(fare);
			
			return resultItinerary;
		}).forEach(resultItinerary -> resultItineraries.add(resultItinerary));
		
		return	resultItineraries;
	}
}
