package com.synerzip.supplier.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.BookingInfo;
import com.synerzip.supplier.amadeus.model.flights.Destination;
import com.synerzip.supplier.amadeus.model.flights.Flight;
import com.synerzip.supplier.amadeus.model.flights.Origin;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FareBasisCode;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FlightSegment;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PricedItinerary;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.SeatsRemaining;
import com.synerzip.supplier.sabre.model.flights.visitors.AbstractFareInfosVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.AbstractPTCFareBreakdownsVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.FareInfosVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.PTCFareBreakdownsVisitor;

@Component
public class SabreAirItineraryTransformer {
	public Flight getFlightObject(FlightSegment flightSegment, PricedItinerary pricedItinerary) {
		Flight flight = new Flight();
		Origin Origin = new Origin();
		Destination Destination = new Destination();
		BookingInfo bookingInfo = new BookingInfo();
		// set destination origin object
		Origin.setAirport(flightSegment.getDepartureAirport().getLocationCode());
		Destination.setAirport(flightSegment.getArrivalAirport().getLocationCode());

		FareInfosVisitor fareInfosVisitor = new AbstractFareInfosVisitor() {
			@Override
			public void visit(SeatsRemaining seatsRemaining) {
				bookingInfo.setSeatsRemaining(seatsRemaining.getNumber()); 
			}		
		};
		pricedItinerary.accept(fareInfosVisitor);

		PTCFareBreakdownsVisitor ptcFareBreakdownsVisitor = new AbstractPTCFareBreakdownsVisitor() {
			@Override
			public void visit(FareBasisCode fareBasisCode) {
				// TODO Auto-generated method stub
				bookingInfo.setBookingCode(fareBasisCode.getBookingCode());
			}
		};
		pricedItinerary.accept(ptcFareBreakdownsVisitor);	

		// set Flight object
		flight.setOrigin(Origin);
		flight.setDestination(Destination);
		flight.setMarketingAirline(flightSegment.getMarketingAirline().getCode());
		flight.setOperatingAirline(flightSegment.getOperatingAirline().getCode());
		flight.setFlightNumber((flightSegment.getOperatingAirline().getFlightNumber()).toString());
		flight.setBookingInfo(bookingInfo);
		return flight;
	}

	public List<Flight> getFlightList(List<FlightSegment> flightSegmentlist, PricedItinerary pricedItinerary) {
		List<Flight> flightList = new ArrayList<Flight>();
		flightSegmentlist.stream().map(flightSegment -> {
			return getFlightObject(flightSegment, pricedItinerary);
		}).filter(flight -> flight != null).forEach(flight -> flightList.add(flight));
		return flightList;
	}
}