package com.synerzip.model.flight;

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
    "cabin_code",
    "travel_class",
    "outbound",
    "deep_link",
    "merchant",
    "payout",
    "fare",
    "fare_family",
    "inbound",
    "airline"
})
public class AffiliateSearchResult {

    @JsonProperty("cabin_code")
    private String cabinCode;
    @JsonProperty("travel_class")
    private String travelClass;
    @JsonProperty("outbound")
    private Outbound outbound;
    @JsonProperty("deep_link")
    private String deepLink;
    @JsonProperty("merchant")
    private String merchant;
    @JsonProperty("payout")
    private Payout payout;
    @JsonProperty("fare")
    private Fare fare;
    @JsonProperty("fare_family")
    private String fareFamily;
    @JsonProperty("inbound")
    private Inbound inbound;
    @JsonProperty("airline")
    private String airline;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The cabinCode
     */
    @JsonProperty("cabin_code")
    public String getCabinCode() {
        return cabinCode;
    }

    /**
     * 
     * @param cabinCode
     *     The cabin_code
     */
    @JsonProperty("cabin_code")
    public void setCabinCode(String cabinCode) {
        this.cabinCode = cabinCode;
    }

    /**
     * 
     * @return
     *     The travelClass
     */
    @JsonProperty("travel_class")
    public String getTravelClass() {
        return travelClass;
    }

    /**
     * 
     * @param travelClass
     *     The travel_class
     */
    @JsonProperty("travel_class")
    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    /**
     * 
     * @return
     *     The outbound
     */
    @JsonProperty("outbound")
    public Outbound getOutbound() {
        return outbound;
    }

    /**
     * 
     * @param outbound
     *     The outbound
     */
    @JsonProperty("outbound")
    public void setOutbound(Outbound outbound) {
        this.outbound = outbound;
    }

    /**
     * 
     * @return
     *     The deepLink
     */
    @JsonProperty("deep_link")
    public String getDeepLink() {
        return deepLink;
    }

    /**
     * 
     * @param deepLink
     *     The deep_link
     */
    @JsonProperty("deep_link")
    public void setDeepLink(String deepLink) {
        this.deepLink = deepLink;
    }

    /**
     * 
     * @return
     *     The merchant
     */
    @JsonProperty("merchant")
    public String getMerchant() {
        return merchant;
    }

    /**
     * 
     * @param merchant
     *     The merchant
     */
    @JsonProperty("merchant")
    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    /**
     * 
     * @return
     *     The payout
     */
    @JsonProperty("payout")
    public Payout getPayout() {
        return payout;
    }

    /**
     * 
     * @param payout
     *     The payout
     */
    @JsonProperty("payout")
    public void setPayout(Payout payout) {
        this.payout = payout;
    }

    /**
     * 
     * @return
     *     The fare
     */
    @JsonProperty("fare")
    public Fare getFare() {
        return fare;
    }

    /**
     * 
     * @param fare
     *     The fare
     */
    @JsonProperty("fare")
    public void setFare(Fare fare) {
        this.fare = fare;
    }

    /**
     * 
     * @return
     *     The fareFamily
     */
    @JsonProperty("fare_family")
    public String getFareFamily() {
        return fareFamily;
    }

    /**
     * 
     * @param fareFamily
     *     The fare_family
     */
    @JsonProperty("fare_family")
    public void setFareFamily(String fareFamily) {
        this.fareFamily = fareFamily;
    }

    /**
     * 
     * @return
     *     The inbound
     */
    @JsonProperty("inbound")
    public Inbound getInbound() {
        return inbound;
    }

    /**
     * 
     * @param inbound
     *     The inbound
     */
    @JsonProperty("inbound")
    public void setInbound(Inbound inbound) {
        this.inbound = inbound;
    }

    /**
     * 
     * @return
     *     The airline
     */
    @JsonProperty("airline")
    public String getAirline() {
        return airline;
    }

    /**
     * 
     * @param airline
     *     The airline
     */
    @JsonProperty("airline")
    public void setAirline(String airline) {
        this.airline = airline;
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
