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
"total_fare",
"tax"
})
public class PricePerAdult {

@JsonProperty("total_fare")
private String totalFare;
@JsonProperty("tax")
private String tax;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The totalFare
*/
@JsonProperty("total_fare")
public String getTotalFare() {
return totalFare;
}

/**
* 
* @param totalFare
* The total_fare
*/
@JsonProperty("total_fare")
public void setTotalFare(String totalFare) {
this.totalFare = totalFare;
}

/**
* 
* @return
* The tax
*/
@JsonProperty("tax")
public String getTax() {
return tax;
}

/**
* 
* @param tax
* The tax
*/
@JsonProperty("tax")
public void setTax(String tax) {
this.tax = tax;
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