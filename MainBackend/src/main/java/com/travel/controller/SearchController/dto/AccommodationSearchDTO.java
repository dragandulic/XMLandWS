package com.travel.controller.SearchController.dto;

public class AccommodationSearchDTO {
	
	public AccommodationSearchDTO(String name, String description, int rating, int category, String type, int price) {
		super();
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.category = category;
		this.type = type;
		this.price = price;
	}
	
	public AccommodationSearchDTO() {
		
	}

	private String name;
	
	private String description;
	
	private long rating;
	
	private int category;
	
	private String type;
	
	private int price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getRating() {
		return rating;
	}

	public void setRating(Long long1) {
		this.rating = long1;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
