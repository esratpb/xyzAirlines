package com.capgemini.xyzAirlines.services;

import com.capgemini.xyzAirlines.models.Airplane;

import java.util.Optional;

public interface AirplaneService {
    public Iterable<Airplane> getAllAirplane();

   public Airplane save(Airplane airplane);



    public Airplane updatedAirplane(Airplane airplane);

   public Optional<Airplane> getById(Integer id);

    public void deleteById(Integer id);
}
