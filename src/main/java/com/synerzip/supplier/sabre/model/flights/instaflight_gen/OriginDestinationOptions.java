
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
import com.synerzip.supplier.sabre.model.flights.visitors.AirItineraryElement;
import com.synerzip.supplier.sabre.model.flights.visitors.AirItineraryVisitor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "OriginDestinationOption" })
public class OriginDestinationOptions implements AirItineraryElement {

	@JsonProperty("OriginDestinationOption")
	private List<OriginDestinationOption> originDestinationOptions = new ArrayList<OriginDestinationOption>();
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The OriginDestinationOption
	 */
	@JsonProperty("OriginDestinationOption")
	public List<OriginDestinationOption> getOriginDestinationOption() {
		return originDestinationOptions;
	}

	/**
	 * 
	 * @param OriginDestinationOption
	 *            The OriginDestinationOption
	 */
	@JsonProperty("OriginDestinationOption")
	public void setOriginDestinationOption(List<OriginDestinationOption> OriginDestinationOption) {
		this.originDestinationOptions = OriginDestinationOption;
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
	public void accept(AirItineraryVisitor visitor) {
		visitor.visit(this);
		originDestinationOptions.stream().forEach(originDestinationOption -> originDestinationOption.accept(visitor));
	}
}
