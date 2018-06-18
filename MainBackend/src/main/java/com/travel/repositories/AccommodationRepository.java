package com.travel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.travel.model.Accommodation;





@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

	
	Accommodation findByIdEquals(Long id);
	
	List<Accommodation> findAll();
	
	Accommodation findByLocation_idEquals(Long id);
	
}
