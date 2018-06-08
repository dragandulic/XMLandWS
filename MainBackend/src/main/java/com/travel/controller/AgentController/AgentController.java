package com.travel.controller.AgentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.annotation.JsonValue;
import com.travel.controller.AgentController.response.AgentResponse;
import com.travel.model.Agent;

import com.travel.services.AgentService;



@RestController
@RequestMapping("/agent")
public class AgentController {
	
	
	@Autowired
	private AgentService agentService;
	
	
	
	
	
	
	
	
	    @JsonValue
		@GetMapping("/getAgents")
		public AgentResponse getAgents(){
			
			List<Agent>listag=agentService.getAllAgents();
			return new AgentResponse(listag);
			
		}

}
