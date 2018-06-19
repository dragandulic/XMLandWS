package com.travel.controller.CommentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.annotation.JsonValue;
import com.travel.controller.AgentController.response.MessageResponse;
import com.travel.controller.CommentController.Response.CommentResponse;
import com.travel.model.Comment;
import com.travel.services.CommentService;



@RestController
@RequestMapping("/comment")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class CommentController {
	
	
	@Autowired
	private CommentService commentService;
	
	
	    @JsonValue
		@GetMapping("/getComments")
		public CommentResponse getComments(){
			
			List<Comment>listac=commentService.getAllComments();
			return new CommentResponse(listac);
			
		}
	    
	    
	    @PostMapping("/addComment/{comment}")
	    public MessageResponse addComment(@PathVariable String comment){
	    	
	    	Comment c=new Comment();
	    	c.setApproved(false);
	    	c.setContent(comment);
	    	Comment saved=commentService.saveComment(c);
	    	
	    	
	    	return new MessageResponse("Successfully added comment");
	    }
	    	
	    	
	    

}