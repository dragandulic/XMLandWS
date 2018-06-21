package com.travel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.model.Accommodation;
import com.travel.model.Review;

import com.travel.repositories.ReviewRepository;







@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository; 
	
	@Autowired
	private AccommodationService aService; 
	
	
	
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


public List<Review> findReviewsByAccommodation(Long accommid){

	return reviewRepository.findReviewsByAccommodation(accommid);
}






public void calculateAverageRating(Long accommid){
	
	// argument rating se odnosi na prosecnu ocenu  jednog korisnika koja ce biti izracunata u frontu
	
	List<Review>rev=findReviewsByAccommodation(accommid);
	Double sum=new Double(0);
	
	int size=rev.size();
	Long sizelong=new Long(size);
	for(int i=0;i<size;i++){
		
		
		Double accomrating=rev.get(i).getRating();
		sum=accomrating+sum;
	}
	
	Double average=sum/sizelong;
	
	Accommodation toedit=aService.getAccommodationById(accommid);
	toedit.setRating(average);
	
	//setovanje rating atributa u accommodation instanci odnosi se na prosecnu ocenu tog accommodationa
	Accommodation saved=aService.saveAccommodation(toedit);
	
	
	
	
	
}





	
}