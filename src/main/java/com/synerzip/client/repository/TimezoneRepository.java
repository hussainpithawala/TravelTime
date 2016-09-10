package com.synerzip.client.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.synerzip.client.orm.Timezone;

@Transactional
public interface TimezoneRepository extends JpaRepository<Timezone, Long> {
	@Cacheable(value="timezonesCache")
	public List<Timezone> findByCodes(String countryCode, String timezoneCode);
}
