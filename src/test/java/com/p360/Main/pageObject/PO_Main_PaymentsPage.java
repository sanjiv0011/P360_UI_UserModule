package com.p360.Main.pageObject;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.p360.ReUseAble.PageObject.ReUseAbleElement;
import com.p360.pageObject.PO_LoginPage;
import com.p360.projectUtility.DatePicker;
import com.p360.projectUtility.FindThreeDotAndClick;
import com.p360.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;

public class PO_Main_PaymentsPage extends ReUseAbleElement {
		
		//CONSTRUCTOR DECLARATION
		public WebDriver driver;
		public Logger logger = LogManager.getLogger(getClass());
		public JavascriptExecutor jsExecutor;
		public ReUseAbleElement ruae;
		public WebDriverWait wait;
		public PO_LoginPage lp;
		public Actions action;
		public SoftAssert softAssert = new SoftAssert();
		
		
		//CONSTRUCTOR CREATION
		public PO_Main_PaymentsPage(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(30));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);
		}
		
		//ALERT MESSAGES
		public String alertMsgPromoCodeAdded = "Promocode Added Successfully";
		public String alertMsgPromoCodeDeActivated = "Promo Code Deactivated Successfully.";
		public String alertMsgPromoCodeActivated = "Promo Code Activated Successfully.";
		
		//======START======PAGE OBJECT FOR PAYMENTS AND ACTOIN METHODS==========//
		
		//TO SELECT THE LOCATIONS
  		public void selectLocations(String locationName) throws InterruptedException {
  			ruae.clickOnDropdown_1_RU(driver);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,locationName);
  			logger.info("Selected Locations from the list: "+locationName);
  			Thread.sleep(500);
  		}
  		
  		//TO SELECT THE PAYMETNS START DATE
  		public void setPaymentStartDate(String paymentStartDate) throws Throwable {
  			clickOnChangeDateIcon_1_RU();
  			DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,paymentStartDate);
  		    Thread.sleep(500);
  		}
  		
  		//TO SELECT THE PAYMETNS END DATE
  		public void setPaymentEndDate(String paymentEndDate) throws Throwable {
  			clickOnChangeDateIcon_2_RU();
  			DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,paymentEndDate);
  		    Thread.sleep(500);
  		}
  		
  		
  		//TEXT NO PAYMENTS MATCHED TO CURRENT APPLIED FILTER
  		@FindBy(xpath = "//*[.='No payment matches Current Filter")
  		@CacheLookup
  		public WebElement noPaymentMatchedWithApplieddFilter;
  		public boolean  isNoPaymentMatchedDisplayed() throws InterruptedException {
  			boolean flag = false;
  			try {
  				if(noPaymentMatchedWithApplieddFilter.isDisplayed()) {
  					flag = true;
  					logger.info("Searched key not present");
  					softAssert.assertTrue(flag,"Payment you are searching is not found");
  					clickOnP360Logo_RU();
  				}
  			}catch(Exception e) {
  				flag = false;
  				logger.info("Searched Payment is matched with the applied fileter");
  				logger.info("Exception from : "+e.getMessage());
  			}
  			softAssert.assertAll();
  			return flag;
  		}
  		
  		
  		//PAYMENTS LIST 
  		@FindBy(xpath = "(//div[contains(@class,'w-full flex')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]")
  		@CacheLookup
  		List<WebElement> paymentList;
  		//PAYMETNS ROW LIST ADDRESS AND ACTION METHODS
  		public String paymentList_address = "(//div[contains(@class,'w-full flex')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]";
  		public int findPaymentFromRowListAndClickOnThreeDot(String paymentName, int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException {
  			int listRowCount = 0; 
			try {
				Thread.sleep(2000);
				listRowCount = FindThreeDotAndClick.findThreedActionButtonAndClick(paymentList_address,paymentList,driver, paymentName, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				
			}catch(Exception e) {
				logger.info("Exception from findPaymentFromRowListAndClickOnThreeDot: "+e.getMessage());
				softAssert.assertTrue(false,"not click on the three dot action button");
			}
			return listRowCount;
  		}
  		
  		//MEMBERSHIP INSHIGHTS CONFIRMATION
  		@FindBy(xpath = "//span[normalize-space()='Membership Insights']")
  		@CacheLookup
  		WebElement MembershipInsights;
  		public boolean isMemberInsightsPresent() {
  			boolean flag = false;
  			try {
  				wait.until(ExpectedConditions.textToBePresentInElementValue(MembershipInsights,"Membership Insights"));
  				flag = MembershipInsights.isDisplayed();
  				Thread.sleep(3000);
  			}catch(Exception e) {
  				logger.info("Exception from : "+e.getMessage());
  			}
  			
  			return flag;
  		}
  		
  		//======END======PAGE OBJECT FOR ADD PAYMENTS ACTOIN METHODS==========//
  			
  		//FIND PAYMENTS FROM THE LIST AND CLICK ON THE THREE DOT BUTTON
  		public void findPaymentFromListAndClickOnThreeDotButton(String searchKey,String paymentName,boolean wantToClickOnThreeDot,int searchKeyColumnIndex, boolean wantToClickOnSearchKey) throws InterruptedException
  		{
  			Thread.sleep(1000);
  			searchBox_1_RU(driver, searchKey);
  			Thread.sleep(5000);
  			boolean flag = isNoPaymentMatchedDisplayed();
  			if(!flag) {
  	  			findPaymentFromRowListAndClickOnThreeDot(paymentName, searchKeyColumnIndex, wantToClickOnThreeDot, wantToClickOnSearchKey);
  	  		
  			}else {
  				softAssert.assertTrue(false,"Payments you are searching is not present");
  			}
  			isMemberInsightsPresent();
  			
  			softAssert.assertAll();
  		}
  		
  		 		
}
