package com.synerzip.client.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synerzip.client.orm.Timezone;

@Transactional
public interface TimezoneRepository extends JpaRepository<Timezone, Long> {
	public List<Timezone> findByCodes(String countryCode, String timezoneCode);
}
