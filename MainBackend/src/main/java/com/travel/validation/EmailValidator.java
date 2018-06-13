package com.travel.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
	
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	

		@Override
		public boolean isValid(String emailStr, ConstraintValidatorContext context) {
			// TODO Auto-generated method stub
			Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
			
	        if(matcher.find()==true){
	        	return true;
	        }
	        else{
	        	return false;
	        }
		}

}
