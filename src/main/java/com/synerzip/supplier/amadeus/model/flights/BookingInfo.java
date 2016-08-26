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
@JsonPropertyOrder({ "travel_class", "booking_code", "seats_remaining", "cabin_code", "fare_basis", "fare_family" })
public class BookingInfo {

	@JsonProperty("travel_class")
	private String travelClass;
	@JsonProperty("booking_code")
	private String bookingCode;
	@JsonProperty("seats_remaining")
	private int seatsRemaining;
	@JsonProperty("cabin_code")
	private String cabinCode;
	@JsonProperty("fare_basis")
	private String fareBasis;
	@JsonProperty("fare_family")
	private String fareFamily;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The travelClass
	 */
	@JsonProperty("travel_class")
	public String getTravelClass() {
		return travelClass;
	}

	/**
	 * 
	 * @param travelClass
	 *            The travel_class
	 */
	@JsonProperty("travel_class")
	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}

	/**
	 * 
	 * @return The bookingCode
	 */
	@JsonProperty("booking_code")
	public String getBookingCode() {
		return bookingCode;
	}

	/**
	 * 
	 * @param bookingCode
	 *            The booking_code
	 */
	@JsonProperty("booking_code")
	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}

	/**
	 * 
	 * @return The seatsRemaining
	 */
	@JsonProperty("seats_remaining")
	public int getSeatsRemaining() {
		return seatsRemaining;
	}

	/**
	 * 
	 * @param seatsRemaining
	 *            The seats_remaining
	 */
	@JsonProperty("seats_remaining")
	public void setSeatsRemaining(int seatsRemaining) {
		this.seatsRemaining = seatsRemaining;
	}

	/**
	 * 
	 * @return The cabinCode
	 */
	@JsonProperty("cabin_code")
	public String getCabinCode() {
		return cabinCode;
	}

	/**
	 * 
	 * @param cabinCode
	 *            The cabin_code
	 */
	@JsonProperty("cabin_code")
	public void setCabinCode(String cabinCode) {
		this.cabinCode = cabinCode;
	}

	/**
	 * 
	 * @return The fareBasis
	 */
	@JsonProperty("fare_basis")
	public String getFareBasis() {
		return fareBasis;
	}

	/**
	 * 
	 * @param fareBasis
	 *            The fare_basis
	 */
	@JsonProperty("fare_basis")
	public void setFareBasis(String fareBasis) {
		this.fareBasis = fareBasis;
	}

	/**
	 * 
	 * @return The fareFamily
	 */
	@JsonProperty("fare_family")
	public String getFareFamily() {
		return fareFamily;
	}

	/**
	 * 
	 * @param fareFamily
	 *            The fare_family
	 */
	@JsonProperty("fare_family")
	public void setFareFamily(String fareFamily) {
		this.fareFamily = fareFamily;
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
		private BookingInfo instance;

		private Builder(BookingInfo instance) {
			this.instance = instance;
		}

		public Builder seatsRemaining(Integer seatsRemaining) {
			this.instance.seatsRemaining = seatsRemaining;
			return this;
		}

		public Builder bookingCode(String bookingCode) {
			this.instance.bookingCode = bookingCode;
			return this;
		}

		public BookingInfo getInstance() {
			return this.instance;
		}
	}

	public static Builder getBuilder() {
		return new Builder(new BookingInfo());
	}
}