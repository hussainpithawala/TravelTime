
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
import com.synerzip.supplier.sabre.model.flights.visitors.AirItineraryElement;
import com.synerzip.supplier.sabre.model.flights.visitors.AirItineraryVisitor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "OriginDestinationOptions", "DirectionInd" })
public class AirItinerary implements AirItineraryElement {

	@JsonProperty("OriginDestinationOptions")
	private OriginDestinationOptions originDestinationOptions;
	@JsonProperty("DirectionInd")
	private String DirectionInd;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The OriginDestinationOptions
	 */
	@JsonProperty("OriginDestinationOptions")
	public OriginDestinationOptions getOriginDestinationOptions() {
		return originDestinationOptions;
	}

	/**
	 * 
	 * @param originDestinationOptions
	 *            The OriginDestinationOptions
	 */
	@JsonProperty("OriginDestinationOptions")
	public void setOriginDestinationOptions(OriginDestinationOptions originDestinationOptions) {
		this.originDestinationOptions = originDestinationOptions;
	}

	/**
	 * 
	 * @return The DirectionInd
	 */
	@JsonProperty("DirectionInd")
	public String getDirectionInd() {
		return DirectionInd;
	}

	/**
	 * 
	 * @param DirectionInd
	 *            The DirectionInd
	 */
	@JsonProperty("DirectionInd")
	public void setDirectionInd(String DirectionInd) {
		this.DirectionInd = DirectionInd;
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
		originDestinationOptions.accept(visitor);
	}

}
