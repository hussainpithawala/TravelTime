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
@JsonPropertyOrder({
"value",
"label"
})
public class AirportAutocompleteRS {
	@JsonProperty("value")
	private String value;
	@JsonProperty("label")
	private String label;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	*
	* @return
	* The value
	*/
	@JsonProperty("value")
	public String getValue() {
	return value;
	}

	/**
	*
	* @param value
	* The value
	*/
	@JsonProperty("value")
	public void setValue(String value) {
	this.value = value;
	}

	/**
	*
	* @return
	* The label
	*/
	@JsonProperty("label")
	public String getLabel() {
	return label;
	}

	/**
	*
	* @param label
	* The label
	*/
	@JsonProperty("label")
	public void setLabel(String label) {
	this.label = label;
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
