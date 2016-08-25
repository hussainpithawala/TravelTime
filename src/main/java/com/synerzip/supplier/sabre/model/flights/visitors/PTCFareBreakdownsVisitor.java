package com.synerzip.supplier.sabre.model.flights.visitors;

import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FareBasisCode;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FareBasisCodes;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PTCFareBreakDown;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PTCFareBreakDowns;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PassengerFare;

public interface PTCFareBreakdownsVisitor extends PricedItineraryVisitor {
	public void visit(PTCFareBreakDowns ptc_FareBreakdowns);
	public void visit(PTCFareBreakDown ptc_FareBreakdown);
	public void visit(PassengerFare passengerFare);
	public void visit(FareBasisCodes fareBasisCodes);
	public void visit(FareBasisCode fareBasisCode);
}
