package com.synerzip.model.flight;

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
"city",
"airports"
})
public class LocationInformationSearchRS {

@JsonProperty("city")
private City city;
@JsonProperty("airports")
private List<Airport> airports = new ArrayList<Airport>();
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The city
*/
@JsonProperty("city")
public City getCity() {
return city;
}

/**
* 
* @param city
* The city
*/
@JsonProperty("city")
public void setCity(City city) {
this.city = city;
}

public LocationInformationSearchRS withCity(City city) {
this.city = city;
return this;
}

/**
* 
* @return
* The airports
*/
@JsonProperty("airports")
public List<Airport> getAirports() {
return airports;
}

/**
* 
* @param airports
* The airports
*/
@JsonProperty("airports")
public void setAirports(List<Airport> airports) {
this.airports = airports;
}

public LocationInformationSearchRS withAirports(List<Airport> airports) {
this.airports = airports;
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

public LocationInformationSearchRS withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}
}