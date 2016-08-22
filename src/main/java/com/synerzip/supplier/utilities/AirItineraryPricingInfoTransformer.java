package com.synerzip.supplier.utilities;

import org.springframework.stereotype.Component;

import com.synerzip.supplier.sabre.model.flights.instaflight_gen.AirItineraryPricingInfo;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PTC_FareBreakdown;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PassengerFare;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PricedItinerary;

@Component
public class AirItineraryPricingInfoTransformer {
	
	public AirItineraryPricingInfo getAirItineraryPricingInfo(PricedItinerary pricedItinerary){
		return pricedItinerary.getAirItineraryPricingInfo();
	}
	
	public PTC_FareBreakdown getPTCBreakdown(AirItineraryPricingInfo airItineraryPricingInfo){
		 return airItineraryPricingInfo.getPTC_FareBreakdowns().getPTC_FareBreakdown();
	}
	
	public PassengerFare getPassengerFare(PTC_FareBreakdown PTC_FareBreakdown){
		return PTC_FareBreakdown.getPassengerFare();
	}
	
	public String getTotalFare(PassengerFare passengerFare){
		return passengerFare.getTotalFare().getAmount();
	}
	
	public String getTaxAmount(PassengerFare passengerFare){
		return passengerFare.getTaxes().getTotalTax().getAmount();
	}
}
