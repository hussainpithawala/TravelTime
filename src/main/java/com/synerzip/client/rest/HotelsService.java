package com.synerzip.client.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.synerzip.model.hotel.HotelSearchRS;

@RestController
public class HotelsService {

	@Autowired
	private Environment env;

	@Autowired
	private RestTemplate restTemplate;

	private Logger logger = LoggerFactory.getLogger(HotelsService.class);

	@RequestMapping(value = "/rest/hotelsearch", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HotelSearchRS> searchLowFareFlights() {
		StringBuilder url = new StringBuilder(
				"http://api.sandbox.amadeus.com/v1.2/hotels/search-airport?&location=BOM&check_in=2016-09-09&check_out=2016-10-11&apikey=");
		url.append(env.getProperty("amadeus.api.key"));

		logger.info(url.toString());

		return new ResponseEntity<HotelSearchRS>(restTemplate.getForObject(url.toString(), HotelSearchRS.class),
				HttpStatus.OK);
	}

}
