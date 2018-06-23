package com.travel.controller.SearchController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.controller.SearchController.dto.AccommodationSearchDTO;
import com.travel.controller.SearchController.dto.SearchDTO;
import com.travel.model.Accommodation;
import com.travel.model.AdditionalServices;
import com.travel.services.AccommodationTypeService;
import com.travel.services.CategoryService;
import com.travel.services.FilterService;
import com.travel.services.SearchService;

@CrossOrigin(origins="http://localhost:4201",allowedHeaders="*")
@RestController
@RequestMapping(value="/search")
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@Autowired
	private FilterService filterService;
	
	@Autowired
	private AccommodationTypeService accommodationTypeService;
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/accommodations")
	public ResponseEntity<List<AccommodationSearchDTO>> search(@RequestBody SearchDTO searchReq){
		
		List<AccommodationSearchDTO> accommodations = searchService.searchAcc(searchReq);
		
		if(accommodations==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(accommodations,HttpStatus.OK);
	}
	
	
	@PostMapping("/filteservices")
	public ResponseEntity<List<AccommodationSearchDTO>> filterservices(@RequestBody SearchDTO searchDto){
		
		List<AccommodationSearchDTO> accommodations = filterService.filterservices(searchDto);
		
		if(accommodations==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(accommodations,HttpStatus.OK);
		
	}
	
	@GetMapping("/getservices")
	public ResponseEntity<List<String>> findallServices(){
		
		List<String> services = searchService.getAllServices();
		
		if(services==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(services,HttpStatus.OK);
	}
	
	@GetMapping("/gettypes")
	public ResponseEntity<List<String>> findallTypes(){
		
		List<String> services = accommodationTypeService.findDistinctTypes();
		
		if(services==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(services,HttpStatus.OK);
	}
	
	@GetMapping("/getcategorys")
	public ResponseEntity<List<String>> findallCategorys(){
		
		List<String> category = categoryService.findDistinctCategory();
		
		if(category==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(category,HttpStatus.OK);
	}
	
	
	@PostMapping("/sortcategory")
	public ResponseEntity<List<AccommodationSearchDTO>> sortcategory(@RequestBody SearchDTO searchDto){
		
		List<AccommodationSearchDTO> accommodation = new ArrayList<>();
		if(searchDto.getSortA().equals("category")) {
			accommodation.addAll(filterService.sortAccCategory(searchDto));
		}
		else if(searchDto.getSortA().equals("rating")) {
			List<AccommodationSearchDTO> accommodation2 = filterService.sortAccRating(searchDto);
			if(accommodation2!=null) {
				accommodation.addAll(accommodation2);
			}
		}
		else if(searchDto.getSortA().equals("Pricea")) {
			List<AccommodationSearchDTO> accommodation2 = filterService.sortAccPriceA(searchDto);
			if(accommodation2!=null) {
				accommodation.addAll(accommodation2);
			}
		}
		else if(searchDto.getSortA().equals("Priced")) {
			List<AccommodationSearchDTO> accommodation2 = filterService.sortAccPriceD(searchDto);
			if(accommodation2!=null) {
				accommodation.addAll(accommodation2);
			}
		}
		
		
		if(accommodation==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(accommodation,HttpStatus.OK);
	}
	
}
