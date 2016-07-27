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
    "service_fees",
    "creditcard_fees"
})
public class Fees {

    @JsonProperty("service_fees")
    private Object serviceFees;
    @JsonProperty("creditcard_fees")
    private Object creditcardFees;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The serviceFees
     */
    @JsonProperty("service_fees")
    public Object getServiceFees() {
        return serviceFees;
    }

    /**
     * 
     * @param serviceFees
     *     The service_fees
     */
    @JsonProperty("service_fees")
    public void setServiceFees(Object serviceFees) {
        this.serviceFees = serviceFees;
    }

    /**
     * 
     * @return
     *     The creditcardFees
     */
    @JsonProperty("creditcard_fees")
    public Object getCreditcardFees() {
        return creditcardFees;
    }

    /**
     * 
     * @param creditcardFees
     *     The creditcard_fees
     */
    @JsonProperty("creditcard_fees")
    public void setCreditcardFees(Object creditcardFees) {
        this.creditcardFees = creditcardFees;
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