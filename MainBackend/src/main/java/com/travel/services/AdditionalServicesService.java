package com.travel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.model.AdditionalServices;
import com.travel.repositories.AdditionalServicesRepository;







@Service
public class AdditionalServicesService {

	@Autowired
	private AdditionalServicesRepository additionalServicesRepository; 
	
	
	public AdditionalServices getAdditionalServiceById(Long id) {
		
		AdditionalServices serv = additionalServicesRepository.findByIdEquals(id);
		
		return serv;
		
	}
	
	
public AdditionalServices saveAdditionalService(AdditionalServices as){
		
		AdditionalServices ass=additionalServicesRepository.save(as);
		return as;
		
	}

public List<AdditionalServices>getAllAdditionalServices(){

	return additionalServicesRepository.findAll();
}

public List<String>findDistinctServices(){
	
	return additionalServicesRepository.findAdditionalServiceNames();
}



	
}