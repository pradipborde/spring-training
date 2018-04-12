package com.myflight.fare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myflight.fare.entity.Fare;

public interface FaresRepository extends JpaRepository<Fare,Long> {
	Fare getFareByFlightNumberAndFlightDate(String flightNumber, String flightDate);
}
