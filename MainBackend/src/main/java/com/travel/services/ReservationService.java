package com.travel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.model.Reservation;
import com.travel.repositories.ReservationRepository;








@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository; 
	
	
	public Reservation getReservationById(Long id) {
		
		Reservation res = reservationRepository.findByIdEquals(id);
		
		return res;
		
	}
	
	
public Reservation saveReservation(Reservation r){
		
		Reservation re=reservationRepository.save(r);
		return re;
		
	}

public List<Reservation>getAllReservations(){

	return reservationRepository.findAll();
}




	
}