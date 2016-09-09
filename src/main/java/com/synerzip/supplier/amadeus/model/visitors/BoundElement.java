package com.synerzip.supplier.amadeus.model.visitors;

import java.util.List;

import com.synerzip.supplier.amadeus.model.flights.Flight;

public interface BoundElement {
	public void accept(BoundVisitor visitor);
	public List<Flight> getFlights();
	public void setDuration(String duration);
	void setAdditionalProperty(String name, Object value);
}
