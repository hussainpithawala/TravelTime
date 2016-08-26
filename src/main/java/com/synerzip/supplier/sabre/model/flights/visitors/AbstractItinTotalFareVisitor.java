package com.synerzip.supplier.sabre.model.flights.visitors;

import com.synerzip.supplier.sabre.model.flights.instaflight_gen.AirItineraryPricingInfo;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FareConstruction_;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.ItinTotalFare;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PricedItinerary;

public abstract class AbstractItinTotalFareVisitor implements ItinTotalFareVisitor {

	@Override
	public void visit(PricedItinerary pricedItinerary) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(AirItineraryPricingInfo airItineraryPricingInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ItinTotalFare itinTotalFare) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(FareConstruction_ fareConstruction_) {
		// TODO Auto-generated method stub

	}

}
