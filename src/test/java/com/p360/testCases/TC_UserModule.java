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

public class TC_UserModule extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_UserModule() {
		super();
	}

	public TC_Home tc_home = new TC_Home();
	public TC_Membership tc_membership = new TC_Membership();
	public TC_Classes tc_classes = new TC_Classes();
	
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
	public void test_Login() throws InterruptedException, SQLException, ParseException {
		tc_home.test_Login();
	}
	
	//TO CHECK HOME PAGE ELEMENT
	@Test(priority = 2)
	public void test_HomePageElement() throws InterruptedException {
		tc_home.test_HomePageElement();
	}
		
	//TO CHANGE CARD DETAILS
	@Test(priority = 3)
	public void test_ChangeCardDetails() throws InterruptedException {
		tc_home.test_ChangeCardDetails();
	}
	
	//TO CHANGE MEMBERSHIP
	@Test(priority = 5)
	public void test_ChangeMembership() throws InterruptedException, SQLException {
		tc_membership.test_ChangeMembership(categoryName, packageName, radioButton, membershipDate);
	}
		
	//TO PAUSE MEMBERSHIP
	@Test(priority = 6)
	public void test_PauseMembership() throws InterruptedException, SQLException, ParseException {
		tc_membership.test_PauseMembership(pauseStartDate, pauseEndDate, pauseReason);
	}
	
	//TO RESUME MEMBERSHIP
	@Test(priority = 7)
	public void test_ResumeMembership() throws InterruptedException, SQLException {
		tc_membership.test_ResumeMembership();
	}
	
	//TO REGISTER A CLASS
	@Test(priority = 8)
	public void test_RegisterClass() throws InterruptedException, SQLException {
		tc_classes.test_RegisterClass(time, monthDate, location, region, instructorName);
	}
	
	//TO CANCEL A CLASS
	@Test(priority = 9)
	public void test_CancelRegisteredClass() throws InterruptedException, SQLException {
		tc_classes.test_CancelRegisteredClass(dateAndTime);
	}
		
	//TO LOGOUT
	@Test(priority = 10)
	public void test_Logout() throws InterruptedException {
		tc_home.test_Logout();
	}

}
