package com.training.spring.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.training.spring.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

//	@Query("from com.training.spring.entity.Customer c where c.fname=:fname")
	List<Customer> getByFname(String fname);

	List<Customer> getByLname(String lname); 
	
}
