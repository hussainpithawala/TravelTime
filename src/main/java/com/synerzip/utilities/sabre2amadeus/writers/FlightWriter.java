package com.synerzip.utilities.sabre2amadeus.writers;

import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.BookingInfo;
import com.synerzip.supplier.amadeus.model.flights.Destination;
import com.synerzip.supplier.amadeus.model.flights.Flight;
import com.synerzip.supplier.amadeus.model.flights.Origin;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.ArrivalAirport;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.DepartureAirport;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FareBasisCode;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FlightSegment;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.MarketingAirline;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.OperatingAirline;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PricedItinerary;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.SeatsRemaining;
import com.synerzip.supplier.sabre.model.flights.visitors.AbstractAirItineraryVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.AbstractFareInfosVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.AbstractPTCFareBreakdownsVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.AirItineraryVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.FareInfosVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.PTCFareBreakdownsVisitor;
import com.synerzip.utils.TimeUtils.TimeUtilities;

@Component
public class FlightWriter {
	public Flight write(FlightSegment flightSegment, PricedItinerary pricedItinerary) {
		Flight.Builder flightBuilder = Flight.getBuilder();
		Origin.Builder originBuilder = Origin.getBuilder();
		Destination.Builder destinationBuilder = Destination.getBuilder();
		
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

		AirItineraryVisitor airItineraryVisitor = new AbstractAirItineraryVisitor(){
			@Override
			public void visit(ArrivalAirport arrivalAirport) {
				destinationBuilder.airport(arrivalAirport.getLocationCode());
			}
			@Override
			public void visit(DepartureAirport departureAirport){
				originBuilder.airport(departureAirport.getLocationCode());
			}
			@Override
			public void visit(MarketingAirline marketingAirline) {
				flightBuilder.marketingAirline(marketingAirline.getCode());
			}
			@Override
			public void visit(OperatingAirline operatingAirline) {
				flightBuilder.operatingAirline(operatingAirline.getCode())
						.flightNumber(operatingAirline.getFlightNumber().toString());
			}
		};
		flightSegment.accept(airItineraryVisitor);
		
		Period flightPeriod = Duration.standardMinutes(flightSegment.getElapsedTime()).toPeriod();
		
		// set Flight object
		return flightBuilder
				.origin(originBuilder.getInstance())
				.destination(destinationBuilder.getInstance())
				.bookingInfo(bookingInfoBuilder.getInstance())
				.additionalProperty("duration", TimeUtilities.periodToString(flightPeriod))
				.getInstance();
	}
}