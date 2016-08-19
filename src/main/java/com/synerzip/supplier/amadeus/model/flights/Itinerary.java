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
"outbound"
})
public class Itinerary {

@JsonProperty("outbound")
private Outbound outbound;
@JsonProperty("inbound")
private Inbound inbound;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The outbound
*/
@JsonProperty("outbound")
public Outbound getOutbound() {
return outbound;
}

/**
* 
* @param outbound
* The outbound
*/
@JsonProperty("outbound")
public void setOutbound(Outbound outbound) {
this.outbound = outbound;
}

@JsonProperty("inbound")
public Inbound getInbound() {
	return inbound;
}

@JsonProperty("inbound")
public void setInbound(Inbound inbound) {
	this.inbound = inbound;
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
