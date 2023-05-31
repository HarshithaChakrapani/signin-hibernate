package com.login;
import java.util.*;
import javax.persistence.*;
class Scan{
	static Scanner sc=new Scanner(System.in);
	static Validation v=new Validation();
	static SL r=new SL();
	}


public class U_details extends Scan {
	
	public static void userDetails() {
		
		enter_id();
		enter_name();
		enter_password();
		enter_number();
		enter_gmail();
			
		System.out.println("enter the age");
		int age=sc.nextInt();
		r.setAge(age);
		
		System.out.println(" enter the gender");
		String gender=sc.next();
		r.setGender(gender);
		
		
		
		System.out.println("enter the otp");
		int otp=sc.nextInt();
		r.setOtp(otp);
		
		
			
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("magician");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		

		et.begin();
	    em.persist(r);
	    
		et.commit();
		
		
		
		
	}
	public static void enter_gmail() {
		System.out.println("enter the gmail");
		String gmail=sc.next();
		v.validateGmail(gmail);
		r.setGmail(gmail);
		
	}

	public static void enter_number() {
		
		System.out.println("enter number");
		String number=sc.next();
		try {
			if(v.validateMobileNumber(number)) {
				System.out.println("valid mobile number pattern");
				r.setMobileNo(number);
			}
			else {
				System.out.println("please enter the 10 digt number and start with 9,8,7,6 ");
				enter_number();
			}
		
		}
		catch(Exception e){
			e.printStackTrace();
			enter_number();
		}
		
	
		
	}

	public static void enter_password() {

		System.out.println("enter password");
		String password=sc.next();
		if(v.validatepass(password)) {
			System.out.println("valid password pattern");
			r.setPassword(password);
		}
		else
		{
			System.out.println("password contain atleast one uppercase, one lowercase, number,symbal and length should be more then 4 charecters ");
		enter_password();
		}
		
			
	}

	public static void enter_name() {
		
		System.out.println("enter name");
		String name=sc.next();
		v.validate(name);
		r.setName(name);
	}

	public static void enter_id() {
		
		System.out.println("enter id");
		int id=sc.nextInt();
		v.validate(id);
		r.setId(id);
		
		
	}




}
