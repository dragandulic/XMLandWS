package com.travel.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.concretepage.gs_ws.SetAccommodationStatusRequest;
import com.concretepage.gs_ws.SetAccommodationStatusResponse;
import com.travel.model.Accommodation;
import com.travel.services.AgentService;

@Endpoint
public class AgentEndpoint {
	
	
	private static final String NAMESPACE_URI = "http://www.travel.com/agent";
	
	
	@Autowired
	private AgentService agentService;

	
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "setAccommodationStatusRequest")
	@ResponsePayload
	public  SetAccommodationStatusResponse addAccommodation(@RequestPayload SetAccommodationStatusRequest request) {
		
		
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
