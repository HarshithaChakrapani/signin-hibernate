package com.login;

import java.util.*;
import java.util.regex.Pattern;

public class Validation {
	
	public static void validate(int id) {
		if(String.valueOf(id).length()==5)
		{
			System.out.println("valid id");
		}
		else
		{
			System.out.println("enter the 5 digit id");
			U_details.enter_id();
			
		}

	}
	
	public void validate(String name) {
		// TODO Auto-generated method stub
		if(name.equals(name.toUpperCase()))
		{		
			System.out.println("u entered valid format");
		}
		else
		{
			System.out.println("please enter the name uppercase format only");
		U_details.enter_name();
		}
	}
	
	public static boolean validatepass(String password)
	{
	
			// TODO Auto-generated method stub
			if(password.length()<5)
			{
//				System.out.println("re-enter the password");
				return false;
				
			}
			if(!password.matches(".*[a-z].*"))
			{
//				System.out.println("re-enter the password");
				return false;
				
			}
			if(!password.matches(".*[A-Z].*"))
				
			{
//				System.out.println("re-enter the password");
				return false;
			}
			if(!password.matches(".*[!@#$%^&*()'',.{}?/|].*"))
	       { 
//				System.out.println("re-enter the password");
				return false;
				
	        }
			
			else
				return true;
		}

	
		
	    
		public static boolean validateMobileNumber(String number) 
		{
			String MOBILE_NUMBER_PATTERN = "^[9|8|7|6]\\d{9}$";
			
		       return Pattern.matches(MOBILE_NUMBER_PATTERN, number);
		    }

		public void validateGmail(String gmail) {
			// TODO Auto-generated method stub
			if(gmail.endsWith("@gmail.com"))
			{
				if(gmail.length()>10)
				{
					System.out.println("vaid gmail");
				}
				else
				{
					System.out.println("invalid gmail format");
				}
			}
			else
			{
				System.out.println("gmail ends with @gmail.com");
				U_details.enter_gmail();
			}
			
		}
		
		}
	

	
	
	
	

	
	

