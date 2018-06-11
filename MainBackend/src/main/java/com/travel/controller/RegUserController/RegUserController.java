package com.travel.controller.RegUserController;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.annotation.JsonValue;
import com.travel.controller.AgentController.response.MessageResponse;
import com.travel.controller.RegUserController.response.RegUserResponse;
import com.travel.model.RegUser;
import com.travel.repositories.RegUserRepository;
import com.travel.services.RegUserService;







@RestController
@RequestMapping("/reguser")
public class RegUserController {
	
	
	@Autowired
	private RegUserService reguserService;
	
	
	@Autowired RegUserRepository reguserRepository;
	
	
	
	
	
	    @JsonValue
		@GetMapping("/getUsers")
		public RegUserResponse getUsers(){
			
			List<RegUser>listus=reguserService.getAllUsers();
			return new RegUserResponse(listus);
			
		}
	    
	    
	    @PostMapping("/getUser/{userId}")
	    public  RegUser getUser(@PathVariable Long userId){
	        RegUser user = reguserService.getRegUserById(userId);
	      
	        return user;
	    }
	    
	    @PostMapping("/blockUser/{userId}")
	    public  MessageResponse blockUser(@PathVariable Long userId){
	        RegUser user = reguserService.getRegUserById(userId);
	        
	        user.setBlocked(true);
	        RegUser blocked=reguserService.saveRegUser(user);
	      if(blocked !=null){
	        return new MessageResponse("Successfully blocked selected user");
	      }else{
	    	  
	    	  return new MessageResponse("Failed to block selected user");
	      }
	    }
	    
	    
	    @PostMapping("/unblockUser/{userId}")
	    public  MessageResponse unblockUser(@PathVariable Long userId){
	        RegUser user = reguserService.getRegUserById(userId);
	        
	        user.setBlocked(false);
	        RegUser unblocked=reguserService.saveRegUser(user);
	      if(unblocked !=null){
	        return new MessageResponse("Successfully unblocked selected user");
	      }else{
	    	  
	    	  return new MessageResponse("Failed to unblock selected user");
	      }
	    }
	    
	    @DeleteMapping("deleteUser/{UserId}")
	    public MessageResponse deleteUser(@PathVariable Long userId){
	    	
	      reguserService.deleteRegUser(reguserRepository.findByIdEquals(userId));
	    	
	    	return new MessageResponse("Successfully deleted selected user");
	    	
	    	
	    	
	    }
	    
	    

}
