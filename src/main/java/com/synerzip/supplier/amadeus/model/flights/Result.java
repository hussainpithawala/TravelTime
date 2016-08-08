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
"destination",
"departure_date",
"return_date",
"price",
"airline"
})
public class Result {

@JsonProperty("destination")
private String destination;
@JsonProperty("departure_date")
private String departureDate;
@JsonProperty("return_date")
private String returnDate;
@JsonProperty("price")
private String price;
@JsonProperty("airline")
private String airline;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

public Result withDestination(String destination) {
this.destination = destination;
return this;
}

/**
* 
* @return
* The departureDate
*/
@JsonProperty("departure_date")
public String getDepartureDate() {
return departureDate;
}

/**
* 
* @param departureDate
* The departure_date
*/
@JsonProperty("departure_date")
public void setDepartureDate(String departureDate) {
this.departureDate = departureDate;
}

public Result withDepartureDate(String departureDate) {
this.departureDate = departureDate;
return this;
}

/**
* 
* @return
* The returnDate
*/
@JsonProperty("return_date")
public String getReturnDate() {
return returnDate;
}

/**
* 
* @param returnDate
* The return_date
*/
@JsonProperty("return_date")
public void setReturnDate(String returnDate) {
this.returnDate = returnDate;
}

public Result withReturnDate(String returnDate) {
this.returnDate = returnDate;
return this;
}

/**
* 
* @return
* The price
*/
@JsonProperty("price")
public String getPrice() {
return price;
}

/**
* 
* @param price
* The price
*/
@JsonProperty("price")
public void setPrice(String price) {
this.price = price;
}

public Result withPrice(String price) {
this.price = price;
return this;
}

/**
* 
* @return
* The airline
*/
@JsonProperty("airline")
public String getAirline() {
return airline;
}

/**
* 
* @param airline
* The airline
*/
@JsonProperty("airline")
public void setAirline(String airline) {
this.airline = airline;
}

public Result withAirline(String airline) {
this.airline = airline;
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

public Result withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

}