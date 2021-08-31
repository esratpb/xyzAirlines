package com.capgemini.xyzAirlines.services;

import com.capgemini.xyzAirlines.models.Airplane;
import com.capgemini.xyzAirlines.repositories.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AirplaneServiceImpl implements AirplaneService {
    AirplaneRepository airplaneRepository;

    @Autowired
    public AirplaneServiceImpl(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }


    @Override
    public Iterable<Airplane> getAllAirplane() {
        Iterable<Airplane>airplanes;
        airplanes=airplaneRepository.findAll();
        return airplanes;
    }

    @Override
    public Airplane save(Airplane airplane) {
            return airplaneRepository.save(airplane);

    }

    @Override
    public Airplane updatedAirplane(Airplane airplane) {return airplaneRepository.save(airplane);}

    @Override
    public Optional<Airplane> getById(Integer id) {return airplaneRepository.findById(id)  ;  }

    @Override
    public void deleteById(Integer id) { airplaneRepository.deleteById(id);  }

    @Override
    public Airplane tanked(Integer id, Double tankedFuelAmount) {
        Airplane airplane=airplaneRepository.findById(id).get();

        airplane.setFuel(airplane.getFuel()+tankedFuelAmount);

        return updatedAirplane(airplane);
    }

}
