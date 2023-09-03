package com.p360.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.p360.ReUseAble.PageObject.ReUseAbleElement;
import com.p360.User.pageObject.PO_ClassesPage;
import com.p360.User.pageObject.PO_HomePage;
import com.p360.User.pageObject.PO_LoginPage;
import com.p360.User.pageObject.PO_MembershipPage;

public class TC_Classes extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Classes() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;
	public PO_HomePage hp;
	public Faker faker  = new Faker();
	public PO_ClassesPage cp;
	public ReUseAbleElement ruae;
	
	//PASS THE ALL THE DATE IN THE GIVEN FORMAT
	String time = "12:10 AM";	//PASS VALUES IN THIS FORMAT ONLY
	String monthDate = "SEP 05";	//PASS VALUES IN THIS FORMAT ONLY
	String location = "GAME ON";
	String region = "UNITED KINGDOM";
	String instructorName = "Brain Lara";
	
	
	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException {
		lp = new PO_LoginPage(driver);
		hp = lp.Login(email,password);
	}
	
	//TO REGISTER FOR A CLASS
	@Test(priority = 2 , dependsOnMethods = "test_Login")
	public void test_RegisterClass() throws InterruptedException {
		cp = callMeBeforePerformAnyAction();
		hp = cp.registerClass(time,monthDate,location,region,instructorName);
	}
		
	
	//TO LOGOUT
	@Test(priority = 10 , dependsOnMethods = "test_Login")	// here zero or ten ensures least priority, so that this call happens at the last.
	public void test_Logout() throws InterruptedException {	
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_ClassesPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		hp.clickMenuDashBoard_RU(); //MOVE THE DRIVER ON THE HOME PAGE
		hp.clickMenuMyClasses();	//MOVE THE DRIVER ON THE MEMBERSHIP PAGE
		Thread.sleep(2000);
		//TO MEMBERSHIP PAGE OBJECTS
		return new PO_ClassesPage(driver);	
	}
	
}
