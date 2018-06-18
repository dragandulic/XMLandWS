package com.travel.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
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
	 @Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<RegUser> optionaluser=reguserRepository.findByEmail(username);
		RegUser opt=reguserRepository.findOneByEmail(username);
		
		
		
		
		
			optionaluser
			   .orElseThrow(()->new UsernameNotFoundException("Email not found"));
			return optionaluser
					.map(CustomUserDetails::new).get();
					
		
	
	}
	

	
	private org.springframework.security.core.userdetails.User createSpringSecurityUser(User user) {
    
		List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toList());
		
		
		
		
		
		
		
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthorities);
    }
	
	
	
	
	
	
	
	
	

}
