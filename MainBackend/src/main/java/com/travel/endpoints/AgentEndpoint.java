package com.travel.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.concretepage.gs_ws.RegistrationAgentRequest;
import com.concretepage.gs_ws.RegistrationAgentResponse;

import com.travel.model.Agent;

import com.travel.services.AgentService;

@Endpoint
public class AgentEndpoint {
	
	
	private static final String NAMESPACE_URI = "http://www.travel.com/agent";
	
	
	@Autowired
	private AgentService agentService;

	
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "registrationAgentRequest")
	@ResponsePayload
	public  RegistrationAgentResponse registerAgent(@RequestPayload RegistrationAgentRequest request) {
		RegistrationAgentResponse response=new RegistrationAgentResponse();
		
		
		
		if(agentService.checkUniqueEmail(request.getEmail())==false){
    		response.setMessage("There is already agent with the same email");
    		return response;
    	
		
		}
		System.out.println("prosao prvi if");
		
		if((request.getPassword1().equals(request.getPassword2())==false)){
			response.setMessage("Password 1 and password 2 must be the same");
    		return response;
			
		}
		System.out.println("prosao drugi if");
		
		Agent ag = agentService.registerNewAgentAccount(request);
		response.setMessage("Agent is registrated");
		
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
