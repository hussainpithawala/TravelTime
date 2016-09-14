package com.synerzip.client.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.synerzip.TravelTimeApplication;
import com.synerzip.supplier.amadeus.model.flights.AffiliateFlightSearchRQ;
import com.synerzip.supplier.amadeus.model.flights.AirportAutocompleteRQ;
import com.synerzip.supplier.amadeus.model.flights.ExtensiveSearchRQ;
import com.synerzip.supplier.amadeus.model.flights.FlightInspirationSearchRQ;
import com.synerzip.supplier.amadeus.model.flights.LocationInformationSearchRQ;
import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRQ;
import com.synerzip.supplier.amadeus.model.flights.NearestAirportSearchRQ;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TravelTimeApplication.class })
@TestPropertySource(locations = { "classpath:supplier.properties", "classpath:application.properties"})
public class FlightsControllerTest {
	@Autowired
	private FlightsController instance;
	
	private MockMvc mockMvc;
	
	@Before
	// create a instance and start server for test.
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(instance).build();
	}
	
	private String getCurrentDate(){
		return LocalDateTime.now().toLocalDate().toString();
	}
	
	private String getTwoDaysAfterCurrentDate(){
		return LocalDateTime.now().toLocalDate().plus(2, ChronoUnit.DAYS).toString();
	}
	
	private String convertObjectToJson(Object requestObject){
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = null;
		try {
			requestJson = writer.writeValueAsString(requestObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return requestJson;
		
	}
	
	@Test
	// Tests the response status of searchFlights request.
	public void searchFlights() throws Exception {
		//set request object using builder pattern
		LowFareFlightSearchRQ flightSearchRequest = LowFareFlightSearchRQ.getBuilder().origin("ORD").destination("LGA")
				.departureDate(getCurrentDate()).returnDate(getTwoDaysAfterCurrentDate()).numberOfResults(2).getInstance();
		String requestJson = convertObjectToJson(flightSearchRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/searchFlights")
				.content(requestJson)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}
	
	@Test
	// Tests response status of searchFlightExtensive
	public void searchFlightExtensiveTest() throws Exception {
		ExtensiveSearchRQ flightSearchRequest = ExtensiveSearchRQ.getBuilder().origin("FRA").destination("LON")
				.departureDate(getCurrentDate() + "--" + getTwoDaysAfterCurrentDate()).oneWay(false).getInstance();
		String requestJson = convertObjectToJson(flightSearchRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/searchExtensive")
				.content(requestJson)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}
	
	@Test
	// Tests the response status of Flight Inspiration request.
	public void searchFilghtInspiration() throws Exception {
		FlightInspirationSearchRQ flightSearchRequest = FlightInspirationSearchRQ.getBuilder().origin("NYC")
				.destination("PAR").departureDate(getCurrentDate()+ "--" + getTwoDaysAfterCurrentDate())
				.oneWay(false).duration(2).maxPrice(900).aggregationMode("WEEK").getInstance();
		String requestJson = convertObjectToJson(flightSearchRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/searchFlightInspiration")
				.content(requestJson)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}

    @Test
    // Tests the response status of Location Information request.
    public void searchLocationInformation() throws Exception {
    	LocationInformationSearchRQ airportSearchRequest = LocationInformationSearchRQ.getBuilder().code("DUB").getInstance();
    	String requestJson = convertObjectToJson(airportSearchRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/searchLocationInformation")
				.content(requestJson)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
    }

	@Test
	// Tests the response status of Affiliate search request.
	public void searchAffiliateFlight() throws Exception {
		AffiliateFlightSearchRQ flightSearchRequest = AffiliateFlightSearchRQ.getBuilder().origin("LON")
				.destination("DUB").departureDate(getCurrentDate()).returnDate(getTwoDaysAfterCurrentDate()).adults(1)
				.children(0).infants(0).maxPrice(900).currency("US").mobile(false).getInstance();
		String requestJson = convertObjectToJson(flightSearchRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/searchAffiliate")
				.content(requestJson)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}
	
	@Test
	// Tests the response status of nearest airport request.
	public void searchNearestAirport() throws Exception {
		NearestAirportSearchRQ airportSearchRequest = NearestAirportSearchRQ.getBuilder().latitude(54.9501).longitude(-71.7412).getInstance();
		String requestJson = convertObjectToJson(airportSearchRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/searchNearestAirport")
				.content(requestJson)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}
	
	@Test
	// Tests the response status of airport auto complete request.
	public void airportAutocomplete() throws Exception {
		AirportAutocompleteRQ airportAutocompleteRequest = AirportAutocompleteRQ.getBuilder().term("LON").country("US")
				.allAirports(false).getInstance();
		String requestJson = convertObjectToJson(airportAutocompleteRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/airportAutocomplete")
				.content(requestJson)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());				
	}
}
