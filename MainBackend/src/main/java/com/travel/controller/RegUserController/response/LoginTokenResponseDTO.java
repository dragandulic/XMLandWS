package com.travel.controller.RegUserController.response;

import com.travel.model.RegUser;

public class LoginTokenResponseDTO {
	
	private RegUser user;
	private String jwt;
	
	
	
	public LoginTokenResponseDTO(RegUser user, String jwt) {
		super();
		this.user = user;
		this.jwt = jwt;
	}
	public LoginTokenResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegUser getUser() {
		return user;
	}
	public void setUser(RegUser user) {
		this.user = user;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	

}
