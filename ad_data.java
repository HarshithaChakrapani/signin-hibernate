package com.login;

public class ad_data extends Scan {
	 static int c=3;

		public static void pass(String mNumber) {
			
			System.out.println("enter password");
			String password=sc.next();
			String old_password=Dao.password(mNumber);
			System.out.println(password);
			if(password.equals(old_password))
			{
				System.out.println("valid password");
				System.out.println("succesfully login to page");
				
				Home.homePage(mNumber);	
			}
			
			else if(c<=0)
			{
				System.out.println("forget the pssword");
				
				
				String mobileNumber=forget_mobile();
				
		         forget_otp(mobileNumber);
					
			}
			else
			{
				c--;
				System.out.println(c+"\t more attepmt    invalid password \t please enter valid password");
				pass(mNumber);
			}
			
		}

		private static void forget_otp(String mobileNumber) {
		
			System.out.println("enter the otp");
			int new_otp=sc.nextInt();
		int otp=Dao.otp(mobileNumber);
		System.out.println(new_otp);
			System.out.println(otp);
		if(otp==new_otp)
			{
				Dao.forgetPass(mobileNumber);
			} 
			else
			{
				System.out.println("please enter valid otp ");
				forget_otp(mobileNumber);
			}
			
			
			
		}

		public static String forget_mobile() {
			
			System.out.println("enter the mobile number ");
			String mobileNumber=sc.next();
			
			if(Validation.validateMobileNumber(mobileNumber))
		{
			String db_mobileNumber=Dao.mobile(mobileNumber);

			if(mobileNumber.equals(db_mobileNumber))
			{
				System.out.println(" valid mobile number");
				return mobileNumber;
				
				
			}
			else
			{
				System.out.println("invalid mobile number enter valid mobile number");
				forget_mobile();
			}
				
		}
			else
			{
				System.out.println("please enter the 10 digt number and start with 9,8,7,6");
				forget_mobile();
			}
			return null;
			
			
		}


}
