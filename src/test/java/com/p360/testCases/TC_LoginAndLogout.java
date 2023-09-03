package com.p360.testCases;

import org.testng.annotations.Test;

import com.p360.User.pageObject.PO_HomePage;
import com.p360.User.pageObject.PO_LoginPage;

public class TC_LoginAndLogout extends TC_Login{

	//TC_Logout CONSTRUCTOR
	public TC_LoginAndLogout(){
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;
	public PO_HomePage hp;
	
	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException {
		lp = new PO_LoginPage(driver);
		hp = lp.Login(email,password);
	}
	
	//TO LOGOUT
	@Test(priority = 10)	// here zero or ten ensures least priority, so that this call happens at the last.
	public void test_Logout() throws InterruptedException {	
		hp.Logout();
	}

}
