package com.travel.controller.AdditionalServicesController.response;

import java.util.List;







public class AdditionalServicesResponse {

	private List<String>services;
	
	
	
	public AdditionalServicesResponse(List<String>serv){
		
		this.services=serv;
	}



	public List<String> getServices() {
		return services;
	}



	public void setServices(List<String> services) {
		this.services = services;
	}
	
	
}


