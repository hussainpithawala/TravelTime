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
@JsonPropertyOrder({ "term", "country", "all_airports" })
public class AirportAutocompleteRQ {

	@JsonProperty("term")
	private String term;
	@JsonProperty("country")
	private String country;
	@JsonProperty("all_airports")
	private Boolean allAirports;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 *
	 * @return The term
	 */
	@JsonProperty("term")
	public String getTerm() {
		return term;
	}

	/**
	 *
	 * @param term
	 *            The term
	 */
	@JsonProperty("term")
	public void setTerm(String term) {
		this.term = term;
	}

	/**
	 *
	 * @return The country
	 */
	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	/**
	 *
	 * @param country
	 *            The country
	 */
	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 *
	 * @return The allAirports
	 */
	@JsonProperty("all_airports")
	public Boolean getAllAirports() {
		return allAirports;
	}

	/**
	 *
	 * @param allAirports
	 *            The all_airports
	 */
	@JsonProperty("all_airports")
	public void setAllAirports(Boolean allAirports) {
		this.allAirports = allAirports;
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
		private AirportAutocompleteRQ instance;

		private Builder(AirportAutocompleteRQ instance) {
			this.instance = instance;
		}

		public Builder term(String term) {
			this.instance.term = term;
			return this;
		}

		public Builder country(String country) {
			this.instance.country = country;
			return this;
		}
		
		public Builder allAirports(Boolean allAirportsOption) {
			this.instance.allAirports = allAirportsOption;
			return this;
		}

		public AirportAutocompleteRQ getInstance() {
			return this.instance;
		}
	}

	public static Builder getBuilder() {
		return new Builder(new AirportAutocompleteRQ());
	}

}