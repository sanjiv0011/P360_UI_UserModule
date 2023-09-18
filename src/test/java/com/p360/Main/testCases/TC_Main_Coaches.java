package com.p360.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.p360.Main.pageObject.PO_Main_CoachesPage;
import com.p360.Main.pageObject.PO_Main_HomePage;
import com.p360.pageObject.PO_HomePage;
import com.p360.pageObject.PO_LoginPage;
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

	//TO ADD CLASS
	@Test(priority = 2)
	public void test_Main_InviteCoaches() throws InterruptedException {
		mCoachesP = callMeBeforePerformAnyAction();
		mhp = mCoachesP.inviteCoach(firstName,lastName, email, coachLocation);
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
