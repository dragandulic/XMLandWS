package com.travel.controller.SearchController;

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

import com.travel.controller.SearchController.dto.SearchDTO;
import com.travel.model.Accommodation;
import com.travel.model.AdditionalServices;
import com.travel.services.SearchService;

@CrossOrigin(origins="http://localhost:4201",allowedHeaders="*")
@RestController
@RequestMapping(value="/search")
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	
	
	@PostMapping("/accommodations")
	public ResponseEntity<List<Accommodation>> search(@RequestBody SearchDTO searchReq){
		
		List<Accommodation> accommodations = searchService.searchAcc(searchReq);
		
		if(accommodations==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(accommodations,HttpStatus.OK);
	}
	
	
	@PostMapping("/filteservices")
	public ResponseEntity<List<Accommodation>> filterservices(@RequestBody SearchDTO searchDto){
		
		List<Accommodation> accommodations = searchService.filterservices(searchDto);
		
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
	

}
