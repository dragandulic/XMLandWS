package com.travel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.model.AdditionalServices;




@Repository
public interface AdditionalServicesRepository extends JpaRepository<AdditionalServices, Long> {

	
	AdditionalServices findByIdEquals(Long id);
	
}
