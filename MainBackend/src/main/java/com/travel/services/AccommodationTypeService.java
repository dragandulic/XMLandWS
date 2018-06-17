package com.travel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travel.model.AccommodationType;
import com.travel.repositories.AccommodationTypeRepository;








@Service
public class AccommodationTypeService {

	@Autowired
	private AccommodationTypeRepository accommodationTypeRepository; 
	
	
	public AccommodationType getAccommodationTypeById(Long id) {
		
		 AccommodationType at= accommodationTypeRepository.findByIdEquals(id);
		
		return at;
		
	}
	
	
public  AccommodationType saveAccommodationType( AccommodationType at){
		
	 AccommodationType att= accommodationTypeRepository.save(at);
		return att;
		
	}

public List< AccommodationType>getAllAccommodationType(){

	return  accommodationTypeRepository.findAll();
}

public List<String>findDistinctTypes(){
	
	return  accommodationTypeRepository.findAccommodationTypeNames();
}

public void deleteAccommodationType(String name){
	
	 accommodationTypeRepository.deleteAccommodationType(name);
}


	
}