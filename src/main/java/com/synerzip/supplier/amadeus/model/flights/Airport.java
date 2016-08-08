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
@JsonPropertyOrder({
"code",
"name",
"city_code",
"city_name",
"state",
"country",
"location",
"aircraft_movements",
"timezone"
})
public class Airport {

@JsonProperty("code")
private String code;
@JsonProperty("name")
private String name;
@JsonProperty("city_code")
private String cityCode;
@JsonProperty("city_name")
private String cityName;
@JsonProperty("state")
private String state;
@JsonProperty("country")
private String country;
@JsonProperty("location")
private Location location;
@JsonProperty("aircraft_movements")
private int aircraftMovements;
@JsonProperty("timezone")
private String timezone;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The code
*/
@JsonProperty("code")
public String getCode() {
return code;
}

/**
* 
* @param code
* The code
*/
@JsonProperty("code")
public void setCode(String code) {
this.code = code;
}

public Airport withCode(String code) {
this.code = code;
return this;
}

/**
* 
* @return
* The name
*/
@JsonProperty("name")
public String getName() {
return name;
}

/**
* 
* @param name
* The name
*/
@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

public Airport withName(String name) {
this.name = name;
return this;
}

/**
* 
* @return
* The cityCode
*/
@JsonProperty("city_code")
public String getCityCode() {
return cityCode;
}

/**
* 
* @param cityCode
* The city_code
*/
@JsonProperty("city_code")
public void setCityCode(String cityCode) {
this.cityCode = cityCode;
}

public Airport withCityCode(String cityCode) {
this.cityCode = cityCode;
return this;
}

/**
* 
* @return
* The cityName
*/
@JsonProperty("city_name")
public String getCityName() {
return cityName;
}

/**
* 
* @param cityName
* The city_name
*/
@JsonProperty("city_name")
public void setCityName(String cityName) {
this.cityName = cityName;
}

public Airport withCityName(String cityName) {
this.cityName = cityName;
return this;
}

/**
* 
* @return
* The state
*/
@JsonProperty("state")
public String getState() {
return state;
}

/**
* 
* @param state
* The state
*/
@JsonProperty("state")
public void setState(String state) {
this.state = state;
}

public Airport withState(String state) {
this.state = state;
return this;
}

/**
* 
* @return
* The country
*/
@JsonProperty("country")
public String getCountry() {
return country;
}

/**
* 
* @param country
* The country
*/
@JsonProperty("country")
public void setCountry(String country) {
this.country = country;
}

public Airport withCountry(String country) {
this.country = country;
return this;
}

/**
* 
* @return
* The location
*/
@JsonProperty("location")
public Location getLocation() {
return location;
}

/**
* 
* @param location
* The location
*/
@JsonProperty("location")
public void setLocation(Location location) {
this.location = location;
}

public Airport withLocation(Location location) {
this.location = location;
return this;
}

/**
* 
* @return
* The aircraftMovements
*/
@JsonProperty("aircraft_movements")
public int getAircraftMovements() {
return aircraftMovements;
}

/**
* 
* @param aircraftMovements
* The aircraft_movements
*/
@JsonProperty("aircraft_movements")
public void setAircraftMovements(int aircraftMovements) {
this.aircraftMovements = aircraftMovements;
}

public Airport withAircraftMovements(int aircraftMovements) {
this.aircraftMovements = aircraftMovements;
return this;
}

/**
* 
* @return
* The timezone
*/
@JsonProperty("timezone")
public String getTimezone() {
return timezone;
}

/**
* 
* @param timezone
* The timezone
*/
@JsonProperty("timezone")
public void setTimezone(String timezone) {
this.timezone = timezone;
}

public Airport withTimezone(String timezone) {
this.timezone = timezone;
return this;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

public Airport withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

}