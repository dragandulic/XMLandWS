package com.travel.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.model.AdditionalServices;








@Repository
public interface AdditionalServicesRepository extends JpaRepository<AdditionalServices, Long> {

	
	AdditionalServices findByIdEquals(Long id);
	List<AdditionalServices> findAll();
	@Query("SELECT DISTINCT a.servicename FROM AdditionalServices a")
	List<String> findAdditionalServiceNames();
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM AdditionalServices a WHERE a.servicename=?1")
	void deleteAservice(String sname);

	List<AdditionalServices> findByAccommodation_idEquals(Long id);
	
	@Query("SELECT  a.servicename FROM AdditionalServices a WHERE (a.accommodation.id)=(:accommid)")
	List<String> findAdditionalServicesForAccommodation(@Param("accommid")Long accommid);
	
}