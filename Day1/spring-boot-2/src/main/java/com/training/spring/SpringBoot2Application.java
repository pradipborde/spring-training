package com.training.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.training.spring.entity.Customer;
import com.training.spring.repository.CustomerRepository;

@SpringBootApplication
public class SpringBoot2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2Application.class, args);
	}
	
	@Bean
	CommandLineRunner init(CustomerRepository repository) {
		System.out.println("Hello World");
		return (evt)->{
			System.out.println("Insert");
			repository.save(new Customer(101, "Pradip", "Borde", "pradip.borde@gmail.com"));
			repository.save(new Customer(102, "Abdul", "Shaikh", "abdul@gmail.com"));
			repository.save(new Customer(103, "Tanvi", "Shah", "tanvi@gmail.com"));
			System.out.println(repository.count());
		};
		
		
		
	}
}
