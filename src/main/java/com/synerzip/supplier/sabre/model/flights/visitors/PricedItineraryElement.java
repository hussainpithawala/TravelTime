package com.synerzip.supplier.sabre.model.flights.visitors;

public interface PricedItineraryElement {
	public void accept(PricedItineraryVisitor visitor);
}
