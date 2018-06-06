package com.travel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.model.PricePlan;





@Repository
public interface PricePlanRepository extends JpaRepository<PricePlan, Long> {

	
	PricePlan findByIdEquals(Long id);
	
}
