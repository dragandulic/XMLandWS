package com.travel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.model.Category;
import com.travel.repositories.CategoryRepository;








@Service
public class CategoryService {

	@Autowired
	private CategoryRepository cRepository; 
	
	
	public Category getAccommodationTypeById(Long id) {
		
		 Category c= cRepository.findByIdEquals(id);
		
		return c;
		
	}
	
	
public  Category saveCategory( Category at){
		
	 Category cat= cRepository.save(at);
		return cat;
		
	}

public List<Category>getAllCategory(){

	return  cRepository.findAll();
}

public List<String>findDistinctCategory(){
	
	return  cRepository.findCategoryNames();
}

public void deleteCategory(String name){
	
	 cRepository.deleteCategory(name);
}


	
}