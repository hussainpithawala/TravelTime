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
@JsonPropertyOrder({ "origin", "destination", "departure_date", "one-way", "duration", "direct", "max_price",
		"aggregation_mode" })
public class FlightInspirationSearchRQ {

	@JsonProperty("origin")
	private String origin;
	@JsonProperty("destination")
	private String destination;
	@JsonProperty("departure_date")
	private String departureDate;
	@JsonProperty("one-way")
	private Boolean oneWay;
	@JsonProperty("duration")
	private Integer duration;
	@JsonProperty("direct")
	private Boolean direct;
	@JsonProperty("max_price")
	private Integer maxPrice;
	@JsonProperty("aggregation_mode")
	private String aggregationMode;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 *
	 * @return The origin
	 */
	@JsonProperty("origin")
	public String getOrigin() {
		return origin;
	}

	/**
	 *
	 * @param origin
	 *            The origin
	 */
	@JsonProperty("origin")
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 *
	 * @return The destination
	 */
	@JsonProperty("destination")
	public String getDestination() {
		return destination;
	}

	/**
	 *
	 * @param destination
	 *            The destination
	 */
	@JsonProperty("destination")
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 *
	 * @return The departureDate
	 */
	@JsonProperty("departure_date")
	public String getDepartureDate() {
		return departureDate;
	}

	/**
	 *
	 * @param departureDate
	 *            The departure_date
	 */
	@JsonProperty("departure_date")
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 *
	 * @return The oneWay
	 */
	@JsonProperty("one-way")
	public Boolean getOneWay() {
		return oneWay;
	}

	/**
	 *
	 * @param oneWay
	 *            The one-way
	 */
	@JsonProperty("one-way")
	public void setOneWay(Boolean oneWay) {
		this.oneWay = oneWay;
	}

	/**
	 *
	 * @return The duration
	 */
	@JsonProperty("duration")
	public Integer getDuration() {
		return duration;
	}

	/**
	 *
	 * @param duration
	 *            The duration
	 */
	@JsonProperty("duration")
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 *
	 * @return The direct
	 */
	@JsonProperty("direct")
	public Boolean getDirect() {
		return direct;
	}

	/**
	 *
	 * @param direct
	 *            The direct
	 */
	@JsonProperty("direct")
	public void setDirect(Boolean direct) {
		this.direct = direct;
	}

	/**
	 *
	 * @return The maxPrice
	 */
	@JsonProperty("max_price")
	public Integer getMaxPrice() {
		return maxPrice;
	}

	/**
	 *
	 * @param maxPrice
	 *            The max_price
	 */
	@JsonProperty("max_price")
	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}

	/**
	 *
	 * @return The aggregationMode
	 */
	@JsonProperty("aggregation_mode")
	public String getAggregationMode() {
		return aggregationMode;
	}

	/**
	 *
	 * @param aggregationMode
	 *            The aggregation_mode
	 */
	@JsonProperty("aggregation_mode")
	public void setAggregationMode(String aggregationMode) {
		this.aggregationMode = aggregationMode;
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
		private FlightInspirationSearchRQ instance;

		private Builder(FlightInspirationSearchRQ instance) {
			this.instance = instance;
		}

		public Builder origin(String origin) {
			this.instance.origin = origin;
			return this;
		}

		public Builder destination(String destination) {
			this.instance.destination = destination;
			return this;
		}

		public Builder departureDate(String departureDate) {
			this.instance.departureDate = departureDate;
			return this;
		}

		public Builder oneWay(Boolean oneWayOption) {
			this.instance.oneWay = oneWayOption;
			return this;
		}

		public Builder duration(Integer duration) {
			this.instance.duration = duration;
			return this;
		}

		public Builder direct(Boolean direct) {
			this.instance.direct = direct;
			return this;
		}

		public Builder maxPrice(Integer maxPrice) {
			this.instance.maxPrice = maxPrice;
			return this;
		}
		
		public Builder aggregationMode(String aggregationMode) {
			this.instance.aggregationMode = aggregationMode;
			return this;
		}


		public FlightInspirationSearchRQ getInstance() {
			return this.instance;
		}
	}

	public static Builder getBuilder() {
		return new Builder(new FlightInspirationSearchRQ());
	}

}