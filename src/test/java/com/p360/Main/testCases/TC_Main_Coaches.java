package com.p360.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.p360.Main.pageObject.PO_Main_ClassesPage;
import com.p360.Main.pageObject.PO_Main_CoachesPage;
import com.p360.Main.pageObject.PO_Main_HomePage;
import com.p360.Main.pageObject.PO_Main_Locations;
import com.p360.Main.pageObject.PO_Main_PackagesPage;
import com.p360.Main.pageObject.PO_Main_UsersPage;
import com.p360.pageObject.PO_HomePage;
import com.p360.pageObject.PO_LoginPage;
import com.p360.pageObject.PO_MembershipPage;
import com.p360.testCases.BaseClass;

public class TC_Main_Coaches extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Main_Coaches() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;	//lp = LOGIN PAGE
	public PO_HomePage hp;	//hp = HOME PAGE
	public Faker faker  = new Faker();
	public PO_Main_HomePage mhp;	//mhp = MAIN HOME PAGE
	public PO_Main_CoachesPage mCoachesP; //mlp = MAIN LOCATION PAGE
	
	//VARIABLES TO CREATE CLASS
	String firstName = faker.name().firstName();
	String lastName = faker.name().lastName();
	String email = faker.internet().emailAddress();
	String coachLocation = "Westwood";

	
	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException {
		lp = new PO_LoginPage(driver);
		mhp = lp.AdminLogin(adminEmail,adminPassword);
	}

	//TO ADD CLASS
	@Test(priority = 2)
	public void test_Main_InviteCoaches() throws InterruptedException {
		mCoachesP = callMeBeforePerformAnyAction();
		mhp = mCoachesP.inviteCoach(firstName,lastName, email, coachLocation);
	}
	
	//TO LOGOUT
	@Test(priority = 10 , dependsOnMethods = "test_Login")	// here zero or ten ensures least priority, so that this call happens at the last.
	public void test_Logout() throws InterruptedException {	
		hp = mhp.clickOntabDashboardReturn_HomePage();
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_CoachesPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		mhp.clickOntabDashboard();
		mhp.clickOntabCoaches();
		Thread.sleep(5000);
		return new PO_Main_CoachesPage(driver);	
	}
	
}
