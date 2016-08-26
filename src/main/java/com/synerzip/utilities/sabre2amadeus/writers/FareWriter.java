package com.synerzip.utilities.sabre2amadeus.writers;

import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.Fare;
import com.synerzip.supplier.amadeus.model.flights.PricePerAdult;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PricedItinerary;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.TotalFare;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.TotalTax;
import com.synerzip.supplier.sabre.model.flights.visitors.AbstractPTCFareBreakdownsVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.AirItineraryPricingInfoVisitor;

@Component
public class FareWriter {
	// this function mapped Fare object
	public Fare write(PricedItinerary pricedItinerary){	
		Fare fare = new Fare();
		PricePerAdult pricePerAdult= new PricePerAdult();
		
		AirItineraryPricingInfoVisitor visitor = new AbstractPTCFareBreakdownsVisitor() {
			@Override
			public void visit(TotalFare totalFare) {
				fare.setTotalPrice(totalFare.getAmount());
			}
			@Override
			public void visit(TotalTax totalTax) {
				pricePerAdult.setTax(totalTax.getAmount());
			}
		};		
		pricedItinerary.accept(visitor);
		fare.setPricePerAdult(pricePerAdult);
		return fare;
	}
}
