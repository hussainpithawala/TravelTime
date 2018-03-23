package com.synerzip.client.orm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@NamedNativeQueries(
		@NamedNativeQuery(name = "Airport.autoComplete", query = "select city_name, code, name from airports where city_name like ?1 or name like ?1 or code like ?1"))
@Table(name="airports")
@Cacheable
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"city_name",
		"code",
		"name",

})
public class Airport implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="airport_id")
	private Long id;
	
	@Column(name="code")
	@JsonProperty("code")
	private String code;
	
	@Column(name="city_code")
	private String cityCode;
	
	@Column(name="name")
	@JsonPropertyOrder("name")
	private String name;
	
	@Column(name="city_name")
	@JsonProperty("city_name")
	private String cityName;
	
	@Column(name="region_code")
	private String regionCode;
	
	@Column(name="country_code")
	private String countryCode;
	
	@Column(name="latitude")
	private String latitude;
	
	@Column(name="longitude")
	private String longitude;
	
	@Column(name="timezone")
	private String timezoneCode;
	
	@Column(name="ctype")
	private String cType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getTimeZone() {
		return timezoneCode;
	}

	public void setTimeZone(String timeZone) {
		this.timezoneCode = timeZone;
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	@Override
	public String toString() {
		return "Airport [id=" + id + ", code=" + code + ", cityCode=" + cityCode + ", name=" + name + ", cityName="
				+ cityName + ", regionCode=" + regionCode + ", countryCode=" + countryCode + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", timezoneCode=" + timezoneCode + ", cType=" + cType + "]";
	}
	
}
