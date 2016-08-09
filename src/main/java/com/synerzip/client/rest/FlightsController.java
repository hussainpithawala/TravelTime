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
import com.synerzip.supplier.amadeus.model.flights.ExtensiveSearchRS;
import com.synerzip.supplier.amadeus.model.flights.FlightInspirationSearchRS;
import com.synerzip.supplier.amadeus.model.flights.LocationInformationSearchRS;
import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRQ;
import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRS;
import com.synerzip.supplier.amadeus.model.flights.NearestAirportSearchRS;
import com.synerzip.supplier.service.AmadeusSupplierService;
import com.synerzip.supplier.service.SabreFlightService;
import com.synerzip.supplier.utilities.RequestTransformer;
import com.synerzip.supplier.utilities.ResponseTransformer;

@RestController
public class FlightsController {

	@Autowired
	private Environment env;

	@Autowired
	@Qualifier("basic")
	private RestTemplate restTemplate;

	private Logger logger = LoggerFactory.getLogger(FlightsController.class);

	@Autowired
	private RequestTransformer requestTransformer;

	@Autowired
	private ResponseTransformer responseTransformer;

	@Autowired
	private AmadeusSupplierService amadeusService;

	@Autowired
	private SabreFlightService sabreFlightService;

	@Autowired
	private ThreadPoolTaskExecutor executor;
	
	
	@RequestMapping(value = "/rest/searchFlights", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LowFareFlightSearchRS[]> searchFlights(
			@RequestBody LowFareFlightSearchRQ flightSearchRequest) {
		ConcurrentLinkedDeque<LowFareFlightSearchRS> collection = new ConcurrentLinkedDeque<>();
		
		CountDownLatch latch = new CountDownLatch(2); // countdown of two, one for sabre and other for amadeus.
		
		executor.execute(() -> {
			try {
				LowFareFlightSearchRS response =
						responseTransformer.convert.apply(
								sabreFlightService.doInstaFlightSearch(requestTransformer.convert.apply(flightSearchRequest)));
						collection.add(response);
			} catch(Exception e) {
				logger.error("An error has occured while processing Sabre Request", e);
			} finally {
				latch.countDown();
			}
		});

		executor.execute(() -> {
			try {
				collection.add(amadeusService.fetchLowFareFlights(flightSearchRequest));
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

		LowFareFlightSearchRS[] responses = new LowFareFlightSearchRS[2];
		collection.toArray(responses);
		return new ResponseEntity<LowFareFlightSearchRS[]>(responses, HttpStatus.OK);
	}

	// This service retrieves the best price for flights.
	@RequestMapping(value = "/rest/searchLowFare", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LowFareFlightSearchRS> searchLowFareFlights() {
		StringBuilder url = new StringBuilder(
				"http://api.sandbox.amadeus.com/v1.2/flights/low-fare-search?origin=LHR&destination=JFK&departure_date=2016-08-30&return_date=2016-09-07&number_of_results=3&apikey=");
		url.append(env.getProperty("amadeus.api.key"));

		logger.info(url.toString());

		return new ResponseEntity<LowFareFlightSearchRS>(
				restTemplate.getForObject(url.toString(), LowFareFlightSearchRS.class), HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/post/searchLowFare", method = RequestMethod.POST)
	public ResponseEntity<LowFareFlightSearchRS> searchLowFareFlightsWithPost(
			@RequestBody LowFareFlightSearchRQ lowFareFlightRequest) {
		StringBuilder url = new StringBuilder(
				"http://api.sandbox.amadeus.com/v1.2/flights/low-fare-search?origin=LHR&destination=JFK&departure_date=2016-08-30&return_date=2016-09-07&number_of_results=3&apikey=");
		url.append(env.getProperty("amadeus.api.key"));

		logger.info(url.toString());

		return new ResponseEntity<LowFareFlightSearchRS>(
				restTemplate.getForObject(url.toString(), LowFareFlightSearchRS.class), HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/async/searchLowFare", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public AsyncResult<LowFareFlightSearchRS> searchLowFareFlightsAsync() {
		StringBuilder url = new StringBuilder(
				"http://api.sandbox.amadeus.com/v1.2/flights/low-fare-search?origin=LHR&destination=JFK&departure_date=2016-08-30&return_date=2016-09-07&number_of_results=3&apikey=");
		url.append(env.getProperty("amadeus.api.key"));

		logger.info(url.toString());
		return new AsyncResult<LowFareFlightSearchRS>(
				restTemplate.getForObject(url.toString(), LowFareFlightSearchRS.class));
	}

	// This service retrieves prices of flights over a large number of days.
	@RequestMapping(value = "/rest/searchExtensive", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ExtensiveSearchRS> searchFlightExtensive() {
		StringBuilder url = new StringBuilder(
				"http://api.sandbox.amadeus.com/v1.2/flights/extensive-search?origin=FRA&destination=LON&departure_date=2016-09-07--2016-09-16&one-way=false&duration=3&direct=false&max_price=450&aggregation_mode=DAY&apikey=");
		url.append(env.getProperty("amadeus.api.key"));

		logger.info(url.toString());
		return new ResponseEntity<ExtensiveSearchRS>(restTemplate.getForObject(url.toString(), ExtensiveSearchRS.class),
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