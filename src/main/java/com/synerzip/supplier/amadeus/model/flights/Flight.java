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
import com.synerzip.supplier.amadeus.model.visitors.FlightElement;
import com.synerzip.supplier.amadeus.model.visitors.FlightVisitor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "departs_at", "arrives_at", "origin", "destination", "marketing_airline", "operating_airline",
		"flight_number", "aircraft", "booking_info" })
public class Flight implements FlightElement {

	@JsonProperty("departs_at")
	private String departsAt;
	@JsonProperty("arrives_at")
	private String arrivesAt;
	@JsonProperty("origin")
	private Origin origin;
	@JsonProperty("destination")
	private Destination destination;
	@JsonProperty("marketing_airline")
	private String marketingAirline;
	@JsonProperty("operating_airline")
	private String operatingAirline;
	@JsonProperty("flight_number")
	private String flightNumber;
	@JsonProperty("aircraft")
	private String aircraft;
	@JsonProperty("booking_info")
	private BookingInfo bookingInfo;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The departsAt
	 */
	@JsonProperty("departs_at")
	public String getDepartsAt() {
		return departsAt;
	}

	/**
	 * 
	 * @param departsAt
	 *            The departs_at
	 */
	@JsonProperty("departs_at")
	public void setDepartsAt(String departsAt) {
		this.departsAt = departsAt;
	}

	/**
	 * 
	 * @return The arrivesAt
	 */
	@JsonProperty("arrives_at")
	public String getArrivesAt() {
		return arrivesAt;
	}

	/**
	 * 
	 * @param arrivesAt
	 *            The arrives_at
	 */
	@JsonProperty("arrives_at")
	public void setArrivesAt(String arrivesAt) {
		this.arrivesAt = arrivesAt;
	}

	/**
	 * 
	 * @return The origin
	 */
	@JsonProperty("origin")
	public Origin getOrigin() {
		return origin;
	}

	/**
	 * 
	 * @param origin
	 *            The origin
	 */
	@JsonProperty("origin")
	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	/**
	 * 
	 * @return The destination
	 */
	@JsonProperty("destination")
	public Destination getDestination() {
		return destination;
	}

	/**
	 * 
	 * @param destination
	 *            The destination
	 */
	@JsonProperty("destination")
	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	/**
	 * 
	 * @return The marketingAirline
	 */
	@JsonProperty("marketing_airline")
	public String getMarketingAirline() {
		return marketingAirline;
	}

	/**
	 * 
	 * @param marketingAirline
	 *            The marketing_airline
	 */
	@JsonProperty("marketing_airline")
	public void setMarketingAirline(String marketingAirline) {
		this.marketingAirline = marketingAirline;
	}

	/**
	 * 
	 * @return The operatingAirline
	 */
	@JsonProperty("operating_airline")
	public String getOperatingAirline() {
		return operatingAirline;
	}

	/**
	 * 
	 * @param operatingAirline
	 *            The operating_airline
	 */
	@JsonProperty("operating_airline")
	public void setOperatingAirline(String operatingAirline) {
		this.operatingAirline = operatingAirline;
	}

	/**
	 * 
	 * @return The flightNumber
	 */
	@JsonProperty("flight_number")
	public String getFlightNumber() {
		return flightNumber;
	}

	/**
	 * 
	 * @param flightNumber
	 *            The flight_number
	 */
	@JsonProperty("flight_number")
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	/**
	 * 
	 * @return The aircraft
	 */
	@JsonProperty("aircraft")
	public String getAircraft() {
		return aircraft;
	}

	/**
	 * 
	 * @param aircraft
	 *            The aircraft
	 */
	@JsonProperty("aircraft")
	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}

	/**
	 * 
	 * @return The bookingInfo
	 */
	@JsonProperty("booking_info")
	public BookingInfo getBookingInfo() {
		return bookingInfo;
	}

	/**
	 * 
	 * @param bookingInfo
	 *            The booking_info
	 */
	@JsonProperty("booking_info")
	public void setBookingInfo(BookingInfo bookingInfo) {
		this.bookingInfo = bookingInfo;
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
		private Flight instance;

		private Builder(Flight instance) {
			this.instance = instance;
		}

		public Builder origin(Origin origin) {
			this.instance.origin = origin;
			return this;
		}

		public Builder destination(Destination destination) {
			this.instance.destination = destination;
			return this;
		}

		public Builder marketingAirline(String marketingAirline) {
			this.instance.marketingAirline = marketingAirline;
			return this;
		}

		public Builder operatingAirline(String operatingAirline) {
			this.instance.operatingAirline = operatingAirline;
			return this;
		}

		public Builder flightNumber(String flightNumber) {
			this.instance.flightNumber = flightNumber;
			return this;
		}

		public Builder bookingInfo(BookingInfo bookingInfo) {
			this.instance.bookingInfo = bookingInfo;
			return this;
		}

		public Flight getInstance() {
			return this.instance;
		}
	}

	public static Builder getBuilder() {
		return new Builder(new Flight());
	}

	@Override
	public void accept(FlightVisitor visitor) {
		visitor.visit(this);
	}
}