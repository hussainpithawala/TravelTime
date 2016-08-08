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
import com.synerzip.supplier.sabre.model.flights.BaseDomainRequest;

public class InstaFlightRequest extends BaseDomainRequest {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Generated("org.jsonschema2pojo")
	@JsonPropertyOrder({ "origin", "destination", "departuredate", "returndate", "includecarriers", "excludedcarriers",
			"outboundflightstops", "inboundflightstops", "includedconnectpoints", "excludedconnectpoints",
			"outboundstopduration", "inboundstopduration", "outbounddeparturewindow", "inbounddeparturewindow",
			"outboundarrivalwindow", "inboundarrivalwindow", "onlineitinerariesonly", "eticketsonly", "minfare",
			"maxfare", "limit", "offset", "sortby", "order", "sortby2", "order2", "pointofsalecountry",
			"passengercount" })

	@JsonProperty("origin")
	private String origin;
	@JsonProperty("destination")
	private String destination;
	@JsonProperty("departuredate")
	private String departuredate;
	@JsonProperty("returndate")
	private String returndate;
	@JsonProperty("includecarriers")
	private String includecarriers;
	@JsonProperty("excludedcarriers")
	private String excludedcarriers;
	@JsonProperty("outboundflightstops")
	private String outboundflightstops;
	@JsonProperty("inboundflightstops")
	private String inboundflightstops;
	@JsonProperty("includedconnectpoints")
	private String includedconnectpoints;
	@JsonProperty("excludedconnectpoints")
	private String excludedconnectpoints;
	@JsonProperty("outboundstopduration")
	private Double outboundstopduration;
	@JsonProperty("inboundstopduration")
	private Double inboundstopduration;
	@JsonProperty("outbounddeparturewindow")
	private String outbounddeparturewindow;
	@JsonProperty("inbounddeparturewindow")
	private String inbounddeparturewindow;
	@JsonProperty("outboundarrivalwindow")
	private String outboundarrivalwindow;
	@JsonProperty("inboundarrivalwindow")
	private String inboundarrivalwindow;
	@JsonProperty("onlineitinerariesonly")
	private String onlineitinerariesonly;
	@JsonProperty("eticketsonly")
	private String eticketsonly;
	@JsonProperty("minfare")
	private Double minfare;
	@JsonProperty("maxfare")
	private Double maxfare;
	@JsonProperty("limit")
	private Double limit;
	@JsonProperty("offset")
	private Double offset;
	@JsonProperty("sortby")
	private String sortby;
	@JsonProperty("order")
	private String order;
	@JsonProperty("sortby2")
	private String sortby2;
	@JsonProperty("order2")
	private String order2;
	@JsonProperty("pointofsalecountry")
	private String pointofsalecountry;
	@JsonProperty("passengercount")
	private Double passengercount;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The origin
	 */
	@JsonProperty("origin")
	public String getOrigin() {
		return origin;
	}

	/**
	 * 
	 * @param origin
	 *            The origin
	 */
	@JsonProperty("origin")
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * 
	 * @return The destination
	 */
	@JsonProperty("destination")
	public String getDestination() {
		return destination;
	}

	/**
	 * 
	 * @param destination
	 *            The destination
	 */
	@JsonProperty("destination")
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * 
	 * @return The departuredate
	 */
	@JsonProperty("departuredate")
	public String getDeparturedate() {
		return departuredate;
	}

	/**
	 * 
	 * @param departuredate
	 *            The departuredate
	 */
	@JsonProperty("departuredate")
	public void setDeparturedate(String departuredate) {
		this.departuredate = departuredate;
	}

	/**
	 * 
	 * @return The returndate
	 */
	@JsonProperty("returndate")
	public String getReturndate() {
		return returndate;
	}

	/**
	 * 
	 * @param returndate
	 *            The returndate
	 */
	@JsonProperty("returndate")
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}

	/**
	 * 
	 * @return The includecarriers
	 */
	@JsonProperty("includecarriers")
	public String getIncludecarriers() {
		return includecarriers;
	}

	/**
	 * 
	 * @param includecarriers
	 *            The includecarriers
	 */
	@JsonProperty("includecarriers")
	public void setIncludecarriers(String includecarriers) {
		this.includecarriers = includecarriers;
	}

	/**
	 * 
	 * @return The excludedcarriers
	 */
	@JsonProperty("excludedcarriers")
	public String getExcludedcarriers() {
		return excludedcarriers;
	}

	/**
	 * 
	 * @param excludedcarriers
	 *            The excludedcarriers
	 */
	@JsonProperty("excludedcarriers")
	public void setExcludedcarriers(String excludedcarriers) {
		this.excludedcarriers = excludedcarriers;
	}

	/**
	 * 
	 * @return The outboundflightstops
	 */
	@JsonProperty("outboundflightstops")
	public String getOutboundflightstops() {
		return outboundflightstops;
	}

	/**
	 * 
	 * @param outboundflightstops
	 *            The outboundflightstops
	 */
	@JsonProperty("outboundflightstops")
	public void setOutboundflightstops(String outboundflightstops) {
		this.outboundflightstops = outboundflightstops;
	}

	/**
	 * 
	 * @return The inboundflightstops
	 */
	@JsonProperty("inboundflightstops")
	public String getInboundflightstops() {
		return inboundflightstops;
	}

	/**
	 * 
	 * @param inboundflightstops
	 *            The inboundflightstops
	 */
	@JsonProperty("inboundflightstops")
	public void setInboundflightstops(String inboundflightstops) {
		this.inboundflightstops = inboundflightstops;
	}

	/**
	 * 
	 * @return The includedconnectpoints
	 */
	@JsonProperty("includedconnectpoints")
	public String getIncludedconnectpoints() {
		return includedconnectpoints;
	}

	/**
	 * 
	 * @param includedconnectpoints
	 *            The includedconnectpoints
	 */
	@JsonProperty("includedconnectpoints")
	public void setIncludedconnectpoints(String includedconnectpoints) {
		this.includedconnectpoints = includedconnectpoints;
	}

	/**
	 * 
	 * @return The excludedconnectpoints
	 */
	@JsonProperty("excludedconnectpoints")
	public String getExcludedconnectpoints() {
		return excludedconnectpoints;
	}

	/**
	 * 
	 * @param excludedconnectpoints
	 *            The excludedconnectpoints
	 */
	@JsonProperty("excludedconnectpoints")
	public void setExcludedconnectpoints(String excludedconnectpoints) {
		this.excludedconnectpoints = excludedconnectpoints;
	}

	/**
	 * 
	 * @return The outboundstopduration
	 */
	@JsonProperty("outboundstopduration")
	public Double getOutboundstopduration() {
		return outboundstopduration;
	}

	/**
	 * 
	 * @param outboundstopduration
	 *            The outboundstopduration
	 */
	@JsonProperty("outboundstopduration")
	public void setOutboundstopduration(Double outboundstopduration) {
		this.outboundstopduration = outboundstopduration;
	}

	/**
	 * 
	 * @return The inboundstopduration
	 */
	@JsonProperty("inboundstopduration")
	public Double getInboundstopduration() {
		return inboundstopduration;
	}

	/**
	 * 
	 * @param inboundstopduration
	 *            The inboundstopduration
	 */
	@JsonProperty("inboundstopduration")
	public void setInboundstopduration(Double inboundstopduration) {
		this.inboundstopduration = inboundstopduration;
	}

	/**
	 * 
	 * @return The outbounddeparturewindow
	 */
	@JsonProperty("outbounddeparturewindow")
	public String getOutbounddeparturewindow() {
		return outbounddeparturewindow;
	}

	/**
	 * 
	 * @param outbounddeparturewindow
	 *            The outbounddeparturewindow
	 */
	@JsonProperty("outbounddeparturewindow")
	public void setOutbounddeparturewindow(String outbounddeparturewindow) {
		this.outbounddeparturewindow = outbounddeparturewindow;
	}

	/**
	 * 
	 * @return The inbounddeparturewindow
	 */
	@JsonProperty("inbounddeparturewindow")
	public String getInbounddeparturewindow() {
		return inbounddeparturewindow;
	}

	/**
	 * 
	 * @param inbounddeparturewindow
	 *            The inbounddeparturewindow
	 */
	@JsonProperty("inbounddeparturewindow")
	public void setInbounddeparturewindow(String inbounddeparturewindow) {
		this.inbounddeparturewindow = inbounddeparturewindow;
	}

	/**
	 * 
	 * @return The outboundarrivalwindow
	 */
	@JsonProperty("outboundarrivalwindow")
	public String getOutboundarrivalwindow() {
		return outboundarrivalwindow;
	}

	/**
	 * 
	 * @param outboundarrivalwindow
	 *            The outboundarrivalwindow
	 */
	@JsonProperty("outboundarrivalwindow")
	public void setOutboundarrivalwindow(String outboundarrivalwindow) {
		this.outboundarrivalwindow = outboundarrivalwindow;
	}

	/**
	 * 
	 * @return The inboundarrivalwindow
	 */
	@JsonProperty("inboundarrivalwindow")
	public String getInboundarrivalwindow() {
		return inboundarrivalwindow;
	}

	/**
	 * 
	 * @param inboundarrivalwindow
	 *            The inboundarrivalwindow
	 */
	@JsonProperty("inboundarrivalwindow")
	public void setInboundarrivalwindow(String inboundarrivalwindow) {
		this.inboundarrivalwindow = inboundarrivalwindow;
	}

	/**
	 * 
	 * @return The onlineitinerariesonly
	 */
	@JsonProperty("onlineitinerariesonly")
	public String getOnlineitinerariesonly() {
		return onlineitinerariesonly;
	}

	/**
	 * 
	 * @param onlineitinerariesonly
	 *            The onlineitinerariesonly
	 */
	@JsonProperty("onlineitinerariesonly")
	public void setOnlineitinerariesonly(String onlineitinerariesonly) {
		this.onlineitinerariesonly = onlineitinerariesonly;
	}

	/**
	 * 
	 * @return The eticketsonly
	 */
	@JsonProperty("eticketsonly")
	public String getEticketsonly() {
		return eticketsonly;
	}

	/**
	 * 
	 * @param eticketsonly
	 *            The eticketsonly
	 */
	@JsonProperty("eticketsonly")
	public void setEticketsonly(String eticketsonly) {
		this.eticketsonly = eticketsonly;
	}

	/**
	 * 
	 * @return The minfare
	 */
	@JsonProperty("minfare")
	public Double getMinfare() {
		return minfare;
	}

	/**
	 * 
	 * @param minfare
	 *            The minfare
	 */
	@JsonProperty("minfare")
	public void setMinfare(Double minfare) {
		this.minfare = minfare;
	}

	/**
	 * 
	 * @return The maxfare
	 */
	@JsonProperty("maxfare")
	public Double getMaxfare() {
		return maxfare;
	}

	/**
	 * 
	 * @param maxfare
	 *            The maxfare
	 */
	@JsonProperty("maxfare")
	public void setMaxfare(Double maxfare) {
		this.maxfare = maxfare;
	}

	/**
	 * 
	 * @return The limit
	 */
	@JsonProperty("limit")
	public Double getLimit() {
		return limit;
	}

	/**
	 * 
	 * @param limit
	 *            The limit
	 */
	@JsonProperty("limit")
	public void setLimit(Double limit) {
		this.limit = limit;
	}

	/**
	 * 
	 * @return The offset
	 */
	@JsonProperty("offset")
	public Double getOffset() {
		return offset;
	}

	/**
	 * 
	 * @param offset
	 *            The offset
	 */
	@JsonProperty("offset")
	public void setOffset(Double offset) {
		this.offset = offset;
	}

	/**
	 * 
	 * @return The sortby
	 */
	@JsonProperty("sortby")
	public String getSortby() {
		return sortby;
	}

	/**
	 * 
	 * @param sortby
	 *            The sortby
	 */
	@JsonProperty("sortby")
	public void setSortby(String sortby) {
		this.sortby = sortby;
	}

	/**
	 * 
	 * @return The order
	 */
	@JsonProperty("order")
	public String getOrder() {
		return order;
	}

	/**
	 * 
	 * @param order
	 *            The order
	 */
	@JsonProperty("order")
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * 
	 * @return The sortby2
	 */
	@JsonProperty("sortby2")
	public String getSortby2() {
		return sortby2;
	}

	/**
	 * 
	 * @param sortby2
	 *            The sortby2
	 */
	@JsonProperty("sortby2")
	public void setSortby2(String sortby2) {
		this.sortby2 = sortby2;
	}

	/**
	 * 
	 * @return The order2
	 */
	@JsonProperty("order2")
	public String getOrder2() {
		return order2;
	}

	/**
	 * 
	 * @param order2
	 *            The order2
	 */
	@JsonProperty("order2")
	public void setOrder2(String order2) {
		this.order2 = order2;
	}

	/**
	 * 
	 * @return The pointofsalecountry
	 */
	@JsonProperty("pointofsalecountry")
	public String getPointofsalecountry() {
		return pointofsalecountry;
	}

	/**
	 * 
	 * @param pointofsalecountry
	 *            The pointofsalecountry
	 */
	@JsonProperty("pointofsalecountry")
	public void setPointofsalecountry(String pointofsalecountry) {
		this.pointofsalecountry = pointofsalecountry;
	}

	/**
	 * 
	 * @return The passengercount
	 */
	@JsonProperty("passengercount")
	public Double getPassengercount() {
		return passengercount;
	}

	/**
	 * 
	 * @param passengercount
	 *            The passengercount
	 */
	@JsonProperty("passengercount")
	public void setPassengercount(Double passengercount) {
		this.passengercount = passengercount;
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
