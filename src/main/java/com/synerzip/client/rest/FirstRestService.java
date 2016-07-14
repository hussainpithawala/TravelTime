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

import com.synerzip.models.LowFareFlightSearchRS;

@RequestMapping("/rest")
@RestController
public class FirstRestService {
	@Autowired
	private Environment env;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(FirstRestService.class);
	
	@RequestMapping(value = "/hello", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SimpleResponse> hello() {
		return new ResponseEntity<SimpleResponse>(new SimpleResponse("Happy Coding with Spring...."), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/searchLowFare", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LowFareFlightSearchRS> searchLowFareFlights() {
		StringBuilder url = new StringBuilder("http://api.sandbox.amadeus.com/v1.2/flights/low-fare-search?origin=LHR&destination=JFK&departure_date=2016-07-30&return_date=2016-08-07&number_of_results=3&apikey=");
		url.append(env.getProperty("amadeus.api.key"));
		
		logger.info(url.toString());
		
		return new ResponseEntity<LowFareFlightSearchRS>(restTemplate.getForObject(url.toString(), LowFareFlightSearchRS.class), HttpStatus.OK);
	}
	
	public static class SimpleResponse {
		private String message;
		public SimpleResponse(String message) {
			this.message = message;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
	}
}
