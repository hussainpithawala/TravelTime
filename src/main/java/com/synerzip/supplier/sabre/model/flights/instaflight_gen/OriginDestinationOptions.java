
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
    "OriginDestinationOption"
})
public class OriginDestinationOptions {

    @JsonProperty("OriginDestinationOption")
    private List<OriginDestinationOption> OriginDestinationOption = new ArrayList<OriginDestinationOption>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The OriginDestinationOption
     */
    @JsonProperty("OriginDestinationOption")
    public List<OriginDestinationOption> getOriginDestinationOption() {
        return OriginDestinationOption;
    }

    /**
     * 
     * @param OriginDestinationOption
     *     The OriginDestinationOption
     */
    @JsonProperty("OriginDestinationOption")
    public void setOriginDestinationOption(List<OriginDestinationOption> OriginDestinationOption) {
        this.OriginDestinationOption = OriginDestinationOption;
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
