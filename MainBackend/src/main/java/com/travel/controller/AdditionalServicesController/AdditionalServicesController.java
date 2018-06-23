package com.travel.controller.AdditionalServicesController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonValue;
import com.travel.controller.AdditionalServicesController.response.AdditionalServicesResponse;
import com.travel.controller.AgentController.response.MessageResponse;
import com.travel.controller.RegUserController.response.RegUserResponse;
import com.travel.model.AdditionalServices;
import com.travel.model.RegUser;
import com.travel.services.AdditionalServicesService;



@RestController
@RequestMapping("/aservices")
@CrossOrigin
public class AdditionalServicesController {
	
	@Autowired
	private AdditionalServicesService aService;
	
	
	
	  @JsonValue
			@GetMapping("/getAServices")
			public AdditionalServicesResponse getServices(){
				
				List<String>listservices=aService.findDistinctServices();
				return new AdditionalServicesResponse (listservices);
				
			}
	  
	  @PostMapping("/addService/{serviceName}")
	    public  MessageResponse addNewService(@PathVariable String serviceName){
	        AdditionalServices newservice=new AdditionalServices();
	        
	        newservice.setServicename(serviceName);
	       AdditionalServices saved=aService.saveAdditionalService(newservice);
	      if(saved !=null){
	        return new MessageResponse("Successfully added new additional service");
	      }else{
	    	  
	    	  return new MessageResponse("Failed to add new additional service");
	      }
	    }
	    
	  @DeleteMapping("deleteService/{serviceName}")
	    public MessageResponse deleteUser(@PathVariable String serviceName){
	    	
	        aService.deleteAdditionalService(serviceName);
	    	
	    	return new MessageResponse("Successfully deleted additional service");
	    	
	    	
	    	
	    }
	  
	  
	  @GetMapping("getServices/{accommid}")
	    public List<String> deleteUser(@PathVariable Long accommid){
	    	
	       List<String>response=aService.getAllAdditionalServicesForAccommodation(accommid);
	    	
	    	return response;
	    	
	    	
	    	
	    }
	  

}
