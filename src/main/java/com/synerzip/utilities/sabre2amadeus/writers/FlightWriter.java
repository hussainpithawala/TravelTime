package com.synerzip.utilities.sabre2amadeus.writers;

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
public class FlightWriter {
	public Flight write(FlightSegment flightSegment, PricedItinerary pricedItinerary) {
		BookingInfo.Builder bookingInfoBuilder = BookingInfo.getBuilder();

		FareInfosVisitor fareInfosVisitor = new AbstractFareInfosVisitor() {
			@Override
			public void visit(SeatsRemaining seatsRemaining) {
				bookingInfoBuilder.seatsRemaining(seatsRemaining.getNumber());
			}
		};
		pricedItinerary.accept(fareInfosVisitor);

		PTCFareBreakdownsVisitor ptcFareBreakdownsVisitor = new AbstractPTCFareBreakdownsVisitor() {
			@Override
			public void visit(FareBasisCode fareBasisCode) {
				bookingInfoBuilder.bookingCode(fareBasisCode.getBookingCode());
			}
		};
		pricedItinerary.accept(ptcFareBreakdownsVisitor);

		// set Flight object
		return Flight.getBuilder()
				.origin(Origin.getBuilder().airport(flightSegment.getDepartureAirport().getLocationCode())
						.getInstance())
				.destination(Destination.getBuilder().airport(flightSegment.getArrivalAirport().getLocationCode())
						.getInstance())
				.bookingInfo(bookingInfoBuilder.getInstance())
				.marketingAirline(flightSegment.getMarketingAirline().getCode())
				.operatingAirline(flightSegment.getOperatingAirline().getCode())
				.flightNumber(flightSegment.getOperatingAirline().getFlightNumber().toString())
				.getInstance();
	}
}