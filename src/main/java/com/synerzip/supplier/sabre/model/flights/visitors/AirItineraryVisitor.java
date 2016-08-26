package com.synerzip.supplier.sabre.model.flights.visitors;

import com.synerzip.supplier.sabre.model.flights.instaflight_gen.AirItinerary;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.ArrivalAirport;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.DepartureAirport;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FlightSegment;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.MarketingAirline;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.OperatingAirline;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.OriginDestinationOption;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.OriginDestinationOptions;

public interface AirItineraryVisitor extends PricedItineraryVisitor {
	public void visit(AirItinerary airItinerary);

	public void visit(OriginDestinationOptions originDestinationOptions);

	public void visit(OriginDestinationOption originDestinationOption);

	public void visit(FlightSegment flightSegment);

	public void visit(DepartureAirport departureAirport);

	public void visit(ArrivalAirport arrivalAirport);

	public void visit(MarketingAirline marketingAirline);

	public void visit(OperatingAirline operatingAirline);
}
