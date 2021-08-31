package com.capgemini.xyzAirlines.services;

import com.capgemini.xyzAirlines.models.Airport;

import java.util.Optional;

public interface AirportService {
    public Iterable<Airport> getAllAirport();

    public Airport save(Airport airport);



    public Airport updatedAirport(Airport airport);

    public Optional<Airport> getById(Integer id);

    public void deleteById(Integer id);
}
