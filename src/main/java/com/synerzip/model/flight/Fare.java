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
@JsonPropertyOrder({ "total_price", "price_per_adult", "restrictions", "currency", "price_per_child", "fees" })
public class Fare {

	@JsonProperty("total_price")
	private String totalPrice;
	@JsonProperty("price_per_adult")
	private PricePerAdult pricePerAdult;
	@JsonProperty("restrictions")
	private Restrictions restrictions;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("price_per_child")
	private PricePerChild pricePerChild;
	@JsonProperty("fees")
	private Fees fees;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The totalPrice
	 */
	@JsonProperty("total_price")
	public String getTotalPrice() {
		return totalPrice;
	}

	/**
	 * 
	 * @param totalPrice
	 *            The total_price
	 */
	@JsonProperty("total_price")
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * 
	 * @return The pricePerAdult
	 */
	@JsonProperty("price_per_adult")
	public PricePerAdult getPricePerAdult() {
		return pricePerAdult;
	}

	/**
	 * 
	 * @param pricePerAdult
	 *            The price_per_adult
	 */
	@JsonProperty("price_per_adult")
	public void setPricePerAdult(PricePerAdult pricePerAdult) {
		this.pricePerAdult = pricePerAdult;
	}

	/**
	 * 
	 * @return The restrictions
	 */
	@JsonProperty("restrictions")
	public Restrictions getRestrictions() {
		return restrictions;
	}

	/**
	 * 
	 * @param restrictions
	 *            The restrictions
	 */
	@JsonProperty("restrictions")
	public void setRestrictions(Restrictions restrictions) {
		this.restrictions = restrictions;
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
	 * @return The pricePerChild
	 */
	@JsonProperty("price_per_child")
	public PricePerChild getPricePerChild() {
		return pricePerChild;
	}

	/**
	 * 
	 * @param pricePerChild
	 *            The price_per_child
	 */
	@JsonProperty("price_per_child")
	public void setPricePerChild(PricePerChild pricePerChild) {
		this.pricePerChild = pricePerChild;
	}

	/**
	 * 
	 * @return The fees
	 */
	@JsonProperty("fees")
	public Fees getFees() {
		return fees;
	}

	/**
	 * 
	 * @param fees
	 *            The fees
	 */
	@JsonProperty("fees")
	public void setFees(Fees fees) {
		this.fees = fees;
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