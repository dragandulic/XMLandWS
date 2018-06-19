package com.travel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.model.Admin;
import com.travel.model.RegUser;
import com.travel.repositories.AdminRepository;



@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository; 
	
	
	public Admin getAdminById(Long id) {
		
		Admin admin = adminRepository.findByIdEquals(id);
		
		return admin;
		
	}
	
	
	
	
	public boolean checkUniqueEmail(String email) {
		if (adminRepository.findOneByEmail(email) != null) {
			return false;
		}
		return true;
	}
 	
 	public Admin findOneAdminByEmail(String email) {
		return adminRepository.findOneByEmail(email);
	}
	
}
