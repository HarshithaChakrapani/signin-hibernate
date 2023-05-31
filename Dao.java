package com.login;
import java.util.List;

import javax.persistence.*;
public class Dao extends Scan {
		public static String mobile(String num)
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("magician");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			et.begin();
			Query q=em.createQuery("select e.mobileNo from SL e where e.mobileNo=?1");
			q.setParameter(1, num);
			List<String>li=q.getResultList();
			for(String r:li)
			{
			  return r;
			}
			et.commit();
			return null;
		}

		public static String password(String mNumber) {
			
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("magician");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			et.begin();
			Query q=em.createQuery("select e.password from SL e where e.mobileNo=?1 ");
			q.setParameter(1, mNumber);
			List<String>li=q.getResultList();
			for(String r:li)
			{
			  return r;
			}
		
			
			
			et.commit();
			return null;
		}
		
		
		
		static int i=0;

		public static void forgetPass(String mNumber) {
			
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("magician");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			System.out.println("enter the password");
			String newPass=sc.next();
			
			
			if(Validation.validatepass(newPass))
			{
				
				String old_password=Dao.password(mNumber);
				
				
				
				
				if(newPass.equals(old_password))
				{
					System.out.println("old password is matching \nplease enter new password");
					forgetPass(mNumber);
				}
				else {
					
					et.begin();
					Query q=em.createQuery("update SL e set e.password=?1 where e.mobileNo=?2");
				     q.setParameter(1, newPass);
				     q.setParameter(2, mNumber );
					i=q.executeUpdate();
					

					et.commit();
					
				
					if(i>0)
					{
						System.out.println("password succesfully updated");
//						System.out.println("welcome to login page");
						U_signin.sigin();
						
					}
					else
					{
						System.out.println("you password not succesfully  ");
						forgetPass(mNumber);
					}
					
				}
				
						
				
			}
			else
			{
//				System.out.println("password rules r not matched");
				System.out.println("password rules r not matched");
				forgetPass(mNumber);
			}

			
		
		}
		private static String old_password() {
			// TODO Auto-generated method stub
			
			
			return null;
		}



		static int c=0;

		public static int otp(String moNumber) {
			// TODO Auto-generated method stub
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("magician");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			et.begin();
			Query q = em.createQuery("SELECT e.otp FROM SL e WHERE e.mobileNo = :mobile");
			q.setParameter("mobile", moNumber); // Replace 'mobile' with the actual value or variable

			List<Integer> otpList = q.getResultList();
			for(Integer re: otpList)
			{
				c++;
				return re;
			}
			et.commit();
			if(c==0) {
				return 0;
			}
			return -1;
		
			
		}

		public static void readAllDats(int id) {
			// TODO Auto-generated method stub
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("magician");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			

				et.begin();
				Query q=em.createQuery("select e from SL e where e.id=?1");
				q.setParameter(1, id);
				List<SL>l=q.getResultList();
				for(SL a:l)
				{
					System.out.println(a.getId()+"\t"+a.getName()+"\t"+a.getMobileNo()+"\t"+a.getGmail());
					
				}
				
				et.commit();
				
			}

		public static int getId(String mNumber) {
			
					EntityManagerFactory emf=Persistence.createEntityManagerFactory("magician");
					EntityManager em=emf.createEntityManager();
					EntityTransaction et=em.getTransaction();
					

						et.begin();
						Query q=em.createQuery("select e.id from SL e where e.mobileNo=?1");
						q.setParameter(1, mNumber);
						List< Integer>li=q.getResultList();
						for(Integer r:li)
						{
							return r;
							
						}
						
			
			return 0;
		}
	  
		public static void deleteUserAccount(int id) {
			// TODO Auto-generated method stub
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("magician");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			try {

				et.begin();
				Query q=em.createQuery("delete from SL e where e.id=?1");
				q.setParameter(1, id);
				if(q!=null)
				{
				int i=q.executeUpdate();
				if(i!=0)
				{
					System.out.println("succesfullly remove data from table");
					
				}
				et.commit();
				}
			}
			catch (Exception e) {
				// TODO: handle exception
				if(et!=null && et.isActive())
				{
					et.rollback();
				}
			}
			finally {
				em.close();
			}
		
		}

		public static void update_Details(int id) {
			 String last=" where a.id=";
			// TODO Auto-generated method stub
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("magician");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();

			et.begin();
			String query=query(id);
			
			String out1=query+last+"'"+id+"'";
			
			StringBuilder sb = new StringBuilder(out1);
			
			char ch=',';
			int i = out1.lastIndexOf(ch);
			sb.deleteCharAt(i);
			System.out.println(sb);
		String res=""+sb;
			Query q1=em.createQuery(res);
			q1.executeUpdate();
			
			et.commit();
			

			
		}
		static String s="update SL a set ";
		static String c1="',";
		public static String query(int id1) {	

			System.out.println("enter 1. for name 2. mobile number 3.password  4.age  5. gender 6.gmail 7.for exist");
			int option=sc.nextInt();
			switch(option)
			{
			case 1:
				System.out.println("enter the name");
				String name1=sc.next();
				s+="a.name='"+name1+c1;
				
				query(id1);
				break;
			case 2:
				System.out.println("enter the mobile number");
				String mobile=sc.next();
				s+="a.number='"+mobile+c1;
				query(id1);
				break;
			case 3:
				System.out.println("enter the password");
				String password1=sc.next();
				s+="a.password='"+password1+c1;
				query(id1);
				break;
			case 4:
				System.out.println("enter the age");
				int age=sc.nextInt();
				s+="a.age='"+age+c1;
				query(id1);
				break;
			case 5:
				System.out.println("enter the gender");
				String g=sc.next();
				s+="a.gender='"+g+c1;
				query(id1);
				break;
			case 6:
				System.out.println();
				String gmail=sc.next();
				s+="a.gmail='"+gmail+c1;
				query(id1);
				break;
			case 7:
				break;
			
				
			}
			
			
//			s+=last;
//			System.out.println(s);
			
			
			return s;
		}


			
			
			
		

	}


