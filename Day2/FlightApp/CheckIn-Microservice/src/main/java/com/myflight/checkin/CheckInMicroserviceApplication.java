package com.myflight.checkin;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myflight.checkin.entity.CheckInRecord;
import com.myflight.checkin.repository.CheckinRepository;

@SpringBootApplication
public class CheckInMicroserviceApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CheckInMicroserviceApplication.class);

	@Autowired
	CheckinRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(CheckInMicroserviceApplication.class, args);
	}
	
	@Override
	public void run(String... strings) throws Exception {
		CheckInRecord record = new CheckInRecord("Satyen", "Singh","28A",new Date(),"MF101","22-JAN-18",1);
		 
 		CheckInRecord result  = repository.save(record);
		logger.info("checked in successfully ..." + result);
		
		
		
		logger.info("Looking to load checkedIn record..."); 
	    logger.info("Result: " + repository.findOne(result.getId()));
 
	    
	}
}
