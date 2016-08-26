
package com.synerzip.supplier.sabre.model.flights.instaflight_gen;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.synerzip.supplier.sabre.model.flights.visitors.PTCFareBreakDownsElement;
import com.synerzip.supplier.sabre.model.flights.visitors.PTCFareBreakdownsVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.AirItineraryPricingInfoElement;
import com.synerzip.supplier.sabre.model.flights.visitors.AirItineraryPricingInfoVisitor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "PTC_FareBreakdown"
})
public class PTCFareBreakDowns implements PTCFareBreakDownsElement {

    @JsonProperty("PTC_FareBreakdown")
    private PTCFareBreakDown ptcFareBreakDown;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The PTC_FareBreakdown
     */
    @JsonProperty("PTC_FareBreakdown")
    public PTCFareBreakDown getPTC_FareBreakdown() {
        return ptcFareBreakDown;
    }

    /**
     * 
     * @param PTC_FareBreakdown
     *     The PTC_FareBreakdown
     */
    @JsonProperty("PTC_FareBreakdown")
    public void setPTC_FareBreakdown(PTCFareBreakDown PTC_FareBreakdown) {
        this.ptcFareBreakDown = PTC_FareBreakdown;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public void accept(PTCFareBreakdownsVisitor visitor) {
		visitor.visit(this);
		ptcFareBreakDown.accept(visitor);
	}
}
