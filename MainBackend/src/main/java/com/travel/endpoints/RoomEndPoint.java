package com.travel.endpoints;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.concretepage.gs_ws.SetRoomStatusRequest;
import com.concretepage.gs_ws.SetRoomStatusResponse;
import com.travel.model.Room;
import com.travel.services.RoomService;


@Endpoint
public class RoomEndPoint {
	
	private static final String NAMESPACE_URI = "http://www.travel.com/room";
	
	@Autowired
	private RoomService roomService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "setRoomStatusRequest")
	@ResponsePayload
	public SetRoomStatusResponse getAdmin(@RequestPayload SetRoomStatusRequest request) {
		
		SetRoomStatusResponse response= new SetRoomStatusResponse();
		
		Room change = roomService.getRoomById(request.getRoomid());
		
		change.setFree(request.isFree());
		Room saved= roomService.saveRoom(change);
		
		response.setMessage("Successfully changed room status");
		
				
		return response;
	}
	

}
