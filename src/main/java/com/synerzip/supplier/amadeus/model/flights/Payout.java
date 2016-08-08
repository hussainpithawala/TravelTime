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
    "CPA",
    "CPS",
    "CPC"
})
public class Payout {

    @JsonProperty("CPA")
    private CPA cPA;
    @JsonProperty("CPS")
    private CPS cPS;
    @JsonProperty("CPC")
    private CPC cPC;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The cPA
     */
    @JsonProperty("CPA")
    public CPA getCPA() {
        return cPA;
    }

    /**
     * 
     * @param cPA
     *     The CPA
     */
    @JsonProperty("CPA")
    public void setCPA(CPA cPA) {
        this.cPA = cPA;
    }

    /**
     * 
     * @return
     *     The cPS
     */
    @JsonProperty("CPS")
    public CPS getCPS() {
        return cPS;
    }

    /**
     * 
     * @param cPS
     *     The CPS
     */
    @JsonProperty("CPS")
    public void setCPS(CPS cPS) {
        this.cPS = cPS;
    }

    /**
     * 
     * @return
     *     The cPC
     */
    @JsonProperty("CPC")
    public CPC getCPC() {
        return cPC;
    }

    /**
     * 
     * @param cPC
     *     The CPC
     */
    @JsonProperty("CPC")
    public void setCPC(CPC cPC) {
        this.cPC = cPC;
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
