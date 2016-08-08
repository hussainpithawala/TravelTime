
package com.synerzip.supplier.sabre.model.flights.bargainfindermax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "AirTravelerAvail"
})
public class TravelerInfoSummary {

    @JsonProperty("AirTravelerAvail")
    private List<AirTravelerAvail> AirTravelerAvail = new ArrayList<AirTravelerAvail>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The AirTravelerAvail
     */
    @JsonProperty("AirTravelerAvail")
    public List<AirTravelerAvail> getAirTravelerAvail() {
        return AirTravelerAvail;
    }

    /**
     * 
     * @param AirTravelerAvail
     *     The AirTravelerAvail
     */
    @JsonProperty("AirTravelerAvail")
    public void setAirTravelerAvail(List<AirTravelerAvail> AirTravelerAvail) {
        this.AirTravelerAvail = AirTravelerAvail;
    }

    public TravelerInfoSummary withAirTravelerAvail(List<AirTravelerAvail> AirTravelerAvail) {
        this.AirTravelerAvail = AirTravelerAvail;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public TravelerInfoSummary withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
