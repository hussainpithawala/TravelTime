package com.synerzip;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		FlightsService instance = new FlightsService();
		ReflectionTestUtils.setField(instance, "env", env);
		ReflectionTestUtils.setField(instance, "restTemplate", restTemplate);
		mockMvc = MockMvcBuilders.standaloneSetup(instance).build();
	}

	@Test
	public void searchLowFarecontextLoads() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/searchLowFare").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void searchFilghtInspiration() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/searchFlightInspiration").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());
	}

}
