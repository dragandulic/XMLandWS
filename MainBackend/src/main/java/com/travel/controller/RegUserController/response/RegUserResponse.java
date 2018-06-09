package com.travel.controller.RegUserController.response;



import java.util.List;

import com.travel.model.RegUser;





public class RegUserResponse {

	private List<RegUser>users;
	
	
	
	public RegUserResponse(List<RegUser>r){
		
		this.users=r;
	}
	
	
}


