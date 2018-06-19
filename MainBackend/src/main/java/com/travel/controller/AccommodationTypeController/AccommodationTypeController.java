package com.travel.controller.AccommodationTypeController;

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
import com.travel.controller.AccommodationTypeController.response.AccommodationTypeResponse;
import com.travel.controller.AdditionalServicesController.response.AdditionalServicesResponse;
import com.travel.controller.AgentController.response.MessageResponse;
import com.travel.controller.RegUserController.response.RegUserResponse;
import com.travel.model.AccommodationType;
import com.travel.model.AdditionalServices;
import com.travel.model.RegUser;
import com.travel.services.AccommodationTypeService;
import com.travel.services.AdditionalServicesService;



@RestController
@RequestMapping("/atypes")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class AccommodationTypeController {
	
	@Autowired
	private AccommodationTypeService atService;
	
	
	
	  @JsonValue
			@GetMapping("/getATypes")
			public AccommodationTypeResponse getTypes(){
				
				List<String>listtypes=atService.findDistinctTypes();
				return new AccommodationTypeResponse (listtypes);
				
			}
	  
	  @PostMapping("/addType/{typeName}")
	    public  MessageResponse addNewType(@PathVariable String typeName){
	        AccommodationType newtype=new AccommodationType();
	        
	        newtype.setTypename(typeName);
	       AccommodationType saved=atService.saveAccommodationType(newtype);
	      if(saved !=null){
	        return new MessageResponse("Successfully added new type");
	      }else{
	    	  
	    	  return new MessageResponse("Failed to add new type");
	      }
	    }
	    
	  @DeleteMapping("deleteType/{typeName}")
	    public MessageResponse deleteType(@PathVariable String typeName){
	    	
	        atService.deleteAccommodationType(typeName);
	    	
	    	return new MessageResponse("Successfully deleted accommodation type");
	    	
	    	
	    	
	    }
	  
	  
	  
	  

}