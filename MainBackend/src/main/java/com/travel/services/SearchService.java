package com.travel.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.controller.SearchController.dto.SearchDTO;
import com.travel.model.Accommodation;
import com.travel.model.Location;
import com.travel.repositories.AccommodationRepository;
import com.travel.repositories.LocationRepository;

@Service
public class SearchService {
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private AccommodationRepository accommodationRepository;
	
	public List<Accommodation> searchAcc(SearchDTO searchR){
		
		String dest = searchR.getDestination();
		System.out.println(dest);
		List<Accommodation> acc = new ArrayList<Accommodation>();
		
		List<Location> locations = locationRepository.findByCityEquals(dest);
		
		for(int i=0; i<locations.size(); i++) {
			Long id = locations.get(i).getId();
			Accommodation accommodation = accommodationRepository.findByLocation_idEquals(id);			
			if(accommodation.isFree()) {
				acc.add(accommodation);
			}
		}
		
		return acc;
	}

}
