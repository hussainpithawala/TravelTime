package com.synerzip.supplier.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;

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

	public Long getBlkTime(String departureStation, String departureDate, String departureTime, String arrivalStation,
			String arrivalDate, String arrivalTime) {
		// For a particular station
		return null;
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
				Integer startDay = Integer.parseInt(values[5].substring(6,8));
				Integer startHour = null;
				Integer startMinute = null;
				if(values[6].length() == 4) {
					startHour = Integer.parseInt(values[6].substring(0, 2));
					startMinute = Integer.parseInt(values[6].substring(2, 4));
				} else if(values[6].length() == 3) {
					startHour = Integer.parseInt(values[6].substring(0, 1));
					startMinute = Integer.parseInt(values[6].substring(1, 2));
				}
				
				Calendar startCal = Calendar.getInstance();
				startCal.set(startYear, startMonth, startDay, startHour, startMinute);
				
				tz.setStartDate(startCal.getTime());
				
				Integer endYear = Integer.parseInt(values[8].substring(0, 4));
				Integer endMonth = Integer.parseInt(values[8].substring(4, 6));
				Integer endDay = Integer.parseInt(values[8].substring(6,8));

				Integer endHour = null;
				Integer endMinute = null;

				if(values[9].length() == 4) {
					endHour = Integer.parseInt(values[9].substring(0, 2));
					endMinute = Integer.parseInt(values[9].substring(2, 4));
				} else if(values[9].length() == 3) {
					endHour = Integer.parseInt(values[9].substring(0, 1));
					endMinute = Integer.parseInt(values[9].substring(1, 2));
				}

				Calendar endCal = Calendar.getInstance();
				endCal.set(endYear, endMonth, endDay, endHour, endMinute);
				tz.setEndDate(endCal.getTime());
				
				Integer gmtAdjustMent = Integer.parseInt(values[10]);
				tz.setGmtAdjustment(gmtAdjustMent);
				
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
