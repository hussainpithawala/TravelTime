package com.synerzip.utilities.sabre2amadeus.writers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.synerzip.TravelTimeApplication;
import com.synerzip.supplier.amadeus.model.flights.Flight;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FlightSegment;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PricedItinerary;

@RunWith(SpringRunner.class)
@WebAppConfiguration	
@ContextConfiguration(classes = { TravelTimeApplication.class })
@TestPropertySource(locations = { "classpath:supplier.properties", "classpath:application.properties" })
public class FlightWriterTest {
private static final Logger logger = LoggerFactory.getLogger(FlightWriterTest.class);
	
	@Autowired
	private FlightWriter writer;

	private static PricedItinerary response;
	
	private static FlightSegment flightSegment;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		response = new PricedItinerary();
		flightSegment = new FlightSegment();
		ObjectMapper objectMapper = new ObjectMapper();
		
		Files.walk(Paths.get("src/test/resources/sabre/response/InstaFlightsSearch/pricedItinerary.json"))
			.filter(Files::isRegularFile).map(Path::toFile).collect(Collectors.toList())
			.stream().forEach(file -> {
				try {
					response = objectMapper.readValue(file, PricedItinerary.class);
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			});
		
		Files.walk(Paths.get("src/test/resources/sabre/response/InstaFlightsSearch/flightSegment.json"))
		.filter(Files::isRegularFile).map(Path::toFile).collect(Collectors.toList())
		.stream().forEach(file -> {
			try {
				flightSegment = objectMapper.readValue(file, FlightSegment.class);
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		});
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Flight flight = writer.write(flightSegment, response);
		Assert.assertNotNull("Flight object can not be null", flight);
		Assert.assertEquals(flight.getOrigin().getAirport(),"ATL");
		Assert.assertEquals(flight.getDestination().getAirport(),"LAS");
		Assert.assertEquals(flight.getFlightNumber(),"1455");
		Assert.assertEquals(flight.getClass(), Flight.class);
	}

}
