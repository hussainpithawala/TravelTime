package com.synerzip.supplier.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synerzip.client.orm.Airport;
import com.synerzip.client.orm.Timezone;
import com.synerzip.client.repository.AirportRepository;
import com.synerzip.client.repository.TimezoneRepository;

@Component
public class TimeService {
	private Logger logger = LoggerFactory.getLogger(TimeService.class);

	@Autowired
	private AirportRepository airportRepository;

	@Autowired
	private TimezoneRepository timezoneRepository;

	private DateTime getDateTimeObject(String airport, LocalDateTime travelDate) {
		Airport departureAirport = airportRepository.findByCode(airport);
		List<Timezone> airportZones = timezoneRepository.findByCodes(departureAirport.getCountryCode(),
				departureAirport.getTimeZone());
		
		Timezone airportZone = airportZones.stream().filter(
				timezone ->  (new LocalDateTime(timezone.getStartDate())).isBefore(travelDate) && 
							 (new LocalDateTime(timezone.getEndDate())).isAfter(travelDate)) 
				.findAny().orElse(null);
		
		String gmtAdjustment =  airportZone.getGmtAdjustment();
		
		if(!gmtAdjustment.startsWith("-")) {
			if (gmtAdjustment.length() == 3) {
				gmtAdjustment = new StringBuffer(gmtAdjustment).insert(0, "0").toString();
			}
			gmtAdjustment = new StringBuffer(gmtAdjustment).insert(0, "+").toString();
		} else {
			if (gmtAdjustment.length() == 4) {
				gmtAdjustment = new StringBuffer(gmtAdjustment).insert(1, "0").toString();
			}
		}
		
		gmtAdjustment = new StringBuffer(gmtAdjustment).insert(gmtAdjustment.length() - 2, ":").toString();
		
		DateTimeZone departTimeZone = DateTimeZone.forID(gmtAdjustment);
		return travelDate.toDateTime(departTimeZone);
	}
	
	/**
	 * 
	 * @param departureStation
	 *            IATA airport code for departure station
	 * @param departureDate
	 *            Date-Time for flight departure (local to the departing
	 *            station)
	 * @param arrivalStation
	 *            IATA airport code for arrival station
	 * @param arrivalDate
	 *            Date-Time for flight arrival (local to the arrival station)
	 * @return Duration
	 */
	public Duration getBlkTime(String departureStation, LocalDateTime departureDate, String arrivalStation, LocalDateTime arrivalDate) {
		DateTime departDateZoned = getDateTimeObject(departureStation, departureDate);

		DateTime arriveDateZoned = getDateTimeObject(arrivalStation, arrivalDate);
		
		Duration duration = new Duration(departDateZoned, arriveDateZoned);
		
		return duration;
	}

	/**
	 * 
	 * @param airportCode IATA airport code for which layover time needs to be calculated
	 * @param arrivalDate Date-Time of the flight arriving to the airport
	 * @param departureDate Date-Time of the flight departing from the airport
	 * @return Duration 
	 */
	public Duration getLayOverTime(String airportCode, LocalDateTime arrivalDate, LocalDateTime departureDate) {
		DateTime haltArrivalTime = getDateTimeObject(airportCode, arrivalDate);
		DateTime haltDepartureTime = getDateTimeObject(airportCode, departureDate);
		Duration duration = new Duration(haltArrivalTime, haltDepartureTime);
		return duration;
	}

	public void importTimeZoneFile(String fileName) {
		try {
			Files.lines(Paths.get(fileName)).forEach(content -> {
				String[] values = content.split("\\t");
				Timezone tz = new Timezone();
				tz.setCountryCode(values[0]);
				tz.setCountryName(values[1]);
				tz.setTimezoneCode(values[2]);
				tz.setTimezoneName(values[3]);

				Integer startYear = Integer.parseInt(values[5].substring(0, 4));
				Integer startMonth = Integer.parseInt(values[5].substring(4, 6));
				Integer startDay = Integer.parseInt(values[5].substring(6, 8));
				Integer startHour = null;
				Integer startMinute = null;
				if (values[6].length() == 4) {
					startHour = Integer.parseInt(values[6].substring(0, 2));
					startMinute = Integer.parseInt(values[6].substring(2, 4));
				} else if (values[6].length() == 3) {
					startHour = Integer.parseInt(values[6].substring(0, 1));
					startMinute = Integer.parseInt(values[6].substring(1, 2));
				}

				Calendar startCal = Calendar.getInstance();
				startCal.set(startYear, startMonth, startDay, startHour, startMinute);

				tz.setStartDate(startCal.getTime());

				Integer endYear = Integer.parseInt(values[8].substring(0, 4));
				Integer endMonth = Integer.parseInt(values[8].substring(4, 6));
				Integer endDay = Integer.parseInt(values[8].substring(6, 8));

				Integer endHour = null;
				Integer endMinute = null;

				if (values[9].length() == 4) {
					endHour = Integer.parseInt(values[9].substring(0, 2));
					endMinute = Integer.parseInt(values[9].substring(2, 4));
				} else if (values[9].length() == 3) {
					endHour = Integer.parseInt(values[9].substring(0, 1));
					endMinute = Integer.parseInt(values[9].substring(1, 2));
				}

				Calendar endCal = Calendar.getInstance();
				endCal.set(endYear, endMonth, endDay, endHour, endMinute);
				tz.setEndDate(endCal.getTime());
				tz.setGmtAdjustment(values[10]);

				logger.info(tz.toString());

				timezoneRepository.save(tz);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void importAirportFile(String fileName) {
		try {
			Files.lines(Paths.get(fileName)).forEach(content -> {
				String[] values = content.split("\\t");
				Airport airport = new Airport();
				airport.setCode(values[0]);
				airport.setCityCode(values[1]);
				airport.setName(values[2]);
				airport.setCityName(values[3]);
				airport.setRegionCode(values[4]);
				airport.setCountryCode(values[5]);
				airport.setLatitude(values[6]);
				airport.setLongitude(values[7]);
				airport.setTimeZone(values[8]);
				airport.setcType(values[9]);
				logger.info(airport.toString());
				airportRepository.save(airport);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
