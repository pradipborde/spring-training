package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@RequestMapping("/")
	public String greet() {
		return "Hello World!";
	}
	
}
