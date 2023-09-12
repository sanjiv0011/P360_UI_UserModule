package com.p360.testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.p360.ReUseAble.PageObject.ReUseAbleElement;
import com.p360.dataProviders.from_readDataFromExcelFile.DataProviders;
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
	String packageName = "Package2";
	String radioButton = "The end of the current period";
	
	//PASS THE ALL THE DATE IN THE GIVEN FORMAT
	String membershipDate = "15 September 2023";
	String pauseStartDate = "18 September 2023";
	String pauseEndDate = "25 September 2023";
	String pauseReason = "Travel"; //"Other" and "Medical Reason"
	
	
	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException {
		try {
			lp = new PO_LoginPage(driver);
			hp = lp.Login(userEmail,userPassword);
		}catch(Exception e) {}
	}
	
	//TO CHANGE MEMBERSHIP
	//@Test(priority = 2  , dependsOnMethods = "test_Login" , dataProvider = "TC_ChangeMembership")
	public void test_ChangeMembership(String categoryName,String packageName,String radioButton,String membershipDate) throws Throwable {
		try {
			mp = callMeBeforePerformAnyAction();
			hp = mp.changeMembership(userEmail,categoryName,packageName,radioButton, membershipDate);
		}catch(Exception e) {}
	}
	
	//TO CHECK AGREED TERMS OF MEMBERSHIP
	//@Test(priority = 3 , dependsOnMethods = "test_Login")
	public void test_CheckAgreedTerms() throws InterruptedException {
		try {
			mp = callMeBeforePerformAnyAction();
			hp = mp.checkAgreedTerm();
		}catch(Exception e) {}
	}
	
	
	//TO PAUSE MEMBERSHIP
	@Test(priority = 4 ,dependsOnMethods = "test_Login", dataProvider = "TC_PauseMembership")
	public void test_PauseMembership(String pauseStartDate, String pauseEndDate, String pauseReason) throws Throwable {
		try {
			mp = callMeBeforePerformAnyAction();
			hp = mp.pasueMembership(userEmail,pauseStartDate, pauseEndDate, pauseReason);
		}catch(Exception e) {}
	}
	
	//TO RESUME MEMBERSHIP
	//@Test(priority = 5 ,dependsOnMethods = "test_Login")
	public void test_ResumeMembership() throws InterruptedException, SQLException {
		try {
			mp = callMeBeforePerformAnyAction();
			hp = mp.resumeMembership(userEmail);
		}catch(Exception e) {}
	}
		
	
	//TO LOGOUT
	@Test(priority = 10, dependsOnMethods = "test_Login" )	// here zero or ten ensures least priority, so that this call happens at the last.
	public void test_Logout() throws InterruptedException {	
		try {
			hp.Logout();
		}catch(Exception e) {}
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
	
}
