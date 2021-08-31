package com.capgemini.xyzAirlines.controllers;



import com.capgemini.xyzAirlines.exceptions.NoIdOrTitle;
import com.capgemini.xyzAirlines.models.Airplane;
import com.capgemini.xyzAirlines.services.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/airplane")
public class AirplaneController {

    @Autowired
    AirplaneService airplaneService;

    @GetMapping
    public ResponseEntity<Iterable<Airplane>> getAllAirplane(){
        Iterable<Airplane> airplanes;
        airplanes=airplaneService.getAllAirplane();
        return new ResponseEntity<Iterable<Airplane>>(airplanes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Airplane> saveAirplane(@RequestBody Airplane airplane){
        System.out.println(airplane.toString());
        Airplane createdAirplane= airplaneService.save(airplane);
        return new ResponseEntity<Airplane>(createdAirplane,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Airplane> updatedAirplane(@RequestBody Airplane airplane){
        Optional<Airplane> optionalAirplane=airplaneService.getById(airplane.getId());
        if(optionalAirplane.isEmpty())
            throw new NoIdOrTitle();

        Airplane updatedAirplane=airplaneService.updatedAirplane(airplane);
        return new ResponseEntity<Airplane>(updatedAirplane,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAirplane(@PathVariable(name = "id")Integer id){
        Optional<Airplane> optionalAirplane=airplaneService.getById(id);
        if(optionalAirplane.isEmpty())
            throw new NoIdOrTitle();
        airplaneService.deleteById(id);
        return true;
    }


}
