package com.training.spring;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.entity.Customer;
import com.training.spring.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	CustomerRepository repository;
	
	

	
	@RequestMapping("/cust")
	public Iterator<Customer> fetchAll() {
		return repository.findAll().iterator();
	}
	
	@RequestMapping("/cust/{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") Integer id) {
		return repository.findById(id);
	}
	
	@RequestMapping("/cust/fname/{fname}")
	public List<Customer> getCustomerByName(@PathVariable("fname") String fname) {
		return repository.getByFname(fname);
	}
	
	@PostMapping("cust")
	public Customer saveCust(@RequestBody Customer  customer) {
		Customer customer2 = repository.save(customer);
		return customer2;
	}
	
	@PutMapping("/cust/{id}")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return repository.save(customer);
	}
	
	@DeleteMapping("/cust/{id}")
	public boolean deleteCust(@PathVariable Integer id) {
		 repository.deleteById(id);
		 return true;
	}
	
}
