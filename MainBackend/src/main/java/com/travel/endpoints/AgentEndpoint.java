package com.travel.endpoints;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpServletConnection;

import com.concretepage.gs_ws.AcceptReservationRequest;
import com.concretepage.gs_ws.AcceptReservationResponse;
import com.concretepage.gs_ws.DeleteReservationRequest;
import com.concretepage.gs_ws.DeleteReservationResponse;
import com.concretepage.gs_ws.GetAgentReservationListRequest;
import com.concretepage.gs_ws.GetAgentReservationListResponse;
import com.concretepage.gs_ws.LoginAgentRequest;
import com.concretepage.gs_ws.LoginAgentResponse;
import com.concretepage.gs_ws.RegistrationAgentRequest;
import com.concretepage.gs_ws.RegistrationAgentResponse;
import com.travel.model.Accommodation;
import com.travel.model.Agent;
import com.travel.model.RegUser;
import com.travel.model.Reservation;

import com.travel.services.AgentService;
import com.travel.services.ReservationService;

@Endpoint
public class AgentEndpoint {
	
	
	private static final String NAMESPACE_URI = "http://www.travel.com/agent";
	
	
	@Autowired
	private AgentService agentService;

	/*@Autowired
	private PasswordEncoder passwordEncoder;*/
	
	@Autowired
	private HttpServletRequest r;
	
	@Autowired 
	 private HttpSession httpSession;
	
	@Autowired
	private ReservationService rService;

	
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
		
		if(!(request.getPassword().equals(temp.getPassword()))){
			response.setMessage("Invalid password");
    		return response;
			
			
		}
		
	/*	if (!(passwordEncoder.matches(request.getPassword(),temp.getPassword()))){
			response.setMessage("Invalid password");
    		return response;
		}*/
		
	
    
		if(temp.isApproved()==false){
			response.setMessage("Your account is not approved by administrator");
    		return response;
			
		}
      
        
		
	
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
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAgentReservationListRequest")
	@ResponsePayload
	public  GetAgentReservationListResponse registerAgent(@RequestPayload GetAgentReservationListRequest request) {
		GetAgentReservationListResponse response=new GetAgentReservationListResponse();
		
		List<Reservation>listr=rService.getReservationsByAgent(request.getAgentid());
		for( int i=0;i<listr.size();i++){
			
			
			com.concretepage.gs_ws.Reservation res= new com.concretepage.gs_ws.Reservation();
			Accommodation mod=listr.get(i).getAccommodation();
			res.setId(listr.get(i).getId());
			res.setEmail(listr.get(i).getEmail());
			res.setStartDate(listr.get(i).getStartdate());
			res.setEndDate(listr.get(i).getEnddate());
			res.setRoomType(listr.get(i).getRoomtype());
			res.setName(listr.get(i).getName());
			res.setSurname(listr.get(i).getSurname());
			res.setPrice(listr.get(i).getPrice());
			res.setDeleted(listr.get(i).isDeleted());
			res.setAccepted(listr.get(i).isAccepted());
			com.concretepage.gs_ws.Accommodation a = new com.concretepage.gs_ws.Accommodation();
			
			a.setId(mod.getId());
			
			res.setAccommodation(a);
			RegUser rmod=listr.get(i).getRegUser();
			
			com.concretepage.gs_ws.RegUser ru = new com.concretepage.gs_ws.RegUser();
			ru.setId(rmod.getId());
			ru.setName(rmod.getName());
			ru.setSurname(rmod.getSurname());
			ru.setEmail(rmod.getEmail());
			res.setRegUser(ru);
			
			response.getReservation().add(res);
		}
		
		
		return response;
	}
	
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "acceptReservationRequest")
	@ResponsePayload
	public  AcceptReservationResponse acceptReservation(@RequestPayload AcceptReservationRequest request) {
		AcceptReservationResponse response=new AcceptReservationResponse();
		
		
		rService.acceptReservation(request.getReservationid());
		
		response.setMessage("Successfully accepted reservation");
		
		return response;
	}
	
	
	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteReservationRequest")
	@ResponsePayload
	public  DeleteReservationResponse deleteReservation(@RequestPayload DeleteReservationRequest request) {
		DeleteReservationResponse response=new DeleteReservationResponse();
		
		
		rService.deleteReservation(request.getReservationid());
		
		response.setMessage("Successfully deleted reservation");
		
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
