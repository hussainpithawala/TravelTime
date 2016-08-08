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
@JsonPropertyOrder({ "room_type", "bed_type", "number_of_beds" })
public class HotelRoomTypeInfo {

	@JsonProperty("room_type")
	private String roomType;
	@JsonProperty("bed_type")
	private String bedType;
	@JsonProperty("number_of_beds")
	private String numberOfBeds;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The roomType
	 */
	@JsonProperty("room_type")
	public String getRoomType() {
		return roomType;
	}

	/**
	 * 
	 * @param roomType
	 *            The room_type
	 */
	@JsonProperty("room_type")
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * 
	 * @return The bedType
	 */
	@JsonProperty("bed_type")
	public String getBedType() {
		return bedType;
	}

	/**
	 * 
	 * @param bedType
	 *            The bed_type
	 */
	@JsonProperty("bed_type")
	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	/**
	 * 
	 * @return The numberOfBeds
	 */
	@JsonProperty("number_of_beds")
	public String getNumberOfBeds() {
		return numberOfBeds;
	}

	/**
	 * 
	 * @param numberOfBeds
	 *            The number_of_beds
	 */
	@JsonProperty("number_of_beds")
	public void setNumberOfBeds(String numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
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