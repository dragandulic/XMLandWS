package com.travel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.travel.model.Agent;

import com.travel.repositories.AgentRepository;





@Service
public class AgentService {

	@Autowired
	private AgentRepository agentRepository; 
	
	
	public Agent getAdminById(Long id) {
		
		Agent agent = agentRepository.findByIdEquals(id);
		
		return agent;
		
	}
	
	
public Agent saveAgent(Agent a){
		
		Agent ag=agentRepository.save(a);
		return ag;
		
	}

public List<Agent>getAllAgents(){

	return agentRepository.findAll();
}




	
}