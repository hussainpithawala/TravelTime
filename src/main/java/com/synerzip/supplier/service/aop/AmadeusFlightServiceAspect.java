package com.synerzip.supplier.service.aop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Phaser;

import com.synerzip.client.orm.Airline;
import com.synerzip.client.repository.AirlineRepository;
import com.synerzip.client.repository.AirportRepository;
import com.synerzip.supplier.amadeus.model.flights.Airport;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.AffiliateFlightSearchRS;
import com.synerzip.supplier.amadeus.model.flights.Flight;
import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRS;
import com.synerzip.supplier.amadeus.model.visitors.BoundElement;
import com.synerzip.supplier.amadeus.model.visitors.BoundVisitor;
import com.synerzip.supplier.amadeus.model.visitors.FlightVisitor;
import com.synerzip.supplier.amadeus.model.visitors.IOBoundWrapper;
import com.synerzip.supplier.service.TimeService;
import com.synerzip.utils.TimeUtils.TimeUtilities;

@Component
@Aspect
public class AmadeusFlightServiceAspect {
	private static final Logger logger = LoggerFactory.getLogger(AmadeusFlightServiceAspect.class);

	@Autowired
	private TimeService timeService;

	@Autowired
	private ThreadPoolTaskExecutor executor;

	@Autowired
	private AirlineRepository airlineRepository;

	@Autowired
	private AirportRepository airportRepository;

	@AfterReturning(pointcut = "execution(* com.synerzip.supplier.service.AmadeusFlightService.fetchLowFareFlights(*))", returning = "lowFareFlightSearchRS")
	public void updateDuration(LowFareFlightSearchRS lowFareFlightSearchRS) {
		logger.debug("After-returning advice for return type LowFareFlightSearchRS");

		final Phaser phaser = new Phaser(1); // "1" to register self
		lowFareFlightSearchRS.getResults().stream().forEach(result -> {
			result.getItineraries().stream().forEach(itinerary -> {
				executor.execute(() -> {
					phaser.register();
					update(itinerary);
					phaser.arriveAndDeregister();
				});
			});
		});
		phaser.arriveAndAwaitAdvance();
	}

	@AfterReturning(pointcut = "execution(* com.synerzip.supplier.service.AmadeusFlightService.fetchLowFareFlights(*))", returning = "affiliateFlightSearchRS")
	public void updateDuration(AffiliateFlightSearchRS affiliateFlightSearchRS) {
		logger.debug("After-returning advice for return type AffiliateFlightSearchRS");

		final Phaser phaser = new Phaser(1); // "1" to register self
		affiliateFlightSearchRS.getResults().stream().forEach(affiliateFlightSearchResult -> {
			executor.execute(() -> {
				phaser.register();
				update(affiliateFlightSearchResult);
				phaser.arriveAndDeregister();
			});
		});
		phaser.arriveAndAwaitAdvance();
	}

	private void update(IOBoundWrapper ioBoundWrapper) {
		update(ioBoundWrapper.getOutbound());
		// in-bound needs to be checked for null-values since one-way flights
		// don't have in-bound itinerary
		if (ioBoundWrapper.getInbound() != null) {
			update(ioBoundWrapper.getInbound());
		}
	}

	private void update(BoundElement bound) {
		BoundVisitor visitor = new BoundVisitor() {
			Period totalFlightPeriod = Period.ZERO;

			@Override
			public void visit(BoundElement bound) {
				Map<String, String> layovers = new HashMap<>();

				FlightVisitor flightVisitor = new FlightVisitor() {
					Flight prevFlight;
					Period prevFlightPeriod;

					@Override
					public void visit(Flight flight) {
						Duration blkTime = timeService.getBlkTime(flight.getOrigin().getAirport(),
								flight.getDepartsAt(), flight.getDestination().getAirport(), flight.getArrivesAt());

						flight.getAdditionalProperties().put("duration",
								TimeUtilities.periodToString(blkTime.toPeriod()));

						if (prevFlightPeriod != null && prevFlight != null) {
							if (prevFlight.getDestination().getAirport().equals(flight.getOrigin().getAirport())) {
								String airportCode = flight.getOrigin().getAirport();
								Period layover = timeService
										.getLayOverTime(airportCode, prevFlight.getArrivesAt(), flight.getDepartsAt())
										.toPeriod();
								layovers.put(airportCode, TimeUtilities.periodToString(layover));
								totalFlightPeriod = totalFlightPeriod.plus(layover);
							}
						}

						totalFlightPeriod = totalFlightPeriod.plus(blkTime.toPeriod());
						prevFlightPeriod = blkTime.toPeriod();
						prevFlight = flight;

						List<Airline> mktAirline = airlineRepository.findByIataCode(flight.getMarketingAirline());

						Optional.ofNullable(mktAirline).ifPresent((airline) ->{
							flight.setMarketingAirline(airline.get(0).getName());
						});

						List<Airline> optAirline = airlineRepository.findByIataCode(flight.getOperatingAirline());

						Optional.ofNullable(optAirline).ifPresent((airline) ->{
							flight.setOperatingAirline(airline.get(0).getName());
						});

						flight.getOrigin().setAirport(airportRepository.findByCode(flight.getOrigin().getAirport()).getName());
						flight.getDestination().setAirport(airportRepository.findByCode(flight.getDestination().getAirport()).getName());

					}
				};

				bound.getFlights().stream().forEach(flight -> {
					flight.accept(flightVisitor);
				});

				bound.setDuration(TimeUtilities.periodToString(totalFlightPeriod));

				if (!layovers.isEmpty()) {
					bound.setAdditionalProperty("layovers", layovers);
				}
			}
		};
		bound.accept(visitor);
	}
}
