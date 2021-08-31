package com.capgemini.xyzAirlines;

import com.capgemini.xyzAirlines.models.Airplane;
import com.capgemini.xyzAirlines.models.Airport;
import com.capgemini.xyzAirlines.repositories.AirplaneRepository;
import com.capgemini.xyzAirlines.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XyzAirlinesApplication implements CommandLineRunner {
	AirplaneRepository airplaneRepository;
	AirportRepository airportRepository;

	public static void main(String[] args) {
		SpringApplication.run(XyzAirlinesApplication.class, args);
	}

	@Autowired
	public XyzAirlinesApplication(AirplaneRepository airplaneRepository, AirportRepository airportRepository) {
		this.airplaneRepository = airplaneRepository;
		this.airportRepository = airportRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Airport airport=new Airport(1,"Schiphol","Nederland");
		airportRepository.save(airport);
		Airport airport1=new Airport(2,"Koln","Deutchland");
		airportRepository.save(airport1);


		Airplane airplane=new Airplane(1,"TC-JCV – Airbus A310-304 – Aras","Airbus","Aras",5,airport);
		airplaneRepository.save(airplane);
		Airplane airplane2=new Airplane(2,"TC-JDG – Boeing 737-4Y0 – Marmaris","Boeing","Marmaris",5,airport1);
		airplaneRepository.save(airplane2);

		airplaneRepository.save(new Airplane(3,"Boeing 737 MAX8 – TC-LCA","Boeing","Ist",5,airport1));

	}
}
