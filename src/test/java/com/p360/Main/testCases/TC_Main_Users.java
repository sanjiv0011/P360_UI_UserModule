package com.p360.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.p360.Main.pageObject.PO_Main_Home;
import com.p360.Main.pageObject.PO_Main_Users;
import com.p360.pageObject.PO_HomePage;
import com.p360.pageObject.PO_LoginPage;
import com.p360.pageObject.PO_MembershipPage;
import com.p360.testCases.BaseClass;

public class TC_Main_Users extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Main_Users() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;
	public PO_HomePage hp;
	public Faker faker  = new Faker();
	public PO_Main_Home mhp;
	public PO_Main_Users mu;
	
	//VARIABLES
	String firstName = faker.name().firstName();
	String lastName = faker.name().lastName();
	String phoneNumber = "1234567890";
	String emailAdd = faker.internet().emailAddress();
	String location = "WESTWOOD";
	String packageName = "westwood Categories (westwood)";
	String membershipName = "westwood packages One Time";
	String membershipStartDate = "12 September 2023";
	
	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException {
		lp = new PO_LoginPage(driver);
		mhp = lp.AdminLogin(adminEmail,adminPassword);
	}

	//TO MAIN HOME PAGE TAB TESTING
	@Test(priority = 2)
	public void test_Main_AddMember() throws InterruptedException {
		mu = callMeBeforePerformAnyAction();
		mhp = mu.addMember(firstName, lastName, phoneNumber, emailAdd, location, packageName, membershipName, membershipStartDate);
	}
	
	//TO LOGOUT
	@Test(priority = 10 , dependsOnMethods = "test_Login")	// here zero or ten ensures least priority, so that this call happens at the last.
	public void test_Logout() throws InterruptedException {	
		hp = mhp.clickOntabDashboardReturn_HomePage();
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_Users callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		mhp.clickOntabDashboard();
		mhp.clickOnTabUsers();
		Thread.sleep(5000);
		//TO MEMBERSHIP PAGE OBJECTS
		return new PO_Main_Users(driver);	
	}
	
}
