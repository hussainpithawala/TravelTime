package com.synerzip.supplier.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.Fare;
import com.synerzip.supplier.amadeus.model.flights.Flight;
import com.synerzip.supplier.amadeus.model.flights.Inbound;
import com.synerzip.supplier.amadeus.model.flights.Itinerary;
import com.synerzip.supplier.amadeus.model.flights.Outbound;
import com.synerzip.supplier.amadeus.model.flights.PricePerAdult;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.AirItinerary;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.AirItineraryPricingInfo;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FlightSegment;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.OriginDestinationOption;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PTC_FareBreakdown;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PassengerFare;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PricedItinerary;

@Component
public class sabrePricedItinerariesTransformer {
	@Autowired
	private sabreAirItineraryTransformer airItineraryTransformer;
	
	@Autowired
	private AirItineraryPricingInfoTransformer airItineraryPricingInfoTransformer;
	
	// this function mapped itinerary object
	public List<Itinerary> mappedPricedItinerarywithItineraries(PricedItinerary pricedItinerary) {
		List<Itinerary> itineraries = new ArrayList<Itinerary>();
		Itinerary itinerary = new Itinerary();
		AirItinerary airItinerary = airItineraryTransformer.getAirItinerary(pricedItinerary);
		List<OriginDestinationOption> originDestinationOptions = airItineraryTransformer
				.getoriginDestinationOptionList(airItinerary);
		for (int iternary_index = 0; iternary_index < originDestinationOptions.size(); ++iternary_index) {
			OriginDestinationOption originDestinationOption = originDestinationOptions.get(iternary_index);
			List<FlightSegment> flightSegmentlist = airItineraryTransformer.getFlightSegment(originDestinationOption);
			if (iternary_index == 0) {
				Outbound outBound = new Outbound();
				List<Flight> flightList = airItineraryTransformer.getFlightList(flightSegmentlist, pricedItinerary);
				outBound.setFlights(flightList);
				itinerary.setOutbound(outBound);
			} else if (iternary_index == 1) {
				Inbound inBound = new Inbound();
				List<Flight> flightList = airItineraryTransformer.getFlightList(flightSegmentlist, pricedItinerary);
				inBound.setFlights(flightList);
				itinerary.setInbound(inBound);
			}
		}
		itineraries.add(itinerary);
		return itineraries;
	}
	
	// this function mapped Fare object
	public Fare mappedPricedItinerarywithFare(PricedItinerary pricedItinerary){	
		Fare fare = new Fare();
		PricePerAdult pricePerAdult= new PricePerAdult();
//		String totalFare = airItineraryPricingInfoTransformer.getTotalFare(airItineraryPricingInfoTransformer.getPassengerFare(airItineraryPricingInfoTransformer.getPTCBreakdown(airItineraryPricingInfoTransformer.getAirItineraryPricingInfo(pricedItinerary))));
		AirItineraryPricingInfo airItineraryPricingInfo = airItineraryPricingInfoTransformer.getAirItineraryPricingInfo(pricedItinerary);
		PTC_FareBreakdown PTC_FareBreakdown = airItineraryPricingInfoTransformer.getPTCBreakdown(airItineraryPricingInfo);
		PassengerFare passengerFare = airItineraryPricingInfoTransformer.getPassengerFare(PTC_FareBreakdown);
		String totalFare = airItineraryPricingInfoTransformer.getTotalFare(passengerFare);
		String totalTax = airItineraryPricingInfoTransformer.getTaxAmount(passengerFare);
		fare.setTotalPrice(totalFare);
		pricePerAdult.setTax(totalTax);
		fare.setPricePerAdult(pricePerAdult);
		return fare;
	}
}