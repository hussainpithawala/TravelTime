package com.synerzip.utilities.sabre2amadeus.writers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.Flight;
import com.synerzip.supplier.amadeus.model.flights.Inbound;
import com.synerzip.supplier.amadeus.model.flights.Itinerary;
import com.synerzip.supplier.amadeus.model.flights.Outbound;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FlightSegment;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.OriginDestinationOption;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PricedItinerary;
import com.synerzip.supplier.sabre.model.flights.visitors.AbstractAirItineraryVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.PricedItineraryVisitor;

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

		PricedItineraryVisitor visitor = new AbstractAirItineraryVisitor() {
			private int counter = 0;

			@Override
			public void visit(OriginDestinationOption originDestinationOption) {
				List<FlightSegment> flightSegmentList = originDestinationOption.getFlightSegment();
				List<Flight> flightList = getFlightList(flightSegmentList, pricedItinerary);

				switch (counter) {
				case 0: // '0' position is for out-bound
					builder.outBound(Outbound.getBuilder().flights(flightList).instance());
					break;
				case 1: // '1' position is for in-bound
					builder.inBound(Inbound.getBuilder().flights(flightList).instance());
					break;
				default:
					break;
				}
				++counter;
			}
		};
		pricedItinerary.accept(visitor);
		return builder.getInstance();
	}
}