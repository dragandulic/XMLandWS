package com.travel.controller.ReviewController.dto;

public class ReviewDTO {

	
	private int rating;
	private long userid;
	private long commentid;
	private long accommodationid;
	
	
	
	public ReviewDTO(int rating, long userid, long commentid, long accommodationid) {
		super();
		this.rating = rating;
		this.userid = userid;
		this.commentid = commentid;
		this.accommodationid = accommodationid;
	}



	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
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
