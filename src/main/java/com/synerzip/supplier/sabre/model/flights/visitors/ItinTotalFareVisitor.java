package com.synerzip.supplier.sabre.model.flights.visitors;

import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FareConstruction_;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.ItinTotalFare;

public interface ItinTotalFareVisitor extends PricedItineraryVisitor {
	void visit(ItinTotalFare itinTotalFare);
	void visit(FareConstruction_ fareConstruction);
}
