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
@JsonPropertyOrder({ "location", "checkIn", "checkOut", "radius", "lang", "currency", "maxRate", "numberOfResults",
		"allRooms", "showSoldOut", "amenities" })
public class HotelSearchRQ {

	@JsonProperty("location")
	private String location;
	@JsonProperty("checkIn")
	private String checkIn;
	@JsonProperty("checkOut")
	private String checkOut;
	@JsonProperty("radius")
	private String radius;
	@JsonProperty("lang")
	private String lang;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("maxRate")
	private String maxRate;
	@JsonProperty("numberOfResults")
	private String numberOfResults;
	@JsonProperty("allRooms")
	private String allRooms;
	@JsonProperty("showSoldOut")
	private String showSoldOut;
	@JsonProperty("amenities")
	private String amenities;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The location
	 */
	@JsonProperty("location")
	public String getLocation() {
		return location;
	}

	/**
	 * 
	 * @param location
	 *            The location
	 */
	@JsonProperty("location")
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * 
	 * @return The checkIn
	 */
	@JsonProperty("checkIn")
	public String getCheckIn() {
		return checkIn;
	}

	/**
	 * 
	 * @param checkIn
	 *            The checkIn
	 */
	@JsonProperty("checkIn")
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	/**
	 * 
	 * @return The checkOut
	 */
	@JsonProperty("checkOut")
	public String getCheckOut() {
		return checkOut;
	}

	/**
	 * 
	 * @param checkOut
	 *            The checkOut
	 */
	@JsonProperty("checkOut")
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	/**
	 * 
	 * @return The radius
	 */
	@JsonProperty("radius")
	public String getRadius() {
		return radius;
	}

	/**
	 * 
	 * @param radius
	 *            The radius
	 */
	@JsonProperty("radius")
	public void setRadius(String radius) {
		this.radius = radius;
	}

	/**
	 * 
	 * @return The lang
	 */
	@JsonProperty("lang")
	public String getLang() {
		return lang;
	}

	/**
	 * 
	 * @param lang
	 *            The lang
	 */
	@JsonProperty("lang")
	public void setLang(String lang) {
		this.lang = lang;
	}

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
	 * @return The maxRate
	 */
	@JsonProperty("maxRate")
	public String getMaxRate() {
		return maxRate;
	}

	/**
	 * 
	 * @param maxRate
	 *            The maxRate
	 */
	@JsonProperty("maxRate")
	public void setMaxRate(String maxRate) {
		this.maxRate = maxRate;
	}

	/**
	 * 
	 * @return The numberOfResults
	 */
	@JsonProperty("numberOfResults")
	public String getNumberOfResults() {
		return numberOfResults;
	}

	/**
	 * 
	 * @param numberOfResults
	 *            The numberOfResults
	 */
	@JsonProperty("numberOfResults")
	public void setNumberOfResults(String numberOfResults) {
		this.numberOfResults = numberOfResults;
	}

	/**
	 * 
	 * @return The allRooms
	 */
	@JsonProperty("allRooms")
	public String getAllRooms() {
		return allRooms;
	}

	/**
	 * 
	 * @param allRooms
	 *            The allRooms
	 */
	@JsonProperty("allRooms")
	public void setAllRooms(String allRooms) {
		this.allRooms = allRooms;
	}

	/**
	 * 
	 * @return The showSoldOut
	 */
	@JsonProperty("showSoldOut")
	public String getShowSoldOut() {
		return showSoldOut;
	}

	/**
	 * 
	 * @param showSoldOut
	 *            The showSoldOut
	 */
	@JsonProperty("showSoldOut")
	public void setShowSoldOut(String showSoldOut) {
		this.showSoldOut = showSoldOut;
	}

	/**
	 * 
	 * @return The amenities
	 */
	@JsonProperty("amenities")
	public String getAmenities() {
		return amenities;
	}

	/**
	 * 
	 * @param amenities
	 *            The amenities
	 */
	@JsonProperty("amenities")
	public void setAmenities(String amenities) {
		this.amenities = amenities;
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