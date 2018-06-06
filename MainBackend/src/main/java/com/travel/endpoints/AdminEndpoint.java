package com.travel.endpoints;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.concretepage.gs_ws.GetAdminByIdRequest;
import com.travel.model.Admin;
import com.travel.services.AdminService;



@Endpoint
public class AdminEndpoint {
	private static final String NAMESPACE_URI = "http://www.travel.com/admin";
	
	@Autowired
	private AdminService adminService;	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAdminById")
	@ResponsePayload
	public Admin getAdmin(@RequestPayload GetAdminByIdRequest request) {
		Admin response = new Admin();
		response = adminService.getAdminById(request.getAdminId());
		return response;
	}
}
