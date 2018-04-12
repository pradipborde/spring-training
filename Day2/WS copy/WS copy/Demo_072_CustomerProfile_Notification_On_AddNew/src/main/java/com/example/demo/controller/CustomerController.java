package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Customer;
import com.example.demo.notification.Sender;
import com.example.demo.service.CustomerRegistrar;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRegistrar registrar;
	
	@Autowired
	private Sender sender;
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public Customer register(@RequestBody Customer customer) {
		Customer cust = registrar.register(customer);
		sender.send("Customer with id: "+cust.getId()+" and Name: "+cust.getName()+" added.");
		return cust;
	}
	
}
