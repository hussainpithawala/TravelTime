package com.synerzip.utilities.sabre2amadeus.writers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.Duration;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.Flight;
import com.synerzip.supplier.amadeus.model.flights.Inbound;
import com.synerzip.supplier.amadeus.model.flights.Itinerary;
import com.synerzip.supplier.amadeus.model.flights.Outbound;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.FlightSegment;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.OriginDestinationOption;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PricedItinerary;
import com.synerzip.supplier.sabre.model.flights.visitors.AbstractAirItineraryVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.PricedItineraryVisitor;
import com.synerzip.supplier.service.TimeService;
import com.synerzip.utils.TimeUtils.TimeUtilities;

@Component
public class ItineraryWriter {
	@Autowired
	private FlightWriter flightWriter;

	@Autowired
	private TimeService timeService;

	private List<Flight> getFlightList(List<FlightSegment> flightSegmentlist, PricedItinerary pricedItinerary,
			FlightInformation fltInfo) {

		List<Flight> flightList = new ArrayList<Flight>();

		flightSegmentlist.stream().map(flightSegment -> {
			if (fltInfo.prevFlightSegment != null) {
				String arrivalAirport = fltInfo.prevFlightSegment.getArrivalAirport().getLocationCode();
				String arrivalDateTimeString = fltInfo.prevFlightSegment.getArrivalDateTime();

				String departureAirport = flightSegment.getDepartureAirport().getLocationCode();
				String departureDateTimeString = flightSegment.getDepartureDateTime();

				if (arrivalAirport.equals(departureAirport)) {
					DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss");
					LocalDateTime departDateTime = LocalDateTime.parse(departureDateTimeString.replace('T', ' '),
							formatter);
					LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalDateTimeString.replace('T', ' '),
							formatter);
					Duration layover = timeService.getLayOverTime(arrivalAirport, arrivalDateTime, departDateTime);
					fltInfo.layovers.put(arrivalAirport, TimeUtilities.periodToString(layover.toPeriod()));
				}
			}

			fltInfo.prevFlightSegment = flightSegment;

			return flightWriter.write(flightSegment, pricedItinerary);
		}).filter(flight -> flight != null).forEach(flight -> {
			flightList.add(flight);
		});
		return flightList;
	}

	public Itinerary write(PricedItinerary pricedItinerary) {
		Itinerary.Builder builder = Itinerary.getBuilder();

		PricedItineraryVisitor visitor = new AbstractAirItineraryVisitor() {
			private int counter = 0;

			@Override
			public void visit(OriginDestinationOption originDestinationOption) {
				List<FlightSegment> flightSegmentList = originDestinationOption.getFlightSegment();
				FlightInformation fltInfo = new FlightInformation();
				List<Flight> flightList = getFlightList(flightSegmentList, pricedItinerary, fltInfo);

				switch (counter) {
				case 0: // '0' position is for out-bound
					Outbound.Builder outboundBuilder = Outbound.getBuilder().flights(flightList)
							.additionalProperty("duration", TimeUtilities.periodToString(
									Duration.standardMinutes(originDestinationOption.getElapsedTime()).toPeriod()));

					if (!fltInfo.layovers.isEmpty()) {
						outboundBuilder.additionalProperty("layovers", fltInfo.layovers);
					}

					builder.outBound(outboundBuilder.instance());
					break;
				case 1: // '1' position is for in-bound
					Inbound.Builder inboundBuilder = Inbound.getBuilder().flights(flightList)
							.additionalProperty("duration", TimeUtilities.periodToString(
									Duration.standardMinutes(originDestinationOption.getElapsedTime()).toPeriod()));

					if (!fltInfo.layovers.isEmpty()) {
						inboundBuilder.additionalProperty("layovers", fltInfo.layovers);
					}

					builder.inBound(inboundBuilder.instance());
					break;
				default:
					break;
				}
				++counter;
			}
		};
		pricedItinerary.accept(visitor);
		return builder.getInstance();
	}

	/**
	 * 
	 * @author hussainp A convenience class to capture layover information from
	 *         a list of Flight-Segment
	 */
	private class FlightInformation {
		FlightSegment prevFlightSegment;
		Map<String, Object> layovers = new HashMap<>();
	}
}