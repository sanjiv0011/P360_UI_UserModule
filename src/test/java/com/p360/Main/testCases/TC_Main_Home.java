package com.p360.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.p360.Main.PageObject.PO_Main_HomePage;
import com.p360.User.pageObject.PO_HomePage;
import com.p360.User.pageObject.PO_LoginPage;
import com.p360.testCases.BaseClass;

public class TC_Main_Home extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Main_Home() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;
	public PO_HomePage hp;
	public Faker faker  = new Faker();
	public PO_Main_HomePage mhp;
	
	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException {
		lp = new PO_LoginPage(driver);
		hp = lp.Login(email,password);
	}

	//TO MAIN HOME PAGE TAB TESTING
	@Test(priority = 3)
	public void test_MainHomePageTabTesting() throws InterruptedException {
		mhp.mainHomePageTesting();
	}
	
	//TO LOGOUT
	@Test(priority = 10 , dependsOnMethods = "test_Login")	// here zero or ten ensures least priority, so that this call happens at the last.
	public void test_Logout() throws InterruptedException {	
		hp.Logout();
	}
	
}
