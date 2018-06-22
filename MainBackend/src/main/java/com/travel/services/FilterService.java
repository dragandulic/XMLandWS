package com.travel.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.controller.SearchController.dto.SearchDTO;
import com.travel.model.Accommodation;
import com.travel.model.AccommodationType;
import com.travel.model.AdditionalServices;
import com.travel.model.Category;
import com.travel.repositories.AccommodationTypeRepository;
import com.travel.repositories.CategoryRepository;
import com.travel.repositories.SearchRepository;

@Service
public class FilterService {

	
	@Autowired
	private SearchRepository searchRepository;
	
	@Autowired
	private AccommodationTypeRepository accommodationTypeRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
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
					accommodations.addAll(searchdto.getListAccommodationid());
				}
		}
		else {
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
		
		
		
		
		//lista povratnih accommodationa posle filtriranja po category
		List<Accommodation> accommodations2 = new ArrayList<>();
		
		
		/**
		 * FILTRIRANJE PO CATEGORIZATION
		 */
		
		List<String> category = searchdto.getFilteCategorys();
		List<Category> listcategory = new ArrayList<>();
		if(category!=null) {
			if(category.size()!=0) {
				for(int i = 0; i<accommodations1.size();i++) {
					
					Category catego = categoryRepository.findByCategorynameEqualsAndAccommodationEquals(searchdto.getFilteCategorys().get(0), accommodations1.get(i).getId());
					
					if(catego!=null) {
						listcategory.add(catego);
					}
				}
				
				for(int i = 0; i<listcategory.size();i++) {
					accommodations2.add(listcategory.get(i).getAccommodation());
				}
				
				
			}
			else {
				accommodations2.addAll(accommodations1);
			}
		}
		else
		{
			accommodations2.addAll(accommodations1);
		}
		
		
		
		
		
		return accommodations2;
		
	}
	
	
	
	public List<Accommodation> sortAccCategory(SearchDTO searchdto){
		
		ArrayList<Category> listcategory = new ArrayList<>();
		
		for(int i = 0; i<searchdto.getListAccommodationid().size();i++) {
			
			Category cat = categoryRepository.findCategoryByAccommodation(searchdto.getListAccommodationid().get(i).getId());
			
			if(cat!=null) {
				listcategory.add(cat);
			}
			
		}
		
		Category pom = new Category();
		
		for(int i = 0;i<listcategory.size();i++) {
			for(int j = i+1; j<listcategory.size();j++) {
				Integer prvi = Integer.valueOf(listcategory.get(i).getCategoryname());
				Integer drugi = Integer.valueOf(listcategory.get(j).getCategoryname());
				if(prvi < drugi) {
					pom = listcategory.get(i);
					
					listcategory.set(i, listcategory.get(j));
				
					listcategory.set(j, pom); 
				}
			}
			
			
		}
		
		ArrayList<Accommodation> listaccommodaton = new ArrayList<>();
		for(int i =0;i<listcategory.size();i++) {
			listaccommodaton.add(listcategory.get(i).getAccommodation());
		}
		
		
		return listaccommodaton;
	}
	
	
}
