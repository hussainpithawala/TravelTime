package com.synerzip.supplier.sabre.model.flights.visitors;

import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FareBasisCode;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FareBasisCodes;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PTCFareBreakDown;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PTCFareBreakDowns;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PassengerFare;

public abstract class AbstractPTCFareBreakdownsVisitor extends AbstractPricedItineraryVisitor
		implements PTCFareBreakdownsVisitor {

	@Override
	public void visit(PTCFareBreakDowns ptc_FareBreakdowns) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(PTCFareBreakDown ptc_FareBreakdown) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(PassengerFare passengerFare) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(FareBasisCodes fareBasisCodes) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(FareBasisCode fareBasisCode) {
		// TODO Auto-generated method stub

	}

}
