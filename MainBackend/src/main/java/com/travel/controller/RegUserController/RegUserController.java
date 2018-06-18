package com.travel.controller.RegUserController;



import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonValue;
import com.travel.controller.AgentController.response.MessageResponse;
import com.travel.controller.RegUserController.dto.RegistrationDTO;
import com.travel.controller.RegUserController.response.RegUserResponse;
import com.travel.model.RegUser;
import com.travel.repositories.RegUserRepository;
import com.travel.services.RegUserService;






@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/reguser")
public class RegUserController {
	
	
	@Autowired
	private RegUserService reguserService;
	

	
	@Autowired RegUserRepository reguserRepository;
	
	/*@Autowired
	private PasswordEncoder passwordEncoder;*/
	
	@Autowired 
	 private HttpSession httpSession;
	
	
	    @JsonValue
	   // @PreAuthorize("hasAnyRole('USER')")
		@GetMapping("/getUsers")
		public RegUserResponse getUsers(){
			
			List<RegUser>listus=reguserService.getAllUsers();
			return new RegUserResponse(listus);
		//	return "USPEO SAM";
			
		}
	    
	    
	    @GetMapping("/getUser/{userId}")
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
	    
	    @DeleteMapping("deleteUser/{userId}")
	    public MessageResponse deleteUser(@PathVariable Long userId){
	    	
	      reguserService.deleteRegUser(reguserRepository.findByIdEquals(userId));
	    	
	    	return new MessageResponse("Successfully deleted selected user");
	    	
	    	
	    	
	    }
	    
	    @JsonValue
	    @PostMapping("/registration")
		public MessageResponse registration(@RequestBody  @Valid RegistrationDTO registrationDTO) {
			
	    	
	    	if(reguserService.checkUniqueEmail(registrationDTO.getEmail())==false){
	    		
	    		return new MessageResponse("There is already user with the same email");
	    	}
	    	
	    /*	
	    	PasswordMatchesValidator pass=new PasswordMatchesValidator();
	    	if(pass.isValid(registrationDTO)==false){
	    		return new MessageResponse("You must retype the same password again");
	    	}
			
			RegUser user = reguserService.registerNewUserAccount(registrationDTO);
	       
			*/
			return new MessageResponse("User is registrated");
		}
	    @JsonValue
	    @GetMapping("/login")
        public String login(Model model, Principal principal) {
	    	
			return "login";
		}
	    
	    
	
	    @PostMapping("/logout")
        public MessageResponse logout(HttpServletRequest  request) {
		
	    	
        	
        
            
          
        	
        	
        	
			
			return new MessageResponse("User is logged out");
		}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    @PostMapping("/confirm")
		public MessageResponse emailConfirm(@RequestParam("token") String token) {
			
			RegUser user = reguserService.findByConfirmationToken(token);
			
			if(user==null) {
				return new MessageResponse("Oops! This token is invalid!");
			}
			user.setActive(true);
			reguserService.saveRegUser(user);
		return new MessageResponse("User is activated");
		}
	    
	    
	    @GetMapping("/getActiveUser")
	    @ResponseBody
	    public String getActiveUser(){
	    
	    //	CustomUserDetails customUser = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    
	   
	    
	    		//return customUser.getEmail();	
	    	return "Obrisi ovo";

	    	
	    }

}
