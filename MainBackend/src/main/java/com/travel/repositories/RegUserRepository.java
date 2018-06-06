package com.travel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.model.RegUser;

@Repository
public interface RegUserRepository extends JpaRepository<RegUser, Long> {
	
	RegUser findByIdEquals(Long id);
	
}
