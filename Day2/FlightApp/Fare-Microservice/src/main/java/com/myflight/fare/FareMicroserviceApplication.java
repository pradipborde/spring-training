package com.myflight.fare;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.myflight.fare.entity.Fare;
import com.myflight.fare.repository.FaresRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class FareMicroserviceApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(FareMicroserviceApplication.class);

	@Autowired
	FaresRepository faresRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FareMicroserviceApplication.class, args);
	}
	
	
	@Override
	public void run(String... strings) throws Exception {
		Fare[] fares = {
		new Fare("MF100","22-JAN-18", "101"),
		new Fare("MF101","22-JAN-18", "101"),
		new Fare("MF102","22-JAN-18", "102"),
		new Fare("MF103","22-JAN-18", "103"),
		new Fare("MF104","22-JAN-18", "104"),
		new Fare("MF105","22-JAN-18", "105"),
		new Fare("MF106","22-JAN-18", "106")};
		List<Fare> list = Arrays.stream(fares).collect(Collectors.toList());
		list.forEach(fare -> faresRepository.save(fare)); 
			
 		logger.info("Result: " + faresRepository.getFareByFlightNumberAndFlightDate("MF101","22-JAN-18"));
 
	}
}
