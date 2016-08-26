package com.synerzip.supplier.sabre.model.flights.visitors;

public interface AirItineraryPricingInfoElement {
	public void accept(AirItineraryPricingInfoVisitor visitor);
}
