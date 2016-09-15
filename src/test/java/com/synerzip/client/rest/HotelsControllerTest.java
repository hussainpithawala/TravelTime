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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.synerzip.TravelTimeApplication;
import com.synerzip.supplier.amadeus.model.hotel.HotelSearchRQ;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TravelTimeApplication.class })
@TestPropertySource(locations = { "classpath:supplier.properties", "classpath:application.properties" })
public class HotelsControllerTest {
	@Autowired
	private HotelsController instance;

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

	@Test
	// Tests the response status of searchHotelsByAirportCode request.
	public void searchHotelsByAirprtCode() throws Exception {
		// set request object using builder pattern
		HotelSearchRQ hotelSearchRequest = HotelSearchRQ.getBuilder().location("BOS")
				.CheckIn(getCurrentDate()).CheckOut(getTwoDaysAfterCurrentDate()).radius(42).lang("EN")
				.currency("USD").maxRate(500).numberOfResults(10).showSoldOut(false).allRooms(true).getInstance();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = writer.writeValueAsString(hotelSearchRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/hotelSearchByAirportCode").content(requestJson)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	}
}
