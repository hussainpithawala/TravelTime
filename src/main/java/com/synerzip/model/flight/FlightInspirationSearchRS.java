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
"origin",
"currency",
"results"
})
public class FlightInspirationSearchRS {

@JsonProperty("origin")
private String origin;
@JsonProperty("currency")
private String currency;
@JsonProperty("results")
private List<Result> results = new ArrayList<Result>();
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

public FlightInspirationSearchRS withOrigin(String origin) {
this.origin = origin;
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

public FlightInspirationSearchRS withCurrency(String currency) {
this.currency = currency;
return this;
}

/**
* 
* @return
* The results
*/
@JsonProperty("results")
public List<Result> getResults() {
return results;
}

/**
* 
* @param results
* The results
*/
@JsonProperty("results")
public void setResults(List<Result> results) {
this.results = results;
}

public FlightInspirationSearchRS withResults(List<Result> results) {
this.results = results;
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

public FlightInspirationSearchRS withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}
}