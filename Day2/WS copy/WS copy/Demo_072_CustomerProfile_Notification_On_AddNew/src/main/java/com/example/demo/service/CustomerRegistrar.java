package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Customer;
import com.example.demo.repo.CustomerRepository;

@Service
public class CustomerRegistrar {

	@Autowired
	private CustomerRepository repository;
	
	public Customer register(Customer customer) {
		Optional<Customer> exisingCustomers = repository.findByName(customer.getName());
		if(exisingCustomers.isPresent())
			throw new RuntimeException("Customer already present!");
		repository.save(customer);
		return customer;
	}
}
