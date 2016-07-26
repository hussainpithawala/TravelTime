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
@JsonPropertyOrder({
"code",
"geonames_ID",
"name",
"state",
"country",
"location",
"timezone",
"currency"
})
public class City {

@JsonProperty("code")
private String code;
@JsonProperty("geonames_ID")
private int geonamesID;
@JsonProperty("name")
private String name;
@JsonProperty("state")
private String state;
@JsonProperty("country")
private String country;
@JsonProperty("location")
private Location location;
@JsonProperty("timezone")
private String timezone;
@JsonProperty("currency")
private String currency;
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

public City withCode(String code) {
this.code = code;
return this;
}

/**
* 
* @return
* The geonamesID
*/
@JsonProperty("geonames_ID")
public int getGeonamesID() {
return geonamesID;
}

/**
* 
* @param geonamesID
* The geonames_ID
*/
@JsonProperty("geonames_ID")
public void setGeonamesID(int geonamesID) {
this.geonamesID = geonamesID;
}

public City withGeonamesID(int geonamesID) {
this.geonamesID = geonamesID;
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

public City withName(String name) {
this.name = name;
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

public City withState(String state) {
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

public City withCountry(String country) {
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

public City withLocation(Location location) {
this.location = location;
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

public City withTimezone(String timezone) {
this.timezone = timezone;
return this;
}

/**
* 
* @return
* The currency
*/
@JsonProperty("currency")
public String getCurrency() {
return currency;
}

/**
* 
* @param currency
* The currency
*/
@JsonProperty("currency")
public void setCurrency(String currency) {
this.currency = currency;
}

public City withCurrency(String currency) {
this.currency = currency;
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

public City withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

}