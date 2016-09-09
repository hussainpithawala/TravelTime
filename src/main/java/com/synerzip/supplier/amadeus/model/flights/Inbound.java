package com.synerzip.supplier.amadeus.model.flights;

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
import com.synerzip.supplier.amadeus.model.visitors.BoundElement;
import com.synerzip.supplier.amadeus.model.visitors.BoundVisitor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "flights", "duration" })
public class Inbound implements BoundElement {

	@JsonProperty("flights")
	private List<Flight> flights = new ArrayList<Flight>();
	@JsonProperty("duration")
	private String duration;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The flights
	 */
	@JsonProperty("flights")
	@Override
	public List<Flight> getFlights() {
		return flights;
	}

	/**
	 * 
	 * @param flights
	 *            The flights
	 */
	@JsonProperty("flights")
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	/**
	 * 
	 * @return The duration
	 */
	@JsonProperty("duration")
	public String getDuration() {
		return duration;
	}

	/**
	 * 
	 * @param duration
	 *            The duration
	 */
	@JsonProperty("duration")
	@Override
	public void setDuration(String duration) {
		this.duration = duration;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	@Override
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
	
	public static class Builder {
		private Inbound instance;
		
		Builder(Inbound inbound) {
			this.instance = inbound;
		}
		
		public Builder flights(List<Flight> flights) {
			this.instance.setFlights(flights);
			return this;
		}
		
		public Inbound instance() {
			return instance;
		}
	}
	
	public static Builder getBuilder() {
		return new Builder(new Inbound());
	}

	@Override
	public void accept(BoundVisitor visitor) {
		visitor.visit(this);
	}
}