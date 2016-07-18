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
"terminal"
})
public class Destination {

@JsonProperty("airport")
private String airport;
@JsonProperty("terminal")
private String terminal;
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

/**
* 
* @return
* The terminal
*/
@JsonProperty("terminal")
public String getTerminal() {
return terminal;
}

/**
* 
* @param terminal
* The terminal
*/
@JsonProperty("terminal")
public void setTerminal(String terminal) {
this.terminal = terminal;
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