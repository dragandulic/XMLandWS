package com.travel.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.travel.model.Category;








@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	
	Category findByIdEquals(Long id);
	List<Category> findAll();
	@Query("SELECT DISTINCT a.categoryname FROM Category a")
	List<String> findCategoryNames();
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM Category a WHERE a.categoryname=?1")
	void deleteCategory(String cname);

	
	
}