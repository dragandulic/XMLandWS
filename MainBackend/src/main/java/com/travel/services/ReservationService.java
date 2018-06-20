package com.travel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.controller.ReservationController.dto.ReservationDTO;
import com.travel.model.RegUser;
import com.travel.model.Reservation;
import com.travel.model.Room;
import com.travel.repositories.RegUserRepository;
import com.travel.repositories.ReservationRepository;
import com.travel.repositories.RoomRepository;


@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository; 
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private RegUserRepository regUserRepository;
	
	
	public Reservation getReservationById(Long id) {
		
		Reservation res = reservationRepository.findByIdEquals(id);
		
		return res;
		
	}
	
	
	public Reservation saveReservation(Reservation r){
		
		Reservation re=reservationRepository.save(r);
		
		return re;
		
	}

	public List<Reservation> getAllReservations(){

	return reservationRepository.findAll();
	
	}


	public List<Reservation> getAllReserOfRegUser(Long id){
		
		List<Reservation> reservations = reservationRepository.findByRegUser_idEquals(id);
		
		return reservations;
	}
	
	public Reservation addReser(ReservationDTO reservation) {
		
		Reservation reser = new Reservation();
		reser.setPrice(reservation.getPrice());
		reser.setStartDate(reservation.getStart_date());
		reser.setEndDate(reservation.getEnd_date());
		reser.setName(reservation.getName());
		reser.setSurname(reservation.getSurname());
		reser.setEmail(reservation.getEmail());
		
		Room room = roomRepository.findByIdEquals(reservation.getRoom_id());		
		room.setFree(false);				
		reser.setRoom(room);
		
		RegUser reguser = regUserRepository.findByIdEquals(reservation.getRegUser());
		reser.setRegUser(reguser);
		
		return reservationRepository.save(reser);
	}
	
	

	
}