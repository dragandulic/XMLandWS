package com.travel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.model.Location;
import com.travel.repositories.LocationRepository;





@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository; 
	
	
	public Location getLocationById(Long id) {
		
		Location location = locationRepository.findByIdEquals(id);
		
		return location;
		
	}
	
	
	public Location saveLocation(Location l){
		
		Location loc=locationRepository.save(l);
		return loc;
		
	}
	
}