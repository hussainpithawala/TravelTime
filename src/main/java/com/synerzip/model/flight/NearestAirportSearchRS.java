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
"airport",
"airport_name",
"city",
"city_name",
"distance",
"location",
"aircraft_movements",
"timezone"
})
public class NearestAirportSearchRS {

@JsonProperty("airport")
private String airport;
@JsonProperty("airport_name")
private String airportName;
@JsonProperty("city")
private String city;
@JsonProperty("city_name")
private String cityName;
@JsonProperty("distance")
private double distance;
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
* The airport
*/
@JsonProperty("airport")
public String getAirport() {
return airport;
}

/**
* 
* @param airport
* The airport
*/
@JsonProperty("airport")
public void setAirport(String airport) {
this.airport = airport;
}

public NearestAirportSearchRS withAirport(String airport) {
this.airport = airport;
return this;
}

/**
* 
* @return
* The airportName
*/
@JsonProperty("airport_name")
public String getAirportName() {
return airportName;
}

/**
* 
* @param airportName
* The airport_name
*/
@JsonProperty("airport_name")
public void setAirportName(String airportName) {
this.airportName = airportName;
}

public NearestAirportSearchRS withAirportName(String airportName) {
this.airportName = airportName;
return this;
}

/**
* 
* @return
* The city
*/
@JsonProperty("city")
public String getCity() {
return city;
}

/**
* 
* @param city
* The city
*/
@JsonProperty("city")
public void setCity(String city) {
this.city = city;
}

public NearestAirportSearchRS withCity(String city) {
this.city = city;
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

public NearestAirportSearchRS withCityName(String cityName) {
this.cityName = cityName;
return this;
}

/**
* 
* @return
* The distance
*/
@JsonProperty("distance")
public double getDistance() {
return distance;
}

/**
* 
* @param distance
* The distance
*/
@JsonProperty("distance")
public void setDistance(double distance) {
this.distance = distance;
}

public NearestAirportSearchRS withDistance(double distance) {
this.distance = distance;
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

public NearestAirportSearchRS withLocation(Location location) {
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

public NearestAirportSearchRS withAircraftMovements(int aircraftMovements) {
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

public NearestAirportSearchRS withTimezone(String timezone) {
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

public NearestAirportSearchRS withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

}