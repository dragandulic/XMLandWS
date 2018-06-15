package com.travel.endpoints;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.concretepage.gs_ws.LoginAgentRequest;
import com.concretepage.gs_ws.LoginAgentResponse;
import com.concretepage.gs_ws.RegistrationAgentRequest;
import com.concretepage.gs_ws.RegistrationAgentResponse;
import com.travel.controller.AgentController.response.MessageResponse;
import com.travel.model.Agent;

import com.travel.services.AgentService;

@Endpoint
public class AgentEndpoint {
	
	
	private static final String NAMESPACE_URI = "http://www.travel.com/agent";
	
	
	@Autowired
	private AgentService agentService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "registrationAgentRequest")
	@ResponsePayload
	public  RegistrationAgentResponse registerAgent(@RequestPayload RegistrationAgentRequest request) {
		RegistrationAgentResponse response=new RegistrationAgentResponse();
		
		
		
		if(agentService.checkUniqueEmail(request.getEmail())==false){
    		response.setMessage("There is already agent with the same email");
    		return response;
    	
		
		}
	
		
		if((request.getPassword1().equals(request.getPassword2())==false)){
			response.setMessage("Password 1 and password 2 must be the same");
    		return response;
			
		}
		
		
		Agent ag = agentService.registerNewAgentAccount(request);
		response.setMessage("Agent is registrated");
		
		return response;
	}
	
	
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "loginAgentRequest")
	@ResponsePayload
	public  LoginAgentResponse loginAgent(@RequestPayload LoginAgentRequest request) {
		
		LoginAgentResponse response=new LoginAgentResponse();
		
		Agent temp=agentService.findOneUserByEmail(request.getEmail());
		
		if (temp == null){
			response.setMessage("Invalid email address");
			return response;
			
    	}
		
		if (!(passwordEncoder.matches(request.getPassword(),temp.getPassword()))){
			response.setMessage("Invalid password");
    		return response;
		}

		
		
	
		response.setMessage("Successfully logged in");
		
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
}
