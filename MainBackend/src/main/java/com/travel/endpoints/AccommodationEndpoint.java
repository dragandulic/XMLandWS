package com.travel.endpoints;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.concretepage.gs_ws.AddAccommodationRequest;
import com.concretepage.gs_ws.AddAccommodationResponse;
import com.concretepage.gs_ws.EditAccommodationRequest;
import com.concretepage.gs_ws.EditAccommodationResponse;
import com.concretepage.gs_ws.GetDistinctServicesRequest;
import com.concretepage.gs_ws.GetDistinctServicesResponse;
import com.concretepage.gs_ws.SetAccommodationStatusRequest;
import com.concretepage.gs_ws.SetAccommodationStatusResponse;
import com.travel.model.Accommodation;
import com.travel.model.AdditionalServices;
import com.travel.model.Location;
import com.travel.model.Room;
import com.travel.services.AccommodationService;
import com.travel.services.AdditionalServicesService;
import com.travel.services.LocationService;
import com.travel.services.RoomService;



@Endpoint
public class AccommodationEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.travel.com/accommodation";
	
	
	@Autowired
	private AccommodationService accommodationService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private AdditionalServicesService as;
	
    
	
	@Autowired
	private RoomService roomService;
	
	
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
		
		
		
		
		/*
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
		*/
		Accommodation acc=new Accommodation();
		acc.setName(request.getName());
		acc.setDescription(request.getDescription());
		acc.setFree(true);
		acc.setType(request.getType());
		acc.setLocation(saved);
		//acc.setAdditionalServices(savedas);
		acc.setRating(request.getRating());
		acc.setCategory(request.getCategory());
		acc.setDatefrom(request.getDatefrom());
		acc.setDateto(request.getDateto());
		Accommodation savedaccomm=accommodationService.saveAccommodation(acc);
		
		List<String>servicelist=request.getServices();
		

		int j = 0;
		while (j < servicelist.size()) {
			String serv=servicelist.get(j);
			AdditionalServices service=new AdditionalServices();
			service.setServicename(serv);
			service.setAccommodation(savedaccomm);
			as.saveAdditionalService(service);
			
			
			j++;
		}
		
		
		for(int i=0;i<request.getOnebadroom();i++){
			
			Room onebad=new Room();
			onebad.setNumberOfBed(1);
			onebad.setFree(true);
			onebad.setAccommodation(savedaccomm);
			Room savedone= roomService.saveRoom(onebad);
		}
		

		for(int i=0;i<request.getTwobadroom();i++){
			
			Room twobad=new Room();
			twobad.setNumberOfBed(2);
			twobad.setFree(true);
			twobad.setAccommodation(savedaccomm);
			Room savedtwo= roomService.saveRoom(twobad);
		}
		

		for(int i=0;i<request.getThreebadroom();i++){
			
			Room threebad=new Room();
			threebad.setNumberOfBed(3);
			threebad.setFree(true);
			threebad.setAccommodation(savedaccomm);
			Room savedthree= roomService.saveRoom(threebad);
		}
		

		for(int i=0;i<request.getFourbadroom();i++){
			
			Room fourbad=new Room();
			fourbad.setNumberOfBed(4);
			fourbad.setFree(true);
			fourbad.setAccommodation(savedaccomm);
			Room savedfour= roomService.saveRoom(fourbad);
		}
		
        for(int i=0;i<request.getFivedbadroom();i++){
			
			Room fivebad=new Room();
			fivebad.setNumberOfBed(5);
			fivebad.setFree(true);
			fivebad.setAccommodation(savedaccomm);
			Room savedfive= roomService.saveRoom(fivebad);
		}
		 
		response.setMessage("Successfully added accommodation");
		
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "editAccommodationRequest")
	@ResponsePayload
	public  EditAccommodationResponse editAccommodation(@RequestPayload EditAccommodationRequest request) {
		
		EditAccommodationResponse response = new EditAccommodationResponse();
		Accommodation accom=accommodationService.getAccommodationById(request.getId());
		
		Location l=accom.getLocation();
		l.setAddress(request.getAddress());
		l.setCity(request.getCity());
		l.setCountry(request.getCountry());
		Location saved=locationService.saveLocation(l);
		
		/*
		AdditionalServices as=accom.getAdditionalServices();
		as.setBathroom(request.isBathroom());
		as.setBreakfast(request.isBreakfast());
		as.setFullBoard(request.isFullBoard());
		as.setHalfBoard(request.isHalfBoard());
		as.setKitchen(request.isKitchen());
		as.setParking(request.isParking());
		as.setTV(request.isTv());
		as.setWiFi(request.isWifi());
		AdditionalServices savedas=asService.saveAS(as);
		*/
		
		accom.setName(request.getName());
		accom.setDescription(request.getDescription());
		accom.setFree(true);
		accom.setType(request.getType());
		accom.setLocation(saved);
		//accom.setAdditionalServices(savedas);
		accom.setRating(request.getRating());
		accom.setCategory(request.getCategory());
		Accommodation savedaccomm=accommodationService.saveAccommodation(accom);
		
		
		
		 
		response.setMessage("Successfully edited accommodation");
		
		
		return response;
	}
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "setAccommodationStatusRequest")
	@ResponsePayload
	public  SetAccommodationStatusResponse addAccommodation(@RequestPayload SetAccommodationStatusRequest request) {
		
		SetAccommodationStatusResponse response = new SetAccommodationStatusResponse();
		
		Accommodation change=accommodationService.getAccommodationById(request.getAccommodationid());
		change.setFree(request.isFree());
		Accommodation s=accommodationService.saveAccommodation(change);
		response.setMessage("Successfully changed accommodation status");
		
		
		return response;
	}
	// komentar
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDistinctServicesRequest")
	@ResponsePayload
	public  GetDistinctServicesResponse getAddServices(@RequestPayload GetDistinctServicesRequest request) {
		
		 GetDistinctServicesResponse response = new  GetDistinctServicesResponse();
		
		//response.setServices(as.findDistinctServices());
		
		response.getServices().addAll(as.findDistinctServices());
		
		
		return response;
	}
	
	
	
	
	
	
	

}
