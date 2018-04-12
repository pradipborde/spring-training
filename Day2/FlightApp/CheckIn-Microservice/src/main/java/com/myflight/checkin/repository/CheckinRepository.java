package com.myflight.checkin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myflight.checkin.entity.CheckInRecord;

public interface CheckinRepository extends JpaRepository<CheckInRecord,Long> {

}
