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

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "airport", "terminal" })
public class Origin {

	@JsonProperty("airport")
	private String airport;

	@JsonProperty("airport_name_city")
	private String airportNameCity;

	@JsonProperty("terminal")
	private String terminal;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The airport
	 */
	@JsonProperty("airport")
	public String getAirport() {
		return airport;
	}

	/**
	 * 
	 * @param airport
	 *            The airport
	 */
	@JsonProperty("airport")
	public void setAirport(String airport) {
		this.airport = airport;
	}

	/**
	 * 
	 * @return The terminal
	 */
	@JsonProperty("terminal")
	public String getTerminal() {
		return terminal;
	}

	/**
	 * 
	 * @param terminal
	 *            The terminal
	 */
	@JsonProperty("terminal")
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@JsonProperty("airport_name_city")
	public String getAirportNameCity() {
		return airportNameCity;
	}

	@JsonProperty("airport_name_city")
	public void setAirportNameCity(String airportNameCity) {
		this.airportNameCity = airportNameCity;
	}


	public static class Builder {
		private Origin instance;

		private Builder(Origin instance) {
			this.instance = instance;
		}

		public Builder airport(String airport) {
			this.instance.airport = airport;
			return this;
		}

		public Origin getInstance() {
			return this.instance;
		}
	}

	public static Builder getBuilder() {
		return new Builder(new Origin());
	}
}