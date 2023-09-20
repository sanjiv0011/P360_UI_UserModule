package com.p360.Main.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.p360.Main.pageObject.PO_Main_HomePage;
import com.p360.Main.pageObject.PO_Main_PackagesPage;
import com.p360.pageObject.PO_HomePage;
import com.p360.pageObject.PO_LoginPage;
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
	public PO_Main_HomePage m_hp;	//m_hp = MAIN HOME PAGE
	public PO_Main_PackagesPage m_pp;	//m_pp = MAIN PACKAGE PAGE
	
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

	//FIND PACKAGE FROM THE LIST
	String packageTitle = "WESTWOOD_PACKAGE_02";
	int searchKeyColumnIndex = 1;
	boolean wantToClickOnThreeDot = true;
	String locationName = "WESTWOOD";
	String packageStatus = "ALL";
	
	//TO CREATE PACKAGE CATEGORY
	//@Test(priority = 1)
	public void test_Main_AddPackageCategory() throws InterruptedException {
		m_pp = callMeBeforePerformAnyAction();
		m_hp = m_pp.addPackageCategory(packageCategoryTitle,packageCategoryInternalTitle,packageCategoryDescription,categoryLocation,wantToMarkCategoryHidden);
	}
	
	
		
		
	//TO CREATE PACKAGE
	//@Test(priority = 2)
	public void test_Main_AddPackage() throws InterruptedException {
		m_pp = callMeBeforePerformAnyAction();
		m_hp = m_pp.addPackage(packageName,packageLocation,packageCategory,packgeDescription,wantToInternalUseOnly,chargeInterval,totalClasses,miniumDurationInMonth, regularPrice,packagedisclaimers);
	}
	
	
	
	//TO DEACTIVATE PACKAGE
	//@Test(priority = 3)
	public void test_Main_DeActivatePackage() throws InterruptedException {
		test_Main_FindPackageFromListAndClickOnThreedotButton();
		m_pp.deActivatePackage();
	}
	
	//TO ACTIVATE PACKAGE
	//@Test(priority = 4)
	public void test_Main_ActivatePackage() throws InterruptedException {
		test_Main_FindPackageFromListAndClickOnThreedotButton();
		m_pp.activatePackage();
	}
		
		
	//TO ARCHIVE PACKAGE
	//@Test(priority = 5)
	public void test_Main_ArchivePackage() throws InterruptedException {
		test_Main_FindPackageFromListAndClickOnThreedotButton();
		m_pp.archivePackage();
	}
	
	//TO RESTORE PACKAGE
	//@Test(priority = 6)
	public void test_Main_RestorePackage() throws InterruptedException {
		test_Main_FindPackageFromListAndClickOnThreedotButton();
		m_pp.restorePackage();
	}
	
	//TO VIEW REPORT PACKAGE
	@Test(priority = 7)
	public void test_Main_ViewPackageReport() throws InterruptedException {
		test_Main_FindPackageFromListAndClickOnThreedotButton();
		m_pp.viewPackageReport();
	}
		
		
		
	
	//TO FIND PACKAGE AND CLICK ON THE THREE DOT BUTTON
	//@Test(priority = 3)
	public void test_Main_FindPackageFromListAndClickOnThreedotButton() throws InterruptedException {
		m_pp = callMeBeforePerformAnyAction();
		m_pp.findPackageAndClickOnThreeDot(packageTitle,searchKeyColumnIndex,wantToClickOnThreeDot,packageLocation,packageStatus);
	}
		
		
		
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_PackagesPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		m_hp = new PO_Main_HomePage(driver);
		m_hp.clickOntabDashboard();
		m_hp.clickOntabPackages();
		Thread.sleep(5000);
		return new PO_Main_PackagesPage(driver);	
	}
	
}
