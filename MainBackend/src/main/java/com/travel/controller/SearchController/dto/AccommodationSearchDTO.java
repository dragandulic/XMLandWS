package com.travel.controller.SearchController.dto;

public class AccommodationSearchDTO {
	
	
	
	

	public AccommodationSearchDTO() {
		
	}

	private long id;
	
	private String name;
	
	private String description;
	
	private Double rating;
	
	private int category;
	
	private String type;
	
	private int price;
	
	
	

	public AccommodationSearchDTO(long id, String name, String description, Double rating, int category, String type,
			int price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.category = category;
		this.type = type;
		this.price = price;
	}

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

	
	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

}
