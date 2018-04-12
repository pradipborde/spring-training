package com.myflight.book.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.myflight.book.entity.BookingRecord;

public interface BookingRepository extends JpaRepository<BookingRecord, Long> {
	
}
