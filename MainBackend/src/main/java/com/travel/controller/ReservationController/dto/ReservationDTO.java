package com.travel.controller.ReservationController.dto;

public class ReservationDTO {
	
	public ReservationDTO() {
		
	}
	
	public ReservationDTO(String name, String surname, String email, String start_date, String end_date,
			long reg_user_id, int price, long room_id) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.start_date = start_date;
		this.end_date = end_date;
		this.regUser = reg_user_id;
		this.price = price;
		this.room_id = room_id;
	}

	private String name;
	
	private String surname;
	
	private String email;
	
	private String start_date;
	
	private String end_date;
	
	private long regUser;
	
	private int price;
	
	private long room_id;

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

	public long getRoom_id() {
		return room_id;
	}

	public void setRoom_id(long room_id) {
		this.room_id = room_id;
	}

	public long getRegUser() {
		return regUser;
	}

	public void setRegUser(long regUser) {
		this.regUser = regUser;
	}

}
