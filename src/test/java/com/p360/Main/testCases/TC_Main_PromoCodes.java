package com.p360.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.p360.Main.pageObject.PO_Main_HomePage;
import com.p360.Main.pageObject.PO_Main_PaymentsPage;
import com.p360.Main.pageObject.PO_Main_PromoCodesPage;
import com.p360.pageObject.PO_HomePage;
import com.p360.pageObject.PO_LoginPage;
import com.p360.testCases.BaseClass;

public class TC_Main_PromoCodes extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Main_PromoCodes() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;	//lp = LOGIN PAGE
	public PO_HomePage hp;	//hp = HOME PAGE
	public Faker faker  = new Faker();
	public PO_Main_HomePage m_hp;	//m_hp = MAIN HOME PAGE
	public PO_Main_PaymentsPage m_pp; //m_pp = MAIN PAYMENT PAGE
	
	//VARIABLES TO ADD PROMO CODE
	String  paymentStartDate = "17 October 2023";
	String paymentEndDate = "30 October 2023";;
	String paymentTitle = "WESTWOOKPROMOCODE_6";
	String searchKey = "WESTWOOKPROMOCODE_6";
	String locationName = "WESTWOOD";
	boolean wantToClickOnThreeDot = false;
	int searchKeyColumnIndex = 1;
	boolean wantToClickOnSearchKey = true;
	
	
	
	//TO CHECK PAYMENT USERS
	@Test(priority = 1)
	public void test_Main_CheckPaymentUsers() throws Throwable {
		m_pp = callMeBeforePerformAnyAction();
		System.out.println("paymentTitle: "+paymentTitle);
		//m_pp.checkPaymentUsersDetails(paymentTitle, paymentStartDate, paymentEndDate,locationName) ;
	}
	
	
	
	//TO FIND PAYMENT AND CLICK ON THREE DOT BUTTON
	//@Test(priority = 10)
	public void test_Main_FindPromoCodeFromListAndClickOnThreeDotButton() throws InterruptedException {
		m_pp = callMeBeforePerformAnyAction();
		m_pp.findPaymentFromListAndClickOnThreeDotButton(paymentTitle, searchKey,wantToClickOnThreeDot, searchKeyColumnIndex,  wantToClickOnSearchKey);
	}
		
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_PaymentsPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		m_hp = new PO_Main_HomePage(driver);
		m_hp.clickOntabDashboard();
		m_hp.clickOntabPayments();
		Thread.sleep(5000);
		return new PO_Main_PaymentsPage(driver);	
	}
	
}
