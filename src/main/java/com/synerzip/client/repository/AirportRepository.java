package com.synerzip.client.repository;

import org.springframework.data.repository.CrudRepository;

import com.synerzip.client.orm.Airport;

public interface AirportRepository extends CrudRepository<Airport, Long> {
	public Airport findByCode(String code);
}
