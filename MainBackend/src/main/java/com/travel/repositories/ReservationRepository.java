package com.travel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.model.Reservation;
import com.travel.model.Review;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	Reservation findByIdEquals(Long id);
	
	List<Reservation> findAll();
	
	List<Reservation> findByRegUser_idEquals(Long id);
	
	

	@Query(value="SELECT r FROM Reservation r WHERE  (r.accommodation.agent.id)=(:agentid)")
	List<Reservation> findReservationsByAgent(@Param("agentid")Long agentid);
	
	
	
	
}