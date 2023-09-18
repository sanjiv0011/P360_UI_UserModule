package com.p360.Main.pageObject;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.p360.DataBaseTesting.DBT_User_Classes;
import com.p360.ReUseAble.PageObject.ReUseAbleElement;
import com.p360.pageObject.PO_LoginPage;
import com.p360.projectUtility.DatePicker;
import com.p360.projectUtility.FindThreeDotBasedOnSearchKeyAndClick;
import com.p360.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;

public class PO_Main_UsersPage extends ReUseAbleElement {
		
		//CONSTRUCTOR DECLARATION
		public WebDriver driver;
		public Logger logger = LogManager.getLogger(getClass());
		public JavascriptExecutor jsExecutor;
		public ReUseAbleElement ruae;
		public WebDriverWait wait;
		public PO_LoginPage lp;
		public Actions action;
		public SoftAssert softAssert = new SoftAssert();
		
		//HOMEPAGE CONSTRUCTOR CREATION
		public PO_Main_UsersPage(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(45));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);

		}
		
		//ALERT MESSAGES
		public String alertMsgMemberhsipPurchagedSuccessfully = "Membership purchased successfully";
		public String alertMsgYourCardNumberIncomplete = "Your card number is incomplete.";
		public String alertMsgAcceptTermCondition = "Please accept term and conditions.";
		public String alertMsgMembeshipChangeSuccessfully = "Pause Membership Successfully";
		
		//TEXT FIELD FIRST NAME
  		@FindBy(xpath = "//input[@placeholder='Enter First Name']")
  		@CacheLookup
  		public WebElement filedFirstName;
  		public void setFirstName(String firstName) throws InterruptedException {
  			filedFirstName.sendKeys(Keys.CONTROL,"a");
  			filedFirstName.sendKeys(Keys.DELETE);
  			filedFirstName.sendKeys(firstName);;
  			logger.info("Clicked on the field first name");
  			Thread.sleep(300);
  		}
		
  		//TEXT FIELD FIRST NAME
  		@FindBy(xpath = "//input[@placeholder='Enter Last Name']")
  		@CacheLookup
  		public WebElement filedLastName;
  		public void setLastName(String lastName) throws InterruptedException {
  			filedLastName.sendKeys(Keys.CONTROL,"a");
  			filedLastName.sendKeys(Keys.DELETE);
  			filedLastName.sendKeys(lastName);;
  			logger.info("Clicked on the field last name");
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD EMIAL
  		@FindBy(xpath = "//input[@placeholder='Enter Email Address']")
  		@CacheLookup
  		public WebElement feildEmail;
  		public void setEmail(String email) throws InterruptedException {
  			feildEmail.sendKeys(Keys.CONTROL,"a");
  			feildEmail.sendKeys(Keys.DELETE);
  			feildEmail.sendKeys(email);;
  			logger.info("Clicked on the field email");
  			Thread.sleep(300);
  		}
  		
  		//USERS FILTERS
  		@FindBy(xpath = "(//*[name()='svg'][@title='User Filters'])[1]")
  		@CacheLookup
  		public WebElement userFilters;
  		public void iconClickOnUsersFilters() throws InterruptedException {
  			userFilters.click();
  			logger.info("Clicked on the field email");
  			Thread.sleep(300);
  		}
  		
  		//BUTTON CLEARS FILTERS
  		@FindBy(xpath = "//div[normalize-space()='Clear Filter']")
  		@CacheLookup
  		public WebElement btnClearFilters;
  		public void clickOnBtnClearFilters() throws InterruptedException {
  			btnClearFilters.click();
  			logger.info("Clicked on the btnClearFilters");
  			Thread.sleep(300);
  		}
  		
// 		//LIST RADIO BUTTON CLEARS FILTERS
//  		@FindBy(xpath = "//div[contains(@class,'MuiFormGroup-root')]")
//  		@CacheLookup
  		public String  listUsreFilterRadioBtn_Address ="//div[contains(@class,'MuiFormGroup-root')]";
  		public void clickOnRadioBtn(String userFilterName) throws InterruptedException {
	  		/*	Active Members
	  	  		On Hold
	  	  		Hold Upcoming
	  	  		Cancel Upcoming
	  	  		Cancelled Members
	  		*/
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,listUsreFilterRadioBtn_Address,userFilterName);
  			Thread.sleep(1000);	
  		}
  	
 
  				
  		//TEXT FIELD PHONE NUMBER
  		@FindBy(xpath = "//input[@placeholder='Enter Phone Number']")
  		@CacheLookup
  		public WebElement feildPhoneNumber;
  		public void setPhoneNumber(String phoneNumber) throws InterruptedException {
  			feildPhoneNumber.sendKeys(Keys.CONTROL,"a");
  			feildPhoneNumber.sendKeys(Keys.DELETE);
  			feildPhoneNumber.sendKeys(phoneNumber);
  			logger.info("Clicked on the field phone number");
  			Thread.sleep(300);
  		}
		
  		//TO SELECT THE LOCATION THE FROM THE LIST
  		public void selectLocation(String location) throws InterruptedException{	
  			clickOnDropdown_1_RU();
  			//BELOW LINE IS USED TO AVOID THE STALE ELEMENT REFERENCE
  			//List<WebElement> listOption_RU = driver.findElements(By.xpath(ruae.listOptionAvoidStaleElementReference_RU)); 
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,listOptionAddress_RU,location);
  			Thread.sleep(1000);
  		}
  		
  		//TO SELECT THE REGION THE FROM THE LIST
  		public void selectRegion(String regionName) throws InterruptedException{	
  			clickOnDropdown_1_RU();
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,listOptionAddress_RU,regionName);
  			Thread.sleep(1000);
  		}
  		
  		//TO SELECT THE LOCATION WHILE USERS SEARCHING THE FROM THE LIST
  		public void selectLocationWhileUsersSearch(String location) throws InterruptedException{	
  			clickOnDropdown_2_RU();
  			//BELOW LINE IS USED TO AVOID THE STALE ELEMENT REFERENCE
  			//List<WebElement> listOption_RU = driver.findElements(By.xpath(ruae.listOptionAvoidStaleElementReference_RU)); 
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,listOptionAddress_RU,location);
  			Thread.sleep(1000);
  		}
  		
  		//TO SELECT THE PACKAGE CATEGORY
  		public void selectPackageCategory(String packageName) throws InterruptedException{	
  			logger.info("SelectPackage methods called");
  			clickOnDropdownBoxAddress_1_RU();
  			//BELOW LINE IS USED TO AVOID THE STALE ELEMENT REFERENCE
  			//List<WebElement> listOption_RU = driver.findElements(By.xpath(ruae.listOptionAvoidStaleElementReference_RU)); 
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,listOptionAddress_RU,packageName);
  			Thread.sleep(1000);
  		}
  		
  		//TO SELECT THE PACKAGE CATEGORY
  		public void selectMembershipPackage(String membershipName) throws InterruptedException{	
  			logger.info("selectMembershipPackage methods called");
  			clickOnDropdownBoxAddress_2_RU();
  			//BELOW LINE IS USED TO AVOID THE STALE ELEMENT REFERENCE
  			//List<WebElement> listOption_RU = driver.findElements(By.xpath(ruae.listOptionAvoidStaleElementReference_RU)); 
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,listOptionAddress_RU,membershipName);
  			Thread.sleep(1000);
  		}
  		
  		//TO SELECT THE MEMBERSHIP START DATE
  		public void setMembershipStartDate(String membershipStartDate) throws Throwable {
  			clickOnDateIcon_1_RU();
  			DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,membershipStartDate);
  			logger.info("Custom date, month and year entered");
  		    Thread.sleep(500);
  		}
  		
  		
  		//TO SELECT THE ACTION MENU ITEMS
  		public void selectThreeDotActionMenuItem(String menuItemName) throws InterruptedException{	
  			logger.info("methods called: selectActionMenuItem");
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,listActionMenuItem_RU,menuItemName);
  			Thread.sleep(1000);
  		}
  	
  		
		public int findUsersAndClickOnThreeDotOption(String searchKey,WebDriver driver,int searchKeyColumnIndex,boolean wantToClickOnThreeDot) throws InterruptedException {
			Thread.sleep(2000);
			int listRowCount = FindThreeDotBasedOnSearchKeyAndClick.findThreedActionButtonAndClick(ruae.listData_RU,driver, searchKey, searchKeyColumnIndex,wantToClickOnThreeDot);
			return listRowCount;
		}
  		
		//TO SELECT THE PUASE MEMBESHIP START DATE
		public void setPauseMembershipStartDate(String pauseStartDate) throws InterruptedException {
			boolean flag = false;
			try {
				clickOnChangeDateIcon_1_RU();
				DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,pauseStartDate);
				flag = true;
			    Thread.sleep(1000);
			   
			}catch(Throwable e) {
				logger.info("Exception from setPauseMembershipStartDate: "+e.getMessage());
				softAssert.assertTrue(false,"To check pause membership start date");
			}
			if(!flag) {
				clickOnBtnCross_RU();
				Thread.sleep(500);
				clickOnBtnCross_RU();
		    }
		}
		
		//TO SELECT THE PAUSE MEMBERSHIP END DATE
		public void setPauseMembershipEndDate(String pauseEndDate) throws InterruptedException {
			boolean flag = false;
			try {
				clickOnChangeDateIcon_2_RU();
				DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,pauseEndDate);
				flag = true;
			    Thread.sleep(1000);
			}catch(Throwable e) {
				logger.info("Exeception from setPauseMembershipEndDate: "+e.getMessage());
				softAssert.assertTrue(false,"To check pause membership end date");
			}
			if(!flag) {
				clickOnBtnCross_RU();
				clickOnBtnCross_RU();
		    }
		}
		
		@FindBy(xpath = "//label[contains(text(),'Select a reason')]")
		@CacheLookup
		public WebElement btnDrpSelectReason;
		
		//TO CLICK ON DROPDWON BUTTON SELECT MEMBERSHIP PAUSE REASON
		public void clickOnDrpReason() throws InterruptedException {
			clickOnDropdownBoxAddress_1_RU();
		}
		
		//TO SELECT THE PAUSE MEMBERSHIP REASON
		public void selectReason(String reason) throws InterruptedException {
			clickOnDrpReason();
			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,reason);
			Thread.sleep(1000);
			logger.info("Pause membership reason selected");
		}
		
		//TO CLICK ON PAUSE MEMBERSHIP BUTTON
		@FindBy(xpath = "//span[normalize-space()='Pause Membership']")
		@CacheLookup
		public WebElement btnPauseMembership;
		public boolean clickOnPauseMembership() {
			boolean flag = false;
			if(btnPauseMembership.isDisplayed()) {
				btnPauseMembership.click();
				flag = true;
				logger.info("Clicked on the: btnPauseMembership");
			}else {
				logger.info("Pause membership button not displayed");
			}
			return flag;
		}
		
		//TO CLICK ON PAUSE MEMBERSHIP BUTTON
		public String textElementMembership = "//span[normalize-space()='Membership']";
		public boolean isDisplayedElementMembership() {
			boolean flag = false;
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(textElementMembership)));
			WebElement elementMembership = 	driver.findElement(By.xpath(textElementMembership));
				if(elementMembership.isDisplayed()) {
					flag = true;
					logger.info("Is Membership present: "+flag);
				}else {
					logger.info("Pause membership button not displayed");
				}
			}catch(Exception e) {
				
			}
			return flag;
		}
		
		
  		//TO ADD MEMBER
  		public PO_Main_HomePage addMember(String firstName, String lastName, String phoneNumber, String email, String location, String packageName, String membershipName, String membershipStartDate) throws Throwable 
  		{
  			clickOnAddMember_RU();
  			setFirstName(firstName);
  			setLastName(lastName);
  			setEmail(email);
  			logger.info("User first name: "+firstName);
  			logger.info("User last name: "+lastName);
  			logger.info("User email: "+email);
  			setPhoneNumber(phoneNumber);
  			clickONBtnContinue_RU();
  			selectLocation(location);
  			Thread.sleep(300);
  			selectPackageCategory(packageName);
  			Thread.sleep(300);
  			selectMembershipPackage(membershipName);
  			Thread.sleep(300);
  			setMembershipStartDate(membershipStartDate);
  			clickONBtnContinueAvoidStaleElemenetRefernce_RU(driver);
  			clickOnCheckBox_1_RU();
  			logger.info("Waiting for 20 seconds to enter the card details");
  			Thread.sleep(20000);
  			jsExecutor.executeScript("window.scrollBy(0, 200);");
  			Thread.sleep(500);
  			clickOnCheckBox_2_RU();
  			action.scrollByAmount(0, 300).build().perform();
  			Thread.sleep(1000);
  			clickOnAddMemberAvoidStaleElementReference_1_RU(driver);
  			Thread.sleep(1000);
  			String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  			if(alertMsg.equals(alertMsgMemberhsipPurchagedSuccessfully)) {
  				softAssert.assertEquals(alertMsg,alertMsgMemberhsipPurchagedSuccessfully,"Check user added successfully");
  				logger.info("===>>> "+alertMsg);
  			}else {
  				logger.info("Alert Message displayed: "+alertMsgMemberhsipPurchagedSuccessfully);
  			}
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		
  		//TO FIND SPECIFIC USERS ANY CLICK ON IT
  		public void findUsersAndViewUsersDetails(String searchKeyuserNameOrEmail,String regionName,String locationName,int searchKeyColumnIndex, boolean wantToClickOnUser,int listActionIndex) throws InterruptedException
  		{
  			selectRegion(regionName);
  			selectLocationWhileUsersSearch(locationName);
  			searchBox_RU(searchKeyuserNameOrEmail);
  			int listRowCount = findUsersAndClickOnThreeDotOption(searchKeyuserNameOrEmail,driver,searchKeyColumnIndex,wantToClickOnUser);
  			logger.info("listRowCount:  "+listRowCount);
  			if(listRowCount != -1) {	
  				clickOnAnyActionBtnPresentUnderThreeDotOption_RU(driver,listActionIndex);
  				Thread.sleep(3000);
			}else {
				softAssert.assertTrue(false,"User you to search is not present");
			}
  			softAssert.assertAll();
  			//NOTE: NOT TAKING RETURN TYPE IN THIS, SO THAT IT WILL STAY ON THE USERS DETAILS PAGE
  		}
  		
  		//TO PAUSE MEMBERSHIP
  		public PO_Main_HomePage pauseMembership(String pauseStartDate, String pauseEndDate, String pauseReason) throws InterruptedException {
  			
  			if(isDisplayedElementMembership()) {
  				Thread.sleep(1000);
  				clickOnActionButton_1_RU();
  	  			selectThreeDotActionMenuItem("Pause Membership");
  	  			setPauseMembershipStartDate(pauseStartDate);
  	  			setPauseMembershipEndDate(pauseEndDate);
  	  			selectReason(pauseReason);
  	  			boolean flag = clickOnPauseMembership();
  	  			if(flag) {
  	  				String alertContent = snakeAlertMessagesDisplayedContent_RU();
  	  				if(alertContent.equalsIgnoreCase(alertMsgMembeshipChangeSuccessfully)) {
  	  					logger.info("===>>> "+alertMsgMembeshipChangeSuccessfully);
  	  				}else {
  	  					logger.info("===>>> "+alertContent);
  	  				}
  	  			}
  			}
  			softAssert.assertAll();	
  			return new PO_Main_HomePage(driver);
  		}
  		
}
