package com.travel.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.model.Review;
import com.travel.model.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByRoleidEquals(Long id);
	
}