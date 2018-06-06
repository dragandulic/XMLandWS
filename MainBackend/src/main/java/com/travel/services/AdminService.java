package com.travel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.model.Admin;
import com.travel.repositories.AdminRepository;



@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository; 
	
	
	public Admin getAdminById(Long id) {
		
		Admin admin = adminRepository.findByIdEquals(id);
		
		return admin;
		
	}
	
}
