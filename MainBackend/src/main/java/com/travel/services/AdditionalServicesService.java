package com.travel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.model.AdditionalServices;
import com.travel.repositories.AdditionalServicesRepository;






@Service
public class AdditionalServicesService {

	@Autowired
	private AdditionalServicesRepository asRepository; 
	
	
	public AdditionalServices getAdditionalServicesById(Long id) {
		
		AdditionalServices as = asRepository.findByIdEquals(id);
		
		return as;
		
	}
	
	
	public AdditionalServices saveAS(AdditionalServices ass){
		
		AdditionalServices a=asRepository.save(ass);
		return a;
		
	}
	
}