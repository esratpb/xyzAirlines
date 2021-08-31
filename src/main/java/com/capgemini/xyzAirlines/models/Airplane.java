package com.capgemini.xyzAirlines.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Airplane {
    @Id
    @GeneratedValue(generator = "native",strategy = GenerationType.AUTO)
    @GenericGenerator(name="native",strategy = "native")
    private int id;
    private String idPlate;     //Airplane Identification Plate
    private String typeOfAirplane;  //
    private String currentAirfield;
    private double fuel;

    @ManyToOne
    private Airport airport;

    public Airplane() {
    }

    public Airplane(int id, String idPlate, String typeOfAirplane, String currentAirfield, double fuel, Airport airport) {
        this.id = id;
        this.idPlate = idPlate;
        this.typeOfAirplane = typeOfAirplane;
        this.currentAirfield = currentAirfield;
        this.fuel = fuel;
        this.airport = airport;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdPlate() {
        return idPlate;
    }

    public void setIdPlate(String idPlate) {
        this.idPlate = idPlate;
    }

    public String getTypeOfAirplane() {
        return typeOfAirplane;
    }

    public void setTypeOfAirplane(String typeOfAirplane) {
        this.typeOfAirplane = typeOfAirplane;
    }

    public String getCurrentAirfield() {
        return currentAirfield;
    }

    public void setCurrentAirfield(String currentAirfield) {
        this.currentAirfield = currentAirfield;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
