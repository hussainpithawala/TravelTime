package com.synerzip.supplier.amadeus.model.flights;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.synerzip.supplier.amadeus.model.visitors.IOBoundWrapper;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "outbound" })
public class Itinerary implements IOBoundWrapper {

	@JsonProperty("outbound")
	private Outbound outbound;
	@JsonProperty("inbound")
	private Inbound inbound;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The outbound
	 */
	@JsonProperty("outbound")
	@Override
	public Outbound getOutbound() {
		return outbound;
	}

	/**
	 * 
	 * @param outbound
	 *            The outbound
	 */
	@JsonProperty("outbound")
	public void setOutbound(Outbound outbound) {
		this.outbound = outbound;
	}

	@JsonProperty("inbound")
	@Override
	public Inbound getInbound() {
		return inbound;
	}

	@JsonProperty("inbound")
	public void setInbound(Inbound inbound) {
		this.inbound = inbound;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public static class Builder {
		private Itinerary instance;

		private Builder(Itinerary instance) {
			this.instance = instance;
		}

		public Builder outBound(Outbound outbound) {
			this.instance.outbound = outbound;
			return this;
		}

		public Builder inBound(Inbound inbound) {
			this.instance.inbound = inbound;
			return this;
		}

		public Itinerary getInstance() {
			return this.instance;
		}
	}

	public static Builder getBuilder() {
		return new Builder(new Itinerary());
	}
}
