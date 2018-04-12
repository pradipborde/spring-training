package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.bean.Customer;
import com.example.demo.repo.CustomerRepository;

@SpringBootApplication
public class Demo07CustomerProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo07CustomerProfileApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CustomerRepository repository) {
		return (evt) -> {
			repository.save(new Customer("Satyen", "satyen@gmail.com"));
			repository.save(new Customer("Vikram", "vikram@gmail.com"));
			repository.save(new Customer("Dinesh", "dinesh@yahoo.com"));
			repository.save(new Customer("Pooja", "poojan@outlook.com"));
			repository.save(new Customer("Suraj", "Suraj@yahoo.com"));
			System.out.println("Sample Data Added...");
		};
	}
}
