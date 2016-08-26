package com.synerzip.utilities.sabre2amadeus.writers;

import java.util.Objects;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRQ;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.InstaFlightRequest;

@Component
public class InstaFlightRequestBuilder {
	public final Function<LowFareFlightSearchRQ, InstaFlightRequest> build = new Function<LowFareFlightSearchRQ, InstaFlightRequest>() {
		@Override
		public InstaFlightRequest apply(LowFareFlightSearchRQ lowFareFlightSearchRQ) {
			return InstaFlightRequest.getBuilder()
					.origin(Objects.requireNonNull(lowFareFlightSearchRQ.getOrigin(), "Origin cannot be null"))
					.destination(Objects.requireNonNull(lowFareFlightSearchRQ.getDestination(), "Destination cannot be null"))
					.departureDate(Objects.requireNonNull(lowFareFlightSearchRQ.getDepartureDate(), "Departure date cannot be null"))
					.returnDate(Objects.requireNonNull(lowFareFlightSearchRQ.getReturnDate(), "Return date cannot be null"))
					.limit(lowFareFlightSearchRQ.getNumberOfResults())
					.getInstance();
		}
	};
}
