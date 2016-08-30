package com.synerzip.client.rest;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.synerzip.supplier.amadeus.model.flights.AffiliateFlightSearchRS;
import com.synerzip.supplier.amadeus.model.flights.AirportAutocompleteRS;
import com.synerzip.supplier.amadeus.model.flights.ExtensiveSearchRQ;
import com.synerzip.supplier.amadeus.model.flights.ExtensiveSearchRS;
import com.synerzip.supplier.amadeus.model.flights.FlightInspirationSearchRS;
import com.synerzip.supplier.amadeus.model.flights.LocationInformationSearchRS;
import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRQ;
import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRS;
import com.synerzip.supplier.amadeus.model.flights.NearestAirportSearchRS;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.InstaFlightRequest;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.InstaFlightResponse;
import com.synerzip.supplier.service.AmadeusFlightService;
import com.synerzip.supplier.service.SabreFlightService;
import com.synerzip.utilities.sabre2amadeus.writers.InstaFlightRequestWriter;
import com.synerzip.utilities.sabre2amadeus.writers.LowFareFlightSearchRSWriter;

@RestController
public class FlightsController {

	@Autowired
	private Environment env;

	@Autowired
	@Qualifier("basic")
	private RestTemplate restTemplate;

	private Logger logger = LoggerFactory.getLogger(FlightsController.class);

	@Autowired
	private InstaFlightRequestWriter instaFlightRequestWriter;

	@Autowired
	private LowFareFlightSearchRSWriter lowFareFlightSearchRSWriter;

	@Autowired
	private AmadeusFlightService amadeusFlightService;

	@Autowired
	private SabreFlightService sabreFlightService;

	@Autowired
	private ThreadPoolTaskExecutor executor;
	
	private boolean lowfareSearchAsync = false;
	
	
	@RequestMapping(value = "/rest/searchFlights", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LowFareFlightSearchRS> searchFlights(
			@RequestBody LowFareFlightSearchRQ lowFareFlightSearchRQ) {
		ConcurrentLinkedDeque<LowFareFlightSearchRS> collection = new ConcurrentLinkedDeque<>();
		
		CountDownLatch latch = new CountDownLatch(2); // count-down of two, one for Sabre and other for Amadeus.
		
		executor.execute(() -> {
			try {
				// prepare a Sabre's InstaFlightRequest from Amadeus's LowFareFlightSearchRQ
				InstaFlightRequest instaFlightRequest = instaFlightRequestWriter.write.apply(lowFareFlightSearchRQ);
				
				// fetch the response from Sabre's service
				InstaFlightResponse instaFlightResponse = sabreFlightService.doInstaFlightSearch(instaFlightRequest);
				
				// write Amadeus's LowFareFlightSearchRS using Sabre's InstaFlightResponse
				LowFareFlightSearchRS response = lowFareFlightSearchRSWriter.write.apply(instaFlightResponse);
				
				collection.add(response);
			} catch(Exception e) {
				logger.error("An error has occured while processing Sabre Request", e);
			} finally {
				latch.countDown();
			}
		});

		executor.execute(() -> {
			try {
				collection.add(amadeusFlightService.fetchLowFareFlights(lowFareFlightSearchRQ,lowfareSearchAsync));
			} catch (Exception e) {
				logger.error("An error has occured while processing Amadeus Request", e);
			} finally {
				latch.countDown();
			}
		});
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			logger.error("Request executor thread has been interrupted", e);
			e.printStackTrace();
		}

		// the two responses are from Amadeus's and Sabre's. we just merge them into the one
		LowFareFlightSearchRS first = collection.getFirst();
		LowFareFlightSearchRS second = collection.getLast();
		
		first.getResults().addAll(second.getResults());
		
		return new ResponseEntity<LowFareFlightSearchRS>(first, HttpStatus.OK);
	}
	
	//this is asynchronous search call for low fare 
	//not tested
	@RequestMapping(value = "/rest/async/searchLowFare", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public AsyncResult<LowFareFlightSearchRS> searchLowFareFlightsAsync(@RequestBody LowFareFlightSearchRQ lowFareFlightSearchRQ) {
		return new AsyncResult<LowFareFlightSearchRS>(amadeusFlightService.fetchLowFareFlights(lowFareFlightSearchRQ,lowfareSearchAsync));
	}
	
	// This service retrieves prices of flights over a large number of days.
	@RequestMapping(value = "/rest/searchExtensive", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ExtensiveSearchRS> searchFlightExtensive(@RequestBody ExtensiveSearchRQ extensiveSearchRQ) {
		return new ResponseEntity<ExtensiveSearchRS>(amadeusFlightService.fetchExtensiveFlights(extensiveSearchRQ),
				HttpStatus.OK);
	}

	// The Inspiration Flight Search allows you to find the prices of one-way
	// and return flights from an origin city without necessarily having a
	// destination, or even a flight date
	@RequestMapping(value = "/rest/searchFlightInspiration", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlightInspirationSearchRS> searchFlightInspiration() {
		StringBuilder url = new StringBuilder(
				"http://api.sandbox.amadeus.com/v1.2/flights/inspiration-search?origin=NYC&destination=PAR&departure_date=2016-09-11--2016-09-26&one-way=false&duration=1--15&&direct=false&max_price=4000&aggregation_mode=WEEK&apikey=");
		url.append(env.getProperty("amadeus.api.key"));

		logger.info(url.toString());
		return new ResponseEntity<FlightInspirationSearchRS>(
				restTemplate.getForObject(url.toString(), FlightInspirationSearchRS.class), HttpStatus.OK);
	}

	// This service retrieves the location information corresponding to a IATA
	// city or airport code.
	@RequestMapping(value = "/rest/searchLocationInformation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LocationInformationSearchRS> searchLocationInformation() {
		StringBuilder url = new StringBuilder("http://api.sandbox.amadeus.com/v1.2/location/PAR/?apikey=");
		url.append(env.getProperty("amadeus.api.key"));

		logger.info(url.toString());
		return new ResponseEntity<LocationInformationSearchRS>(
				restTemplate.getForObject(url.toString(), LocationInformationSearchRS.class), HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/searchAffiliate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AffiliateFlightSearchRS> searchFlightAffiliate() {
		StringBuilder url = new StringBuilder(
				"http://api.sandbox.amadeus.com/v1.2/flights/affiliate-search?origin=LON&destination=DUB&departure_date=2016-11-25&return_date=2016-11-28&adults=1&children=0&infants=0&max_price=980&cy=EUR&mobile=false&apikey=");
		url.append(env.getProperty("amadeus.api.key"));

		logger.info(url.toString());
		return new ResponseEntity<AffiliateFlightSearchRS>(
				restTemplate.getForObject(url.toString(), AffiliateFlightSearchRS.class), HttpStatus.OK);
	}

	// This service gives the most relevant airports in a radius of 500 km
	// around the given coordinates.
	@RequestMapping(value = "/rest/searchNearestAirport", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NearestAirportSearchRS[]> searchNearestAirport() {
		StringBuilder url = new StringBuilder(
				"http://api.sandbox.amadeus.com/v1.2/airports/nearest-relevant?latitude=54.9501&longitude=-7.7373&apikey=");
		url.append(env.getProperty("amadeus.api.key"));

		logger.info(url.toString());
		return new ResponseEntity<NearestAirportSearchRS[]>(
				restTemplate.getForObject(url.toString(), NearestAirportSearchRS[].class), HttpStatus.OK);
	}

	// This service provides a full name of IATA location with their IATA code.
	@RequestMapping(value = "/rest/airportAutocomplete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AirportAutocompleteRS[]> airportAutocomplete() {
		StringBuilder url = new StringBuilder(
				"http://api.sandbox.amadeus.com/v1.2/airports/autocomplete?term=LON&apikey=");
		url.append(env.getProperty("amadeus.api.key"));

		logger.info(url.toString());
		return new ResponseEntity<AirportAutocompleteRS[]>(
				restTemplate.getForObject(url.toString(), AirportAutocompleteRS[].class), HttpStatus.OK);
	}

	// This service is accept search keyword and return possible set of result
	@RequestMapping(value = "/rest/get/airportAutocomplete", method = RequestMethod.GET)
	public ResponseEntity<AirportAutocompleteRS[]> searchairportAutoComplete(@RequestParam("term") String term) {
		StringBuilder url = new StringBuilder(
				"http://api.sandbox.amadeus.com/v1.2/airports/autocomplete?term=" + term + "&apikey=");
		url.append(env.getProperty("amadeus.api.key"));
		logger.info(url.toString());
		return new ResponseEntity<AirportAutocompleteRS[]>(
				restTemplate.getForObject(url.toString(), AirportAutocompleteRS[].class), HttpStatus.OK);
	}
}
