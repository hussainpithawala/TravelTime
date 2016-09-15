package com.synerzip.supplier.amadeus.model.hotel;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "location", "check_in", "check_out", "radius", "lang", "currency", "max_rate", "number_of_results",
		"all_rooms", "show_sold_out", "amenities" })
public class HotelSearchRQ {

	@NotNull
	@JsonProperty("location")
	private String location;
	
	@NotNull
	@JsonProperty("check_in")
	private String checkIn;
	
	@NotNull
	@JsonProperty("check_out")
	private String checkOut;
	
	@JsonProperty("radius")
	private Integer radius;
	
	@JsonProperty("lang")
	private String lang;
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("max_rate")
	private Integer maxRate;
	
	@JsonProperty("number_of_results")
	private Integer numberOfResults;
	
	@JsonProperty("all_rooms")
	private Boolean allRooms;
	
	@JsonProperty("show_sold_out")
	private Boolean showSoldOut;
	
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
	@JsonProperty("check_in")
	public String getCheckIn() {
		return checkIn;
	}

	/**
	 * 
	 * @param checkIn
	 *            The checkIn
	 */
	@JsonProperty("check_in")
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	/**
	 * 
	 * @return The checkOut
	 */
	@JsonProperty("check_out")
	public String getCheckOut() {
		return checkOut;
	}

	/**
	 * 
	 * @param checkOut
	 *            The checkOut
	 */
	@JsonProperty("check_out")
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	/**
	 * 
	 * @return The radius
	 */
	@JsonProperty("radius")
	public Integer getRadius() {
		return radius;
	}

	/**
	 * 
	 * @param radius
	 *            The radius
	 */
	@JsonProperty("radius")
	public void setRadius(Integer radius) {
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
	@JsonProperty("max_rate")
	public Integer getMaxRate() {
		return maxRate;
	}

	/**
	 * 
	 * @param maxRate
	 *            The maxRate
	 */
	@JsonProperty("max_rate")
	public void setMaxRate(Integer maxRate) {
		this.maxRate = maxRate;
	}

	/**
	 * 
	 * @return The numberOfResults
	 */
	@JsonProperty("number_of_results")
	public Integer getNumberOfResults() {
		return numberOfResults;
	}

	/**
	 * 
	 * @param numberOfResults
	 *            The numberOfResults
	 */
	@JsonProperty("number_of_results")
	public void setNumberOfResults(Integer numberOfResults) {
		this.numberOfResults = numberOfResults;
	}

	/**
	 * 
	 * @return The allRooms
	 */
	@JsonProperty("all_rooms")
	public Boolean getAllRooms() {
		return allRooms;
	}

	/**
	 * 
	 * @param allRooms
	 *            The allRooms
	 */
	@JsonProperty("all_rooms")
	public void setAllRooms(Boolean allRooms) {
		this.allRooms = allRooms;
	}

	/**
	 * 
	 * @return The showSoldOut
	 */
	@JsonProperty("show_sold_out")
	public Boolean getShowSoldOut() {
		return showSoldOut;
	}

	/**
	 * 
	 * @param showSoldOut
	 *            The showSoldOut
	 */
	@JsonProperty("show_sold_out")
	public void setShowSoldOut(Boolean showSoldOut) {
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
	
	public static class Builder {
		private HotelSearchRQ instance;

		private Builder(HotelSearchRQ instance) {
			this.instance = instance;
		}

		public Builder location(String location) {
			this.instance.location = location;
			return this;
		}

		public Builder CheckIn(String CheckIn) {
			this.instance.checkIn = CheckIn;
			return this;
		}

		public Builder CheckOut(String CheckOut) {
			this.instance.checkOut = CheckOut;
			return this;
		}

		public Builder radius(Integer radius) {
			this.instance.radius = radius;
			return this;
		}

		public Builder lang(String lang) {
			this.instance.lang = lang;
			return this;
		}
		
		public Builder currency(String currency) {
			this.instance.currency = currency;
			return this;
		}

		public Builder maxRate(Integer maxRate) {
			this.instance.maxRate = maxRate;
			return this;
		}
		
		public Builder numberOfResults(Integer numberOfResults) {
			this.instance.numberOfResults = numberOfResults;
			return this;
		}

		public Builder allRooms(Boolean allRooms) {
			this.instance.allRooms = allRooms;
			return this;
		}
		
		public Builder showSoldOut(Boolean showSoldOut) {
			this.instance.showSoldOut = showSoldOut;
			return this;
		}
		
		public Builder amenities(String amenities) {
			this.instance.amenities = amenities;
			return this;
		}

		public HotelSearchRQ getInstance() {
			return this.instance;
		}
	}

	public static Builder getBuilder() {
		return new Builder(new HotelSearchRQ());
	}
}