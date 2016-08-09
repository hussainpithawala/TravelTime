package com.synerzip.supplier.utilities;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.synerzip.supplier.amadeus.model.flights.LowFareFlightSearchRS;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.InstaFlightResponse;

@Component
public class ResponseTransformer {
	public final Function<InstaFlightResponse, LowFareFlightSearchRS> convert = new Function<InstaFlightResponse, LowFareFlightSearchRS>() {

		@Override
		public LowFareFlightSearchRS apply(InstaFlightResponse instaFlightResponse) {
			LowFareFlightSearchRS lowFareFlightSearchRS = new LowFareFlightSearchRS();
			return lowFareFlightSearchRS;
		}
	};
}
