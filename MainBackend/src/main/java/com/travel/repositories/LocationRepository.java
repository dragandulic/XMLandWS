package com.travel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.model.Location;




@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

	
	Location findByIdEquals(Long id);
	
	List<Location> findByCityEquals(String city);
	
}
