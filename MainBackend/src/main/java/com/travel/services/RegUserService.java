package com.travel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travel.model.RegUser;
import com.travel.repositories.RegUserRepository;

@Service
public class RegUserService {

	@Autowired
	private RegUserRepository regUserRepository;
	
	public RegUser getRegUserById(Long id) {
		
		RegUser regUser = regUserRepository.findByIdEquals(id);
		
		return regUser;
	}
	
	
     public RegUser saveRegUser(RegUser ru){
		
		RegUser reg=regUserRepository.save(ru);
		return reg;
		
	}
     
     
     public void deleteRegUser(RegUser r){
    	 
    	 regUserRepository.delete(r);
     }
     
     public List<RegUser>getAllUsers(){

    		return regUserRepository.findAll();
    	}
     
     
 	public boolean checkUniqueEmail(String email) {
		if (regUserRepository.findOneByEmail(email) != null) {
			return false;
		}
		return true;
	}
 	
 	public RegUser findOneUserByEmail(String email) {
		return regUserRepository.findOneByEmail(email);
	}
     
     
}
