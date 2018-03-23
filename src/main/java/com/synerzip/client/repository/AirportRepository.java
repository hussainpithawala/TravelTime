package com.synerzip.client.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import com.synerzip.client.orm.Airport;

import java.util.List;

public interface AirportRepository extends CrudRepository<Airport, Long> {
	@Cacheable(value="airportsCache")
	Airport findByCode(String code);

	List<Object[]> autoComplete(String parameter);
}
