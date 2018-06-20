package com.travel.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.controller.SearchController.dto.SearchDTO;
import com.travel.model.Accommodation;
import com.travel.model.AdditionalServices;
import com.travel.model.Location;
import com.travel.repositories.AccommodationRepository;
import com.travel.repositories.LocationRepository;
import com.travel.repositories.SearchRepository;

@Service
public class SearchService {
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private AccommodationRepository accommodationRepository;
	
	@Autowired
	private SearchRepository searchRepository;
	
	public List<Accommodation> searchAcc(SearchDTO searchR){
		
		String dest = searchR.getDestination();
		
		List<Accommodation> acc = new ArrayList<Accommodation>();
		
		List<Location> locations = locationRepository.findByCityEquals(dest);
		
		for(int i=0; i<locations.size(); i++) {
			Long id = locations.get(i).getId();
			Accommodation accommodation = accommodationRepository.findByLocation_idEquals(id);			
			
			String datefrom = accommodation.getDatefrom();
			String dateto = accommodation.getDateto();
			
			String searchfrom = searchR.getCheckIn();
			String searchto = searchR.getCheckOut();
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
			
			
			
			if(datefrom!=null && dateto!=null) {

				LocalDate reservedfrom = LocalDate.parse(datefrom, formatter);
				LocalDate reservedto = LocalDate.parse(dateto, formatter);
				if(searchfrom!=null && searchto!=null) {

					LocalDate searchreservedfrom = LocalDate.parse(searchfrom, formatter);
					LocalDate searchreservedto = LocalDate.parse(searchto, formatter);

					if((searchreservedfrom.isBefore(reservedfrom) && searchreservedto.isBefore(reservedfrom)) ||(searchreservedfrom.isAfter(reservedto) && searchreservedto.isAfter(reservedto))) {
						
						acc.add(accommodation);
					}
				
				
				}
				
				
			}else {
				acc.add(accommodation);
			}
			
			
		}
		
		
		return acc;
	}
	
	public List<Accommodation> filterservices(SearchDTO searchdto){
		
		List<String> services = searchdto.getFilterServices();
		
		List<AdditionalServices> additionalservice;
		
		additionalservice  = new ArrayList<>();
		additionalservice.addAll(searchRepository.findByServicenameEquals(services.get(0)));
		
		System.out.println("qqqqqqqqqqq  size " + additionalservice.size());
		for(int i =0; i<additionalservice.size();i++) {
			if(additionalservice.get(i).getAccommodation()!=null) {
				
				System.out.println("aaaaaaaaa");
				for(int j=1;j<services.size();j++) {
					System.out.println("bbbbb");
					AdditionalServices accpom = searchRepository.findByServicenameEqualsAndAccommodation_idEquals(services.get(j), additionalservice.get(i).getAccommodation().getId());
					if(accpom==null) {
						additionalservice.remove(i);
						j=services.size();
					}
				}
				
				
			}
			
			
		}
		
		List<Accommodation> accommodations = new ArrayList<>();
		for(int i =0;i<additionalservice.size();i++) {
			if(additionalservice.get(i).getAccommodation()!=null) {
			accommodations.add(accommodationRepository.findByIdEquals(additionalservice.get(i).getAccommodation().getId()));
		}
		}
		
		
		return accommodations;
	}

}
