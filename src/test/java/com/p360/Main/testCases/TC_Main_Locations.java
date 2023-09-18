package com.p360.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.p360.Main.pageObject.PO_Main_HomePage;
import com.p360.Main.pageObject.PO_Main_Locations;
import com.p360.Main.pageObject.PO_Main_PackagesPage;
import com.p360.pageObject.PO_HomePage;
import com.p360.pageObject.PO_LoginPage;
import com.p360.testCases.BaseClass;

public class TC_Main_Locations extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Main_Locations() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;	//lp = LOGIN PAGE
	public PO_HomePage hp;	//hp = HOME PAGE
	public Faker faker  = new Faker();
	public PO_Main_HomePage mhp;	//mhp = MAIN HOME PAGE
	public PO_Main_PackagesPage mpp;	//mpp = MAIN PACKAGE PAGE
	public PO_Main_Locations mlp; //mlp = MAIN LOCATION PAGE
	
	//VARIABLES TO CREATE REGIONS
	String regionName = faker.address().cityName();
	String parentRegion = "Westwood";
	String regionCode = faker.random().hex(3);
	String regionDescription = faker.lorem().paragraph();
	
	
	
	//VARIABLES TO CREATE LOCATIONS
	String locationName = regionName;
	String locationInternalName = regionName;
	String locationRegionName = "Jefferyview"; //"Dicki-Turner";
	String locatoinCode = faker.address().zipCode();
	String locationDescription = faker.lorem().paragraph();
	String addressLine1 = faker.address().fullAddress();
	String addressLine2 = faker.address().secondaryAddress();
	String city = faker.address().cityName();
	String postalCode = String.valueOf(faker.number().digits(6));
	String stateName = "West Virginia";
	String locationEmail = faker.internet().emailAddress();
	String locationPhoneNumber = "1"+String.valueOf(faker.number().digits(9));
	String locationVitalsDescription = faker.lorem().paragraph();
	String timeZone = faker.address().timeZone();
	String p360Shares = faker.number().digits(1);
	String wantEnableNoShow = "Yes";
	String noShowFee = faker.number().digits(1);

	//TO ADD REGIONS
	//@Test(priority = 1)
	public void test_Main_AddRegion() throws InterruptedException {
		mlp = callMeBeforePerformAnyAction();
		mhp = mlp.addRegion(regionName,parentRegion,regionCode,regionDescription);
	}
	
	
	//TO ADD LOCATIONS
	@Test(priority = 2)
	public void test_Main_AddLocation() throws InterruptedException {
		mlp = callMeBeforePerformAnyAction();
		mhp = mlp.addLocation(locationName,locationInternalName,locationRegionName,locatoinCode,locationDescription,addressLine1,addressLine2,city, postalCode,stateName,locationEmail,locationPhoneNumber,locationVitalsDescription,timeZone,p360Shares,wantEnableNoShow,noShowFee);
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_Locations callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		mhp.clickOntabDashboard();
		mhp.clickOntabLocations();
		Thread.sleep(5000);
		return new PO_Main_Locations(driver);	
	}
	
}
