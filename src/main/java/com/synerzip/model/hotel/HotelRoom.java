package com.synerzip.model.hotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
@JsonPropertyOrder({ "booking_code", "room_type_code", "rate_plan_code", "total_amount", "rates", "descriptions",
		"room_type_info", "rate_type_code" })
public class HotelRoom {

	@JsonProperty("booking_code")
	private String bookingCode;
	@JsonProperty("room_type_code")
	private String roomTypeCode;
	@JsonProperty("rate_plan_code")
	private String ratePlanCode;
	@JsonProperty("total_amount")
	private HotelTotalAmount totalAmount;
	@JsonProperty("rates")
	private List<HotelRate> rates = new ArrayList<HotelRate>();
	@JsonProperty("descriptions")
	private List<String> descriptions = new ArrayList<String>();
	@JsonProperty("room_type_info")
	private HotelRoomTypeInfo roomTypeInfo;
	@JsonProperty("rate_type_code")
	private String rateTypeCode;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
	 * @return The roomTypeCode
	 */
	@JsonProperty("room_type_code")
	public String getRoomTypeCode() {
		return roomTypeCode;
	}

	/**
	 * 
	 * @param roomTypeCode
	 *            The room_type_code
	 */
	@JsonProperty("room_type_code")
	public void setRoomTypeCode(String roomTypeCode) {
		this.roomTypeCode = roomTypeCode;
	}

	/**
	 * 
	 * @return The ratePlanCode
	 */
	@JsonProperty("rate_plan_code")
	public String getRatePlanCode() {
		return ratePlanCode;
	}

	/**
	 * 
	 * @param ratePlanCode
	 *            The rate_plan_code
	 */
	@JsonProperty("rate_plan_code")
	public void setRatePlanCode(String ratePlanCode) {
		this.ratePlanCode = ratePlanCode;
	}

	/**
	 * 
	 * @return The totalAmount
	 */
	@JsonProperty("total_amount")
	public HotelTotalAmount getTotalAmount() {
		return totalAmount;
	}

	/**
	 * 
	 * @param totalAmount
	 *            The total_amount
	 */
	@JsonProperty("total_amount")
	public void setTotalAmount(HotelTotalAmount totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * 
	 * @return The rates
	 */
	@JsonProperty("rates")
	public List<HotelRate> getRates() {
		return rates;
	}

	/**
	 * 
	 * @param rates
	 *            The rates
	 */
	@JsonProperty("rates")
	public void setRates(List<HotelRate> rates) {
		this.rates = rates;
	}

	/**
	 * 
	 * @return The descriptions
	 */
	@JsonProperty("descriptions")
	public List<String> getDescriptions() {
		return descriptions;
	}

	/**
	 * 
	 * @param descriptions
	 *            The descriptions
	 */
	@JsonProperty("descriptions")
	public void setDescriptions(List<String> descriptions) {
		this.descriptions = descriptions;
	}

	/**
	 * 
	 * @return The roomTypeInfo
	 */
	@JsonProperty("room_type_info")
	public HotelRoomTypeInfo getRoomTypeInfo() {
		return roomTypeInfo;
	}

	/**
	 * 
	 * @param roomTypeInfo
	 *            The room_type_info
	 */
	@JsonProperty("room_type_info")
	public void setRoomTypeInfo(HotelRoomTypeInfo roomTypeInfo) {
		this.roomTypeInfo = roomTypeInfo;
	}

	/**
	 * 
	 * @return The rateTypeCode
	 */
	@JsonProperty("rate_type_code")
	public String getRateTypeCode() {
		return rateTypeCode;
	}

	/**
	 * 
	 * @param rateTypeCode
	 *            The rate_type_code
	 */
	@JsonProperty("rate_type_code")
	public void setRateTypeCode(String rateTypeCode) {
		this.rateTypeCode = rateTypeCode;
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