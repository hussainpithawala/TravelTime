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
@JsonPropertyOrder({ "origin", "destination", "departure_date", "return_date", "adults", "children", "infants",
		"include_merchants", "exclude_merchants", "max_price", "currency", "mobile" })
public class AffiliateFlightSearchRQ {

	@JsonProperty("origin")
	private String origin;
	@JsonProperty("destination")
	private String destination;
	@JsonProperty("departure_date")
	private String departureDate;
	@JsonProperty("return_date")
	private String returnDate;
	@JsonProperty("adults")
	private Integer adults;
	@JsonProperty("children")
	private Integer children;
	@JsonProperty("infants")
	private Integer infants;
	@JsonProperty("include_merchants")
	private String includeMerchants;
	@JsonProperty("exclude_merchants")
	private String excludeMerchants;
	@JsonProperty("max_price")
	private Integer maxPrice;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("mobile")
	private Boolean mobile;
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
	 * @return The children
	 */
	@JsonProperty("children")
	public Integer getChildren() {
		return children;
	}

	/**
	 *
	 * @param children
	 *            The children
	 */
	@JsonProperty("children")
	public void setChildren(Integer children) {
		this.children = children;
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

	/**
	 *
	 * @return The includeMerchants
	 */
	@JsonProperty("include_merchants")
	public String getIncludeMerchants() {
		return includeMerchants;
	}

	/**
	 *
	 * @param includeMerchants
	 *            The include_merchants
	 */
	@JsonProperty("include_merchants")
	public void setIncludeMerchants(String includeMerchants) {
		this.includeMerchants = includeMerchants;
	}

	/**
	 *
	 * @return The excludeMerchants
	 */
	@JsonProperty("exclude_merchants")
	public String getExcludeMerchants() {
		return excludeMerchants;
	}

	/**
	 *
	 * @param excludeMerchants
	 *            The exclude_merchants
	 */
	@JsonProperty("exclude_merchants")
	public void setExcludeMerchants(String excludeMerchants) {
		this.excludeMerchants = excludeMerchants;
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
	 * @return The mobile
	 */
	@JsonProperty("mobile")
	public Boolean getMobile() {
		return mobile;
	}

	/**
	 *
	 * @param mobile
	 *            The mobile
	 */
	@JsonProperty("mobile")
	public void setMobile(Boolean mobile) {
		this.mobile = mobile;
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