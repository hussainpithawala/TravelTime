package com.synerzip.supplier.utilities;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRS;
import com.synerzip.supplier.amadeus.model.flights.ResultItinerary;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FareConstruction_;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.InstaFlightResponse;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PricedItinerary;
import com.synerzip.supplier.sabre.model.flights.visitors.AbstractItinTotalFareVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.ItinTotalFareVisitor;

@Component
public class ResponseTransformer {
	@Autowired
	private SabreInstaFlightTransformer instaFlightTransformer;
	
	public final Function<InstaFlightResponse, LowFareFlightSearchRS> convert = new Function<InstaFlightResponse, LowFareFlightSearchRS>() {
		@Override
		public LowFareFlightSearchRS apply(InstaFlightResponse instaFlightResponse) {
			//create a lowFareSearch response object and mapped result and currency
			LowFareFlightSearchRS lowFareFlightSearchRS = new LowFareFlightSearchRS();

			//map Sabre's currency-code with Amadeus's currency-code
			ItinTotalFareVisitor itinTotalFareVisitor = new AbstractItinTotalFareVisitor() {
				@Override
				public void visit(FareConstruction_ fareConstruction){
					lowFareFlightSearchRS.setCurrency(fareConstruction.getCurrencyCode());
				}
			};
			
			// pick up the first element of PricedItineraries i.e. a PricedItinerary to fetch the currency-code
			instaFlightResponse.getPricedItineraries().get(0).accept(itinTotalFareVisitor);
			
			//map sabre result with amadeus result
			List<ResultItinerary> results = instaFlightTransformer.mappedPricedItinerarywithResult(instaFlightResponse);
			lowFareFlightSearchRS.setResults(results);

			return lowFareFlightSearchRS;
		}
	};
}
