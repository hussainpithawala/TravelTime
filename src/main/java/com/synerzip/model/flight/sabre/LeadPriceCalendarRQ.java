package com.synerzip.model.flight.sabre;

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
@JsonPropertyOrder({
"origin",
"destination",
"lengthofstay",
"departuredate",
"minfare",
"maxfare",
"pointofsalecountry"
})
public class LeadPriceCalendarRQ {

@JsonProperty("origin")
private String origin;
@JsonProperty("destination")
private String destination;
@JsonProperty("lengthofstay")
private String lengthofstay;
@JsonProperty("departuredate")
private String departuredate;
@JsonProperty("minfare")
private int minfare;
@JsonProperty("maxfare")
private int maxfare;
@JsonProperty("pointofsalecountry")
private String pointofsalecountry;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
*
* @return
* The origin
*/
@JsonProperty("origin")
public String getOrigin() {
return origin;
}

/**
*
* @param origin
* The origin
*/
@JsonProperty("origin")
public void setOrigin(String origin) {
this.origin = origin;
}

/**
*
* @return
* The destination
*/
@JsonProperty("destination")
public String getDestination() {
return destination;
}

/**
*
* @param destination
* The destination
*/
@JsonProperty("destination")
public void setDestination(String destination) {
this.destination = destination;
}

/**
*
* @return
* The lengthofstay
*/
@JsonProperty("lengthofstay")
public String getLengthofstay() {
return lengthofstay;
}

/**
*
* @param lengthofstay
* The lengthofstay
*/
@JsonProperty("lengthofstay")
public void setLengthofstay(String lengthofstay) {
this.lengthofstay = lengthofstay;
}

/**
*
* @return
* The departuredate
*/
@JsonProperty("departuredate")
public String getDeparturedate() {
return departuredate;
}

/**
*
* @param departuredate
* The departuredate
*/
@JsonProperty("departuredate")
public void setDeparturedate(String departuredate) {
this.departuredate = departuredate;
}

/**
*
* @return
* The minfare
*/
@JsonProperty("minfare")
public int getMinfare() {
return minfare;
}

/**
*
* @param minfare
* The minfare
*/
@JsonProperty("minfare")
public void setMinfare(int minfare) {
this.minfare = minfare;
}

/**
*
* @return
* The maxfare
*/
@JsonProperty("maxfare")
public int getMaxfare() {
return maxfare;
}

/**
*
* @param maxfare
* The maxfare
*/
@JsonProperty("maxfare")
public void setMaxfare(int maxfare) {
this.maxfare = maxfare;
}

/**
*
* @return
* The pointofsalecountry
*/
@JsonProperty("pointofsalecountry")
public String getPointofsalecountry() {
return pointofsalecountry;
}

/**
*
* @param pointofsalecountry
* The pointofsalecountry
*/
@JsonProperty("pointofsalecountry")
public void setPointofsalecountry(String pointofsalecountry) {
this.pointofsalecountry = pointofsalecountry;
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
