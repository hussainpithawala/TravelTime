package com.synerzip.supplier.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.hotel.HotelSearchRQ;
import com.synerzip.supplier.amadeus.model.hotel.HotelSearchRS;

@Component
public class AmadeusHotelService extends AmadeusService {

	private Logger logger = LoggerFactory.getLogger(AmadeusHotelService.class);
	
	public HotelSearchRS searchHotelsByAirportCode(HotelSearchRQ hotelSearchRQ) {
		String subUrl = "/hotels/search-airport";
		return getResponseObject(subUrl, hotelSearchRQ, HotelSearchRS.class);
	}
}
