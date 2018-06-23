package com.travel.controller.SearchController.dto;

import java.util.List;

import com.travel.model.Accommodation;

public class SearchDTO {
	

	

	public SearchDTO(String destination, String checkIn, String checkOut, int numPerson, List<String> filterServices,
			List<String> filterTypes, List<String> filteCategorys, List<Accommodation> listAccommodationid,
			List<AccommodationSearchDTO> listAccommodationsDto, String sortA) {
		
		this.destination = destination;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numPerson = numPerson;
		this.filterServices = filterServices;
		this.filterTypes = filterTypes;
		this.filteCategorys = filteCategorys;
		this.listAccommodationid = listAccommodationid;
		this.listAccommodationsDto = listAccommodationsDto;
		this.sortA = sortA;
	}


	public SearchDTO() {
		
	}
	
	

	private String destination;
	
	private String checkIn;
	
	private String checkOut;
	
	private int numPerson;
	
	private List<String> filterServices;
	
	private List<String> filterTypes;
	
	private List<String> filteCategorys;
	
	private List<Accommodation> listAccommodationid;
	
	private List<AccommodationSearchDTO> listAccommodationsDto;
	
	private String sortA;
	
	
	

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public int getNumPerson() {
		return numPerson;
	}

	public void setNumPerson(int numPerson) {
		this.numPerson = numPerson;
	}

	public List<String> getFilterServices() {
		return filterServices;
	}

	public void setFilterServices(List<String> filterServices) {
		this.filterServices = filterServices;
	}

	public List<Accommodation> getListAccommodationid() {
		return listAccommodationid;
	}

	public void setListAccommodationid(List<Accommodation> listAccommodationid) {
		this.listAccommodationid = listAccommodationid;
	}

	public List<String> getFilterTypes() {
		return filterTypes;
	}

	public void setFilterTypes(List<String> filterTypes) {
		this.filterTypes = filterTypes;
	}

	public List<String> getFilteCategorys() {
		return filteCategorys;
	}

	public void setFilteCategorys(List<String> filteCategorys) {
		this.filteCategorys = filteCategorys;
	}



	public String getSortA() {
		return sortA;
	}



	public void setSortA(String sortA) {
		this.sortA = sortA;
	}

	public List<AccommodationSearchDTO> getListAccommodationsDto() {
		return listAccommodationsDto;
	}

	public void setListAccommodationsDto(List<AccommodationSearchDTO> listAccommodationsDto) {
		this.listAccommodationsDto = listAccommodationsDto;
	}

	

	

}
