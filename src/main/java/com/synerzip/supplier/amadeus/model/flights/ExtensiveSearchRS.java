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
@JsonPropertyOrder({
"origin",
"currency",
"results"
})
public class ExtensiveSearchRS {
	@JsonProperty("origin")
	private String origin;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("results")
	private List<ExtensiveSearchResult> results = new ArrayList<ExtensiveSearchResult>();
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	*
	* @return
	* The origin
	*/
	@JsonProperty("origin")
	public String getOrigin() {
	return origin;
	}

	/**
	*
	* @param origin
	* The origin
	*/
	@JsonProperty("origin")
	public void setOrigin(String origin) {
	this.origin = origin;
	}

	/**
	*
	* @return
	* The currency
	*/
	@JsonProperty("currency")
	public String getCurrency() {
	return currency;
	}

	/**
	*
	* @param currency
	* The currency
	*/
	@JsonProperty("currency")
	public void setCurrency(String currency) {
	this.currency = currency;
	}

	/**
	*
	* @return
	* The results
	*/
	@JsonProperty("results")
	public List<ExtensiveSearchResult> getResults() {
	return results;
	}

	/**
	*
	* @param results
	* The results
	*/
	@JsonProperty("results")
	public void setResults(List<ExtensiveSearchResult> results) {
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

}
