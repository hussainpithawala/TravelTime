package com.synerzip;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.synerzip.supplier.sabre.model.flights.instaflight_gen.InstaFlightRequest;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.InstaFlightResponse;
import com.synerzip.supplier.service.SabreFlightService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TravelTimeApplication.class })
@TestPropertySource(locations = { "classpath:supplier.properties" })
public class SabreFlightServiceTest {
	@Autowired
	private SabreFlightService sabreFlightService;
	
	@Test
	public void testDoInstaFlightSearch() {
		InstaFlightRequest request = new InstaFlightRequest();
		request.setOrigin("ORD");
		request.setDestination("LGA");
		request.setDeparturedate("2016-09-13");
		request.setReturndate("2016-09-16");
		request.setMaxfare(140.0);
		InstaFlightResponse response = sabreFlightService.doInstaFlightSearch(request);
		Assert.assertNotNull("Returned Priced Itineraries", response.getPricedItineraries().size());
	}

}
