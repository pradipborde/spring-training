package com.example.demo.controller;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Greet;

@RestController
public class GreetingController {
	
	@RequestMapping("/")
	@ResponseBody
	public HttpEntity<Greet> greet() {
		Greet greet = new Greet("Hello World!");
		greet.add(ControllerLinkBuilder.linkTo(
				ControllerLinkBuilder.methodOn(GreetingController.class).newGreet("Satyen"))
				.withRel("/greeting"));
		return new ResponseEntity<Greet>(greet, HttpStatus.OK);
	}
	
	@RequestMapping("/greeting")
	public HttpEntity<Greet> newGreet(@RequestParam(value="name", required=false, defaultValue="Satyen") String name){
		Greet greet = new Greet("Hello "+name);
		greet.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(GreetingController.class).greet()).withRel("/"));
		return new ResponseEntity<Greet>(greet, HttpStatus.OK);
	}
}
