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
    "OriginLocation",
    "DestinationLocation",
    "FareInfo",
    "Links"
})
public class LeadPriceCalendarRS {

    @JsonProperty("OriginLocation")
    private String originLocation;
    @JsonProperty("DestinationLocation")
    private String destinationLocation;
    @JsonProperty("FareInfo")
    private List<FareInfo> fareInfo = new ArrayList<FareInfo>();
    @JsonProperty("Links")
    private List<Link> links = new ArrayList<Link>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The originLocation
     */
    @JsonProperty("OriginLocation")
    public String getOriginLocation() {
        return originLocation;
    }

    /**
     * 
     * @param originLocation
     *     The OriginLocation
     */
    @JsonProperty("OriginLocation")
    public void setOriginLocation(String originLocation) {
        this.originLocation = originLocation;
    }

    /**
     * 
     * @return
     *     The destinationLocation
     */
    @JsonProperty("DestinationLocation")
    public String getDestinationLocation() {
        return destinationLocation;
    }

    /**
     * 
     * @param destinationLocation
     *     The DestinationLocation
     */
    @JsonProperty("DestinationLocation")
    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    /**
     * 
     * @return
     *     The fareInfo
     */
    @JsonProperty("FareInfo")
    public List<FareInfo> getFareInfo() {
        return fareInfo;
    }

    /**
     * 
     * @param fareInfo
     *     The FareInfo
     */
    @JsonProperty("FareInfo")
    public void setFareInfo(List<FareInfo> fareInfo) {
        this.fareInfo = fareInfo;
    }

    /**
     * 
     * @return
     *     The links
     */
    @JsonProperty("Links")
    public List<Link> getLinks() {
        return links;
    }

    /**
     * 
     * @param links
     *     The Links
     */
    @JsonProperty("Links")
    public void setLinks(List<Link> links) {
        this.links = links;
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