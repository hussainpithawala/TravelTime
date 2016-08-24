package com.synerzip.supplier.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.BookingInfo;
import com.synerzip.supplier.amadeus.model.flights.Destination;
import com.synerzip.supplier.amadeus.model.flights.Flight;
import com.synerzip.supplier.amadeus.model.flights.Origin;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.AirItinerary;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.AirItineraryPricingInfo;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FlightSegment;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.OriginDestinationOption;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PTC_FareBreakdown;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PricedItinerary;

@Component
public class SabreAirItineraryTransformer {
	@Autowired
	private AirItineraryPricingInfoTransformer airItineraryPricingInfoTransformer;
	
	public AirItinerary getAirItinerary(PricedItinerary pricedItinerary){
		return pricedItinerary.getAirItinerary();
	}
	
	public List<OriginDestinationOption> getoriginDestinationOptionList(AirItinerary airItinerary){
		return airItinerary.getOriginDestinationOptions().getOriginDestinationOption();
	}
	
	public List<FlightSegment> getFlightSegment(OriginDestinationOption originDestinationOption){
        return originDestinationOption.getFlightSegment(); 
	}

	public String getOriginCode(FlightSegment flightSegment){
		return flightSegment.getDepartureAirport().getLocationCode();
	}
	
	public String getDestinationCode(FlightSegment flightSegment){
		return flightSegment.getArrivalAirport().getLocationCode();
	}
	
	public String getBookingCode(AirItineraryPricingInfo airItineraryPricingInfo){
		PTC_FareBreakdown PTC_FareBreakdown = airItineraryPricingInfoTransformer.getPTCBreakdown(airItineraryPricingInfo);
		return PTC_FareBreakdown.getFareBasisCodes().getFareBasisCode().get(0).getBookingCode();
	}
	
	public int getSeatsRemaining(AirItineraryPricingInfo airItineraryPricingInfo){
		return airItineraryPricingInfo.getFareInfos().getFareInfo().get(0).getTPA_Extensions().getSeatsRemaining()
				.getNumber();
	}
	
	public Flight getFlightObject(FlightSegment flightSegment,PricedItinerary pricedItinerary){
		Flight flight = new Flight();
		Origin Origin = new Origin();
		Destination Destination = new Destination();
		BookingInfo booking_info = new BookingInfo();
		//set destination origin object
		Origin.setAirport(getOriginCode(flightSegment));
		Destination.setAirport(getDestinationCode(flightSegment));
		
		//set bookingInfo object
		AirItineraryPricingInfo airItineraryPricingInfo = airItineraryPricingInfoTransformer.getAirItineraryPricingInfo(pricedItinerary);
		booking_info.setBookingCode(getBookingCode(airItineraryPricingInfo));
		booking_info.setSeatsRemaining(getSeatsRemaining(airItineraryPricingInfo));
		
		//set Flight object
		flight.setOrigin(Origin);
		flight.setDestination(Destination);
		flight.setMarketingAirline(flightSegment.getMarketingAirline().getCode());
 		flight.setOperatingAirline(flightSegment.getOperatingAirline().getCode());
		flight.setFlightNumber((flightSegment.getOperatingAirline().getFlightNumber()).toString());
	  	flight.setBookingInfo(booking_info);
	  	return flight;
	}
	
	public List<Flight> getFlightList(List<FlightSegment> flightSegmentlist, PricedItinerary pricedItinerary) {
		List<Flight> flightList = new ArrayList<Flight>();
		flightSegmentlist.stream().map(flightSegment -> {
			return getFlightObject(flightSegment, pricedItinerary);
		}).filter(flight -> flight != null).forEach(flight -> flightList.add(flight));
		return flightList;
	}
}