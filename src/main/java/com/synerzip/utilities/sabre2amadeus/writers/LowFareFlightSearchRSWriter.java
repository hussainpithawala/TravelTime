package com.synerzip.utilities.sabre2amadeus.writers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRS;
import com.synerzip.supplier.amadeus.model.flights.ResultItinerary;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FareConstruction_;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.InstaFlightResponse;
import com.synerzip.supplier.sabre.model.flights.visitors.AbstractItinTotalFareVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.ItinTotalFareVisitor;

@Component
public class LowFareFlightSearchRSWriter {
	@Autowired
	private ResultItineraryWriter resultItineraryWriter;
	
	public final Function<InstaFlightResponse, LowFareFlightSearchRS> write = new Function<InstaFlightResponse, LowFareFlightSearchRS>() {
		@Override
		public LowFareFlightSearchRS apply(InstaFlightResponse instaFlightResponse) {
			//create a lowFareSearch response object and mapped result and currency
			LowFareFlightSearchRS.Builder builder = LowFareFlightSearchRS.getBuilder();

			//map Sabre's currency-code with Amadeus's currency-code
			ItinTotalFareVisitor itinTotalFareVisitor = new AbstractItinTotalFareVisitor() {
				@Override
				public void visit(FareConstruction_ fareConstruction){
					builder.currency(fareConstruction.getCurrencyCode());
				}
			};
			
			// pick up the first element of PricedItineraries i.e. a PricedItinerary to fetch the currency-code
			if (!instaFlightResponse.getPricedItineraries().isEmpty()) {
				instaFlightResponse.getPricedItineraries().get(0).accept(itinTotalFareVisitor);
			}
			
			List<ResultItinerary> resultItineraries = new ArrayList<ResultItinerary>();
			
			//Build Amadeus's ResultItinerary from Sabre's PricedItinerary 
			instaFlightResponse.getPricedItineraries().stream().forEach(pricedItinerary -> {
				resultItineraries.add(resultItineraryWriter.write(pricedItinerary));
			});
			
			builder.results(resultItineraries);

			return builder.getInstance();
		}
	};
}