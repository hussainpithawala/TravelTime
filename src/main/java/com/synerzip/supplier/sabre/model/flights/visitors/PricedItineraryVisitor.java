package com.synerzip.supplier.sabre.model.flights.visitors;

import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PricedItinerary;

public interface PricedItineraryVisitor {
	public void visit(PricedItinerary pricedItinerary);
}
