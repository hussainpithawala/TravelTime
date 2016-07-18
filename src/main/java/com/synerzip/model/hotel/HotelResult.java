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
@JsonPropertyOrder({ "property_code", "property_name", "location", "address", "total_price", "min_daily_rate",
		"contacts", "amenities", "awards", "images", "rooms", "_links" })
public class HotelResult {

	@JsonProperty("property_code")
	private String propertyCode;
	@JsonProperty("property_name")
	private String propertyName;
	@JsonProperty("location")
	private HotelLocation location;
	@JsonProperty("address")
	private HotelAddress address;
	@JsonProperty("total_price")
	private HotelTotalPrice totalPrice;
	@JsonProperty("min_daily_rate")
	private MinDailyRate minDailyRate;
	@JsonProperty("contacts")
	private List<HotelContact> contacts = new ArrayList<HotelContact>();
	@JsonProperty("amenities")
	private List<HotelAmenity> amenities = new ArrayList<HotelAmenity>();
	@JsonProperty("awards")
	private List<Object> awards = new ArrayList<Object>();
	@JsonProperty("images")
	private List<Object> images = new ArrayList<Object>();
	@JsonProperty("rooms")
	private List<HotelRoom> rooms = new ArrayList<HotelRoom>();
	@JsonProperty("_links")
	private MoreRoomsAtThisHotel links;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The propertyCode
	 */
	@JsonProperty("property_code")
	public String getPropertyCode() {
		return propertyCode;
	}

	/**
	 * 
	 * @param propertyCode
	 *            The property_code
	 */
	@JsonProperty("property_code")
	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}

	/**
	 * 
	 * @return The propertyName
	 */
	@JsonProperty("property_name")
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * 
	 * @param propertyName
	 *            The property_name
	 */
	@JsonProperty("property_name")
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * 
	 * @return The location
	 */
	@JsonProperty("location")
	public HotelLocation getLocation() {
		return location;
	}

	/**
	 * 
	 * @param location
	 *            The location
	 */
	@JsonProperty("location")
	public void setLocation(HotelLocation location) {
		this.location = location;
	}

	/**
	 * 
	 * @return The address
	 */
	@JsonProperty("address")
	public HotelAddress getAddress() {
		return address;
	}

	/**
	 * 
	 * @param address
	 *            The address
	 */
	@JsonProperty("address")
	public void setAddress(HotelAddress address) {
		this.address = address;
	}

	/**
	 * 
	 * @return The totalPrice
	 */
	@JsonProperty("total_price")
	public HotelTotalPrice getTotalPrice() {
		return totalPrice;
	}

	/**
	 * 
	 * @param totalPrice
	 *            The total_price
	 */
	@JsonProperty("total_price")
	public void setTotalPrice(HotelTotalPrice totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * 
	 * @return The minDailyRate
	 */
	@JsonProperty("min_daily_rate")
	public MinDailyRate getMinDailyRate() {
		return minDailyRate;
	}

	/**
	 * 
	 * @param minDailyRate
	 *            The min_daily_rate
	 */
	@JsonProperty("min_daily_rate")
	public void setMinDailyRate(MinDailyRate minDailyRate) {
		this.minDailyRate = minDailyRate;
	}

	/**
	 * 
	 * @return The contacts
	 */
	@JsonProperty("contacts")
	public List<HotelContact> getContacts() {
		return contacts;
	}

	/**
	 * 
	 * @param contacts
	 *            The contacts
	 */
	@JsonProperty("contacts")
	public void setContacts(List<HotelContact> contacts) {
		this.contacts = contacts;
	}

	/**
	 * 
	 * @return The amenities
	 */
	@JsonProperty("amenities")
	public List<HotelAmenity> getAmenities() {
		return amenities;
	}

	/**
	 * 
	 * @param amenities
	 *            The amenities
	 */
	@JsonProperty("amenities")
	public void setAmenities(List<HotelAmenity> amenities) {
		this.amenities = amenities;
	}

	/**
	 * 
	 * @return The awards
	 */
	@JsonProperty("awards")
	public List<Object> getAwards() {
		return awards;
	}

	/**
	 * 
	 * @param awards
	 *            The awards
	 */
	@JsonProperty("awards")
	public void setAwards(List<Object> awards) {
		this.awards = awards;
	}

	/**
	 * 
	 * @return The images
	 */
	@JsonProperty("images")
	public List<Object> getImages() {
		return images;
	}

	/**
	 * 
	 * @param images
	 *            The images
	 */
	@JsonProperty("images")
	public void setImages(List<Object> images) {
		this.images = images;
	}

	/**
	 * 
	 * @return The rooms
	 */
	@JsonProperty("rooms")
	public List<HotelRoom> getRooms() {
		return rooms;
	}

	/**
	 * 
	 * @param rooms
	 *            The rooms
	 */
	@JsonProperty("rooms")
	public void setRooms(List<HotelRoom> rooms) {
		this.rooms = rooms;
	}

	/**
	 * 
	 * @return The links
	 */
	@JsonProperty("_links")
	public MoreRoomsAtThisHotel getLinks() {
		return links;
	}

	/**
	 * 
	 * @param links
	 *            The _links
	 */
	@JsonProperty("_links")
	public void setLinks(MoreRoomsAtThisHotel links) {
		this.links = links;
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