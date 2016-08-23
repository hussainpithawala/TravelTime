package com.synerzip.supplier.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.Fare;
import com.synerzip.supplier.amadeus.model.flights.Itinerary;
import com.synerzip.supplier.amadeus.model.flights.ResultItinerary;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.InstaFlightResponse;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PricedItinerary;

@Component
public class SabreInstaFlightTransformer {
	@Autowired
	private sabrePricedItinerariesTransformer pricedItineraryTransformer;
	
	public String mappedPricedItinerarywithCurrency(InstaFlightResponse instaFlightResponse){
		String currency = instaFlightResponse.getPricedItineraries().get(0).getAirItineraryPricingInfo().getItinTotalFare().getFareConstruction().getCurrencyCode();
		return currency;
	}
	//this function create resultItinerary object
	public List<ResultItinerary> mappedPricedItinerarywithResult(InstaFlightResponse instaFlightResponse) {
		List<ResultItinerary> resultItineraries = new ArrayList<ResultItinerary>();
		List<PricedItinerary> pricedItineraries = instaFlightResponse.getPricedItineraries();
		for (int pricedItinerary_index = 0; pricedItinerary_index < pricedItineraries.size(); ++pricedItinerary_index) {
			ResultItinerary resultItinerary = new ResultItinerary();
			PricedItinerary  pricedItinerary = pricedItineraries.get(pricedItinerary_index);
			// mapped itinerary object
			List<Itinerary> itineraries = pricedItineraryTransformer.mappedPricedItinerarywithItineraries(pricedItinerary);
			resultItinerary.setItineraries(itineraries);
			//mapped fare object
			Fare fare = pricedItineraryTransformer.mappedPricedItinerarywithFare(pricedItinerary);
			resultItinerary.setFare(fare);
			resultItineraries.add(resultItinerary);
			}
		return	resultItineraries;
	}
}
