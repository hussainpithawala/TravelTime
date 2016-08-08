package com.synerzip.supplier.amadeus.model.hotel;

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
@JsonPropertyOrder({ "amenity", "ota_code", "description" })
public class HotelAmenity {

	@JsonProperty("amenity")
	private String amenity;
	@JsonProperty("ota_code")
	private int otaCode;
	@JsonProperty("description")
	private String description;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The amenity
	 */
	@JsonProperty("amenity")
	public String getAmenity() {
		return amenity;
	}

	/**
	 * 
	 * @param amenity
	 *            The amenity
	 */
	@JsonProperty("amenity")
	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}

	/**
	 * 
	 * @return The otaCode
	 */
	@JsonProperty("ota_code")
	public int getOtaCode() {
		return otaCode;
	}

	/**
	 * 
	 * @param otaCode
	 *            The ota_code
	 */
	@JsonProperty("ota_code")
	public void setOtaCode(int otaCode) {
		this.otaCode = otaCode;
	}

	/**
	 * 
	 * @return The description
	 */
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 *            The description
	 */
	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
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