package com.travel.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;


import com.travel.model.RegUser;

@Repository
public interface RegUserRepository extends JpaRepository<RegUser, Long> {
	
	RegUser findByIdEquals(Long id);
	List<RegUser> findAll();
	RegUser findOneByEmail(String email);
	RegUser findByConfirmationtoken(String confirmationToken);
	Optional<RegUser> findByEmail(String email);
	
	
}
