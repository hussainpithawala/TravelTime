package com.synerzip.client.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.synerzip.TravelTimeApplication;
import com.synerzip.supplier.amadeus.model.flights.ExtensiveSearchRQ;
import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRQ;

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
	
	@Test
    // Tests the response status of searchFlights request.  
    public void searchFlights() throws Exception {
    	LowFareFlightSearchRQ flightSearchRequest = new LowFareFlightSearchRQ();
    	flightSearchRequest.setOrigin("ORD");
    	flightSearchRequest.setDestination("LGA");
    	flightSearchRequest.setDepartureDate("2016-11-25");
    	flightSearchRequest.setReturnDate("2016-11-30");
    	flightSearchRequest.setNumberOfResults(2);
    	ObjectMapper mapper = new ObjectMapper();
    	mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    	ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
    	String requestJson = writer.writeValueAsString(flightSearchRequest);
    	mockMvc.perform(MockMvcRequestBuilders.post("/rest/searchFlights")
    			.content(requestJson)
    			.contentType(MediaType.APPLICATION_JSON_VALUE))
          .andExpect(status().isOk())
          .andDo(print());
    }	
	
	@Test
	// Tests response status of searchFlightExtensive
	public void searchFlightExtensiveTest() throws Exception {
		ExtensiveSearchRQ flightSearchRequest = new ExtensiveSearchRQ();
		flightSearchRequest.setOrigin("FRA");
		flightSearchRequest.setDestination("LON");
		flightSearchRequest.setDepartureDate("2016-12-02--2016-12-06");
		flightSearchRequest.setOneWay(true);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = writer.writeValueAsString(flightSearchRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/searchExtensive")
				.content(requestJson)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}
	
    @Test
    // Tests the response status of Flight Inspiration request.
    public void searchFilghtInspiration() throws Exception {
      mockMvc.perform(MockMvcRequestBuilders.get("/rest/searchFlightInspiration").accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andDo(print());
    }

    @Test
    // Tests the response status of Location Information request.
    public void searchLocationInformation() throws Exception {
      mockMvc.perform(MockMvcRequestBuilders.get("/rest/searchLocationInformation")
          .accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andDo(print());
    }

	@Test
	public void searchAffiliateFlight() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/searchAffiliate").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void airportAutocomplete() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/airportAutocomplete").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());
	}
}
