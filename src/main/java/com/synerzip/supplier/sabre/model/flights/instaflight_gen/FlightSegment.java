
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "DepartureAirport",
    "ArrivalAirport",
    "MarketingAirline",
    "ArrivalTimeZone",
    "TPA_Extensions",
    "StopQuantity",
    "ElapsedTime",
    "ResBookDesigCode",
    "MarriageGrp",
    "Equipment",
    "DepartureDateTime",
    "ArrivalDateTime",
    "FlightNumber",
    "OperatingAirline",
    "DepartureTimeZone"
})
public class FlightSegment {

    @JsonProperty("DepartureAirport")
    private DepartureAirport DepartureAirport;
    @JsonProperty("ArrivalAirport")
    private ArrivalAirport ArrivalAirport;
    @JsonProperty("MarketingAirline")
    private MarketingAirline MarketingAirline;
    @JsonProperty("ArrivalTimeZone")
    private ArrivalTimeZone ArrivalTimeZone;
    @JsonProperty("TPA_Extensions")
    private TPA_Extensions TPA_Extensions;
    @JsonProperty("StopQuantity")
    private Integer StopQuantity;
    @JsonProperty("ElapsedTime")
    private Integer ElapsedTime;
    @JsonProperty("ResBookDesigCode")
    private String ResBookDesigCode;
    @JsonProperty("MarriageGrp")
    private String MarriageGrp;
    @JsonProperty("Equipment")
    private Equipment Equipment;
    @JsonProperty("DepartureDateTime")
    private String DepartureDateTime;
    @JsonProperty("ArrivalDateTime")
    private String ArrivalDateTime;
    @JsonProperty("FlightNumber")
    private Integer FlightNumber;
    @JsonProperty("OperatingAirline")
    private OperatingAirline OperatingAirline;
    @JsonProperty("DepartureTimeZone")
    private DepartureTimeZone DepartureTimeZone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The DepartureAirport
     */
    @JsonProperty("DepartureAirport")
    public DepartureAirport getDepartureAirport() {
        return DepartureAirport;
    }

    /**
     * 
     * @param DepartureAirport
     *     The DepartureAirport
     */
    @JsonProperty("DepartureAirport")
    public void setDepartureAirport(DepartureAirport DepartureAirport) {
        this.DepartureAirport = DepartureAirport;
    }

    /**
     * 
     * @return
     *     The ArrivalAirport
     */
    @JsonProperty("ArrivalAirport")
    public ArrivalAirport getArrivalAirport() {
        return ArrivalAirport;
    }

    /**
     * 
     * @param ArrivalAirport
     *     The ArrivalAirport
     */
    @JsonProperty("ArrivalAirport")
    public void setArrivalAirport(ArrivalAirport ArrivalAirport) {
        this.ArrivalAirport = ArrivalAirport;
    }

    /**
     * 
     * @return
     *     The MarketingAirline
     */
    @JsonProperty("MarketingAirline")
    public MarketingAirline getMarketingAirline() {
        return MarketingAirline;
    }

    /**
     * 
     * @param MarketingAirline
     *     The MarketingAirline
     */
    @JsonProperty("MarketingAirline")
    public void setMarketingAirline(MarketingAirline MarketingAirline) {
        this.MarketingAirline = MarketingAirline;
    }

    /**
     * 
     * @return
     *     The ArrivalTimeZone
     */
    @JsonProperty("ArrivalTimeZone")
    public ArrivalTimeZone getArrivalTimeZone() {
        return ArrivalTimeZone;
    }

    /**
     * 
     * @param ArrivalTimeZone
     *     The ArrivalTimeZone
     */
    @JsonProperty("ArrivalTimeZone")
    public void setArrivalTimeZone(ArrivalTimeZone ArrivalTimeZone) {
        this.ArrivalTimeZone = ArrivalTimeZone;
    }

    /**
     * 
     * @return
     *     The TPA_Extensions
     */
    @JsonProperty("TPA_Extensions")
    public TPA_Extensions getTPA_Extensions() {
        return TPA_Extensions;
    }

    /**
     * 
     * @param TPA_Extensions
     *     The TPA_Extensions
     */
    @JsonProperty("TPA_Extensions")
    public void setTPA_Extensions(TPA_Extensions TPA_Extensions) {
        this.TPA_Extensions = TPA_Extensions;
    }

    /**
     * 
     * @return
     *     The StopQuantity
     */
    @JsonProperty("StopQuantity")
    public Integer getStopQuantity() {
        return StopQuantity;
    }

    /**
     * 
     * @param StopQuantity
     *     The StopQuantity
     */
    @JsonProperty("StopQuantity")
    public void setStopQuantity(Integer StopQuantity) {
        this.StopQuantity = StopQuantity;
    }

    /**
     * 
     * @return
     *     The ElapsedTime
     */
    @JsonProperty("ElapsedTime")
    public Integer getElapsedTime() {
        return ElapsedTime;
    }

    /**
     * 
     * @param ElapsedTime
     *     The ElapsedTime
     */
    @JsonProperty("ElapsedTime")
    public void setElapsedTime(Integer ElapsedTime) {
        this.ElapsedTime = ElapsedTime;
    }

    /**
     * 
     * @return
     *     The ResBookDesigCode
     */
    @JsonProperty("ResBookDesigCode")
    public String getResBookDesigCode() {
        return ResBookDesigCode;
    }

    /**
     * 
     * @param ResBookDesigCode
     *     The ResBookDesigCode
     */
    @JsonProperty("ResBookDesigCode")
    public void setResBookDesigCode(String ResBookDesigCode) {
        this.ResBookDesigCode = ResBookDesigCode;
    }

    /**
     * 
     * @return
     *     The MarriageGrp
     */
    @JsonProperty("MarriageGrp")
    public String getMarriageGrp() {
        return MarriageGrp;
    }

    /**
     * 
     * @param MarriageGrp
     *     The MarriageGrp
     */
    @JsonProperty("MarriageGrp")
    public void setMarriageGrp(String MarriageGrp) {
        this.MarriageGrp = MarriageGrp;
    }

    /**
     * 
     * @return
     *     The Equipment
     */
    @JsonProperty("Equipment")
    public Equipment getEquipment() {
        return Equipment;
    }

    /**
     * 
     * @param Equipment
     *     The Equipment
     */
    @JsonProperty("Equipment")
    public void setEquipment(Equipment Equipment) {
        this.Equipment = Equipment;
    }

    /**
     * 
     * @return
     *     The DepartureDateTime
     */
    @JsonProperty("DepartureDateTime")
    public String getDepartureDateTime() {
        return DepartureDateTime;
    }

    /**
     * 
     * @param DepartureDateTime
     *     The DepartureDateTime
     */
    @JsonProperty("DepartureDateTime")
    public void setDepartureDateTime(String DepartureDateTime) {
        this.DepartureDateTime = DepartureDateTime;
    }

    /**
     * 
     * @return
     *     The ArrivalDateTime
     */
    @JsonProperty("ArrivalDateTime")
    public String getArrivalDateTime() {
        return ArrivalDateTime;
    }

    /**
     * 
     * @param ArrivalDateTime
     *     The ArrivalDateTime
     */
    @JsonProperty("ArrivalDateTime")
    public void setArrivalDateTime(String ArrivalDateTime) {
        this.ArrivalDateTime = ArrivalDateTime;
    }

    /**
     * 
     * @return
     *     The FlightNumber
     */
    @JsonProperty("FlightNumber")
    public Integer getFlightNumber() {
        return FlightNumber;
    }

    /**
     * 
     * @param FlightNumber
     *     The FlightNumber
     */
    @JsonProperty("FlightNumber")
    public void setFlightNumber(Integer FlightNumber) {
        this.FlightNumber = FlightNumber;
    }

    /**
     * 
     * @return
     *     The OperatingAirline
     */
    @JsonProperty("OperatingAirline")
    public OperatingAirline getOperatingAirline() {
        return OperatingAirline;
    }

    /**
     * 
     * @param OperatingAirline
     *     The OperatingAirline
     */
    @JsonProperty("OperatingAirline")
    public void setOperatingAirline(OperatingAirline OperatingAirline) {
        this.OperatingAirline = OperatingAirline;
    }

    /**
     * 
     * @return
     *     The DepartureTimeZone
     */
    @JsonProperty("DepartureTimeZone")
    public DepartureTimeZone getDepartureTimeZone() {
        return DepartureTimeZone;
    }

    /**
     * 
     * @param DepartureTimeZone
     *     The DepartureTimeZone
     */
    @JsonProperty("DepartureTimeZone")
    public void setDepartureTimeZone(DepartureTimeZone DepartureTimeZone) {
        this.DepartureTimeZone = DepartureTimeZone;
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
