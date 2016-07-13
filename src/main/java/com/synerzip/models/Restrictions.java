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
"refundable",
"change_penalties"
})
public class Restrictions {

@JsonProperty("refundable")
private boolean refundable;
@JsonProperty("change_penalties")
private boolean changePenalties;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The refundable
*/
@JsonProperty("refundable")
public boolean isRefundable() {
return refundable;
}

/**
* 
* @param refundable
* The refundable
*/
@JsonProperty("refundable")
public void setRefundable(boolean refundable) {
this.refundable = refundable;
}

/**
* 
* @return
* The changePenalties
*/
@JsonProperty("change_penalties")
public boolean isChangePenalties() {
return changePenalties;
}

/**
* 
* @param changePenalties
* The change_penalties
*/
@JsonProperty("change_penalties")
public void setChangePenalties(boolean changePenalties) {
this.changePenalties = changePenalties;
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