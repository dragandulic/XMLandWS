package com.travel.controller.AgentController.response;

import java.util.List;

import com.travel.model.Agent;



public class AgentResponse {

	private List<Agent>agents;
	
	
	
	public AgentResponse(List<Agent>a){
		
		this.agents=a;
	}



	public List<Agent> getAgents() {
		return agents;
	}



	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}



	
	
	
	
	
	
	
}
