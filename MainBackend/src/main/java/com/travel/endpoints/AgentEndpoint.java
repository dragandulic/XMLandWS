package com.travel.endpoints;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpServletConnection;

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
	
	@Autowired
	private HttpServletRequest r;
	
	@Autowired 
	 private HttpSession httpSession;
	
	
	
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
	public  LoginAgentResponse loginAgent(@RequestPayload LoginAgentRequest request,ServerWebExchange r) {
		
		LoginAgentResponse response=new LoginAgentResponse();
		
		System.out.println(request.getEmail());
		
		Agent temp=agentService.findOneUserByEmail(request.getEmail());
		
		if (temp == null){
			response.setMessage("Invalid email address");
			return response;
			
    	}
		
		if (!(passwordEncoder.matches(request.getPassword(),temp.getPassword()))){
			response.setMessage("Invalid password");
    		return response;
		}
		
	
    
		
         httpSession.setAttribute("agent", temp);
        
		
	
		response.setMessage("Successfully logged in");
		
		return response;
	}
	
	
	
	
	public HttpServletRequest getHttpServletRequest() {
	    TransportContext ctx = TransportContextHolder.getTransportContext();
	    return ( null != ctx ) ? ((HttpServletConnection ) ctx.getConnection()).getHttpServletRequest() : null;
	}

	public String getHttpHeaderValue( final String headerName ) {
	    HttpServletRequest httpServletRequest = getHttpServletRequest();
	    return ( null != httpServletRequest ) ? httpServletRequest.getHeader( headerName ) : null;
	}
	
	
	
	
	
	
}
