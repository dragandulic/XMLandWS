package com.travel.endpoints;

import java.util.ArrayList;
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
import com.concretepage.gs_ws.AddPricePlanRequest;
import com.concretepage.gs_ws.AddPricePlanResponse;
import com.concretepage.gs_ws.EditAccommodationRequest;
import com.concretepage.gs_ws.EditAccommodationResponse;
import com.concretepage.gs_ws.GetDistinctCategoriesRequest;
import com.concretepage.gs_ws.GetDistinctCategoriesResponse;
import com.concretepage.gs_ws.GetDistinctServicesRequest;
import com.concretepage.gs_ws.GetDistinctServicesResponse;
import com.concretepage.gs_ws.GetDistinctTypesRequest;
import com.concretepage.gs_ws.GetDistinctTypesResponse;
import com.concretepage.gs_ws.SetAccommodationOccupationDatesRequest;
import com.concretepage.gs_ws.SetAccommodationOccupationDatesResponse;
import com.concretepage.gs_ws.SetAccommodationStatusRequest;
import com.concretepage.gs_ws.SetAccommodationStatusResponse;
import com.travel.model.Accommodation;
import com.travel.model.AccommodationType;
import com.travel.model.AdditionalServices;
import com.travel.model.Agent;
import com.travel.model.Category;
import com.travel.model.Location;
import com.travel.model.PricePlan;
import com.travel.model.Room;
import com.travel.repositories.AdditionalServicesRepository;
import com.travel.repositories.PricePlanRepository;
import com.travel.services.AccommodationService;
import com.travel.services.AccommodationTypeService;
import com.travel.services.AdditionalServicesService;
import com.travel.services.AgentService;
import com.travel.services.CategoryService;
import com.travel.services.LocationService;
import com.travel.services.PricePlanService;
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
	private CategoryService cService;
	
	@Autowired
	private AccommodationTypeService atService;
	
	@Autowired
	private PricePlanService ppService;
	
	@Autowired
	private AdditionalServicesRepository asr;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private PricePlanRepository pricepriceRepository;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addAccommodationRequest")
	@ResponsePayload
	public  AddAccommodationResponse addAccommodation(@RequestPayload AddAccommodationRequest request) {
		
	
		AddAccommodationResponse response = new AddAccommodationResponse();
		
		Agent owner=agentService.getAgentById(request.getAgentid());
		
		
		
		Location loc=new Location();
		loc.setAddress(request.getAddress());
		loc.setCity(request.getCity());
		loc.setCountry(request.getCountry());
		Location saved=locationService.saveLocation(loc);
		
		Accommodation acc=new Accommodation();
		acc.setAgent(owner);
		acc.setName(request.getName());
		acc.setDescription(request.getDescription());
	    acc.setPicture(request.getPicture());
		acc.setFree(true);
		//acc.setType(request.getType());
		acc.setLocation(saved);
			acc.setRating(new Double(0));
		//acc.setCategory(request.getCategory());
		acc.setDatefrom(request.getDatefrom());
		acc.setDateto(request.getDateto());
		Accommodation savedaccomm=accommodationService.saveAccommodation(acc);
		
		Category cat=new Category();
		cat.setCategoryname(request.getCategory());
		cat.setAccommodation(savedaccomm);
		Category savedd=cService.saveCategory(cat);
		
		AccommodationType type=new AccommodationType();
		type.setTypename(request.getType());
		type.setAccommodation(savedaccomm);
		AccommodationType t=atService.saveAccommodationType(type);
		
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
		System.out.println("eeeeeeeeee");
		EditAccommodationResponse response = new EditAccommodationResponse();
		Accommodation accom=accommodationService.getAccommodationById(request.getId());
		System.out.println(accom.getName());
		Location l=accom.getLocation();
		l.setAddress(request.getAddress());
		l.setCity(request.getCity());
		l.setCountry(request.getCountry());
		Location saved=locationService.saveLocation(l);
		
		
		accom.setName(request.getName());
		System.out.println(accom.getName());
		accom.setDescription(request.getDescription());
		accom.setFree(true);
	
		accom.setLocation(saved);
		
		//accom.setRating(request.getRating());
		
		
		
		Category c=cService.findCategoryByAccommodationId(accom.getId());
		c.setCategoryname(request.getCategory());
		Category edited=cService.saveCategory(c);
		
		
		AccommodationType at=atService.findTypeByAccommodationId(accom.getId());
		at.setTypename(request.getType());
		AccommodationType editedd=atService.saveAccommodationType(at);
		
		List<AdditionalServices> adds = asr.findByAccommodation_idEquals(request.getId());
		System.out.println(adds.size());
		for(int i=0; i<adds.size(); i++) {
			asr.delete(adds.get(i));
		}
		
		List<String> addsA = request.getServices();
		
		for(int i=0; i<addsA.size();i++) {
			AdditionalServices addser = new AdditionalServices();
			addser.setServicename(addsA.get(i));
			addser.setAccommodation(accom);
			asr.save(addser);
		}
		
		
		
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
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDistinctServicesRequest")
	@ResponsePayload
	public  GetDistinctServicesResponse getAllServices(@RequestPayload GetDistinctServicesRequest request) {
		
		 GetDistinctServicesResponse response = new  GetDistinctServicesResponse();
		
		//response.setServices(as.findDistinctServices());
		
		response.getServices().addAll(as.findDistinctServices());
		
		
		return response;
	}
	
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDistinctTypesRequest")
	@ResponsePayload
	public  GetDistinctTypesResponse getAllTypes(@RequestPayload GetDistinctTypesRequest request) {
		
		 GetDistinctTypesResponse response = new  GetDistinctTypesResponse();
		
		//response.setServices(as.findDistinctServices());
		
		response.getTypes().addAll(atService.findDistinctTypes());
		
		
		return response;
	}
	
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDistinctCategoriesRequest")
	@ResponsePayload
	public  GetDistinctCategoriesResponse getAllCategories(@RequestPayload GetDistinctCategoriesRequest request) {
		
		 GetDistinctCategoriesResponse response = new  GetDistinctCategoriesResponse();
		
		//response.setServices(as.findDistinctServices());
		
		response.getCategories().addAll(cService.findDistinctCategory());
		
		
		return response;
	}
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addPricePlanRequest")
	@ResponsePayload
	public  AddPricePlanResponse addPricePlan(@RequestPayload AddPricePlanRequest request) {
		
		 AddPricePlanResponse response = new  AddPricePlanResponse();
		
		
		
	Accommodation a=accommodationService.getAccommodationById(request.getId());
	
	PricePlan pp = pricepriceRepository.findByRoomtypeEqualsAndAccommodation_idEquals(request.getRoomtype(), a.getId());
	
	if(pp==null) {
	
	PricePlan plan  = new PricePlan();
	
	plan.setAccommodation(a);
	plan.setRoomtype(request.getRoomtype());
	plan.setJanuary(request.getJanuaryprice());
	plan.setFebruary(request.getFebruaryprice());
	plan.setMarch(request.getMarchprice());
	plan.setApril(request.getAprilprice());
	plan.setMay(request.getMayprice());
	plan.setJune(request.getJuneprice());
	plan.setJuly(request.getJulyprice());
	plan.setAugust(request.getAugustprice());
	plan.setSeptember(request.getSeptemberprice());
	plan.setOctober(request.getOctoberprice());
	plan.setNovember(request.getNovemberprice());
	plan.setDecember(request.getDecemberprice());
	
	PricePlan saved=ppService.savePlan(plan);
	
	response.setMessage("Successfully added price plan to accommodation");
		
		return response;
	}
	else if(pp!=null) {
		
		pp.setAccommodation(a);
		pp.setRoomtype(request.getRoomtype());
		pp.setJanuary(request.getJanuaryprice());
		pp.setFebruary(request.getFebruaryprice());
		pp.setMarch(request.getMarchprice());
		pp.setApril(request.getAprilprice());
		pp.setMay(request.getMayprice());
		pp.setJune(request.getJuneprice());
		pp.setJuly(request.getJulyprice());
		pp.setAugust(request.getAugustprice());
		pp.setSeptember(request.getSeptemberprice());
		pp.setOctober(request.getOctoberprice());
		pp.setNovember(request.getNovemberprice());
		pp.setDecember(request.getDecemberprice());
		
		PricePlan saved=ppService.savePlan(pp);
		
		response.setMessage("Successfully added price plan to accommodation");
			
			return response;
	}
	
	return response;
	}
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "setAccommodationOccupationRequest")
	@ResponsePayload
	public SetAccommodationOccupationDatesResponse setOccupationRequest(@RequestPayload SetAccommodationOccupationDatesRequest request) {
		
		SetAccommodationOccupationDatesResponse response = new  SetAccommodationOccupationDatesResponse();
		
		Accommodation changedates=accommodationService.getAccommodationById(request.getId());
		changedates.setDatefrom(request.getDatefrom());
		changedates.setDateto(request.getDateto());
		
		Accommodation saved=accommodationService.saveAccommodation(changedates);
		
	
		response.setMessage("Successfully set occupation dates ");
		
		return response;
	}
	
	
	
	
	
	

}
