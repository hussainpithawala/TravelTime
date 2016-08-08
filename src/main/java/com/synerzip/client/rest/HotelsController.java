package com.synerzip.client.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.synerzip.supplier.amadeus.model.hotel.HotelSearchRQ;
import com.synerzip.supplier.amadeus.model.hotel.HotelSearchRS;

@RestController
public class HotelsController {

	@Autowired
	private Environment env;

	@Autowired
	private RestTemplate restTemplate;

	private Logger logger = LoggerFactory.getLogger(HotelsController.class);
	
	@RequestMapping(value="/rest/hotelSearchByAirportCode", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HotelSearchRS> searchHotelsByAirportCode(@RequestBody HotelSearchRQ hotelSearchRQ){
		StringBuilder url = new StringBuilder("http://api.sandbox.amadeus.com/v1.2/hotels/search-airport?");
		
		// append location
		url.append("location=");
		url.append(hotelSearchRQ.getLocation());
		
		// append checkin date
		url.append("&check_in=");
		url.append(hotelSearchRQ.getCheckIn());
		
		// append checkout date
		url.append("&check_out=");
		url.append(hotelSearchRQ.getCheckOut());
		
		// append apikey
		url.append("&apikey=");
		url.append(env.getProperty("amadeus.api.key"));

		logger.info(url.toString());
		
		return new ResponseEntity<HotelSearchRS>(restTemplate.getForObject(url.toString(), HotelSearchRS.class), HttpStatus.OK);
	}
}
