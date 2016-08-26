package com.synerzip.utilities.sabre2amadeus.writers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.Flight;
import com.synerzip.supplier.amadeus.model.flights.Inbound;
import com.synerzip.supplier.amadeus.model.flights.Itinerary;
import com.synerzip.supplier.amadeus.model.flights.Outbound;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.AirItinerary;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FlightSegment;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.OriginDestinationOption;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PricedItinerary;

@Component
public class ItineraryWriter {
	@Autowired
	private FlightWriter flightWriter;
	
	private List<Flight> getFlightList(List<FlightSegment> flightSegmentlist, PricedItinerary pricedItinerary) {
		List<Flight> flightList = new ArrayList<Flight>();
		flightSegmentlist.stream().map(flightSegment -> {
			return flightWriter.write(flightSegment, pricedItinerary);
		}).filter(flight -> flight != null).forEach(flight -> flightList.add(flight));
		return flightList;
	}
	
	public Itinerary write(PricedItinerary pricedItinerary) {
		Itinerary.Builder builder = Itinerary.getBuilder();
		
		AirItinerary airItinerary = pricedItinerary.getAirItinerary();
		List<OriginDestinationOption> originDestinationOptions = airItinerary.getOriginDestinationOptions().getOriginDestinationOption();

		Stream.of(0, 1).forEach(index -> {
			List<FlightSegment> flightSegmentList = originDestinationOptions.get(index).getFlightSegment();
			
			List<Flight> flightList = getFlightList(flightSegmentList, pricedItinerary);
			if (index == 0) {
				// 1st position refers to Out-bound flights
				builder.outBound(Outbound.getBuilder().flights(flightList).instance());
			} else if (index == 1) {
				// 2nd position refers to In-bound flights
				builder.inBound(Inbound.getBuilder().flights(flightList).instance());
			}
		});
		return builder.getInstance();
	}
}