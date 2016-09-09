package com.synerzip.supplier.amadeus.model.visitors;

public interface FlightElement {
	public void accept(FlightVisitor visitor);
}
