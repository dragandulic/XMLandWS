package com.travel.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.controller.SearchController.dto.AccommodationSearchDTO;
import com.travel.controller.SearchController.dto.SearchDTO;
import com.travel.model.Accommodation;
import com.travel.model.AdditionalServices;
import com.travel.model.Location;
import com.travel.model.PricePlan;
import com.travel.model.Room;
import com.travel.repositories.AccommodationRepository;
import com.travel.repositories.AdditionalServicesRepository;
import com.travel.repositories.LocationRepository;
import com.travel.repositories.PricePlanRepository;
import com.travel.repositories.RoomRepository;
import com.travel.repositories.SearchRepository;

@Service
public class SearchService {
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private AccommodationRepository accommodationRepository;
	
	@Autowired
	private PricePlanRepository pricePlanRepository;
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private AdditionalServicesRepository additionalServicesRepository;
	
	public List<AccommodationSearchDTO> searchAcc(SearchDTO searchR){
		
		String dest = searchR.getDestination();
		
		List<Accommodation> acc = new ArrayList<Accommodation>();
		
		List<Location> locations = locationRepository.findByCityEquals(dest);
		
		for(int i=0; i<locations.size(); i++) {
			Long id = locations.get(i).getId();
			Accommodation accommodation = accommodationRepository.findByLocation_idEquals(id);			
			
			String datefrom = accommodation.getDatefrom();
			String dateto = accommodation.getDateto();
			
			String searchfrom = searchR.getCheckIn();
			String searchto = searchR.getCheckOut();
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
			
			
			
			if(datefrom!=null && dateto!=null) {

				LocalDate reservedfrom = LocalDate.parse(datefrom, formatter);
				LocalDate reservedto = LocalDate.parse(dateto, formatter);
				if(searchfrom!=null && searchto!=null) {

					LocalDate searchreservedfrom = LocalDate.parse(searchfrom, formatter);
					LocalDate searchreservedto = LocalDate.parse(searchto, formatter);

					if((searchreservedfrom.isBefore(reservedfrom) && searchreservedto.isBefore(reservedfrom)) ||(searchreservedfrom.isAfter(reservedto) && searchreservedto.isAfter(reservedto))) {
						
						acc.add(accommodation);
					}
				
				
				}
				
				
			}else {
				acc.add(accommodation);
			}
			
			
		}
		
		List<Accommodation> acc2 = new ArrayList<Accommodation>();
		
		for(int i=0; i<acc.size();i++) {
			System.out.println(acc.get(i).getName());
			List<Room> rooms = roomRepository.findByAccommodation_idEquals(acc.get(i).getId());
			
			if(rooms.size()!=0) {
				for(int j=0; j<rooms.size();j++) {
					
					if(rooms.get(j).getNumberOfBed()>=searchR.getNumPerson()) {
						acc2.add(acc.get(i));
					}
				}			
			}
		}
		
		List<Accommodation> acc3 = new ArrayList<Accommodation>();
		
		for(int k=0; k<acc2.size();k++) {
			if(!acc3.contains(acc2.get(k))) {
				acc3.add(acc2.get(k));
			}
		}
		
		List<AccommodationSearchDTO> accommodations= new ArrayList<AccommodationSearchDTO>();
		for(int a=0; a<acc3.size(); a++) {
			AccommodationSearchDTO accS = new AccommodationSearchDTO();
			accS.setName(acc3.get(a).getName());
			accS.setDescription(acc3.get(a).getDescription());
			accS.setRating(acc3.get(a).getRating());
			accommodations.add(accS);
			
			String searchfrom = searchR.getCheckIn();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
			LocalDate searchreservedfrom = LocalDate.parse(searchfrom, formatter);
			int month = searchreservedfrom.getMonthValue();
			System.out.println(month+"eeeeeeeee");
			
			List<PricePlan> pricesPlans = pricePlanRepository.findByRoomtypeEquals(searchR.getNumPerson());
			System.out.println(pricesPlans.size()+"mmmmmmmmm");
		}
		
		
		return accommodations;
	}
	
	
	
	public List<String> getAllServices(){
		  
	List<String> services = additionalServicesRepository.findAdditionalServiceNames();
		  
	return services;
		  
	}

}
