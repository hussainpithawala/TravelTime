package com.synerzip;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import com.synerzip.client.rest.FlightsService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TravelTimeApplication.class })
@TestPropertySource(locations = { "classpath:supplier.properties" })
public class FlightsServiceTest {
	@Autowired
	private Environment env;
	@Autowired
	private RestTemplate restTemplate;
	private MockMvc mockMvc;

	@Before
	// create a instance and start server for test.
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		FlightsService instance = new FlightsService();
		ReflectionTestUtils.setField(instance, "env", env);
		ReflectionTestUtils.setField(instance, "restTemplate", restTemplate);
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
    // Tests the response status of Nearest Airport request.
    public void searchNearestAirport() throws Exception {
      mockMvc.perform(MockMvcRequestBuilders.get("/rest/searchNearestAirport").accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andDo(print());
    }
}
