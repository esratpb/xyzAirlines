package com.capgemini.xyzAirlines.services;

import com.capgemini.xyzAirlines.models.Airport;
import com.capgemini.xyzAirlines.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {
    AirportRepository airportRepository;

    @Autowired
    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }


    @Override
    public Iterable<Airport> getAllAirport() {
        Iterable<Airport>airports;
        airports=airportRepository.findAll();
        return airports;
    }

    @Override
    public Airport save(Airport airport) {
        return airportRepository.save(airport);

    }

    @Override
    public Airport updatedAirport(Airport airport) {return airportRepository.save(airport);}

    @Override
    public Optional<Airport> getById(Integer id) {return airportRepository.findById(id)  ;  }

    @Override
    public void deleteById(Integer id) { airportRepository.deleteById(id);  }

}