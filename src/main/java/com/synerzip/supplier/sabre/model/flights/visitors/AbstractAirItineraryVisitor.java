package com.synerzip.supplier.sabre.model.flights.visitors;

import com.synerzip.supplier.sabre.model.flights.instaflight_gen.AirItinerary;
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

}
