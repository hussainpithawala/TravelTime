package com.synerzip.model.flight;

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
@JsonPropertyOrder({ "travel_class", "booking_code", "seats_remaining" })
public class BookingInfo {

	@JsonProperty("travel_class")
	private String travelClass;
	@JsonProperty("booking_code")
	private String bookingCode;
	@JsonProperty("seats_remaining")
	private int seatsRemaining;
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

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}