package com.myflight.web;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.client.RestTemplate;

import com.myflight.web.client.BookingRecord;
import com.myflight.web.client.CheckInRecord;
import com.myflight.web.client.Flight;
import com.myflight.web.client.Passenger;
import com.myflight.web.client.SearchQuery;

@EnableGlobalMethodSecurity
@SpringBootApplication
@EnableDiscoveryClient
public class WebMicroserviceApplication implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(WebMicroserviceApplication.class);

	@Autowired
	RestTemplate searchClient ;
	
	@Bean
	@LoadBalanced
	RestTemplate getTemplate() {
		return new RestTemplate();
	}

	RestTemplate bookingClient = new RestTemplate();

	RestTemplate checkInClient = new RestTemplate();

	RestTemplate restClient = new RestTemplate();

	public static void main(String[] args) {
		SpringApplication.run(WebMicroserviceApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		// Search for a flight
		SearchQuery searchQuery = new SearchQuery("BOM", "BLR", "22-JAN-18");
		// Flight[] flights =
		// searchClient.postForObject("http://search-service/search/get",
		// searchQuery, Flight[].class);
		Flight[] flights = searchClient.postForObject("http://search-apigateway/api/search/get", searchQuery, Flight[].class);

		Arrays.asList(flights).forEach(flight -> logger.info(" flight >" + flight));

		// create a booking only if there are flights.
		if (flights == null || flights.length == 0) {
			return;
		}
		Flight flight = flights[0];
		BookingRecord booking = new BookingRecord(flight.getFlightNumber(), flight.getOrigin(), flight.getDestination(),
				flight.getFlightDate(), null, flight.getFares().getFare());
		Set<Passenger> passengers = new HashSet<Passenger>();
		passengers.add(new Passenger("Dinesh", "Singh", "Male", booking));
		booking.setPassengers(passengers);
		long bookingId = 0;
		try {
			// long bookingId =
			// bookingClient.postForObject("http://book-service/booking/create",
			// booking, long.class);
			bookingId = bookingClient.postForObject("http://localhost:8060/booking/create", booking, long.class);
			logger.info("Booking created " + bookingId);
		} catch (Exception e) {
			logger.error("BOOKING SERVICE NOT AVAILABLE...!!!");
		}

		// check in passenger
		if (bookingId == 0)
			return;
		try {
			CheckInRecord checkIn = new CheckInRecord("Singh", "Dinesh", "28C", null, "BF101", "22-JAN-18", bookingId);
			long checkinId = checkInClient.postForObject("http://localhost:8070/checkin/create", checkIn, long.class);
			logger.info("Checked IN " + checkinId);
		} catch (Exception e) {
			logger.error("CHECK IN SERVICE NOT AVAILABLE...!!!");
		}
	}

}