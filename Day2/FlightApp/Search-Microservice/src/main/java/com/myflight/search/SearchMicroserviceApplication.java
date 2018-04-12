package com.myflight.search;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.myflight.search.entity.Fares;
import com.myflight.search.entity.Flight;
import com.myflight.search.entity.Inventory;
import com.myflight.search.repository.FlightRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class SearchMicroserviceApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(SearchMicroserviceApplication.class);

	@Autowired
	private FlightRepository flightRepository;

	public static void main(String[] args) {
		SpringApplication.run(SearchMicroserviceApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		List<Flight> flights = new ArrayList<>();
		flights.add(new Flight("MF100", "JAI", "BLR", "22-JAN-18", new Fares("100", "INR"), new Inventory(100)));
		flights.add(new Flight("MF101", "BOM", "BLR", "22-JAN-18", new Fares("101", "INR"), new Inventory(100)));
		flights.add(new Flight("MF105", "BOM", "BLR", "22-JAN-18", new Fares("105", "INR"), new Inventory(100)));
		flights.add(new Flight("MF106", "BOM", "BLR", "22-JAN-18", new Fares("106", "INR"), new Inventory(100)));
		flights.add(new Flight("MF102", "CHN", "BLR", "22-JAN-18", new Fares("102", "INR"), new Inventory(100)));
		flights.add(new Flight("MF103", "HYD", "BLR", "22-JAN-18", new Fares("103", "INR"), new Inventory(100)));
		flights.add(new Flight("MF104", "CCU", "BLR", "22-JAN-18", new Fares("104", "INR"), new Inventory(100)));

		flightRepository.saveAll(flights);

		logger.info("Looking to load flights...");
		for (Flight flight : flightRepository.findByOriginAndDestinationAndFlightDate("BOM", "BLR", "22-JAN-18")) {
			logger.info(flight.toString());
		}
	}

}
