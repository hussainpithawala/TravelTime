package com.synerzip.client.repository;

import com.synerzip.client.orm.Airline;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AirlineRepository extends CrudRepository<Airline, Long>{
    @Cacheable(value="airlinesCache")
    public List<Airline> findByIataCode(String code);

}
