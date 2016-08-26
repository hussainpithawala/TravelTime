package com.synerzip.supplier.sabre.model.flights.visitors;

import com.synerzip.supplier.sabre.model.flights.instaflight_gen.AirItinerary;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.OriginDestinationOption;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.OriginDestinationOptions;

public interface AirItineraryVisitor extends PricedItineraryVisitor {
	public void visit(AirItinerary airItinerary);

	public void visit(OriginDestinationOptions originDestinationOptions);

	public void visit(OriginDestinationOption originDestinationOption);
}
