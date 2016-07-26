package com.synerzip.client.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.synerzip.model.flight.ExtensiveSearchRS;
import com.synerzip.model.flight.FlightInspirationSearchRS;
import com.synerzip.model.flight.LowFareFlightSearchRQ;
import com.synerzip.model.flight.LowFareFlightSearchRS;
import com.synerzip.supplier.service.AmadeusSupplierService;

@RestController
public class FlightsService {

	@Autowired
	private Environment env;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(FlightsService.class);
	
	@Autowired
	AmadeusSupplierService amadeusService;
	
	@RequestMapping(value = "/rest/searchLowFare", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LowFareFlightSearchRS> searchLowFareFlights() {
		StringBuilder url = new StringBuilder("http://api.sandbox.amadeus.com/v1.2/flights/low-fare-search?origin=LHR&destination=JFK&departure_date=2016-07-30&return_date=2016-08-07&number_of_results=3&apikey=");
		url.append(env.getProperty("amadeus.api.key"));
		
		logger.info(url.toString());
		
		return new ResponseEntity<LowFareFlightSearchRS>(restTemplate.getForObject(url.toString(), LowFareFlightSearchRS.class), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rest/post/searchLowFare", method=RequestMethod.POST)
	public ResponseEntity<LowFareFlightSearchRS> searchLowFareFlightsWithPost(@RequestBody LowFareFlightSearchRQ lowFareFlightRequest) {
		StringBuilder url = new StringBuilder("http://api.sandbox.amadeus.com/v1.2/flights/low-fare-search?origin=LHR&destination=JFK&departure_date=2016-07-30&return_date=2016-08-07&number_of_results=3&apikey=");
		url.append(env.getProperty("amadeus.api.key"));
		
		logger.info(url.toString());
		
		return new ResponseEntity<LowFareFlightSearchRS>(restTemplate.getForObject(url.toString(), LowFareFlightSearchRS.class), HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/async/searchLowFare", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public AsyncResult<LowFareFlightSearchRS> searchLowFareFlightsAsync() {
		StringBuilder url = new StringBuilder(
				"http://api.sandbox.amadeus.com/v1.2/flights/low-fare-search?origin=LHR&destination=JFK&departure_date=2016-07-30&return_date=2016-08-07&number_of_results=3&apikey=");
		url.append(env.getProperty("amadeus.api.key"));

		logger.info(url.toString());
		return new AsyncResult<LowFareFlightSearchRS>(restTemplate.getForObject(url.toString(), LowFareFlightSearchRS.class));
	}
	
	
	@RequestMapping(value = "/rest/searchExtensive", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ExtensiveSearchRS> searchextensiveFlights() {
		StringBuilder url = new StringBuilder("http://api.sandbox.amadeus.com/v1.2/flights/extensive-search?origin=FRA&destination=LON&departure_date=2016-08-07--2016-08-16&one-way=false&duration=3&direct=false&max_price=450&aggregation_mode=DAY&apikey=");
		url.append(env.getProperty("amadeus.api.key"));
		
		logger.info(url.toString());
		return new ResponseEntity<ExtensiveSearchRS>(restTemplate.getForObject(url.toString(), ExtensiveSearchRS.class), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/rest/searchFlightInspiration", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlightInspirationSearchRS> searchFlightInspiration() {
		StringBuilder url = new StringBuilder("http://api.sandbox.amadeus.com/v1.2/flights/inspiration-search?origin=NYC&destination=PAR&departure_date=2016-09-11--2016-09-26&one-way=false&duration=1--15&&direct=false&max_price=4000&aggregation_mode=WEEK&apikey=");
		url.append(env.getProperty("amadeus.api.key"));
		
		logger.info(url.toString());
		
		return new ResponseEntity<FlightInspirationSearchRS>(restTemplate.getForObject(url.toString(), FlightInspirationSearchRS.class), HttpStatus.OK);
	}
	
}
