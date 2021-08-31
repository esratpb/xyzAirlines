package com.capgemini.xyzAirlines.repositories;

import com.capgemini.xyzAirlines.models.Airplane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirplaneRepository extends CrudRepository<Airplane,Integer> {

}
