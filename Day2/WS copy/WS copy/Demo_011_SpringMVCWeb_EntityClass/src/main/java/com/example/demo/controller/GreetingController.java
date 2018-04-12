package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Greet;

@RestController
public class GreetingController {
	
	@RequestMapping("/")
	public Greet greet() {
		return new Greet("Hello World!");
	}
	
}
