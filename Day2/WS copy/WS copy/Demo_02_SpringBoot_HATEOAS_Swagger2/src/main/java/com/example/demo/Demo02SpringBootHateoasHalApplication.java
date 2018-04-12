package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * http://localhost:8080/swagger-ui.html
 */

@SpringBootApplication
@EnableSwagger2
public class Demo02SpringBootHateoasHalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo02SpringBootHateoasHalApplication.class, args);
	}
}
