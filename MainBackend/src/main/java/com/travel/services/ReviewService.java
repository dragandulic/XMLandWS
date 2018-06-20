package com.travel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.travel.model.Review;

import com.travel.repositories.ReviewRepository;







@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository; 
	
	
	public Review getReviewById(Long id) {
		
		Review review= reviewRepository.findByIdEquals(id);
		
		return review;
		
	}
	
	
public Review saveReview(Review r){
		
		Review rr=reviewRepository.save(r);
		return rr;
		
	}

public List<Review>getAllReviews(){

	return reviewRepository.findAll();
}


public void deleteReview(Review rr){
	
	
	 reviewRepository.delete(rr);
	
}

public List<Review>getAllReviewsWithUnApprovedComments(){

	return reviewRepository.findReviewsWithUnApprovedComments();
}


	
}