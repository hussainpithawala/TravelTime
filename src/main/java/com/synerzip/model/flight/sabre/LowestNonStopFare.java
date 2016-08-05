package com.synerzip.model.flight.sabre;

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
    "AirlineCodes",
    "Fare"
})
public class LowestNonStopFare {

    @JsonProperty("AirlineCodes")
    private List<String> airlineCodes = new ArrayList<String>();
    @JsonProperty("Fare")
    private Integer fare;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The airlineCodes
     */
    @JsonProperty("AirlineCodes")
    public List<String> getAirlineCodes() {
        return airlineCodes;
    }

    /**
     * 
     * @param airlineCodes
     *     The AirlineCodes
     */
    @JsonProperty("AirlineCodes")
    public void setAirlineCodes(List<String> airlineCodes) {
        this.airlineCodes = airlineCodes;
    }

    /**
     * 
     * @return
     *     The fare
     */
    @JsonProperty("Fare")
    public Integer getFare() {
        return fare;
    }

    /**
     * 
     * @param fare
     *     The Fare
     */
    @JsonProperty("Fare")
    public void setFare(Integer fare) {
        this.fare = fare;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
