package com.synerzip.supplier.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.synerzip.TravelTimeApplication;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.InstaFlightRequest;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.InstaFlightResponse;

/**
 * @author synerzip
 *
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TravelTimeApplication.class })
@TestPropertySource(locations = { "classpath:supplier.properties", "classpath:application.properties"})
public class SabreFlightServiceTest {
	/**
	 * @author synerzip
	 *
	 */
	@Autowired
	private transient SabreFlightService sabreFlightService;
	
	public SabreFlightServiceTest(){
			
	}
	
	private String getCurrentDate(){
		return LocalDateTime.now().toLocalDate().toString();
	}
	
	private String getTwoDaysAfterCurrentDate(){
		return LocalDateTime.now().toLocalDate().plus(2, ChronoUnit.DAYS).toString();
	}
	
	/**
	 * @author synerzip
	 *
	 */
	@Test
	public void testDoInstaFlightSearch() {
		final InstaFlightRequest request = new InstaFlightRequest();
		request.setOrigin("ORD");
		request.setDestination("LGA");
		request.setDeparturedate(getCurrentDate());
		request.setReturndate(getTwoDaysAfterCurrentDate());
//		request.setMaxfare(140.0);
		final InstaFlightResponse response = sabreFlightService.doInstaFlightSearch(request);
		Assert.assertNull(response.getAdditionalProperties().get("errorCode"));
		Assert.assertNotNull("Returned Priced Itineraries", response.getPricedItineraries().size());
	}

}
