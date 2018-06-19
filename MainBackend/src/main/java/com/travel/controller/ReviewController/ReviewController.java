package com.travel.controller.ReviewController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.annotation.JsonValue;
import com.travel.controller.AgentController.response.MessageResponse;
import com.travel.controller.CommentController.Response.CommentResponse;
import com.travel.controller.ReviewController.Response.ReviewResponse;
import com.travel.controller.ReviewController.dto.ReviewDTO;
import com.travel.model.Comment;
import com.travel.model.Review;
import com.travel.services.AccommodationService;
import com.travel.services.CommentService;
import com.travel.services.RegUserService;
import com.travel.services.ReviewService;



@RestController
@RequestMapping("/review")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class ReviewController {
	
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private AccommodationService aService;
	
	@Autowired
	private CommentService cService;
	
	@Autowired
	private RegUserService ruService;
	
	    @JsonValue
		@GetMapping("/getReviews")
		public ReviewResponse getReviews(){
			
			List<Review>listar=reviewService.getAllReviews();
			return new ReviewResponse(listar);
			
		}
	    

	    @PostMapping("/addReview")
	    public MessageResponse addComment(@RequestBody ReviewDTO reviewDTO){
	    	
	    	Review r=new Review();
	    	r.setAccommodation(aService.getAccommodationById(reviewDTO.getAccommodationid()));
	    	r.setComment(cService.getCommentById(reviewDTO.getCommentid()));
	    	r.setRating(reviewDTO.getRating());
	    	r.setRegUser(ruService.getRegUserById(reviewDTO.getUserid()));
	    	
	    Review re=reviewService.saveReview(r);
	    	
	    	return new MessageResponse("Successfully review");
	    }
	    	
}
	    


