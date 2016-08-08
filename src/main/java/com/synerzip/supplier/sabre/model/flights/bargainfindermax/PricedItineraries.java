package com.synerzip.supplier.sabre.model.flights.bargainfindermax;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.synerzip.supplier.sabre.model.flights.instaflight_gen.PricedItinerary;

public class PricedItineraries {

    @JsonProperty("PricedItinerary")
    private List<PricedItinerary> pricedItinerary;
}
