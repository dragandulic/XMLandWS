package com.travel.endpoints;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.concretepage.gs_ws.GetAdminByIdRequest;
import com.concretepage.gs_ws.GetAdminByIdResponse;
import com.travel.services.AdminService;



@Endpoint
public class AdminEndpoint {
	private static final String NAMESPACE_URI = "http://www.travel.com/admin";
	
	@Autowired
	private AdminService adminService;	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAdminByIdRequest")
	@ResponsePayload
	public GetAdminByIdResponse getAdmin(@RequestPayload GetAdminByIdRequest request) {
		GetAdminByIdResponse response = new GetAdminByIdResponse();
		BeanUtils.copyProperties(adminService.getAdminById(request.getAdminId()), response);
		return response;
	}
}







