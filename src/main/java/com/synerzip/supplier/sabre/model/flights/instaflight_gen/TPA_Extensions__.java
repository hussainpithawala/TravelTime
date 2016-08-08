
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "Cabin",
    "SeatsRemaining"
})
public class TPA_Extensions__ {

    @JsonProperty("Cabin")
    private Cabin Cabin;
    @JsonProperty("SeatsRemaining")
    private SeatsRemaining SeatsRemaining;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Cabin
     */
    @JsonProperty("Cabin")
    public Cabin getCabin() {
        return Cabin;
    }

    /**
     * 
     * @param Cabin
     *     The Cabin
     */
    @JsonProperty("Cabin")
    public void setCabin(Cabin Cabin) {
        this.Cabin = Cabin;
    }

    /**
     * 
     * @return
     *     The SeatsRemaining
     */
    @JsonProperty("SeatsRemaining")
    public SeatsRemaining getSeatsRemaining() {
        return SeatsRemaining;
    }

    /**
     * 
     * @param SeatsRemaining
     *     The SeatsRemaining
     */
    @JsonProperty("SeatsRemaining")
    public void setSeatsRemaining(SeatsRemaining SeatsRemaining) {
        this.SeatsRemaining = SeatsRemaining;
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
