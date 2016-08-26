
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
import com.synerzip.supplier.sabre.model.flights.visitors.FareInfosElement;
import com.synerzip.supplier.sabre.model.flights.visitors.FareInfosVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.AirItineraryPricingInfoElement;
import com.synerzip.supplier.sabre.model.flights.visitors.AirItineraryPricingInfoVisitor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "FareInfo"
})
public class FareInfos implements FareInfosElement {

    @JsonProperty("FareInfo")
    private List<FareInfo> fareInfoList = new ArrayList<FareInfo>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The FareInfo
     */
    @JsonProperty("FareInfo")
    public List<FareInfo> getFareInfo() {
        return fareInfoList;
    }

    /**
     * 
     * @param FareInfo
     *     The FareInfo
     */
    @JsonProperty("FareInfo")
    public void setFareInfo(List<FareInfo> FareInfo) {
        this.fareInfoList = FareInfo;
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
		fareInfoList.stream().forEach(fareInfo -> fareInfo.accept(visitor));
	}
}
