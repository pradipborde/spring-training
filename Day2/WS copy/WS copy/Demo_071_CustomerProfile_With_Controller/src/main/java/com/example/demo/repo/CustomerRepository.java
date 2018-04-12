package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.bean.Customer;

@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	Optional<Customer> findByName(@Param("name") String name);
	
}
