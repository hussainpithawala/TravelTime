package com.synerzip.supplier.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.Fare;
import com.synerzip.supplier.amadeus.model.flights.Flight;
import com.synerzip.supplier.amadeus.model.flights.Inbound;
import com.synerzip.supplier.amadeus.model.flights.Itinerary;
import com.synerzip.supplier.amadeus.model.flights.Outbound;
import com.synerzip.supplier.amadeus.model.flights.PricePerAdult;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.AirItinerary;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FlightSegment;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.OriginDestinationOption;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PricedItinerary;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.TotalFare;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.TotalTax;
import com.synerzip.supplier.sabre.model.flights.visitors.AbstractPTCFareBreakdownsVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.PricedItineraryVisitor;

@Component
public class SabrePricedItinerariesTransformer {
	@Autowired
	private SabreAirItineraryTransformer airItineraryTransformer;
	
	// this function mapped itinerary object
	public List<Itinerary> mappedPricedItinerarywithItineraries(PricedItinerary pricedItinerary) {
		List<Itinerary> itineraries = new ArrayList<Itinerary>();
		Itinerary itinerary = new Itinerary();
		
		AirItinerary airItinerary = pricedItinerary.getAirItinerary();
		List<OriginDestinationOption> originDestinationOptions = airItinerary.getOriginDestinationOptions().getOriginDestinationOption();

		Stream.of(0, 1).forEach(index -> {
			List<FlightSegment> flightSegmentList = originDestinationOptions.get(index).getFlightSegment();
			List<Flight> flightList = airItineraryTransformer.getFlightList(flightSegmentList, pricedItinerary);
			if (index == 0) {
				// 1st position refers to Out-bound flights
				itinerary.setOutbound(Outbound.getBuilder().flights(flightList).instance());
			} else if (index == 1) {
				// 2nd position refers to In-bound flights
				itinerary.setInbound(Inbound.getBuilder().flights(flightList).instance());
			}
		});
				
		itineraries.add(itinerary);
		return itineraries;
	}
	
	// this function mapped Fare object
	public Fare mappedPricedItinerarywithFare(PricedItinerary pricedItinerary){	
		Fare fare = new Fare();
		PricePerAdult pricePerAdult= new PricePerAdult();
		
		PricedItineraryVisitor visitor = new AbstractPTCFareBreakdownsVisitor() {
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