
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
import com.synerzip.supplier.sabre.model.flights.visitors.FareInfosElement;
import com.synerzip.supplier.sabre.model.flights.visitors.FareInfosVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.PricedItineraryElement;
import com.synerzip.supplier.sabre.model.flights.visitors.PricedItineraryVisitor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "TPA_Extensions",
    "FareReference"
})
public class FareInfo implements FareInfosElement {

    @JsonProperty("TPA_Extensions")
    private TPAExtensions tpaExtensions;
    @JsonProperty("FareReference")
    private String FareReference;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The TPA_Extensions
     */
    @JsonProperty("TPA_Extensions")
    public TPAExtensions getTPA_Extensions() {
        return tpaExtensions;
    }

    /**
     * 
     * @param TPA_Extensions
     *     The TPA_Extensions
     */
    @JsonProperty("TPA_Extensions")
    public void setTPA_Extensions(TPAExtensions TPA_Extensions) {
        this.tpaExtensions = TPA_Extensions;
    }

    /**
     * 
     * @return
     *     The FareReference
     */
    @JsonProperty("FareReference")
    public String getFareReference() {
        return FareReference;
    }

    /**
     * 
     * @param FareReference
     *     The FareReference
     */
    @JsonProperty("FareReference")
    public void setFareReference(String FareReference) {
        this.FareReference = FareReference;
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
	public void accept(FareInfosVisitor visitor) {
		visitor.visit(this);
		tpaExtensions.accept(visitor);
	}

}
