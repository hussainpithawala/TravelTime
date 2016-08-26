package com.synerzip.supplier.sabre.model.flights.visitors;

import com.synerzip.supplier.sabre.model.flights.instaflight_gen.AirItineraryPricingInfo;

public interface AirItineraryPricingInfoVisitor extends PricedItineraryVisitor {
	public void visit(AirItineraryPricingInfo airItineraryPricingInfo);
}
