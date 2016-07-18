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
import com.synerzip.model.hotel.MoreRoomsAtThisHotel;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "more_rooms_at_this_hotel" })
public class LinksForMoreRooms {

	@JsonProperty("more_rooms_at_this_hotel")
	private MoreRoomsAtThisHotel moreRoomsAtThisHotel;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The moreRoomsAtThisHotel
	 */
	@JsonProperty("more_rooms_at_this_hotel")
	public MoreRoomsAtThisHotel getMoreRoomsAtThisHotel() {
		return moreRoomsAtThisHotel;
	}

	/**
	 * 
	 * @param moreRoomsAtThisHotel
	 *            The more_rooms_at_this_hotel
	 */
	@JsonProperty("more_rooms_at_this_hotel")
	public void setMoreRoomsAtThisHotel(MoreRoomsAtThisHotel moreRoomsAtThisHotel) {
		this.moreRoomsAtThisHotel = moreRoomsAtThisHotel;
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