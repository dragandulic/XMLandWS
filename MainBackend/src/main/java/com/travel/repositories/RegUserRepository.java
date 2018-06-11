package com.travel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.travel.model.RegUser;

@Repository
public interface RegUserRepository extends JpaRepository<RegUser, Long> {
	
	RegUser findByIdEquals(Long id);
	List<RegUser> findAll();
	RegUser findOneByEmail(String email);
	
	
}
