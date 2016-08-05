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
    "LowestFare",
    "CurrencyCode",
    "LowestNonStopFare",
    "DepartureDateTime",
    "ReturnDateTime",
    "Links"
})
public class FareInfo {

    @JsonProperty("LowestFare")
    private LowestFare lowestFare;
    @JsonProperty("CurrencyCode")
    private String currencyCode;
    @JsonProperty("LowestNonStopFare")
    private LowestNonStopFare lowestNonStopFare;
    @JsonProperty("DepartureDateTime")
    private String departureDateTime;
    @JsonProperty("ReturnDateTime")
    private String returnDateTime;
    @JsonProperty("Links")
    private List<Link> links = new ArrayList<Link>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The lowestFare
     */
    @JsonProperty("LowestFare")
    public LowestFare getLowestFare() {
        return lowestFare;
    }

    /**
     * 
     * @param lowestFare
     *     The LowestFare
     */
    @JsonProperty("LowestFare")
    public void setLowestFare(LowestFare lowestFare) {
        this.lowestFare = lowestFare;
    }

    /**
     * 
     * @return
     *     The currencyCode
     */
    @JsonProperty("CurrencyCode")
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * 
     * @param currencyCode
     *     The CurrencyCode
     */
    @JsonProperty("CurrencyCode")
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * 
     * @return
     *     The lowestNonStopFare
     */
    @JsonProperty("LowestNonStopFare")
    public LowestNonStopFare getLowestNonStopFare() {
        return lowestNonStopFare;
    }

    /**
     * 
     * @param lowestNonStopFare
     *     The LowestNonStopFare
     */
    @JsonProperty("LowestNonStopFare")
    public void setLowestNonStopFare(LowestNonStopFare lowestNonStopFare) {
        this.lowestNonStopFare = lowestNonStopFare;
    }

    /**
     * 
     * @return
     *     The departureDateTime
     */
    @JsonProperty("DepartureDateTime")
    public String getDepartureDateTime() {
        return departureDateTime;
    }

    /**
     * 
     * @param departureDateTime
     *     The DepartureDateTime
     */
    @JsonProperty("DepartureDateTime")
    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    /**
     * 
     * @return
     *     The returnDateTime
     */
    @JsonProperty("ReturnDateTime")
    public String getReturnDateTime() {
        return returnDateTime;
    }

    /**
     * 
     * @param returnDateTime
     *     The ReturnDateTime
     */
    @JsonProperty("ReturnDateTime")
    public void setReturnDateTime(String returnDateTime) {
        this.returnDateTime = returnDateTime;
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
