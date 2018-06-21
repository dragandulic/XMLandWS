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
		
		//lista povratnih accommodationa
		List<Accommodation> accommodations = new ArrayList<>();
		

		
		/**
		 * FILTRIRANJE PO ADDITIONAL SERVICE
		 */
		
		List<String> services = searchdto.getFilterServices();
		
		List<AdditionalServices> additionalservice;
		additionalservice  = new ArrayList<AdditionalServices>();
		
		if(services.size()!=0) {
			
		
		
		for(int i = 0;i<searchdto.getListAccommodationid().size();i++) {
			
			
			AdditionalServices ads=searchRepository.findByServicenameEqualsAndAccommodation_idEquals(services.get(0),searchdto.getListAccommodationid().get(i).getId());
			if(ads!=null) {
				additionalservice.add(ads);
			}
			
		}
		
	
		  
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
		  
		
		for(int i =0;i<additionalservice.size();i++) {
		    
		   accommodations.add(additionalservice.get(i).getAccommodation());
		   
		}
		  
		  
		  
		
		}
		else {
			
			
			accommodations.addAll(searchdto.getListAccommodationid());
		}
		
		
		
		/**
		 * FILTRIRANJE PO TYPE
		 */
		
		
		
		System.out.println("aaaaaaaaa " + accommodations.size());
		
		return accommodations;
		
	}
	
	
}
