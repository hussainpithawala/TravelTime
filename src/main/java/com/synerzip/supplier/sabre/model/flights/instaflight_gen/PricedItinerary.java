
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
import com.synerzip.supplier.sabre.model.flights.visitors.PricedItineraryElement;
import com.synerzip.supplier.sabre.model.flights.visitors.PricedItineraryVisitor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "AirItinerary",
    "TPA_Extensions",
    "SequenceNumber",
    "AirItineraryPricingInfo",
    "TicketingInfo"
})
public class PricedItinerary implements PricedItineraryElement {

    @JsonProperty("AirItinerary")
    private AirItinerary airItinerary;
    @JsonProperty("TPA_Extensions")
    private TPA_Extensions_ tpaExtensions;
    @JsonProperty("SequenceNumber")
    private Integer sequenceNumber;
    @JsonProperty("AirItineraryPricingInfo")
    private AirItineraryPricingInfo airItineraryPricingInfo;
    @JsonProperty("TicketingInfo")
    private TicketingInfo ticketingInfo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The AirItinerary
     */
    @JsonProperty("AirItinerary")
    public AirItinerary getAirItinerary() {
        return airItinerary;
    }

    /**
     * 
     * @param AirItinerary
     *     The AirItinerary
     */
    @JsonProperty("AirItinerary")
    public void setAirItinerary(AirItinerary AirItinerary) {
        this.airItinerary = AirItinerary;
    }

    /**
     * 
     * @return
     *     The TPA_Extensions
     */
    @JsonProperty("TPA_Extensions")
    public TPA_Extensions_ getTPA_Extensions() {
        return tpaExtensions;
    }

    /**
     * 
     * @param TPA_Extensions
     *     The TPA_Extensions
     */
    @JsonProperty("TPA_Extensions")
    public void setTPA_Extensions(TPA_Extensions_ TPA_Extensions) {
        this.tpaExtensions = TPA_Extensions;
    }

    /**
     * 
     * @return
     *     The SequenceNumber
     */
    @JsonProperty("SequenceNumber")
    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * 
     * @param SequenceNumber
     *     The SequenceNumber
     */
    @JsonProperty("SequenceNumber")
    public void setSequenceNumber(Integer SequenceNumber) {
        this.sequenceNumber = SequenceNumber;
    }

    /**
     * 
     * @return
     *     The AirItineraryPricingInfo
     */
    @JsonProperty("AirItineraryPricingInfo")
    public AirItineraryPricingInfo getAirItineraryPricingInfo() {
        return airItineraryPricingInfo;
    }

    /**
     * 
     * @param AirItineraryPricingInfo
     *     The AirItineraryPricingInfo
     */
    @JsonProperty("AirItineraryPricingInfo")
    public void setAirItineraryPricingInfo(AirItineraryPricingInfo AirItineraryPricingInfo) {
        this.airItineraryPricingInfo = AirItineraryPricingInfo;
    }

    /**
     * 
     * @return
     *     The TicketingInfo
     */
    @JsonProperty("TicketingInfo")
    public TicketingInfo getTicketingInfo() {
        return ticketingInfo;
    }

    /**
     * 
     * @param TicketingInfo
     *     The TicketingInfo
     */
    @JsonProperty("TicketingInfo")
    public void setTicketingInfo(TicketingInfo TicketingInfo) {
        this.ticketingInfo = TicketingInfo;
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
	public void accept(PricedItineraryVisitor visitor) {
		visitor.visit(this);
		airItineraryPricingInfo.accept(visitor);
	}

}
