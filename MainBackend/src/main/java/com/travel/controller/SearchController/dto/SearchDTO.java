package com.travel.controller.SearchController.dto;

public class SearchDTO {
	
	public SearchDTO() {
		
	}
	
	public SearchDTO(String destination, String checkIn, String checkOut, int numPerson) {
		super();
		this.destination = destination;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numPerson = numPerson;
	}

	private String destination;
	
	private String checkIn;
	
	private String checkOut;
	
	private int numPerson;

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

}
