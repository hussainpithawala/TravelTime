
package com.synerzip.supplier.sabre.model.flights.instaflight_gen;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.synerzip.supplier.sabre.model.flights.visitors.FareInfosVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.ItinTotalFareVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.PTCFareBreakdownsVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.PricedItineraryElement;
import com.synerzip.supplier.sabre.model.flights.visitors.PricedItineraryVisitor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "PTC_FareBreakdowns",
    "FareInfos",
    "TPA_Extensions",
    "ItinTotalFare"
})
public class AirItineraryPricingInfo implements PricedItineraryElement {

    @JsonProperty("PTC_FareBreakdowns")
    private PTCFareBreakDowns ptcFareBreakDowns;
    @JsonProperty("FareInfos")
    private FareInfos fareInfos;
    @JsonProperty("TPA_Extensions")
    private TPA_Extensions___ TPA_Extensions;
    @JsonProperty("ItinTotalFare")
    private ItinTotalFare itinTotalFare;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The PTC_FareBreakdowns
     */
    @JsonProperty("PTC_FareBreakdowns")
    public PTCFareBreakDowns getPTC_FareBreakdowns() {
        return ptcFareBreakDowns;
    }

    /**
     * 
     * @param PTC_FareBreakdowns
     *     The PTC_FareBreakdowns
     */
    @JsonProperty("PTC_FareBreakdowns")
    public void setPTC_FareBreakdowns(PTCFareBreakDowns PTC_FareBreakdowns) {
        this.ptcFareBreakDowns = PTC_FareBreakdowns;
    }

    /**
     * 
     * @return
     *     The FareInfos
     */
    @JsonProperty("FareInfos")
    public FareInfos getFareInfos() {
        return fareInfos;
    }

    /**
     * 
     * @param FareInfos
     *     The FareInfos
     */
    @JsonProperty("FareInfos")
    public void setFareInfos(FareInfos FareInfos) {
        this.fareInfos = FareInfos;
    }

    /**
     * 
     * @return
     *     The TPA_Extensions
     */
    @JsonProperty("TPA_Extensions")
    public TPA_Extensions___ getTPA_Extensions() {
        return TPA_Extensions;
    }

    /**
     * 
     * @param TPA_Extensions
     *     The TPA_Extensions
     */
    @JsonProperty("TPA_Extensions")
    public void setTPA_Extensions(TPA_Extensions___ TPA_Extensions) {
        this.TPA_Extensions = TPA_Extensions;
    }

    /**
     * 
     * @return
     *     The ItinTotalFare
     */
    @JsonProperty("ItinTotalFare")
    public ItinTotalFare getItinTotalFare() {
        return itinTotalFare;
    }

    /**
     * 
     * @param itinTotalFare
     *     The ItinTotalFare
     */
    @JsonProperty("ItinTotalFare")
    public void setItinTotalFare(ItinTotalFare itinTotalFare) {
        this.itinTotalFare = itinTotalFare;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public void accept(PricedItineraryVisitor visitor) {
		visitor.visit(this);

		if (visitor instanceof PTCFareBreakdownsVisitor) {
			ptcFareBreakDowns.accept(((PTCFareBreakdownsVisitor)visitor));
		}

		if (visitor instanceof FareInfosVisitor) {
			fareInfos.accept((FareInfosVisitor)visitor);
		}
		
		if (visitor instanceof ItinTotalFareVisitor) {
			itinTotalFare.accept((ItinTotalFareVisitor)visitor);
		}
	}

}
