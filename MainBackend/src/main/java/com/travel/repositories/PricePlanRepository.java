package com.travel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.model.PricePlan;





@Repository
public interface PricePlanRepository extends JpaRepository<PricePlan, Long> {

	
	PricePlan findByIdEquals(Long id);
	
	PricePlan findByRoomtypeEqualsAndAccommodation_idEquals(int roomtype, Long id);
	
}
