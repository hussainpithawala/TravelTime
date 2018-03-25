package com.synerzip.client.rest;

import com.synerzip.client.repository.AirportRepository;
import com.synerzip.supplier.amadeus.model.flights.*;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.InstaFlightRequest;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.InstaFlightResponse;
import com.synerzip.supplier.service.AmadeusFlightService;
import com.synerzip.supplier.service.SabreFlightService;
import com.synerzip.utilities.sabre2amadeus.writers.InstaFlightRequestWriter;
import com.synerzip.utilities.sabre2amadeus.writers.LowFareFlightSearchRSWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

@RestController
public class FlightsController {

    private Logger logger = LoggerFactory.getLogger(FlightsController.class);

    @Autowired
    private AirportRepository airportRepository;

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

    @RequestMapping(value = "/rest/searchFlights", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LowFareFlightSearchRS> searchFlights2(@RequestBody final LowFareFlightSearchRQ lowFareFlightSearchRQ) {

        BiFunction<LowFareFlightSearchRS, Throwable, LowFareFlightSearchRS> exceptionHandler = (lowFareFlightSearchRS, ex) -> {
            if(ex != null) {
                logger.error("Unable to process the request", ex.getMessage());
                ex.printStackTrace();
                return null;
            } else {
                return lowFareFlightSearchRS;
            }
        };

        CompletableFuture<LowFareFlightSearchRS> sabreCompleteableFuture = CompletableFuture.supplyAsync(() -> {
            LowFareFlightSearchRS response = getLowFareFlightSearchRSFromSabre(lowFareFlightSearchRQ);
            return response;
        }).handle(exceptionHandler);

        CompletableFuture<LowFareFlightSearchRS> amadeusCompletableFuture = CompletableFuture.supplyAsync(() -> {
            LowFareFlightSearchRS response = amadeusFlightService.fetchLowFareFlights(lowFareFlightSearchRQ);
            return response;
        }).handle(exceptionHandler);

        LowFareFlightSearchRS lowFareFlightSearchRSFinal = Stream.of(sabreCompleteableFuture, amadeusCompletableFuture).map(CompletableFuture::join).reduce((lowFareFlightSearchRS, lowFareFlightSearchRS2) -> {
            LowFareFlightSearchRS result = null;
            if (lowFareFlightSearchRS != null && lowFareFlightSearchRS2 != null) {
                lowFareFlightSearchRS.getResults().addAll(lowFareFlightSearchRS2.getResults());
                result = lowFareFlightSearchRS;
            } else if (lowFareFlightSearchRS == null && lowFareFlightSearchRS2 != null) {
                result = lowFareFlightSearchRS2;
            } else if (lowFareFlightSearchRS != null && lowFareFlightSearchRS2 == null) {
                result = lowFareFlightSearchRS;
            }
            return result;
        }).get();

        return new ResponseEntity<>(lowFareFlightSearchRSFinal, HttpStatus.OK);
    }

    private LowFareFlightSearchRS getLowFareFlightSearchRSFromSabre(LowFareFlightSearchRQ lowFareFlightSearchRQ) {
        // prepare a Sabre's InstaFlightRequest from Amadeus's LowFareFlightSearchRQ
        InstaFlightRequest instaFlightRQ = instaFlightRequestWriter.write.apply(lowFareFlightSearchRQ);

        // fetch the response from Sabre's service
        InstaFlightResponse instaFlightResponse = sabreFlightService.doInstaFlightSearch(instaFlightRQ);

        // write Amadeus's LowFareFlightSearchRS using Sabre's InstaFlightResponse
        LowFareFlightSearchRS response = lowFareFlightSearchRSWriter.write.apply(instaFlightResponse);
        return response;
    }

    //this is asynchronous search call for low fare
    //not tested
    @RequestMapping(value = "/rest/async/searchLowFare", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public AsyncResult<LowFareFlightSearchRS> searchLowFareFlightsAsync(@RequestBody LowFareFlightSearchRQ lowFareFlightSearchRQ) {
        return new AsyncResult<LowFareFlightSearchRS>(amadeusFlightService.fetchLowFareFlights(lowFareFlightSearchRQ));
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
    @RequestMapping(value = "/rest/searchFlightInspiration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightInspirationSearchRS> searchFlightInspiration(
            @RequestBody FlightInspirationSearchRQ inspirationSearchRQ) {
        return new ResponseEntity<FlightInspirationSearchRS>(amadeusFlightService.fetchInspirationFlights(inspirationSearchRQ),
                HttpStatus.OK);
    }

    // This service retrieves the location information corresponding to a IATA
    // city or airport code.
    @RequestMapping(value = "/rest/searchLocationInformation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocationInformationSearchRS> searchLocationInformation(
            @RequestBody LocationInformationSearchRQ locationInformationSearchRQ) {
        return new ResponseEntity<LocationInformationSearchRS>(
                amadeusFlightService.fetchAiportLocation(locationInformationSearchRQ), HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/searchAffiliate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AffiliateFlightSearchRS> searchFlightAffiliate(
            @RequestBody AffiliateFlightSearchRQ affiliateFlightSearchRQ) {
        return new ResponseEntity<AffiliateFlightSearchRS>(
                amadeusFlightService.fetchAffiliateFlights(affiliateFlightSearchRQ), HttpStatus.OK);
    }

    // This service gives the most relevant airports in a radius of 500 km
    // around the given coordinates.
    @RequestMapping(value = "/rest/searchNearestAirport", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NearestAirportSearchRS[]> searchNearestAirport(
            @RequestBody NearestAirportSearchRQ nearestAirportSearchRQ) {
        return new ResponseEntity<NearestAirportSearchRS[]>(
                amadeusFlightService.fetchNearestAirport(nearestAirportSearchRQ), HttpStatus.OK);
    }

    // This service provides a full name of IATA location with their IATA code.
    @RequestMapping(value = "/rest/airportAutocomplete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportAutocompleteRS[]> searchairportAutoComplete(
            @RequestBody AirportAutocompleteRQ airportAutocompleteRQ) {

        String key = airportAutocompleteRQ.getTerm();

        String likeKey = key + "%";
        List<Object[]> objectArrayList = airportRepository.autoComplete(likeKey);

        int size = objectArrayList.size();
        AirportAutocompleteRS[] airportAutocompleteRSArray = new AirportAutocompleteRS[size];

        int index = 0;
        for (Object[] objectArray : objectArrayList) {
            String code = (String) objectArray[1];
            String name = (String) objectArray[2];

            AirportAutocompleteRS airportAutocompleteRS = new AirportAutocompleteRS();
            airportAutocompleteRS.setValue(code);
            airportAutocompleteRS.setLabel(name);

            airportAutocompleteRSArray[index] = airportAutocompleteRS;
            ++index;
        }

        return new ResponseEntity<AirportAutocompleteRS[]>(airportAutocompleteRSArray, HttpStatus.OK);
    }
}
