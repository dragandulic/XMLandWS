package com.travel.validation;


import com.travel.controller.RegUserController.dto.RegistrationDTO;

public class PasswordMatchesValidator   {

	
	public PasswordMatchesValidator(){
		
		
	}
	
	public boolean isValid(Object obj){   
        RegistrationDTO user =  (RegistrationDTO) obj;
        return user.getPassword1().equals(user.getPassword2());    
    }

	
	
}
