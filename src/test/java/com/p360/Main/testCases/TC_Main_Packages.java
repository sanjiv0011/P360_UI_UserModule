package com.p360.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.p360.Main.pageObject.PO_Main_HomePage;
import com.p360.Main.pageObject.PO_Main_PackagesPage;
import com.p360.Main.pageObject.PO_Main_UsersPage;
import com.p360.pageObject.PO_HomePage;
import com.p360.pageObject.PO_LoginPage;
import com.p360.pageObject.PO_MembershipPage;
import com.p360.testCases.BaseClass;

public class TC_Main_Packages extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Main_Packages() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;	//lp = LOGIN PAGE
	public PO_HomePage hp;	//hp = HOME PAGE
	public Faker faker  = new Faker();
	public PO_Main_HomePage mhp;	//mHp = MAIN HOME PAGE
	public PO_Main_PackagesPage mpp;	//mpp = MAIN PACKAGE PAGE
	
	//VARIABLES TO CREATE PACKAGE CATEGORY
	String packageCategoryTitle = faker.name().title();
	String packageCategoryInternalTitle = faker.company().name();
	String packageCategoryDescription = faker.lorem().paragraph();
	String categoryLocation = "Westwood";
	String wantToMarkCategoryHidden = "No";
	
	
	//VARIABLES TO CREATE PACKAGE
	String packageName = faker.name().title();
	String packageLocation = categoryLocation;
	String packageCategory = packageCategoryTitle; //"Dicki-Turner";
	String packgeDescription = faker.lorem().paragraph();
	String wantToInternalUseOnly = "No";
	String chargeInterval = "Monthly"; //One-Time
	String totalClasses = String.valueOf(faker.number().numberBetween(30, 60));
	String miniumDurationInMonth = String.valueOf(faker.number().digit());
	String regularPrice = String.valueOf(faker.number().numberBetween(100, 200));
	String packagedisclaimers = faker.lorem().paragraph();

	
	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException {
		lp = new PO_LoginPage(driver);
		mhp = lp.AdminLogin(adminEmail,adminPassword);
	}

	//TO CREATE PACKAGE CATEGORY
	@Test(priority = 2)
	public void test_Main_AddPackageCategory() throws InterruptedException {
		mpp = callMeBeforePerformAnyAction();
		mhp = mpp.addPackageCategory(packageCategoryTitle,packageCategoryInternalTitle,packageCategoryDescription,categoryLocation,wantToMarkCategoryHidden);
	}
	
	
	//TO CREATE PACKAGE
	@Test(priority = 3)
	public void test_Main_AddPackage() throws InterruptedException {
		mpp = callMeBeforePerformAnyAction();
		mhp = mpp.addPackage(packageName,packageLocation,packageCategory,packgeDescription,wantToInternalUseOnly,chargeInterval,totalClasses,miniumDurationInMonth, regularPrice,packagedisclaimers);
	}
		
		
		
	
	//TO LOGOUT
	@Test(priority = 10 , dependsOnMethods = "test_Login")	// here zero or ten ensures least priority, so that this call happens at the last.
	public void test_Logout() throws InterruptedException {	
		hp = mhp.clickOntabDashboardReturn_HomePage();
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_PackagesPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		mhp.clickOntabDashboard();
		mhp.clickOntabPackages();
		Thread.sleep(5000);
		return new PO_Main_PackagesPage(driver);	
	}
	
}
