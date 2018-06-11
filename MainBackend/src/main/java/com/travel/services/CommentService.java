package com.travel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.model.Comment;
import com.travel.repositories.CommentRepository;







@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository; 
	
	
	public Comment getCommentById(Long id) {
		
		Comment comment = commentRepository.findByIdEquals(id);
		
		return comment;
		
	}
	
	
public Comment saveComment(Comment c){
		
		Comment com=commentRepository.save(c);
		return com;
		
	}

public List<Comment>getAllComments(){

	return commentRepository.findAll();
}


public void deleteComment(Comment c){
	
	
	 commentRepository.delete(c);
	
}

	
}