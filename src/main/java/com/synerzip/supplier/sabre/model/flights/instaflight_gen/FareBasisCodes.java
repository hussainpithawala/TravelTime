
package com.synerzip.supplier.sabre.model.flights.instaflight_gen;

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
import com.synerzip.supplier.sabre.model.flights.visitors.PTCFareBreakDownsElement;
import com.synerzip.supplier.sabre.model.flights.visitors.PTCFareBreakdownsVisitor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "FareBasisCode"
})
public class FareBasisCodes implements PTCFareBreakDownsElement {

    @JsonProperty("FareBasisCode")
    private List<FareBasisCode> fareBasisCodes = new ArrayList<FareBasisCode>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The FareBasisCode
     */
    @JsonProperty("FareBasisCode")
    public List<FareBasisCode> getFareBasisCodes() {
        return fareBasisCodes;
    }

    /**
     * 
     * @param FareBasisCode
     *     The FareBasisCode
     */
    @JsonProperty("FareBasisCode")
    public void setFareBasisCodes(List<FareBasisCode> FareBasisCode) {
        this.fareBasisCodes = FareBasisCode;
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
		fareBasisCodes.get(0).accept(visitor);
	}

}
