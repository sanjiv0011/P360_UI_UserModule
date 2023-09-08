package com.p360.testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.p360.ReUseAble.PageObject.ReUseAbleElement;
import com.p360.dataProviders.from_readDataFromExcelFile.DataProviders;
import com.p360.pageObject.PO_ClassesPage;
import com.p360.pageObject.PO_HomePage;
import com.p360.pageObject.PO_LoginPage;


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
	String time = "7:00 PM";	//PASS VALUES IN THIS FORMAT ONLY
	String monthDate = "SEP 21 THU";	//PASS VALUES IN THIS FORMAT ONLY
	String location = "GAME ON";
	String region = "SPAIN";//"UNITED KINGDOM";
	String instructorName = "Envoy Matt";
	String dateAndTime = "Sep 21, 2023 | 02:00 AM";
	String userEmailAddress = userEmail;
	
	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException {
		lp = new PO_LoginPage(driver);
		hp = lp.Login(userEmail,userPassword);
	}
	
	//TO REGISTER FOR A CLASS
	//@Test(priority = 2 , dependsOnMethods = "test_Login", dataProvider = fileNameOnly_Registration)
	public void test_RegisterClass(String time, String monthDate, String location, String region, String instructorName) throws InterruptedException, SQLException {
		cp = callMeBeforePerformAnyAction();
		hp = cp.registerClass(time,monthDate,location,region,instructorName,userEmailAddress);
		
	}
		
	//TO CANCEL REGISTERED CLASS
	@Test(priority = 3 , dependsOnMethods = "test_Login", dataProvider = fileNameOnly_Cancelation)
	public void test_CancelRegisteredClass(String dateAndTime) throws InterruptedException, SQLException {
		cp = callMeBeforePerformAnyAction();
		hp = cp.cancelRegisteredClass(dateAndTime,driver,userEmailAddress);
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
	
}
