package com.p360.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.p360.Main.pageObject.PO_Main_ClassesPage;
import com.p360.Main.pageObject.PO_Main_HomePage;
import com.p360.Main.pageObject.PO_Main_Locations;
import com.p360.Main.pageObject.PO_Main_PackagesPage;
import com.p360.Main.pageObject.PO_Main_UsersPage;
import com.p360.pageObject.PO_HomePage;
import com.p360.pageObject.PO_LoginPage;
import com.p360.pageObject.PO_MembershipPage;
import com.p360.testCases.BaseClass;

public class TC_Main_Classes extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Main_Classes() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;	//lp = LOGIN PAGE
	public PO_HomePage hp;	//hp = HOME PAGE
	public Faker faker  = new Faker();
	public PO_Main_HomePage mhp;	//mhp = MAIN HOME PAGE
	public PO_Main_PackagesPage mpp;	//mpp = MAIN PACKAGE PAGE
	public PO_Main_ClassesPage mcp; //mlp = MAIN LOCATION PAGE
	
	//VARIABLES TO CREATE CLASS
	String className = "Class "+faker.name().title();
	String classLocation = "Westwood";
	String caochName = "west wood";
	String classCapacity = "20";
	String cancelationCutOffTime = "2";
	String waitListSpot = "10";
	String description = faker.lorem().paragraph();
	String classStartDate = "12 September 2023";
	String classEndDate = "10 October 2023";
	String dayName = "Monday";
	String hours = "10";
	String minutes = "30";
	String AmPm = "AM";
	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException {
		lp = new PO_LoginPage(driver);
		mhp = lp.AdminLogin(adminEmail,adminPassword);
	}

	//TO ADD CLASS
	@Test(priority = 2)
	public void test_Main_AddClass() throws InterruptedException {
		mcp = callMeBeforePerformAnyAction();
		mhp = mcp.addClass(className,classLocation, caochName, classCapacity,cancelationCutOffTime, waitListSpot, description, classStartDate,classEndDate,dayName,hours,minutes,AmPm);
	}
	
	//TO LOGOUT
	@Test(priority = 10 , dependsOnMethods = "test_Login")	// here zero or ten ensures least priority, so that this call happens at the last.
	public void test_Logout() throws InterruptedException {	
		hp = mhp.clickOntabDashboardReturn_HomePage();
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_ClassesPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		mhp.clickOntabDashboard();
		mhp.clickOntabClasses();
		Thread.sleep(5000);
		return new PO_Main_ClassesPage(driver);	
	}
	
}
