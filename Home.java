package com.login;

public class Home extends Scan{
	public static void homePage(String mNumber) {
		// TODO Auto-generated method stub
		
		int Id=Dao.getId(mNumber);
		System.out.println("1.for all user details  2.for update the user details  3.for delete the user account   4.logout");
		
//		try {
		int option =sc.nextInt();
		switch (option) {
		
		case 1:
			Dao.readAllDats(Id);
			homePage(mNumber);
			
			break;
			
		case 2:
			Dao.update_Details(Id);
			homePage(mNumber);
			break;
		
		case 3:
			Dao.deleteUserAccount(Id);
			System.out.println("you account deleted succesfully");
			
		case 4:
			System.out.println("succesfully logOut");
			break;
			

		default:
			System.out.println("select correct option 1,2,,3,4");
			break;
		}

}

}
