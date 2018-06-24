package com.travel.controller.AgentController;

import java.util.List;

import javax.mail.Transport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.annotation.JsonValue;
import com.travel.controller.AgentController.response.AgentResponse;
import com.travel.controller.AgentController.response.MessageResponse;
import com.travel.controller.ReviewController.dto.ReviewDTO;
import com.travel.model.Accommodation;
import com.travel.model.Agent;
import com.travel.model.Comment;
import com.travel.model.RegUser;
import com.travel.model.Review;
import com.travel.services.AccommodationService;
import com.travel.services.AgentService;
import com.travel.services.RegUserService;



@RestController
@RequestMapping("/agent")
@CrossOrigin()
public class AgentController {
	
	
	@Autowired
	private AgentService agentService;
	
	
	@Autowired
	private RegUserService ruService;
	
	@Autowired
	private AccommodationService aService;
	
	@Autowired
	private JavaMailSender sender;
	
	
	    @JsonValue
		@GetMapping("/getAgents")
		public AgentResponse getAgents(){
			
			List<Agent>listag=agentService.getAllAgents();
			return new AgentResponse(listag);
			
		}
	    

	    
	    @PostMapping("approveAgent/{agentId}")        //odobri agenta
	    public MessageResponse approveSelectedAgent(@PathVariable Long agentId){
	    	
	    	Agent selected=agentService.getAgentById(agentId);
	    	selected.setApproved(true);
	    	Agent updated=agentService.saveAgent(selected);
            	    	
	    return new MessageResponse("Successfully approved selected agent");
	    		
	    	
	    }
	    
	    
	    @PostMapping("/sendMessage")
	    public MessageResponse sendMessage(@RequestBody ReviewDTO reviewDTO){
	    	
	    	
	    	String comment=reviewDTO.getCommentcontent();
	    	
	    	RegUser user=ruService.getRegUserById(reviewDTO.getUserid());
	    	Agent agent=agentService.getAgentById(reviewDTO.getRating().longValue()); // rating =agent id (da bismo iskoristili dto)
	    	Accommodation acc=aService.getAccommodationById(reviewDTO.getAccommodationid());
	    	
		
	    	
	    	String appUrl = "http://localhost:4200/dashboard/message/"+user.getId();
			SimpleMailMessage messageEmail=new SimpleMailMessage();
			messageEmail.setTo(agent.getEmail());
			messageEmail.setSubject("Message from "+user.getName()+" "+user.getSurname()+" " +" for accommodation " + acc.getName());
			messageEmail.setText("Message: "+ comment+"\n\n\n Please reply on this link below:\n"
			+appUrl);
			
			
		sender.send(messageEmail);
			
	    	
	    	
	   
	    	
	    	return new MessageResponse("Successfully sent message");
	    }
	    
	    
	    
	    
	    
	    
	    

}
