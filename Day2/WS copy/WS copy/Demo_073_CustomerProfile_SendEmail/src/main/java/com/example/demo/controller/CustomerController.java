package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Customer;
import com.example.demo.service.CustomerRegistrar;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRegistrar registrar;
	
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public Customer register(@RequestBody Customer customer) {
		return registrar.register(customer);
	}
	
}
