package com.synerzip.supplier.utilities;

import java.util.Objects;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRQ;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.InstaFlightRequest;

@Component
public class RequestTransformer {
	public final Function<LowFareFlightSearchRQ, InstaFlightRequest> convert = new Function<LowFareFlightSearchRQ, InstaFlightRequest>() {
		@Override
		public InstaFlightRequest apply(LowFareFlightSearchRQ lowFareFlightSearchRQ) {
			InstaFlightRequest instaFlightRequest = new InstaFlightRequest();
			instaFlightRequest
					.setOrigin(Objects.requireNonNull(lowFareFlightSearchRQ.getOrigin(), "Origin cannot be null"));
			instaFlightRequest.setDestination(
					Objects.requireNonNull(lowFareFlightSearchRQ.getDestination(), "Destination cannot be null"));
			instaFlightRequest.setDeparturedate(
					Objects.requireNonNull(lowFareFlightSearchRQ.getDepartureDate(), "Departure date cannot be null"));
			instaFlightRequest.setReturndate(
					Objects.requireNonNull(lowFareFlightSearchRQ.getReturnDate(), "Return date cannot be null"));
			return instaFlightRequest;
		}
	};
}
