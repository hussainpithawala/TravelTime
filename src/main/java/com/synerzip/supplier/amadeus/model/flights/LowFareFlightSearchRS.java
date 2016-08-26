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

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "currency", "results" })
public class LowFareFlightSearchRS {

	@JsonProperty("currency")
	private String currency;
	@JsonProperty("results")
	private List<ResultItinerary> results = new ArrayList<ResultItinerary>();
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The currency
	 */
	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}

	/**
	 * 
	 * @param currency
	 *            The currency
	 */
	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * 
	 * @return The results
	 */
	@JsonProperty("results")
	public List<ResultItinerary> getResults() {
		return results;
	}

	/**
	 * 
	 * @param results
	 *            The results
	 */
	@JsonProperty("results")
	public void setResults(List<ResultItinerary> results) {
		this.results = results;
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
		private LowFareFlightSearchRS instance;
		
		private Builder(LowFareFlightSearchRS instance){
			this.instance = instance;
		}
		
		public Builder results(List<ResultItinerary> results) {
			this.instance.results = results;
			return this;
		}
		
		public Builder currency(String currency){
			this.instance.currency = currency;
			return this;
		}
		
		public LowFareFlightSearchRS getInstance(){
			return this.instance;
		}
	}
	
	public static Builder getBuilder() {
		return new Builder(new LowFareFlightSearchRS());
	}
}
