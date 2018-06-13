package com.travel.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
	
	
	public static final Pattern VALID_PASSWORD_REGEX = 
		    Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", Pattern.CASE_INSENSITIVE);

		

		@Override
		public boolean isValid(String password, ConstraintValidatorContext arg1) {
			// TODO Auto-generated method stub
			 Matcher matcher = VALID_PASSWORD_REGEX .matcher(password);
			 
			 if(matcher.find()){
				 
				 return true;
			 }else{
				 
				 return false;
			 }
		        
		}

         /* 
		      EXPLANATION
		^                 # start-of-string
		(?=.*[0-9])       # a digit must occur at least once
		(?=.*[a-z])       # a lower case letter must occur at least once
		(?=.*[A-Z])       # an upper case letter must occur at least once
		(?=.*[@#$%^&+=])  # a special character must occur at least once
		(?=\S+$)          # no whitespace allowed in the entire string
		.{8,}             # anything, at least eight places though
		$                 # end-of-string
		
		*/
		
}
