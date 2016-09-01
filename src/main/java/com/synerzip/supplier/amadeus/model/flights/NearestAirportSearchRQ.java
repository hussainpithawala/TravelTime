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
@JsonPropertyOrder({ "latitude", "longitude" })
public class NearestAirportSearchRQ {

	@JsonProperty("latitude")
	private Double latitude;
	@JsonProperty("longitude")
	private Double longitude;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 *
	 * @return The latitude
	 */
	@JsonProperty("latitude")
	public Double getLatitude() {
		return latitude;
	}

	/**
	 *
	 * @param latitude
	 *            The latitude
	 */
	@JsonProperty("latitude")
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 *
	 * @return The longitude
	 */
	@JsonProperty("longitude")
	public Double getLongitude() {
		return longitude;
	}

	/**
	 *
	 * @param longitude
	 *            The longitude
	 */
	@JsonProperty("longitude")
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
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
		private NearestAirportSearchRQ instance;

		private Builder(NearestAirportSearchRQ instance) {
			this.instance = instance;
		}

		public Builder latitude(Double latitude) {
			this.instance.latitude = latitude;
			return this;
		}

		public Builder longitude(Double longitude) {
			this.instance.longitude = longitude;
			return this;
		}

		public NearestAirportSearchRQ getInstance() {
			return this.instance;
		}
	}

	public static Builder getBuilder() {
		return new Builder(new NearestAirportSearchRQ());
	}

}