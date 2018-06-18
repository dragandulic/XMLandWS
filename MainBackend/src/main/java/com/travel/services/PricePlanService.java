package com.travel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.travel.model.PricePlan;

import com.travel.repositories.PricePlanRepository;



@Service
public class PricePlanService {
	
	@Autowired
	private PricePlanRepository ppRepository; 
	
    public PricePlan getPlanById(Long id) {
		
		PricePlan pp = ppRepository.findByIdEquals(id);
		
		return pp;
		
	}
    
public PricePlan savePlan(PricePlan p) {
		
	PricePlan pp = ppRepository.save(p);
		
		return pp;
		
	}


	

}