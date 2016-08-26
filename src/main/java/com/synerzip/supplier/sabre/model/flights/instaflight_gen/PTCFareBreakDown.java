
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
    "FareBasisCodes",
    "PassengerTypeQuantity",
    "PassengerFare"
})
public class PTCFareBreakDown implements PTCFareBreakDownsElement {

    @JsonProperty("FareBasisCodes")
    private FareBasisCodes FareBasisCodes;
    @JsonProperty("PassengerTypeQuantity")
    private PassengerTypeQuantity PassengerTypeQuantity;
    @JsonProperty("PassengerFare")
    private PassengerFare passengerFare;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The FareBasisCodes
     */
    @JsonProperty("FareBasisCodes")
    public FareBasisCodes getFareBasisCodes() {
        return FareBasisCodes;
    }

    /**
     * 
     * @param FareBasisCodes
     *     The FareBasisCodes
     */
    @JsonProperty("FareBasisCodes")
    public void setFareBasisCodes(FareBasisCodes FareBasisCodes) {
        this.FareBasisCodes = FareBasisCodes;
    }

    /**
     * 
     * @return
     *     The PassengerTypeQuantity
     */
    @JsonProperty("PassengerTypeQuantity")
    public PassengerTypeQuantity getPassengerTypeQuantity() {
        return PassengerTypeQuantity;
    }

    /**
     * 
     * @param PassengerTypeQuantity
     *     The PassengerTypeQuantity
     */
    @JsonProperty("PassengerTypeQuantity")
    public void setPassengerTypeQuantity(PassengerTypeQuantity PassengerTypeQuantity) {
        this.PassengerTypeQuantity = PassengerTypeQuantity;
    }

    /**
     * 
     * @return
     *     The PassengerFare
     */
    @JsonProperty("PassengerFare")
    public PassengerFare getPassengerFare() {
        return passengerFare;
    }

    /**
     * 
     * @param PassengerFare
     *     The PassengerFare
     */
    @JsonProperty("PassengerFare")
    public void setPassengerFare(PassengerFare PassengerFare) {
        this.passengerFare = PassengerFare;
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
		passengerFare.accept(visitor);
	}

}
