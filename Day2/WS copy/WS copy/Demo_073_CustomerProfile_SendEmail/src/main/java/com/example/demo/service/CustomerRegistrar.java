package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Customer;
import com.example.demo.notification.Sender;
import com.example.demo.repo.CustomerRepository;

@Service
//@Lazy
public class CustomerRegistrar {

	private CustomerRepository repository;
	private Sender sender;
	
	@Autowired
	public CustomerRegistrar(CustomerRepository repository, Sender sender) {
		super();
		this.repository = repository;
		this.sender = sender;
	}

	public Customer register(Customer customer) {
		Optional<Customer> exisingCustomers = repository.findByName(customer.getName());
		if(exisingCustomers.isPresent())
			throw new RuntimeException("Customer already present!");
		repository.save(customer);
		System.out.println("Added to repository, now sending message to queue...");
		sender.send(customer.getEmail());//Email to send mail from Mailer class
		return customer;
	}
}
