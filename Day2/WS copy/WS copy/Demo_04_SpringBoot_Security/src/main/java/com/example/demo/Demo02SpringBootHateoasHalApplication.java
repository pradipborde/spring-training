package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


//@EnableGlobalMethodSecurity//use only when Method level security is needed.
@SpringBootApplication
public class Demo02SpringBootHateoasHalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo02SpringBootHateoasHalApplication.class, args);
	}
}
