package com.myflight.book;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.myflight.book.component.BookingComponent;
import com.myflight.book.entity.BookingRecord;
import com.myflight.book.entity.Inventory;
import com.myflight.book.entity.Passenger;
import com.myflight.book.repository.BookingRepository;
import com.myflight.book.repository.InventoryRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class BookMicroserviceApplication implements CommandLineRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(BookMicroserviceApplication.class);
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private BookingComponent bookingComponent;
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookMicroserviceApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		
		Inventory[] invs = { 
					new Inventory("MF100", "22-JAN-18", 100),
					new Inventory("MF101", "22-JAN-18", 100),
					new Inventory("MF102", "22-JAN-18", 100),
					new Inventory("MF103", "22-JAN-18", 100),
					new Inventory("MF104", "22-JAN-18", 100),
					new Inventory("MF105", "22-JAN-18", 100),
					new Inventory("MF106", "22-JAN-18", 100)};
		Arrays.asList(invs).forEach(inventory -> inventoryRepository.save(inventory));
				
		 
		
		BookingRecord booking = new BookingRecord("MF101", "BOM","BLR","22-JAN-18",new Date(),"101");
		Set<Passenger> passengers = new HashSet<Passenger>();
		passengers.add(new Passenger("Vikram","Rathod","Male", booking));
//		passengers.add(new Passenger("Pooja","Bedi","Female",booking));
	 	
		booking.setPassengers(passengers);
 		long record  = bookingComponent.book(booking);
		logger.info("Booking successfully saved..." + record);
		
		logger.info("Looking to load booking record..."); 
	    logger.info("Result: " + bookingComponent.getBooking(record));
 
	}
}
