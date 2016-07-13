package com.synerzip.models;

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
"total_price",
"price_per_adult",
"restrictions"
})
public class Fare {

@JsonProperty("total_price")
private String totalPrice;
@JsonProperty("price_per_adult")
private PricePerAdult pricePerAdult;
@JsonProperty("restrictions")
private Restrictions restrictions;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The totalPrice
*/
@JsonProperty("total_price")
public String getTotalPrice() {
return totalPrice;
}

/**
* 
* @param totalPrice
* The total_price
*/
@JsonProperty("total_price")
public void setTotalPrice(String totalPrice) {
this.totalPrice = totalPrice;
}

/**
* 
* @return
* The pricePerAdult
*/
@JsonProperty("price_per_adult")
public PricePerAdult getPricePerAdult() {
return pricePerAdult;
}

/**
* 
* @param pricePerAdult
* The price_per_adult
*/
@JsonProperty("price_per_adult")
public void setPricePerAdult(PricePerAdult pricePerAdult) {
this.pricePerAdult = pricePerAdult;
}

/**
* 
* @return
* The restrictions
*/
@JsonProperty("restrictions")
public Restrictions getRestrictions() {
return restrictions;
}

/**
* 
* @param restrictions
* The restrictions
*/
@JsonProperty("restrictions")
public void setRestrictions(Restrictions restrictions) {
this.restrictions = restrictions;
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