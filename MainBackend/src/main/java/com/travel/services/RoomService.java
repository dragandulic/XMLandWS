package com.travel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.travel.model.Room;
import com.travel.repositories.RoomRepository;





@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository; 
	
	
	public Room getRoomById(Long id) {
		
		Room room = roomRepository.findByIdEquals(id);
		
		return room;
		
	}
	
	
public Room saveRoom(Room r){
		
		Room room=roomRepository.save(r);
		return room;
		
	}
	
}