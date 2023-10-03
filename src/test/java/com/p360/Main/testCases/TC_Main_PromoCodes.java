package com.p360.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.p360.Main.pageObject.PO_Main_CoachesPage;
import com.p360.Main.pageObject.PO_Main_HomePage;
import com.p360.Main.pageObject.PO_Main_MovementsPage;
import com.p360.Main.pageObject.PO_Main_PromoCodesPage;
import com.p360.Main.pageObject.PO_Main_WorkoutsPage;
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
	public PO_Main_PromoCodesPage m_pcp; //m_mp = MAIN MOVEMENT PAGE
	
	//VARIABLES TO ADD PROMO CODE
	String promoCodeName = "WestwookPromoCode_"+randomStringNumber(1,2);
	String discountTypes = "percent";
	String discountValue = randomStringNumber(1,2);;
	String  promoCodeStartDate = "17 October 2023";
	String promoCodeEndDate = "30 October 2023";;
	boolean wantToAllowForAllLocations = true;
	boolean wantToAllowForAllUsers = true;
	String locationName = "WESTWOOD";
	String maxNumberOfUsers = randomStringNumber(1,2);;

	
	
	//TO FIND PROMO CODES FROM THE LIST
	String promoCodeTitle = "WESTWOOKPROMOCODE_6";
	String searchKey = "WESTWOOKPROMOCODE_6";
	boolean wantToClickOnThreeDot = true;
	int searchKeyColumnIndex = 1;
	boolean wantToClickOnSearchKey = false;
	
	
	
	//TO ADD PROMO CODE
	@Test(priority = 1)
	public void test_Main_AddMovement() throws Throwable {
		m_pcp = callMeBeforePerformAnyAction();
		System.out.println("promoCodeName: "+promoCodeName);
		m_pcp.addOrChangePromoCodes(promoCodeName,discountTypes,discountValue, promoCodeStartDate,promoCodeEndDate,wantToAllowForAllLocations,wantToAllowForAllUsers,locationName,maxNumberOfUsers) ;
	}
	
	
		
	//TO DEACTIVATE PROMOCODE
	@Test(priority = 2)
	public void test_Main_DeactivatePromoCode() throws InterruptedException {
		test_Main_FindPromoCodeFromListAndClickOnThreeDotButton();
		m_pcp.deactivatePromoCode();
	}
		
	//TO ACTIVATE PROMOCODE
	@Test(priority = 3)
	public void test_Main_ActivatePromoCode() throws InterruptedException {
		test_Main_FindPromoCodeFromListAndClickOnThreeDotButton();
		m_pcp.activatePromoCode();
	}	
	
	
	//TO FIND PROMO CODES AND CLICK ON THREE DOT BUTTON
	//@Test(priority = 10)
	public void test_Main_FindPromoCodeFromListAndClickOnThreeDotButton() throws InterruptedException {
		m_pcp = callMeBeforePerformAnyAction();
		m_pcp.findPromoCodesFromListAndClickOnThreeDotButton(promoCodeTitle, searchKey,wantToClickOnThreeDot, searchKeyColumnIndex,  wantToClickOnSearchKey);
	}
		
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_PromoCodesPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		m_hp = new PO_Main_HomePage(driver);
		m_hp.clickOntabDashboard();
		m_hp.clickOntabPromoCodes();
		Thread.sleep(5000);
		return new PO_Main_PromoCodesPage(driver);	
	}
	
}
