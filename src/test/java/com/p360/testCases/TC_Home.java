package com.p360.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.p360.pageObject.PO_HomePage;
import com.p360.pageObject.PO_LoginPage;

public class TC_Home extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Home() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_HomePage hp;
	public PO_LoginPage lp;
	public Faker faker  = new Faker();
	
	String cardHolderName = faker.name().fullName();
	String expiary = "34/45";
	String CCVcode = "546";
	String zipCode = "564665";
	
	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException {
		lp = new PO_LoginPage(driver);
		hp = lp.Login(userEmail,userPassword);
	}
	
	//TO CHECK HOME PAGE ELEMENT
	@Test(priority = 2, dependsOnMethods = "test_Login")
	public void test_HomePageElement() throws InterruptedException {
		hp.checkClickActionOnHomePageElement();
	}

	//TO CHENGE THE CARD DETAILS
	@Test(priority = 3)
	public void test_ChangeCardDetails() throws InterruptedException {
		hp.changeCardDetails(cardHolderName,expiary,CCVcode,zipCode);
	}
	
	//TO LOGOUT
	@Test(priority = 10 , dependsOnMethods = "test_Login")	// here zero or ten ensures least priority, so that this call happens at the last.
	public void test_Logout() throws InterruptedException {	
		hp.Logout();
	}
	
}
