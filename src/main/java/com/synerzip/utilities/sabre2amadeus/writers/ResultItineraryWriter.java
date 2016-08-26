package com.synerzip.utilities.sabre2amadeus.writers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.Itinerary;
import com.synerzip.supplier.amadeus.model.flights.ResultItinerary;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PricedItinerary;

@Component
public class ResultItineraryWriter {
	@Autowired
	private ItineraryWriter itineraryWriter;
	
	@Autowired
	private FareWriter fareWriter;

	public ResultItinerary write(PricedItinerary pricedItinerary) {
		// mapped itinerary object and fare object
		List<Itinerary> itineraries = new ArrayList<Itinerary>();
		itineraries.add(itineraryWriter.write(pricedItinerary));
		
		return ResultItinerary.getBuilder()
				.itineraries(itineraries)
				.fare(fareWriter.write(pricedItinerary))
				.getInstance();
	}

}
