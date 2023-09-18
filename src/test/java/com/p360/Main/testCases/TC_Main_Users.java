package com.p360.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.p360.Main.pageObject.PO_Main_HomePage;
import com.p360.Main.pageObject.PO_Main_UsersPage;
import com.p360.pageObject.PO_HomePage;
import com.p360.pageObject.PO_LoginPage;
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
	public PO_Main_HomePage m_hp;
	public PO_Main_UsersPage m_up;
	
	//VARIABLES
	String firstName = "OTPUser";
	String lastName = faker.name().lastName();
	String phoneNumber = "1234567890";
	String emailAdd = faker.internet().emailAddress();
	String location = "WESTWOOD";
	String packageName = "westwood Categories (westwood)";
	String membershipName = "Westwood Packages One Time";
	String membershipStartDate = "20 September 2023";
	
	//TO SEARCH USER AND VIEW DETAILS
	String searchKeyuserNameOrEmail = "SUSAN5 DAVIS5";
	String regionName = "WESTWOOD";
	boolean wantToClickOnUser = true;
	int listActionIndex = 1;
	int searcKeyColumnIndex = 1;
	
	//TO PAUSE MEMBERSHIP
	String pauseStartDate = "20 September 2023";
	String pauseEndDate = "30 September 2023";
	String pauseReason = "Travel";
	
	//TO CHANGE EMAIL
	String confirmNewEmail = "susandavis6@yopmail.com";
	String newEmail = "susandavis6@yopmail.com";
	

	//TO ADD MEMBER
	//@Test(priority = 1)
	public void test_Main_AddMember() throws Throwable {
		m_up = callMeBeforePerformAnyAction();
		m_hp = m_up.addMember(firstName, lastName, phoneNumber, emailAdd, location, packageName, membershipName, membershipStartDate);
	}
	
	
	
	//TO PAUSE THE USERS MEMBERSHIP
	//@Test(priority = 3)
	public void test_Main_PauseMembership() throws Throwable {
		searchAndViewUsersDetails();
		m_hp = m_up.pauseMembership(pauseStartDate, pauseEndDate, pauseReason);
	}
	
	
	//TO PAUSE THE USERS MEMBERSHIP
	//@Test(priority = 4)
	public void test_Main_ResumeMembership() throws Throwable {
		searchAndViewUsersDetails();
		m_hp = m_up.resumeMembership();
	}
	
	//TO VIEW AGREED TERMS AND CONDITIONS
	@Test(priority = 5)
	public void test_Main_ViewAgreedConditions() throws Throwable {
		searchAndViewUsersDetails();
		m_up.checkAgreedTerm();
	}
	
	//TO CHANGE EMAIL
	@Test(priority = 6)
	public void test_Main_ChangeEmail() throws Throwable {
		searchAndViewUsersDetails();
		m_up.changeEmail(newEmail,confirmNewEmail);
	}
		
		
	//TO FIND ANY SPECIFIC USERS FROM THE LIST AND CLICK ON THE VIEW DETAILS ACTION BUTTON
	public void searchAndViewUsersDetails() throws Throwable {
		m_up = callMeBeforePerformAnyAction();
		m_up.findUsersAndViewUsersDetails(searchKeyuserNameOrEmail,regionName,location,searcKeyColumnIndex, wantToClickOnUser,listActionIndex);
	}	
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_UsersPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		m_hp = new PO_Main_HomePage(driver);
		m_hp.clickOntabDashboard();
		m_hp.clickOnTabUsers();
		Thread.sleep(5000);
		//TO USERS PAGE OBJECTS
		return new PO_Main_UsersPage(driver);	
	}
	
	
}
