package com.travel.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.model.AccommodationType;
import com.travel.model.Category;








@Repository
public interface AccommodationTypeRepository extends JpaRepository<AccommodationType, Long> {

	
	AccommodationType findByIdEquals(Long id);
	List<AccommodationType> findAll();
	@Query("SELECT DISTINCT a.typename FROM AccommodationType a")
	List<String> findAccommodationTypeNames();
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM AccommodationType a WHERE a.typename=?1")
	void deleteAccommodationType(String tname);
	
	
	
	@Query(value="SELECT a FROM AccommodationType a WHERE (a.accommodation.id)=(:accomid)")
	AccommodationType findTypeByAccommodation(@Param("accomid")Long accomid);

	
	
	
	
}