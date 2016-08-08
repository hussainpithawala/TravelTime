package com.synerzip.supplier.amadeus.model.flights;

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
@JsonPropertyOrder({
"itineraries",
"fare"
})
public class ResultItinerary {

@JsonProperty("itineraries")
private List<Itinerary> itineraries = new ArrayList<Itinerary>();
@JsonProperty("fare")
private Fare fare;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The itineraries
*/
@JsonProperty("itineraries")
public List<Itinerary> getItineraries() {
return itineraries;
}

/**
* 
* @param itineraries
* The itineraries
*/
@JsonProperty("itineraries")
public void setItineraries(List<Itinerary> itineraries) {
this.itineraries = itineraries;
}

/**
* 
* @return
* The fare
*/
@JsonProperty("fare")
public Fare getFare() {
return fare;
}

/**
* 
* @param fare
* The fare
*/
@JsonProperty("fare")
public void setFare(Fare fare) {
this.fare = fare;
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
