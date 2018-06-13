package com.travel.controller.RegUserController.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.travel.validation.ValidEmail;
import com.travel.validation.ValidPassword;

public class RegistrationDTO {
	
	@NotNull
	@NotEmpty
	@ValidPassword
	private String password1;
	
	@NotNull
	@NotEmpty
	@ValidPassword
    private String password2;
	
	@NotNull
	@NotEmpty
	@ValidEmail
    private String email;
	
	@NotNull
	@NotEmpty
    private String name;
	
	@NotNull
	@NotEmpty
    private String surname;
	
	@NotNull
	@NotEmpty
    private String address;
    
    
    
    public RegistrationDTO(){

    }
    
    
    
    
    
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	
    
    
    
    
    
	
	

}
