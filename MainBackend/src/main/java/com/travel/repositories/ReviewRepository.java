package com.travel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.model.AccommodationType;
import com.travel.model.Review;



@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	Review findByIdEquals(Long id);
	List<Review> findAll();
	
	@Query(value="SELECT r FROM Review r WHERE r.comment.approved=false")
	List<Review> findReviewsWithUnApprovedComments();
	
}