package com.training.spring;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	
	@RequestMapping(value="/", produces= {"application/xml"})
	public Message sayHello() {
		return new Message("hello!");
	}
	

	@RequestMapping(value="/hello", produces= {"application/json"})
	public Message sayHello2() {
		Message message = new Message("hello world!");
		message.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(HelloController.class).sayHello3()).withRel("comment"));
		return message;
	}
	
	
	@RequestMapping(value="/hello3", produces= {"application/json"})
	public Message sayHello3() {
		return new Message("hello!");
	}
	
	
}
