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
"flights",
"duration"
})
public class Outbound {

@JsonProperty("flights")
private List<Flight> flights = new ArrayList<Flight>();
@JsonProperty("duration")
private String duration;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The flights
*/
@JsonProperty("flights")
public List<Flight> getFlights() {
return flights;
}

/**
* 
* @param flights
* The flights
*/
@JsonProperty("flights")
public void setFlights(List<Flight> flights) {
this.flights = flights;
}

/**
 * 
 * @return The duration
 */
@JsonProperty("duration")
public String getDuration() {
    return duration;
}

/**
 * 
 * @param duration
 *       The duration
 */
@JsonProperty("duration")
public void setDuration(String duration) {
    this.duration = duration;
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