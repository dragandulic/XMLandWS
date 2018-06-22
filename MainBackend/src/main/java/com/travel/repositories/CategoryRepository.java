package com.travel.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.model.AccommodationType;
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

	
	@Query(value="SELECT a FROM Category a WHERE (a.accommodation.id)=(:accomid)")
	Category findCategoryByAccommodation(@Param("accomid")Long accomid);
	
	@Query(value="SELECT at FROM Category at WHERE (at.categoryname)=(:t) AND (at.accommodation.id)=(:id) ")
	Category findByCategorynameEqualsAndAccommodationEquals(@Param("t")String  t,@Param("id")Long id);
	
	
	
	
	
	
	
}








