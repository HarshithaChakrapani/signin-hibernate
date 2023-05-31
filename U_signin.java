package com.login;
import java.util.*;


public class U_signin extends  MobileValidation {
	public static void sigin()
	{
		System.out.println("welcome to login page");
		MobileValidation.Validate();
		
	}
}
	
	  class MobileValidation extends Scan
	{
		static int c=0;
		public static void Validate() {
			System.out.println("enter the mobile number");
			
			
			String mNumber=sc.next();
			
			String old_mobile=Dao.mobile(mNumber);
			if(mNumber.equals(old_mobile))
			{
				System.out.println("valid mobile number");
				
				
				ad_data.pass(mNumber);
				
			}
			else if(c>=3)
			{
				System.out.println("you mobile number is not exit please signup again");
			    U_details.userDetails();
			}
			else
			{ 
			    c++;
				System.out.println(c+" "+"mobile number is not exits");
				Validate();
			}
			
		}


	}

