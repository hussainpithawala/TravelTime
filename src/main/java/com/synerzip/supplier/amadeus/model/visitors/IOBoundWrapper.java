package com.synerzip.supplier.amadeus.model.visitors;

import com.synerzip.supplier.amadeus.model.flights.Inbound;
import com.synerzip.supplier.amadeus.model.flights.Outbound;

public interface IOBoundWrapper {
	Inbound getInbound();
	Outbound getOutbound();
}
