package com.login;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class a_data extends Scan {

	public static void option() {
			
			System.out.println("1.for sinin   2.login");
			
			
				
				int op=sc.nextInt();
			switch (op) {
			case 1:
				System.out.println("welcome to sinin page");
				
				U_details.userDetails();
				System.out.println("suceesfully registered");
			
				U_signin.sigin();
				
				
				break;
			case 2:
			
				U_signin i=new U_signin();
				i.sigin();
				break;
			default:
				System.out.println("select valid option i.e 1  or 2");
				option();
			    	break;
			 }
		}
	
	
}
