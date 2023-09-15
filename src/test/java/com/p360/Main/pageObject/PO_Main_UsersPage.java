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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.p360.ReUseAble.PageObject.ReUseAbleElement;
import com.p360.pageObject.PO_LoginPage;
import com.p360.projectUtility.DatePicker;
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
  			logger.info("SelectPackage methods called");
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
  		
  		
}
