
package com.synerzip.supplier.sabre.model.flights.bargainfindermax;

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
    "RequestorID"
})
public class Source {

    @JsonProperty("RequestorID")
    private RequestorID RequestorID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The RequestorID
     */
    @JsonProperty("RequestorID")
    public RequestorID getRequestorID() {
        return RequestorID;
    }

    /**
     * 
     * @param RequestorID
     *     The RequestorID
     */
    @JsonProperty("RequestorID")
    public void setRequestorID(RequestorID RequestorID) {
        this.RequestorID = RequestorID;
    }

    public Source withRequestorID(RequestorID RequestorID) {
        this.RequestorID = RequestorID;
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

    public Source withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
