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
@JsonPropertyOrder({ "origin", "destination", "departure_date", "return_date", "number_of_results", "adults",
		"infants" })
public class LowFareFlightSearchRQ {

	@JsonProperty("origin")
	private String origin;
	@JsonProperty("destination")
	private String destination;
	@JsonProperty("departure_date")
	private String departureDate;
	@JsonProperty("return_date")
	private String returnDate;
	@JsonProperty("number_of_results")
	private Integer numberOfResults;
	@JsonProperty("adults")
	private Integer adults;
	@JsonProperty("infants")
	private Integer infants;
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
	 * @return The returnDate
	 */
	@JsonProperty("return_date")
	public String getReturnDate() {
		return returnDate;
	}

	/**
	 * 
	 * @param returnDate
	 *            The return_date
	 */
	@JsonProperty("return_date")
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
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
	 *            The number_of_results
	 */
	@JsonProperty("number_of_results")
	public void setNumberOfResults(Integer numberOfResults) {
		this.numberOfResults = numberOfResults;
	}

	/**
	 * 
	 * @return The adults
	 */
	@JsonProperty("adults")
	public Integer getAdults() {
		return adults;
	}

	/**
	 * 
	 * @param adults
	 *            The adults
	 */
	@JsonProperty("adults")
	public void setAdults(Integer adults) {
		this.adults = adults;
	}

	/**
	 * 
	 * @return The infants
	 */
	@JsonProperty("infants")
	public Integer getInfants() {
		return infants;
	}

	/**
	 * 
	 * @param infants
	 *            The infants
	 */
	@JsonProperty("infants")
	public void setInfants(Integer infants) {
		this.infants = infants;
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
		private LowFareFlightSearchRQ instance;

		private Builder(LowFareFlightSearchRQ instance) {
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

		public Builder returnDate(String returnDate) {
			this.instance.returnDate = returnDate;
			return this;
		}

		public Builder numberOfResults(Integer numberOfResults) {
			this.instance.numberOfResults = numberOfResults;
			return this;
		}
		
		public Builder adults(Integer adults) {
			this.instance.adults = adults;
			return this;
		}

		public Builder infants(Integer infants) {
			this.instance.infants = infants;
			return this;
		}

		public LowFareFlightSearchRQ getInstance() {
			return this.instance;
		}
	}

	public static Builder getBuilder() {
		return new Builder(new LowFareFlightSearchRQ());
	}

}
