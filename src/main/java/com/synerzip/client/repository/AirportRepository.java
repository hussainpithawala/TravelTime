package com.synerzip.client.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import com.synerzip.client.orm.Airport;

public interface AirportRepository extends CrudRepository<Airport, Long> {
	@Cacheable(value="airportsCache", key="#code")
	public Airport findByCode(String code);
}
