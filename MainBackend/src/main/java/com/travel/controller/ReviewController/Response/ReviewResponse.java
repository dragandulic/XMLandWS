package com.travel.controller.ReviewController.Response;

import java.util.List;

import com.travel.model.Review;







public class ReviewResponse {

	private List<Review>reviews;

	public ReviewResponse(List<Review> reviews) {
		super();
		this.reviews = reviews;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	
	
	
	
	
}