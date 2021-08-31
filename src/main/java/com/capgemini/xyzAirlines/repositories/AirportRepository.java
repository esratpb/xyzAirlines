package com.capgemini.xyzAirlines.repositories;

import com.capgemini.xyzAirlines.models.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport,Integer> {

}
