package com.travel.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.controller.SearchController.dto.SearchDTO;
import com.travel.model.Accommodation;
import com.travel.model.AdditionalServices;
import com.travel.repositories.SearchRepository;

@Service
public class FilterService {

	
	@Autowired
	private SearchRepository searchRepository;
	
	public List<Accommodation> filterservices(SearchDTO searchdto){
		  
		List<String> services = searchdto.getFilterServices();
		  
		List<AdditionalServices> additionalservice;
		  
		additionalservice  = new ArrayList<>();
		additionalservice.addAll(searchRepository.findByServicenameEquals(services.get(0)));
		  
		  
		  
		for(int i =0;i<additionalservice.size();i++) {
			if(additionalservice.get(i).getAccommodation()==null) {
				additionalservice.remove(i);  
		    }
		}
		  
		  
		for(int i =0; i<additionalservice.size();i++) {
		 
		    for(int j=1;j<services.size();j++) {
		     
		    	AdditionalServices accpom = searchRepository.findByServicenameEqualsAndAccommodation_idEquals(services.get(j), additionalservice.get(i).getAccommodation().getId());
		    	if(accpom==null) {
		    		additionalservice.remove(i);
		    		j=services.size();
		    		i--;
		    	}
		    }
		}
		  
		List<Accommodation> accommodations = new ArrayList<>();
		for(int i =0;i<additionalservice.size();i++) {
		    
		   accommodations.add(additionalservice.get(i).getAccommodation());
		   
		}
		  
		  
		  
		return accommodations;
	}
	
	
}
