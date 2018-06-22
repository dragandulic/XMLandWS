package com.travel.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.controller.SearchController.dto.SearchDTO;
import com.travel.model.Accommodation;
import com.travel.model.AccommodationType;
import com.travel.model.AdditionalServices;
import com.travel.repositories.AccommodationTypeRepository;
import com.travel.repositories.SearchRepository;

@Service
public class FilterService {

	
	@Autowired
	private SearchRepository searchRepository;
	
	@Autowired
	private AccommodationTypeRepository accommodationTypeRepository;
	
	public List<Accommodation> filterservices(SearchDTO searchdto){
		
		//lista povratnih accommodationa posle filtriranja po dodatnim uslugama
		List<Accommodation> accommodations = new ArrayList<>();
		

		
		/**
		 * FILTRIRANJE PO ADDITIONAL SERVICE
		 */
		
		List<String> services = searchdto.getFilterServices();
		
		List<AdditionalServices> additionalservice;
		additionalservice  = new ArrayList<AdditionalServices>();
		
		if(services!=null) {
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
					
					System.out.println("Usao u eleseeeeeeeeee1");
					accommodations.addAll(searchdto.getListAccommodationid());
				}
		}
		else {
			
			System.out.println("Usao u eleseeeeeeeeee2");
			accommodations.addAll(searchdto.getListAccommodationid());
		}
		
		
		
		
		//lista povratnih accommodationa posle filtriranja po dodatnim uslugama
		List<Accommodation> accommodations1 = new ArrayList<>();
		
		
		/**
		 * FILTRIRANJE PO TYPE
		 */
		
		List<String> types = searchdto.getFilterTypes();
		
		List<AccommodationType> accommodationtypes = new ArrayList<>();
		if(types!=null) {
			if(types.size()!=0) {
				for(int i = 0; i<accommodations.size();i++) {
					
					for(int j = 0; j<types.size();j++) {
						
						AccommodationType pom = accommodationTypeRepository.findByTypenameEqualsAndAccommodationEquals(types.get(j), accommodations.get(i).getId());
						if(pom!=null)
						accommodationtypes.add(pom);
						
					}
				}
				
				
				for(int i = 0; i<accommodationtypes.size();i++) {
					accommodations1.add(accommodationtypes.get(i).getAccommodation());
				}
			}
			else {
				accommodations1.addAll(accommodations);
			}
		}
		else {
			accommodations1.addAll(accommodations);
		}
		
		
		
		/**
		 * FILTRIRANJE PO CATEGORIZATION
		 */
		
		
		
		
		
		
		
		return accommodations1;
		
	}
	
	
}
