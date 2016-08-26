package com.synerzip.supplier.sabre.model.flights.visitors;

import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FareBasisCode;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FareInfo;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FareInfos;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.SeatsRemaining;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.TPAExtensions;

public abstract class AbstractFareInfosVisitor extends AbstractAirItineraryPricingInfoVisitor implements FareInfosVisitor {

	@Override
	public void visit(FareInfos fareInfos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(FareInfo fareInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(TPAExtensions tpaExtensions) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(SeatsRemaining seatsRemaining) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(FareBasisCode fareBasisCode) {
		// TODO Auto-generated method stub

	}

}
