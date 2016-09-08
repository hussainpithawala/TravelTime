package com.synerzip.supplier.service;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
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

import com.synerzip.TravelTimeApplication;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TravelTimeApplication.class })
@TestPropertySource(locations = { "classpath:supplier.properties", "classpath:application.properties"})
public class TimeServiceTest {
	@Autowired
	private TimeService timeService;

	private static final Logger logger = LoggerFactory.getLogger(TimeServiceTest.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void testGetBlkTime() {
		String departAirportCode = "IST";
		String departureDateTimeString = "2015-10-15T13:25";
		
		String arrivalAirportCode = "BOS";
		String arrivalDateTimeString = "2015-10-15T17:00";

		DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm");

		LocalDateTime departDateTime = LocalDateTime.parse(departureDateTimeString.replace('T',' '), formatter);
		LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalDateTimeString.replace('T',' '), formatter);
		
		Long blktime = timeService.getBlkTime(departAirportCode, departDateTime, arrivalAirportCode, arrivalDateTime);

		Assert.assertEquals(new Long(635L), blktime);
	}

	@Test
	public void testGetLayOverTime() {
		String airportCode = "CDG";
		String arrivalDateTimeString = "2015-10-22T08:35";
		String departureDateTimeString = "2015-10-22T10:00";
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm");

		LocalDateTime departDateTime = LocalDateTime.parse(departureDateTimeString.replace('T',' '), formatter);
		LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalDateTimeString.replace('T',' '), formatter);

		Long layOverTime = timeService.getLayOverTime(airportCode, arrivalDateTime, departDateTime);
		Assert.assertEquals(new Long(85L), layOverTime);
	}
	
	public void testImportTimeZoneFile() {
		timeService.importTimeZoneFile("src/test/resources/data-files/timezones.txt");
	}

	public void testImportAirportFile() {
		timeService.importAirportFile("src/test/resources/data-files/stations.txt");
	}

}
