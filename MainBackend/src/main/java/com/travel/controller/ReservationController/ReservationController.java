package com.travel.controller.ReservationController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.controller.ReservationController.dto.ReservationDTO;
import com.travel.model.Reservation;
import com.travel.services.ReservationService;

@CrossOrigin(origins="http://localhost:4201",allowedHeaders="*")
@RestController
@RequestMapping(value="/reservation")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("/getAllReserOfRegU/{id}")
	public ResponseEntity<List<Reservation>> getAllReservOfRegU(@PathVariable Long id){
		
		List<Reservation> reservations = reservationService.getAllReserOfRegUser(id);
		
		if(reservations==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(reservations, HttpStatus.OK);
	}
	
	@PostMapping(value="/addReservation")
	public ResponseEntity<Reservation> addReservation(@RequestBody ReservationDTO reservation){
		
		Reservation reser = reservationService.addReser(reservation);
		
		if(reser==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(reser, HttpStatus.OK);
	}

}
