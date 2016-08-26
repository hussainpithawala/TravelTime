package com.synerzip.supplier.sabre.model.flights.visitors;

import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FareBasisCode;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FareInfo;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FareInfos;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.SeatsRemaining;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.TPAExtensions;

public interface FareInfosVisitor extends AirItineraryPricingInfoVisitor {
	public void visit(FareInfos fareInfos);
	public void visit(FareInfo fareInfo);
	public void visit(TPAExtensions tpaExtensions);
	public void visit(SeatsRemaining seatsRemaining);
	public void visit(FareBasisCode fareBasisCode);
}
