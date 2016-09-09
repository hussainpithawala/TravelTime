package com.synerzip.supplier.amadeus.model.visitors;

import com.synerzip.supplier.amadeus.model.flights.Flight;

public interface FlightVisitor {
	public void visit(Flight flight);
}
