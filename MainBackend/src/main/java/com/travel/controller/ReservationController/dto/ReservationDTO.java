package com.travel.controller.ReservationController.dto;

public class ReservationDTO {
	
	

	public ReservationDTO(String name, String surname, String email, String start_date, String end_date, long regUser,
			int price, long accommodation_id, String room_type) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.start_date = start_date;
		this.end_date = end_date;
		this.regUser = regUser;
		this.price = price;
		this.accommodation_id = accommodation_id;
		this.room_type = room_type;
	}

	public ReservationDTO() {
		
	}
	
	

	private String name;
	
	private String surname;
	
	private String email;
	
	private String start_date;
	
	private String end_date;
	
	private long regUser;
	
	private int price;
	
	private long accommodation_id;
	
	private String room_type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	

	public long getRegUser() {
		return regUser;
	}

	public void setRegUser(long regUser) {
		this.regUser = regUser;
	}

	public long getAccommodation_id() {
		return accommodation_id;
	}

	public void setAccommodation_id(long accommodation_id) {
		this.accommodation_id = accommodation_id;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

}
