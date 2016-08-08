
package com.synerzip.supplier.sabre.model.flights.bargainfindermax;

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
    "DepartureDateTime",
    "DestinationLocation",
    "OriginLocation",
    "RPH"
})
public class OriginDestinationInformation {

    @JsonProperty("DepartureDateTime")
    private String DepartureDateTime;
    @JsonProperty("DestinationLocation")
    private DestinationLocation DestinationLocation;
    @JsonProperty("OriginLocation")
    private OriginLocation OriginLocation;
    @JsonProperty("RPH")
    private String RPH;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The DepartureDateTime
     */
    @JsonProperty("DepartureDateTime")
    public String getDepartureDateTime() {
        return DepartureDateTime;
    }

    /**
     * 
     * @param DepartureDateTime
     *     The DepartureDateTime
     */
    @JsonProperty("DepartureDateTime")
    public void setDepartureDateTime(String DepartureDateTime) {
        this.DepartureDateTime = DepartureDateTime;
    }

    public OriginDestinationInformation withDepartureDateTime(String DepartureDateTime) {
        this.DepartureDateTime = DepartureDateTime;
        return this;
    }

    /**
     * 
     * @return
     *     The DestinationLocation
     */
    @JsonProperty("DestinationLocation")
    public DestinationLocation getDestinationLocation() {
        return DestinationLocation;
    }

    /**
     * 
     * @param DestinationLocation
     *     The DestinationLocation
     */
    @JsonProperty("DestinationLocation")
    public void setDestinationLocation(DestinationLocation DestinationLocation) {
        this.DestinationLocation = DestinationLocation;
    }

    public OriginDestinationInformation withDestinationLocation(DestinationLocation DestinationLocation) {
        this.DestinationLocation = DestinationLocation;
        return this;
    }

    /**
     * 
     * @return
     *     The OriginLocation
     */
    @JsonProperty("OriginLocation")
    public OriginLocation getOriginLocation() {
        return OriginLocation;
    }

    /**
     * 
     * @param OriginLocation
     *     The OriginLocation
     */
    @JsonProperty("OriginLocation")
    public void setOriginLocation(OriginLocation OriginLocation) {
        this.OriginLocation = OriginLocation;
    }

    public OriginDestinationInformation withOriginLocation(OriginLocation OriginLocation) {
        this.OriginLocation = OriginLocation;
        return this;
    }

    /**
     * 
     * @return
     *     The RPH
     */
    @JsonProperty("RPH")
    public String getRPH() {
        return RPH;
    }

    /**
     * 
     * @param RPH
     *     The RPH
     */
    @JsonProperty("RPH")
    public void setRPH(String RPH) {
        this.RPH = RPH;
    }

    public OriginDestinationInformation withRPH(String RPH) {
        this.RPH = RPH;
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

    public OriginDestinationInformation withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
