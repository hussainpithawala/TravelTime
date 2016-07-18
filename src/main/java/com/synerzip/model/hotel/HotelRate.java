package com.synerzip.model.hotel;

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
@JsonPropertyOrder({ "start_date", "end_date", "currency_code", "price" })
public class HotelRate {

	@JsonProperty("start_date")
	private String startDate;
	@JsonProperty("end_date")
	private String endDate;
	@JsonProperty("currency_code")
	private String currencyCode;
	@JsonProperty("price")
	private int price;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The startDate
	 */
	@JsonProperty("start_date")
	public String getStartDate() {
		return startDate;
	}

	/**
	 * 
	 * @param startDate
	 *            The start_date
	 */
	@JsonProperty("start_date")
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * 
	 * @return The endDate
	 */
	@JsonProperty("end_date")
	public String getEndDate() {
		return endDate;
	}

	/**
	 * 
	 * @param endDate
	 *            The end_date
	 */
	@JsonProperty("end_date")
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * 
	 * @return The currencyCode
	 */
	@JsonProperty("currency_code")
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * 
	 * @param currencyCode
	 *            The currency_code
	 */
	@JsonProperty("currency_code")
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * 
	 * @return The price
	 */
	@JsonProperty("price")
	public int getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price
	 *            The price
	 */
	@JsonProperty("price")
	public void setPrice(int price) {
		this.price = price;
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