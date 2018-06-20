package com.travel.controller.ReviewController.dto;

public class ReviewDTO {

	
	private Long rating;
	private Long userid;
	private Long commentid;
	private Long accommodationid;
	
	
	public ReviewDTO(Long rating, Long userid, Long commentid, Long accommodationid) {
		super();
		this.rating = rating;
		this.userid = userid;
		this.commentid = commentid;
		this.accommodationid = accommodationid;
	}


	public Long getRating() {
		return rating;
	}


	public void setRating(Long rating) {
		this.rating = rating;
	}


	public Long getUserid() {
		return userid;
	}


	public void setUserid(Long userid) {
		this.userid = userid;
	}


	public Long getCommentid() {
		return commentid;
	}


	public void setCommentid(Long commentid) {
		this.commentid = commentid;
	}


	public Long getAccommodationid() {
		return accommodationid;
	}


	public void setAccommodationid(Long accommodationid) {
		this.accommodationid = accommodationid;
	}
	
	
	
	



	


	
	
	
	
	
	
	
	
}
