package com.travel.controller.ReviewController.dto;

public class ReviewDTO {

	
	private Long rating;
	private long userid;
	private long commentid;
	private long accommodationid;
	
	
	
	



	


	public ReviewDTO(Long rating, long userid, long commentid, long accommodationid) {
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



	public long getUserid() {
		return userid;
	}



	public void setUserid(long userid) {
		this.userid = userid;
	}



	public long getCommentid() {
		return commentid;
	}



	public void setCommentid(long commentid) {
		this.commentid = commentid;
	}



	public long getAccommodationid() {
		return accommodationid;
	}



	public void setAccommodationid(long accommodationid) {
		this.accommodationid = accommodationid;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
