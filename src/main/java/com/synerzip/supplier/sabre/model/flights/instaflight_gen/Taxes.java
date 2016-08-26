
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
    "TotalTax",
    "Tax"
})
public class Taxes implements PTCFareBreakDownsElement {

    @JsonProperty("TotalTax")
    private TotalTax totalTax;
    @JsonProperty("Tax")
    private List<Tax> Tax = new ArrayList<Tax>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The TotalTax
     */
    @JsonProperty("TotalTax")
    public TotalTax getTotalTax() {
        return totalTax;
    }

    /**
     * 
     * @param totalTax
     *     The TotalTax
     */
    @JsonProperty("TotalTax")
    public void setTotalTax(TotalTax totalTax) {
        this.totalTax = totalTax;
    }

    /**
     * 
     * @return
     *     The Tax
     */
    @JsonProperty("Tax")
    public List<Tax> getTax() {
        return Tax;
    }

    /**
     * 
     * @param Tax
     *     The Tax
     */
    @JsonProperty("Tax")
    public void setTax(List<Tax> Tax) {
        this.Tax = Tax;
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
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

}
