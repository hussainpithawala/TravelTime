package com.synerzip;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.core.env.Environment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
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

public class FlightsServiceTest {
	@Mock
	private Environment env;
	@Mock
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
				.andExpect(status().isOk());

	}

}
