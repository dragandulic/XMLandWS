package com.travel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.model.Comment;



@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	Comment findByIdEquals(Long id);
	
}
