package com.travel.controller.SearchController.dto;

import java.util.List;

public class SearchDTO {
	
	public SearchDTO(String destination, String checkIn, String checkOut, int numPerson, List<String> filterServices) {
		
		this.destination = destination;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numPerson = numPerson;
		this.filterServices = filterServices;
	}

	public SearchDTO() {
		
	}
	
	

	private String destination;
	
	private String checkIn;
	
	private String checkOut;
	
	private int numPerson;
	
	private List<String> filterServices;

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

}
