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
@TestPropertySource(locations = { "classpath:supplier.properties", "classpath:application.properties" })
/**
* @author synerzip
*
*/
public class TimeServiceTest {
	/**
	 * @author synerzip
	 *
	 */
	@Autowired
	private transient TimeService timeService;

	private static final Logger logger = LoggerFactory.getLogger(TimeServiceTest.class);
	
	/**
	 * @author synerzip
	 *
	*/
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	/**
	 * @author synerzip
	 *
	*/
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	/**
	 * @author synerzip
	 *
	*/
	@Before
	public void setUp() throws Exception {
	}
	
	/**
	 * @author synerzip
	 *
	*/
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * @author synerzip
	 *
	 */
	@Test
	public void testGetBlkTime() {
		final String departAirportCode = "IST";
		final String departureDateTimeString = "2015-10-15T13:25";

		final String arrivalAirportCode = "BOS";
		final String arrivalDateTimeString = "2015-10-15T17:00";

		final DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm");

		final LocalDateTime departDateTime = LocalDateTime.parse(departureDateTimeString.replace('T', ' '), formatter);
		final LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalDateTimeString.replace('T', ' '), formatter);

		final Long blktime = timeService.getBlkTime(departAirportCode, departDateTime, arrivalAirportCode, arrivalDateTime)
				.getStandardMinutes();

		Assert.assertEquals(Long.valueOf(635L), blktime);
	}
	
	/**
	 * @author synerzip
	 *
	*/
	@Test
	public void testGetLayOverTime() {
		final String airportCode = "CDG";
		final String arrivalDateTimeString = "2015-10-22T08:35";
		final String departureDateTimeString = "2015-10-22T10:00";

		final DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm");

		final LocalDateTime departDateTime = LocalDateTime.parse(departureDateTimeString.replace('T', ' '), formatter);
		final LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalDateTimeString.replace('T', ' '), formatter);

		final Long layOverTime = timeService.getLayOverTime(airportCode, arrivalDateTime, departDateTime)
				.getStandardMinutes();
		Assert.assertEquals(Long.valueOf(85L), layOverTime);
	}

	/**
	 * @author synerzip
	 *
	*/
	public void testImportTimeZoneFile() {
		timeService.importTimeZoneFile("src/test/resources/data-files/timezones.txt");
	}

	/**
	 * @author synerzip
	 *
	*/
	public void testImportAirportFile() {
		timeService.importAirportFile("src/test/resources/data-files/stations.txt");
	}

}
