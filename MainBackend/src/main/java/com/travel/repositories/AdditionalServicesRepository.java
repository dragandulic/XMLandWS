package com.travel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.travel.model.AdditionalServices;








@Repository
public interface AdditionalServicesRepository extends JpaRepository<AdditionalServices, Long> {

	
	AdditionalServices findByIdEquals(Long id);
	List<AdditionalServices> findAll();
	@Query("SELECT DISTINCT a.servicename FROM AdditionalServices a")
	List<String> findAdditionalServiceNames();

	
	
}