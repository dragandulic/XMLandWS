package com.travel.endpoints;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.concretepage.gs_ws.AddAccommodationRequest;
import com.concretepage.gs_ws.AddAccommodationResponse;
import com.travel.model.Accommodation;
import com.travel.model.AdditionalServices;
import com.travel.model.Location;
import com.travel.services.AccommodationService;
import com.travel.services.AdditionalServicesService;
import com.travel.services.LocationService;



@Endpoint
public class AccommodationEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.travel.com/accommodation";
	
	
	@Autowired
	private AccommodationService accommodationService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private AdditionalServicesService asService;
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addAccommodationRequest")
	@ResponsePayload
	public  AddAccommodationResponse addAccommodation(@RequestPayload AddAccommodationRequest request) {
		
		System.out.println("POGODIO");
		AddAccommodationResponse response = new AddAccommodationResponse();
		Location loc=new Location();
		loc.setAddress(request.getAddress());
		loc.setCity(request.getCity());
		loc.setCountry(request.getCountry());
		Location saved=locationService.saveLocation(loc);
		
		AdditionalServices as=new AdditionalServices();
		as.setBathroom(request.isBathroom());
		as.setBreakfast(request.isBreakfast());
		as.setFullBoard(request.isFullBoard());
		as.setHalfBoard(request.isHalfBoard());
		as.setKitchen(request.isKitchen());
		as.setParking(request.isParking());
		as.setTV(request.isTv());
		as.setWiFi(request.isWifi());
		AdditionalServices savedas=asService.saveAS(as);
		
		Accommodation acc=new Accommodation();
		acc.setName(request.getName());
		acc.setDescription(request.getDescription());
		acc.setFree(true);
		acc.setType(request.getType());
		acc.setLocation(saved);
		acc.setAdditionalServices(savedas);
		acc.setRating(request.getRating());
		acc.setCategory(request.getCategory());
		Accommodation savedaccomm=accommodationService.saveAccommodation(acc);
		 
		response.setMessage("Successfully added accommodation");
		
		
		return response;
	}

}
