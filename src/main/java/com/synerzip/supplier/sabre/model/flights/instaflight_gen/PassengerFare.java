
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
import com.synerzip.supplier.sabre.model.flights.visitors.PTCFareBreakDownsElement;
import com.synerzip.supplier.sabre.model.flights.visitors.PTCFareBreakdownsVisitor;
import com.synerzip.supplier.sabre.model.flights.visitors.PricedItineraryElement;
import com.synerzip.supplier.sabre.model.flights.visitors.PricedItineraryVisitor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "FareConstruction", "TotalFare", "Taxes", "BaseFare", "EquivFare" })
public class PassengerFare implements PTCFareBreakDownsElement {

	@JsonProperty("FareConstruction")
	private FareConstruction FareConstruction;
	@JsonProperty("TotalFare")
	private TotalFare totalFare;
	@JsonProperty("Taxes")
	private Taxes taxes;
	@JsonProperty("BaseFare")
	private BaseFare BaseFare;
	@JsonProperty("EquivFare")
	private EquivFare EquivFare;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The FareConstruction
	 */
	@JsonProperty("FareConstruction")
	public FareConstruction getFareConstruction() {
		return FareConstruction;
	}

	/**
	 * 
	 * @param FareConstruction
	 *            The FareConstruction
	 */
	@JsonProperty("FareConstruction")
	public void setFareConstruction(FareConstruction FareConstruction) {
		this.FareConstruction = FareConstruction;
	}

	/**
	 * 
	 * @return The TotalFare
	 */
	@JsonProperty("TotalFare")
	public TotalFare getTotalFare() {
		return totalFare;
	}

	/**
	 * 
	 * @param totalFare
	 *            The TotalFare
	 */
	@JsonProperty("TotalFare")
	public void setTotalFare(TotalFare totalFare) {
		this.totalFare = totalFare;
	}

	/**
	 * 
	 * @return The Taxes
	 */
	@JsonProperty("Taxes")
	public Taxes getTaxes() {
		return taxes;
	}

	/**
	 * 
	 * @param taxes
	 * The Taxes
	 */
	@JsonProperty("Taxes")
	public void setTaxes(Taxes taxes) {
		this.taxes = taxes;
	}

	/**
	 * 
	 * @return The BaseFare
	 */
	@JsonProperty("BaseFare")
	public BaseFare getBaseFare() {
		return BaseFare;
	}

	/**
	 * 
	 * @param BaseFare
	 *            The BaseFare
	 */
	@JsonProperty("BaseFare")
	public void setBaseFare(BaseFare BaseFare) {
		this.BaseFare = BaseFare;
	}

	/**
	 * 
	 * @return The EquivFare
	 */
	@JsonProperty("EquivFare")
	public EquivFare getEquivFare() {
		return EquivFare;
	}

	/**
	 * 
	 * @param EquivFare
	 *            The EquivFare
	 */
	@JsonProperty("EquivFare")
	public void setEquivFare(EquivFare EquivFare) {
		this.EquivFare = EquivFare;
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
	public void accept(PTCFareBreakdownsVisitor visitor) {
		visitor.visit(this);
		totalFare.accept(visitor);
		taxes.accept(visitor);
	}
}
