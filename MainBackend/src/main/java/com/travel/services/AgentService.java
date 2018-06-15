package com.travel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.concretepage.gs_ws.RegistrationAgentRequest;
import com.travel.model.Agent;

import com.travel.repositories.AgentRepository;





@Service
public class AgentService {

	@Autowired
	private AgentRepository agentRepository; 
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public Agent getAgentById(Long id) {
		
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


public boolean checkUniqueEmail(String email) {
	if (agentRepository.findOneByEmail(email) != null) {
		return false;
	}
	return true;
}

public void deleteAgent(Agent a){
	 
	 agentRepository.delete(a);
}

public Agent registerNewAgentAccount( RegistrationAgentRequest request){
	
	Agent agent=new Agent();
	agent.setName(request.getName());
	agent.setSurname(request.getSurname());
	agent.setEmail(request.getEmail());
	agent.setBusinessregnum(request.getBusinessregnum());
	agent.setPassword(passwordEncoder.encode(request.getPassword1()));
	agent.setAddress(request.getAddress());
	agent.setApproved(false);
	
	/*
	newuser.setConfirmationToken(UUID.randomUUID().toString());
	//user.setPoints(0);
	
	String appUrl = "http://localhost:4200/confirmEmail/";//request.getScheme() + "://" + request.getServerName();
	SimpleMailMessage registrationEmail=new SimpleMailMessage();
	registrationEmail.setTo(newuser.getEmail());
	registrationEmail.setSubject("Registration Confirmation");
	registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
	+appUrl+ newuser.getConfirmationToken());
	emailService.sendEmail(registrationEmail);
	
	
	
	*/
	
	
	
	
	Agent saved=saveAgent(agent);
	
	
	return saved;
}








	
}