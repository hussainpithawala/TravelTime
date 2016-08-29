package com.synerzip.client.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.synerzip.TravelTimeApplication;
import com.synerzip.client.rest.FlightsController;
import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRQ;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TravelTimeApplication.class })
@TestPropertySource(locations = { "classpath:supplier.properties", "classpath:application.properties"})
public class FlightsControllerTest {
	@Autowired
	private Environment env;
	@Autowired
	private FlightsController instance;
	@Autowired
	@Qualifier("basic")
	private RestTemplate restTemplate;
	private MockMvc mockMvc;
	@Before
	// create a instance and start server for test.
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(instance).build();
	}

	@Test
	// Tests the response status and print the response on console of LowFare search request.
	public void searchLowFareFlight() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/searchLowFare").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void searchExtensiveFlight() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/searchExtensive").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());
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
    	ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
    	String requestJson=ow.writeValueAsString(flightSearchRequest);
    	mockMvc.perform(MockMvcRequestBuilders.post("/rest/searchFlights")
    			.content(requestJson)
    			.contentType(MediaType.APPLICATION_JSON_VALUE))
          .andExpect(status().isOk())
          .andDo(print());
    }
}
