package com.travel.controller.CategoryController;

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
import com.travel.model.Category;
import com.travel.model.RegUser;
import com.travel.services.AccommodationTypeService;
import com.travel.services.AdditionalServicesService;
import com.travel.services.CategoryService;



@RestController
@RequestMapping("/category")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class CategoryController {
	
	@Autowired
	private CategoryService cService;
	
	
	
	  @JsonValue
			@GetMapping("/getCategories")
			public CategoryResponse getCats(){
				
				List<String>listcats=cService.findDistinctCategory();
				return new CategoryResponse (listcats);
				
			}
	  
	  @PostMapping("/addCategory/{cName}")
	    public  MessageResponse addNewCategory(@PathVariable String cName){
	        Category newcat=new Category();
	        
	        newcat.setCategoryname(cName);
	        Category saved=cService.saveCategory(newcat);
	      if(saved !=null){
	        return new MessageResponse("Successfully added new category");
	      }else{
	    	  
	    	  return new MessageResponse("Failed to add category");
	      }
	    }
	    
	  @DeleteMapping("deleteCategory/{catName}")
	    public MessageResponse deleteCategory(@PathVariable String catName){
	    	
	        cService.deleteCategory(catName);
	    	
	    	return new MessageResponse("Successfully deleted category");
	    	
	    	
	    	
	    }
	  
	  
	  
	  

}