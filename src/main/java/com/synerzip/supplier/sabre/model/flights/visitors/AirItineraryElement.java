package com.synerzip.supplier.sabre.model.flights.visitors;

public interface AirItineraryElement {
	public void accept(AirItineraryVisitor visitor);
}
