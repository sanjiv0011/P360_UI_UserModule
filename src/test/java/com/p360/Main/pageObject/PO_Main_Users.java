package com.p360.Main.pageObject;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.p360.ReUseAble.PageObject.ReUseAbleElement;
import com.p360.pageObject.PO_LoginPage;
import com.p360.projectUtility.DatePicker;
import com.p360.projectUtility.Generic_Method_ToSelect_Boostrape_Dropdown;

public class PO_Main_Users extends ReUseAbleElement {
		
		//CONSTRUCTOR DECLARATION
		public WebDriver driver;
		public Logger logger = LogManager.getLogger(getClass());
		public JavascriptExecutor jsExecutor;
		public ReUseAbleElement ruae;
		public WebDriverWait wait;
		public PO_LoginPage lp;
		public Actions action;
		
		//HOMEPAGE CONSTRUCTOR CREATION
		public PO_Main_Users(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(45));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);

		}

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
  			feildPhoneNumber.click();
  			logger.info("Clicked on the field phone number");
  			Thread.sleep(300);
  		}
		
  		//TO SELECT THE LOCATION THE FROM THE LIST
  		public void selectLocation(String location) throws InterruptedException{	
  			clickOnDropdown_1_RU();
  			Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(ruae.listOption_RU,location);
  			Thread.sleep(1000);
  		}
  		
  		//TO SELECT THE PACKAGE CATEGORY
  		public void selectPackageCategory(String packageName) throws InterruptedException{	
  			logger.info("SelectPackage methods called");
  			clickOnDropdownBoxAddress_1_RU();
  			Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(ruae.listOption_RU,packageName);
  			Thread.sleep(1000);
  		}
  		
  		//TO SELECT THE PACKAGE CATEGORY
  		public void selectMembershipPackage(String membershipName) throws InterruptedException{	
  			logger.info("SelectPackage methods called");
  			clickOnDropdownBoxAddress_2_RU();
  			Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(ruae.listOption_RU,membershipName);
  			Thread.sleep(1000);
  		}
  		
  		//TO SELECT THE MEMBERSHIP START DATE
  		public void setMembershipStartDate(String membershipStartDate) throws InterruptedException {
  			clickOnDateIcon_1_RU();
  			DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,membershipStartDate);
  			logger.info("Custom date, month and year entered");
  		    Thread.sleep(500);
  		}
  		
  		//TO ADD MEMBER
  		public PO_Main_HomePage addMember(String firstName, String lastName, String phoneNumber, String email, String location, String packageName, String membershipName, String membershipStartDate) throws InterruptedException 
  		{
  			clickOnAddMember_RU();
  			setFirstName(firstName);
  			setLastName(lastName);
  			setEmail(email);
  			setPhoneNumber(phoneNumber);
  			clickONBtnContinue_RU();
  			selectLocation(location);
  			selectPackageCategory(packageName);
  			selectMembershipPackage(membershipName);
  			setMembershipStartDate(membershipStartDate);
  			clickONBtnContinue_RU();
  			clickOnCheckBox_1_RU();
  			clickOnCheckBox_2_RU();
  			clickOnAddMember_RU();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		
}
