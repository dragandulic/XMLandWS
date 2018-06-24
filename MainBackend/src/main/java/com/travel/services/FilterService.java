package com.travel.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.controller.SearchController.dto.AccommodationSearchDTO;
import com.travel.controller.SearchController.dto.SearchDTO;
import com.travel.model.Accommodation;
import com.travel.model.AccommodationType;
import com.travel.model.AdditionalServices;
import com.travel.model.Category;
import com.travel.model.PricePlan;
import com.travel.repositories.AccommodationTypeRepository;
import com.travel.repositories.CategoryRepository;
import com.travel.repositories.PricePlanRepository;
import com.travel.repositories.SearchRepository;

@Service
public class FilterService {

	
	@Autowired
	private SearchRepository searchRepository;
	
	@Autowired
	private AccommodationTypeRepository accommodationTypeRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PricePlanRepository pricePlanRepository;
	
	public List<AccommodationSearchDTO> filterservices(SearchDTO searchdto){
		
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
		
		
		ArrayList<AccommodationSearchDTO> returnlist = new ArrayList<>();
		for(int i =0;i<accommodations2.size();i++) {
			
			AccommodationSearchDTO accdto = new AccommodationSearchDTO();
			accdto.setId(accommodations2.get(i).getId());
			accdto.setName(accommodations2.get(i).getName());
			accdto.setDescription(accommodations2.get(i).getDescription());
			accdto.setRating(accommodations2.get(i).getRating());
			accdto.setPicture(accommodations2.get(i).getPicture());
			
			String searchfrom = searchdto.getCheckIn();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
			LocalDate searchreservedfrom = LocalDate.parse(searchfrom, formatter);
			int month = searchreservedfrom.getMonthValue();
			
			
			PricePlan pricesPlans = pricePlanRepository.findByRoomtypeEqualsAndAccommodation_idEquals(searchdto.getNumPerson(),accommodations2.get(i).getId());
			
			if(pricesPlans!=null) {
			System.out.println("USAO U IF " + pricesPlans.getJuly());
			
			
			if(month==1) {
				int price = pricesPlans.getJanuary();
				accdto.setPrice(price);
			}
			else if(month==2) {
				int price = pricesPlans.getFebruary();
				accdto.setPrice(price);
			}
			else if(month==3) {
				int price = pricesPlans.getMarch();
				accdto.setPrice(price);
			}
			else if(month==4) {
				int price = pricesPlans.getApril();
				accdto.setPrice(price);
			}
			else if(month==5) {
				int price = pricesPlans.getMay();
				accdto.setPrice(price);
			}
			else if(month==6) {
				int price = pricesPlans.getJune();
				accdto.setPrice(price);
			}
			else if(month==7) {
				int price = pricesPlans.getJuly();
				accdto.setPrice(price);
				System.out.println("July usao " + returnlist.size());
			}
			else if(month==8) {
				int price = pricesPlans.getAugust();
				accdto.setPrice(price);
			}
			else if(month==9) {
				int price = pricesPlans.getSeptember();
				accdto.setPrice(price);
			}
			else if(month==10) {
				int price = pricesPlans.getOctober();
				accdto.setPrice(price);
			}
			else if(month==11) {
				int price = pricesPlans.getNovember();
				accdto.setPrice(price);
			}
			else if(month==12) {
				int price = pricesPlans.getDecember();
				accdto.setPrice(price);
			}
			
			}
			returnlist.add(accdto);
			
		}
		
		
		
		return returnlist;
		
	}
	
	
	
	public List<AccommodationSearchDTO> sortAccCategory(SearchDTO searchdto){
		
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
		
		
		ArrayList<AccommodationSearchDTO> returnlist = new ArrayList<>();
		for(int i =0;i<listaccommodaton.size();i++) {
			
			AccommodationSearchDTO accdto = new AccommodationSearchDTO();
			accdto.setId(listaccommodaton.get(i).getId());
			accdto.setName(listaccommodaton.get(i).getName());
			accdto.setDescription(listaccommodaton.get(i).getDescription());
			accdto.setRating(listaccommodaton.get(i).getRating());
			accdto.setPicture(listaccommodaton.get(i).getPicture());
			
			String searchfrom = searchdto.getCheckIn();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
			LocalDate searchreservedfrom = LocalDate.parse(searchfrom, formatter);
			int month = searchreservedfrom.getMonthValue();
			
			
			PricePlan pricesPlans = pricePlanRepository.findByRoomtypeEqualsAndAccommodation_idEquals(searchdto.getNumPerson(),listaccommodaton.get(i).getId());
			
			if(pricesPlans!=null) {
			System.out.println("USAO U IF " + pricesPlans.getJuly());
			
			
			if(month==1) {
				int price = pricesPlans.getJanuary();
				accdto.setPrice(price);
			}
			else if(month==2) {
				int price = pricesPlans.getFebruary();
				accdto.setPrice(price);
			}
			else if(month==3) {
				int price = pricesPlans.getMarch();
				accdto.setPrice(price);
			}
			else if(month==4) {
				int price = pricesPlans.getApril();
				accdto.setPrice(price);
			}
			else if(month==5) {
				int price = pricesPlans.getMay();
				accdto.setPrice(price);
			}
			else if(month==6) {
				int price = pricesPlans.getJune();
				accdto.setPrice(price);
			}
			else if(month==7) {
				int price = pricesPlans.getJuly();
				accdto.setPrice(price);
				System.out.println("July usao " + returnlist.size());
			}
			else if(month==8) {
				int price = pricesPlans.getAugust();
				accdto.setPrice(price);
			}
			else if(month==9) {
				int price = pricesPlans.getSeptember();
				accdto.setPrice(price);
			}
			else if(month==10) {
				int price = pricesPlans.getOctober();
				accdto.setPrice(price);
			}
			else if(month==11) {
				int price = pricesPlans.getNovember();
				accdto.setPrice(price);
			}
			else if(month==12) {
				int price = pricesPlans.getDecember();
				accdto.setPrice(price);
			}
			
			}
			returnlist.add(accdto);
			
		}
		
		
		
		
		return returnlist;
	}
	
	
	
	public ArrayList<AccommodationSearchDTO> sortAccRating(SearchDTO searchdto){
		
		AccommodationSearchDTO pom = new AccommodationSearchDTO();
		for(int i = 0;i<searchdto.getListAccommodationsDto().size();i++) {
			for(int j = i+1;j<searchdto.getListAccommodationsDto().size();j++) {
				Double prvi = searchdto.getListAccommodationsDto().get(i).getRating();
				Double drugi = searchdto.getListAccommodationsDto().get(j).getRating();
				if(prvi < drugi) {
					pom = searchdto.getListAccommodationsDto().get(i);
					
					searchdto.getListAccommodationsDto().set(i, searchdto.getListAccommodationsDto().get(j));
				
					searchdto.getListAccommodationsDto().set(j, pom); 
				}
			}
		}
		
		
		
		
		return (ArrayList<AccommodationSearchDTO>) searchdto.getListAccommodationsDto();
	}
	
	public ArrayList<AccommodationSearchDTO> sortAccPriceA(SearchDTO searchdto){
		
		AccommodationSearchDTO pom = new AccommodationSearchDTO();
		for(int i = 0;i<searchdto.getListAccommodationsDto().size();i++) {
			for(int j = i+1;j<searchdto.getListAccommodationsDto().size();j++) {
				int prvi = searchdto.getListAccommodationsDto().get(i).getPrice();
				int drugi = searchdto.getListAccommodationsDto().get(j).getPrice();
				if(prvi > drugi) {
					pom = searchdto.getListAccommodationsDto().get(i);
					
					searchdto.getListAccommodationsDto().set(i, searchdto.getListAccommodationsDto().get(j));
				
					searchdto.getListAccommodationsDto().set(j, pom); 
				}
			}
		}
		return (ArrayList<AccommodationSearchDTO>) searchdto.getListAccommodationsDto();
	}
	
	
	public ArrayList<AccommodationSearchDTO> sortAccPriceD(SearchDTO searchdto){
		
		AccommodationSearchDTO pom = new AccommodationSearchDTO();
		for(int i = 0;i<searchdto.getListAccommodationsDto().size();i++) {
			for(int j = i+1;j<searchdto.getListAccommodationsDto().size();j++) {
				int prvi = searchdto.getListAccommodationsDto().get(i).getPrice();
				int drugi = searchdto.getListAccommodationsDto().get(j).getPrice();
				if(prvi < drugi) {
					pom = searchdto.getListAccommodationsDto().get(i);
					
					searchdto.getListAccommodationsDto().set(i, searchdto.getListAccommodationsDto().get(j));
				
					searchdto.getListAccommodationsDto().set(j, pom); 
				}
			}
		}
		return (ArrayList<AccommodationSearchDTO>) searchdto.getListAccommodationsDto();
	}
	
}
