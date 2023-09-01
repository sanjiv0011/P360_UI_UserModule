package com.p360.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.p360.ReUseAble.PageObject.ReUseAbleElement;
import com.p360.pageObject.PO_HomePage;
import com.p360.pageObject.PO_LoginPage;
import com.p360.pageObject.PO_MembershipPage;

public class TC_Membership extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Membership() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;
	public PO_HomePage hp;
	public Faker faker  = new Faker();
	public PO_MembershipPage mp;
	public ReUseAbleElement ruae;
	
	String categoryName = "All";
	String packageName = "Alaska";
	String radioButton = "Custom Date";
	
	//PASS THE ALL THE DATE IN THE GIVEN FORMAT
	String membershipDate = "15 September 2023";
	String pauseStartDate = "10 September 2023";
	String pauseEndDate = "25 September 2023";
	String pauseReason = "Travel"; //"Other" and "Medical Reason"
	
	
	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException {
		lp = new PO_LoginPage(driver);
		hp = lp.Login(email,password);
	}
	
	//TO CHANGE MEMBERSHIP
	@Test(priority = 2 , dependsOnMethods = "test_Login")
	public void test_ChangeMembership() throws InterruptedException {
		mp = callMeBeforePerformAnyAction();
		hp = mp.changeMembership(categoryName,packageName,radioButton, membershipDate);
	}
	
	//TO CHECK AGREED TERMS OF MEMBERSHIP
	//@Test(priority = 3 , dependsOnMethods = "test_Login")
	public void test_CheckAgreedTerms() throws InterruptedException {
		mp = callMeBeforePerformAnyAction();
		hp = mp.checkAgreedTerm();
	}
	
	
	//TO PAUSE MEMBERSHIP
	//@Test(priority = 4 ,dependsOnMethods = "test_Login")
	public void test_PauseMembership() throws InterruptedException {
		mp = callMeBeforePerformAnyAction();
		hp = mp.pasueMembership(pauseStartDate, pauseEndDate, pauseReason);
	}
	
	//TO RESUME MEMBERSHIP
	//@Test(priority = 5 ,dependsOnMethods = "test_Login")
	public void test_ResumeMembership() throws InterruptedException {
		mp = callMeBeforePerformAnyAction();
		hp = mp.resumeMembership();
	}
		
	
	//TO LOGOUT
	@Test(priority = 10 , dependsOnMethods = "test_Login")	// here zero or ten ensures least priority, so that this call happens at the last.
	public void test_Logout() throws InterruptedException {	
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_MembershipPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		hp.clickMenuDashBoard_RU(); //MOVE THE DRIVER ON THE HOME PAGE
		hp.clickMenuMembership();	//MOVE THE DRIVER ON THE MEMBERSHIP PAGE
		Thread.sleep(2000);
		//TO MEMBERSHIP PAGE OBJECTS
		return new PO_MembershipPage(driver);	
	}
	
}
