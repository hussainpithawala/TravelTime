package com.synerzip.client.orm;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@NamedQuery(name="Timezone.findByCodes", query = "SELECT t FROM Timezone t WHERE t.countryCode = ?1 AND t.timezoneCode = ?2")
@Table(name="timezones")
@Cacheable
public class Timezone implements Serializable {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="timzone_id")
	private Long id;
	
	@Column(name="country_code")
	private String countryCode;
	
	@Column(name="country_name")
	private String countryName;
	
	@Column(name="timezone_code")
	private String timezoneCode;
	
	@Column(name="timezone_name")
	private String timezoneName;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="gmt_adjustment")
	private String gmtAdjustment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getTimezoneCode() {
		return timezoneCode;
	}

	public void setTimezoneCode(String timezoneCode) {
		this.timezoneCode = timezoneCode;
	}

	public String getTimezoneName() {
		return timezoneName;
	}

	public void setTimezoneName(String timezoneName) {
		this.timezoneName = timezoneName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getGmtAdjustment() {
		return gmtAdjustment;
	}

	public void setGmtAdjustment(String gmtAdjustment) {
		this.gmtAdjustment = gmtAdjustment;
	}

	@Override
	public String toString() {
		return "Timezone [id=" + id + ", countryCode=" + countryCode + ", countryName=" + countryName
				+ ", timezoneCode=" + timezoneCode + ", timezoneName=" + timezoneName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", gmtAdjustment=" + gmtAdjustment + "]";
	}
	
}
