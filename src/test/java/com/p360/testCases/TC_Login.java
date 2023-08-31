package com.p360.testCases;


import org.testng.annotations.Test;

import com.p360.pageObject.PO_LoginPage; 

//TO TEST THE LOGIN FUNCTIONALITY
public class TC_Login extends BaseClass {
	
	//CONSTRUCTOR
	public TC_Login(){
		super();
	}
	
	//LOIGN CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;

	//TO LOGIN
	@Test(priority = 1)
	public void test_Login(String email,String password) throws InterruptedException {
		logger.info("Method called: test_Login");
		lp = new PO_LoginPage(driver);
		lp.Login(email,password);
	}
	
}