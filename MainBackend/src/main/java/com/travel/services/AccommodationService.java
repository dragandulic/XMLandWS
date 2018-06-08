package com.travel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.model.Accommodation;
import com.travel.repositories.AccommodationRepository;



@Service
public class AccommodationService {
	
	@Autowired
	private AccommodationRepository accommodationRepository; 
	
    public Accommodation getAccommodationById(Long id) {
		
		Accommodation acc = accommodationRepository.findByIdEquals(id);
		
		return acc;
		
	}
    
public Accommodation saveAccommodation(Accommodation a) {
		
		Accommodation acc = accommodationRepository.save(a);
		
		return acc;
		
	}

public List<Accommodation>getAllAccommodations(){

	return accommodationRepository.findAll();
}
	

}
