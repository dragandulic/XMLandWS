package com.travel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.model.Agent;





@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

	
	Agent findByIdEquals(Long id);
	
}