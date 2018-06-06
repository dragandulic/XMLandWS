package com.travel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.model.Accommodation;





@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

	
	Accommodation findByIdEquals(Long id);
	
}
