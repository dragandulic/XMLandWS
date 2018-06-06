package com.travel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.model.Admin;



@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	
	Admin findByIdEquals(Long id);
	
}
