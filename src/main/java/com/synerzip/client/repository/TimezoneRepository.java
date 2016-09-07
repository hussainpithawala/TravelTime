package com.synerzip.client.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.synerzip.client.orm.Timezone;

@Transactional
public interface TimezoneRepository extends CrudRepository<Timezone, Long> {
	public List<Timezone> findByCode(String countryCode, String timezoneCode);
}
