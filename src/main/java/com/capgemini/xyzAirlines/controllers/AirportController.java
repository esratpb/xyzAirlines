package com.capgemini.xyzAirlines.controllers;

import com.capgemini.xyzAirlines.exceptions.NoIdOrTitle;
import com.capgemini.xyzAirlines.models.Airport;
import com.capgemini.xyzAirlines.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/airport")
public class AirportController {

    @Autowired
    AirportService airportService;

    @GetMapping
    public ResponseEntity<Iterable<Airport>> getAllAirport(){
        Iterable<Airport> airports;
        airports=airportService.getAllAirport();
        return new ResponseEntity<Iterable<Airport>>(airports, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Airport> saveAirport(@RequestBody Airport airport){
        System.out.println(airport.toString());
        Airport createdAirport= airportService.save(airport);
        return new ResponseEntity<Airport>(createdAirport,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Airport> updatedAirport(@RequestBody Airport airport){
//        Optional<Airport> optionalAirport=airportService.getByIdPlate(airport.getIdPlate());
        Optional<Airport> optionalAirport=airportService.getById(airport.getId());
        if(optionalAirport.isEmpty())
            throw new NoIdOrTitle();

        Airport updatedAirport=airportService.updatedAirport(airport);
        return new ResponseEntity<Airport>(updatedAirport,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAirport(@PathVariable(name = "id")Integer id){
        Optional<Airport> optionalAirport=airportService.getById(id);
        if(optionalAirport.isEmpty())
            throw new NoIdOrTitle();
        airportService.deleteById(id);
        return true;
    }


}
