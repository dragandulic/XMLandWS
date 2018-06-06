package com.travel.endpoints;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.concretepage.gs_ws.GetAdminByIdRequest;
import com.concretepage.gs_ws.GetAdminByIdResponse;
import com.concretepage.gs_ws.GetRegUserByIdRequest;
import com.concretepage.gs_ws.GetRegUserByIdResponse;
import com.travel.services.AdminService;
import com.travel.services.RegUserService;

@Endpoint
public class RegUserEndpoint {

private static final String NAMESPACE_URI = "http://www.travel.com/reguser";
	
	@Autowired
	private RegUserService regUserService;	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRegUserByIdRequest")
	@ResponsePayload
	public GetRegUserByIdResponse getAdmin(@RequestPayload GetRegUserByIdRequest request) {
		GetRegUserByIdResponse response = new GetRegUserByIdResponse();
		BeanUtils.copyProperties(regUserService.getRegUserById(request.getRegUserId()), response);
		return response;
	}
}
