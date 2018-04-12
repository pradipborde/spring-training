package com.myflight.book.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.myflight.book.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	Inventory findByFlightNumberAndFlightDate(String flightNumber, String flightDate);
	
}
