package com.travel.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.travel.controller.RegUserController.dto.RegistrationDTO;
import com.travel.error.UserAlreadyExistsException;
import com.travel.model.RegUser;
import com.travel.repositories.RegUserRepository;


@Service
public class RegUserService {

	@Autowired
	private RegUserRepository regUserRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JavaMailSender sender;

	
	
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
		newuser.setPassword(passwordEncoder.encode(userDTO.getPassword1()));
		//newuser.setPassword((userDTO.getPassword1()));
		/*
		newuser.setConfirmationToken(UUID.randomUUID().toString());
		//user.setPoints(0);
		
		String appUrl = "http://localhost:4200/confirmEmail/";//request.getScheme() + "://" + request.getServerName();
		SimpleMailMessage registrationEmail=new SimpleMailMessage();
		registrationEmail.setTo(newuser.getEmail());
		registrationEmail.setSubject("Registration Confirmation");
		registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
		+appUrl+ newuser.getConfirmationToken());
		emailService.sendEmail(registrationEmail);
		
		
		
		*/
		
		
		
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
