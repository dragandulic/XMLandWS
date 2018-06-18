package com.travel.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.travel.model.CustomUserDetails;
import com.travel.model.RegUser;
import com.travel.repositories.RegUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	
	
	@Autowired
	private RegUserRepository reguserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<RegUser> optionaluser=reguserRepository.findByEmail(username);
		RegUser opt=reguserRepository.findOneByEmail(username);
		if(opt==null){
			throw new UsernameNotFoundException("Email not found");
		}
		
		System.out.println(opt.getEmail());
		
		/*
			optionaluser
			   .orElseThrow(()->new UsernameNotFoundException("Email not found"));
			return optionaluser
					.map(CustomUserDetails::new).get();
					*/
		
		return new CustomUserDetails(opt);
	}

}
