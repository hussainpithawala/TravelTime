package com.synerzip.supplier.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.Flight;
import com.synerzip.supplier.amadeus.model.flights.Inbound;
import com.synerzip.supplier.amadeus.model.flights.Itinerary;
import com.synerzip.supplier.amadeus.model.flights.Outbound;
import com.synerzip.supplier.amadeus.model.flights.ResultItinerary;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.AirItinerary;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FlightSegment;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.InstaFlightResponse;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.OriginDestinationOption;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PricedItinerary;

@Component
public class sabrePricedItinerariesTransformer {
	@Autowired
	private sabreAirItineraryTransformer airItineraryTransformer;

	public List<ResultItinerary> mappedPricedItinerarywithResult(InstaFlightResponse instaFlightResponse) {
		// lowFareFlightRS result object
		List<ResultItinerary> resultItineries = new ArrayList<ResultItinerary>();
		// first element in sabre response
		List<PricedItinerary> pricedItineraries = instaFlightResponse.getPricedItineraries();
		for (int i = 0; i < pricedItineraries.size(); ++i) {
			ResultItinerary resultItinerary = new ResultItinerary();
			// traverse through pricedItinerariesList and get
			PricedItinerary pricedItinerary = pricedItineraries.get(i);
			AirItinerary airItinerary = airItineraryTransformer.getAirItinerary(pricedItinerary);
			List<OriginDestinationOption> originDestinationOptions = airItineraryTransformer
					.getoriginDestinationOptionList(airItinerary);
			List<Itinerary> itineraries = new ArrayList<Itinerary>();
			Itinerary itinerary = new Itinerary();
			for (int iternary_index = 0; iternary_index < originDestinationOptions.size(); ++iternary_index) {
				OriginDestinationOption originDestinationOption = originDestinationOptions.get(iternary_index);
				List<FlightSegment> flightSegmentlist = airItineraryTransformer.getFlightSegment(
						originDestinationOption);
				if (iternary_index == 0) {
					Outbound outBound = new Outbound();
					List<Flight> flightList = airItineraryTransformer.getFlightList(flightSegmentlist, pricedItinerary);
					outBound.setFlights(flightList);
					itinerary.setOutbound(outBound);
				} else if (iternary_index == 1) {
					Inbound inBound = new Inbound();
					List<Flight> flightList = airItineraryTransformer.getFlightList(flightSegmentlist, pricedItinerary);
					inBound.setFlights(flightList);
					itinerary.setInbound(inBound);
				}
			}
			itineraries.add(itinerary);
			resultItinerary.setItineraries(itineraries);
			resultItineries.add(resultItinerary);
		}
		return resultItineries;
	}
}