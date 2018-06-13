package com.travel.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.travel.controller.RegUserController.dto.RegistrationDTO;
import com.travel.error.UserAlreadyExistsException;
import com.travel.model.RegUser;
import com.travel.repositories.RegUserRepository;


@Service
public class RegUserService {

	@Autowired
	private RegUserRepository regUserRepository;
	
	
	private BCryptPasswordEncoder passwordEncoder;

	
	
	public RegUser getRegUserById(Long id) {
		
		RegUser regUser = regUserRepository.findByIdEquals(id);
		
		return regUser;
	}
	
	
	public RegUser registerNewUserAccount(RegistrationDTO userDTO){
		
		
		RegUser newuser=new RegUser();
		newuser.setName(userDTO.getName());
		newuser.setSurname(userDTO.getSurname());
		newuser.setEmail(userDTO.getEmail());
		newuser.setAddress(userDTO.getAddress());
		//newuser.setPassword(passwordEncoder.encode(userDTO.getPassword1()));
		newuser.setPassword((userDTO.getPassword1()));
		
		RegUser saved=saveRegUser(newuser);
		
		return saved;
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
     
 	 public RegUser findByConfirmationToken(String confirmationToken){
     	
     	return regUserRepository.findByConfirmationtoken(confirmationToken);
     }
 	
     
}
