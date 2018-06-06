package com.travel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.model.Review;



@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	Review findByIdEquals(Long id);
	
}