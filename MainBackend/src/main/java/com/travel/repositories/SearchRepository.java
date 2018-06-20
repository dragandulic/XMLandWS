package com.travel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.model.Accommodation;
import com.travel.model.AdditionalServices;

@Repository
public interface SearchRepository extends JpaRepository<AdditionalServices, Long> {

	
	List<AdditionalServices> findByServicenameEquals(String s);
	
	AdditionalServices findByServicenameEqualsAndAccommodation_idEquals(String s, Long id);
}
