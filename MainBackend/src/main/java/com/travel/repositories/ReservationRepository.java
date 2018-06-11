package com.travel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.model.Reservation;




@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	Reservation findByIdEquals(Long id);
	List<Reservation> findAll();
	
}