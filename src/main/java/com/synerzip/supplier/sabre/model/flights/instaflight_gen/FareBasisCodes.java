
package com.synerzip.supplier.sabre.model.flights.instaflight_gen;

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
    "FareBasisCode"
})
public class FareBasisCodes {

    @JsonProperty("FareBasisCode")
    private List<FareBasisCode> FareBasisCode = new ArrayList<FareBasisCode>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The FareBasisCode
     */
    @JsonProperty("FareBasisCode")
    public List<FareBasisCode> getFareBasisCode() {
        return FareBasisCode;
    }

    /**
     * 
     * @param FareBasisCode
     *     The FareBasisCode
     */
    @JsonProperty("FareBasisCode")
    public void setFareBasisCode(List<FareBasisCode> FareBasisCode) {
        this.FareBasisCode = FareBasisCode;
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
