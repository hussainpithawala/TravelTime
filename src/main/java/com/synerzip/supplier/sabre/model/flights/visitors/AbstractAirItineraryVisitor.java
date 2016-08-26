package com.synerzip.supplier.sabre.model.flights.visitors;

import com.synerzip.supplier.sabre.model.flights.instaflight_gen.AirItinerary;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.ArrivalAirport;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.DepartureAirport;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FlightSegment;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.MarketingAirline;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.OperatingAirline;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.OriginDestinationOption;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.OriginDestinationOptions;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PricedItinerary;

public abstract class AbstractAirItineraryVisitor implements AirItineraryVisitor {
	@Override
	public void visit(PricedItinerary pricedItinerary) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(AirItinerary airItinerary) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(OriginDestinationOptions originDestinationOptions) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(OriginDestinationOption originDestinationOption) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(FlightSegment flightSegment) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(DepartureAirport departureAirport) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(ArrivalAirport arrivalAirport) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(MarketingAirline marketingAirline) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(OperatingAirline operatingAirline) {
		// TODO Auto-generated method stub
	}
}
