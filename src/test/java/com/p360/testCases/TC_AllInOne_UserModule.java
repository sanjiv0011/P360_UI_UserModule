package com.p360.testCases;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.p360.ReUseAble.PageObject.ReUseAbleElement;
import com.p360.dataProviders.from_readDataFromExcelFile.DataProviders;
import com.p360.pageObject.PO_ClassesPage;
import com.p360.pageObject.PO_HomePage;
import com.p360.pageObject.PO_LoginPage;
import com.p360.pageObject.PO_MembershipPage;

public class TC_AllInOne_UserModule extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_AllInOne_UserModule() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;
	public PO_HomePage hp;
	public Faker faker  = new Faker();
	public PO_MembershipPage mp;
	public ReUseAbleElement ruae;
	public PO_ClassesPage cp;
	
	//VARIABLE FOR THE MEMBERSHIP PAGE
	String categoryName = "All";
	String packageName = "Package2";
	String radioButton = "Custom Date";
	
	//PASS THE ALL THE DATE IN THE GIVEN FORMAT
	String membershipDate = "15 September 2023";
	String pauseStartDate = "10 September 2023";
	String pauseEndDate = "25 September 2023";
	String pauseReason = "Travel"; //"Other" and "Medical Reason"
	
	//VARIABLE FOR THE HOME PAGE
	String cardHolderName = faker.name().fullName();
	String expiary = "34/45";
	String CCVcode = "546";
	String zipCode = "564665";
	
	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException {
		try {
			lp = new PO_LoginPage(driver);
			hp = lp.Login(userEmail,userPassword);
		}catch(Exception e) {}
	}
	
	//==========START=======HOME PAGE TESTING============//
	//TO CHECK HOME PAGE ELEMENT
	@Test(priority = 2, dependsOnMethods = "test_Login")
	public void test_HomePageElement() throws InterruptedException {
		try {
			hp.checkClickActionOnHomePageElement();
		}catch(Exception e) {}
	}

	//TO CHENGE THE CARD DETAILS
	@Test(priority = 3)
	public void test_ChangeCardDetails() throws InterruptedException {
		try {
			hp.changeCardDetails(cardHolderName,expiary,CCVcode,zipCode);
		}catch(Exception e) {}
	}
	//==========END=======MEMBERSHIP PAGE TESTING============//	
		
		
	//==========START=======MEMBERSHIP PAGE TESTING============//
	//TO CHANGE MEMBERSHIP
	@Test(priority = 4 , dependsOnMethods = "test_Login", dataProvider = "TC_ChangeMembership")
	public void test_ChangeMembership(String categoryName,String packageName,String radioButton,String membershipDate) throws InterruptedException, SQLException {
		try {
			mp = callMeBeforePerformAnyAction_TC_Membership();
			hp = mp.changeMembership(userEmail,categoryName,packageName,radioButton, membershipDate);
		}catch(Exception e) {}
	}
	
	//TO CHECK AGREED TERMS OF MEMBERSHIP
	@Test(priority = 5 , dependsOnMethods = "test_Login")
	public void test_CheckAgreedTerms() throws InterruptedException {
		try {
			mp = callMeBeforePerformAnyAction_TC_Membership();
			hp = mp.checkAgreedTerm();
		}catch(Exception e) {}
	}
	
	
	//TO PAUSE MEMBERSHIP
	@Test(priority = 6 ,dependsOnMethods = "test_Login", dataProvider = "TC_PauseMembership")
	public void test_PauseMembership(String pauseStartDate, String pauseEndDate, String pauseReason) throws InterruptedException, SQLException, ParseException {
		try {
			mp = callMeBeforePerformAnyAction_TC_Membership();
			hp = mp.pasueMembership(userEmail,pauseStartDate, pauseEndDate, pauseReason);
		}catch(Exception e) {}
	}
	
	//TO RESUME MEMBERSHIP
	@Test(priority = 7 ,dependsOnMethods = "test_Login")
	public void test_ResumeMembership() throws InterruptedException, SQLException {
		try {
			mp = callMeBeforePerformAnyAction_TC_Membership();
			hp = mp.resumeMembership(userEmail);
		}catch(Exception e) {}
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_MembershipPage callMeBeforePerformAnyAction_TC_Membership() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		hp.clickMenuDashBoard_RU(); //MOVE THE DRIVER ON THE HOME PAGE
		hp.clickMenuMembership();	//MOVE THE DRIVER ON THE MEMBERSHIP PAGE
		Thread.sleep(2000);
		//TO MEMBERSHIP PAGE OBJECTS
		return new PO_MembershipPage(driver);	
	}
	
	//EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
  	public final String fileNameOnly_ChangeMembership = "TC_ChangeMembership";
  	//CONSTRUCTOR DECLARATIONS TO ACCESS THE DATA PROVIDER METHODs
  	public DataProviders dp_ChangeMembership =  new DataProviders();
  	//DATA PROVIDER
  	@DataProvider(name = fileNameOnly_ChangeMembership)
  	public String[][] dataProvider_ChangeMemebership() throws IOException {
  		String data[][] = DataProviders.dataProviderGetDataFromExcelFile(fileNameOnly_ChangeMembership);
  		return data;
  	}
  	
  //EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
  	public final String fileNameOnly_PauseMembership = "TC_PauseMembership";
  	//CONSTRUCTOR DECLARATIONS TO ACCESS THE DATA PROVIDER METHODs
  	public DataProviders dp_PauseMembership =  new DataProviders();
  	//DATA PROVIDER
  	@DataProvider(name = fileNameOnly_PauseMembership)
  	public String[][] dataProvider_PauseMembership() throws IOException {
  		String data[][] = DataProviders.dataProviderGetDataFromExcelFile(fileNameOnly_PauseMembership);
  		return data;
  	}
  	
	//==========END=======MEMBERSHIP PAGE TESTING============//
  	
  	
	//==========START=======CLASSES PAGE TESTING============//
	//TO REGISTER FOR A CLASS
  	@Test(priority = 8 , dependsOnMethods = "test_Login", dataProvider = fileNameOnly_Registration)
  	public void test_RegisterClass(String time, String monthDate, String location, String region, String instructorName) throws InterruptedException, SQLException {
  		try {
  			cp = callMeBeforePerformAnyAction_TC_Classes();
  	  		hp = cp.registerClass(time,monthDate,location,region,instructorName,userEmail);
  		}catch(Exception e) {}
  		
  	}
  		
  	//TO CANCEL REGISTERED CLASS
  	@Test(priority = 9 , dependsOnMethods = "test_Login", dataProvider = fileNameOnly_Cancelation)
  	public void test_CancelRegisteredClass(String dateAndTime) throws InterruptedException, SQLException {
  		try {
  			cp = callMeBeforePerformAnyAction_TC_Classes();
  	  		hp = cp.cancelRegisteredClass(dateAndTime,driver,userEmail);
  		}catch(Exception e) {}
  	}
  	
  //CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
  	public PO_ClassesPage callMeBeforePerformAnyAction_TC_Classes() throws InterruptedException {
  		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
  		hp.clickMenuDashBoard_RU(); //MOVE THE DRIVER ON THE HOME PAGE
  		hp.clickMenuMyClasses();	//MOVE THE DRIVER ON THE MEMBERSHIP PAGE
  		driver.navigate().refresh();
  		Thread.sleep(4000);
  		//TO MEMBERSHIP PAGE OBJECTS
  		return new PO_ClassesPage(driver);	
  	}
  	
  	//=========DATA PROVIDER CONCEPT========WHILE USING THIS PROVIDES THE EXCEL FIEL VARIABLE AS AN AGRUMENT IN THE TEST_METHODS======//
	//======START=====DATA READING FORM THE EXCEL FILE======IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME=====//
	//EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
	public final String fileNameOnly_Registration = "TC_ClassRegistration";
	//CONSTRUCTOR DECLARATIONS TO ACCESS THE DATA PROVIDER METHODs
	public DataProviders dp_Registration =  new DataProviders();
	//DATA PROVIDER
	@DataProvider(name = fileNameOnly_Registration)
	public String[][] dataProvider_Registration() throws IOException {
		String data[][] = DataProviders.dataProviderGetDataFromExcelFile(fileNameOnly_Registration);
		return data;
	}
	
	public final String fileNameOnly_Cancelation = "TC_CancelRegisterClass";
	//CONSTRUCTOR DECLARATIONS TO ACCESS THE DATA PROVIDER METHODs
	public DataProviders dp_Cancelation =  new DataProviders();
	//DATA PROVIDER
	@DataProvider(name = fileNameOnly_Cancelation)
	public String[][] dataProvider_Cancelation() throws IOException {
		String data[][] = DataProviders.dataProviderGetDataFromExcelFile(fileNameOnly_Cancelation);
		return data;
	}
	//======END=====DATA READING FORM THE EXCEL FILE=====IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME======//
  	
  	//==========END=======CLASSES PAGE TESTING============//
  	
  	
  	//TO LOGOUT
  	@Test(priority = 10 , dependsOnMethods = "test_Login")	// here zero or ten ensures least priority, so that this call happens at the last.
  	public void test_Logout() throws InterruptedException {	
  		hp.Logout();
  	}
	
}
