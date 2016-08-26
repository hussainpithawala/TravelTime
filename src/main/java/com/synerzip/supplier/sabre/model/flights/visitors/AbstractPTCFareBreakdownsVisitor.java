package com.synerzip.supplier.sabre.model.flights.visitors;

import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FareBasisCode;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FareBasisCodes;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PTCFareBreakDown;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PTCFareBreakDowns;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PassengerFare;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.Taxes;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.TotalFare;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.TotalTax;

public abstract class AbstractPTCFareBreakdownsVisitor extends AbstractAirItineraryPricingInfoVisitor
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

	@Override
	public void visit(TotalFare totalFare) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(Taxes taxes) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(TotalTax totalTax) {
		// TODO Auto-generated method stub
	}
}
