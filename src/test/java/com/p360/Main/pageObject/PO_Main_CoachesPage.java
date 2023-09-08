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

import com.p360.ReUseAble.PageObject.ReUseAbleElement;
import com.p360.pageObject.PO_LoginPage;
import com.p360.projectUtility.DatePicker;
import com.p360.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;

public class PO_Main_CoachesPage extends ReUseAbleElement {
		
		//CONSTRUCTOR DECLARATION
		public WebDriver driver;
		public Logger logger = LogManager.getLogger(getClass());
		public JavascriptExecutor jsExecutor;
		public ReUseAbleElement ruae;
		public WebDriverWait wait;
		public PO_LoginPage lp;
		public Actions action;
		
		//HOMEPAGE CONSTRUCTOR CREATION
		public PO_Main_CoachesPage(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(30));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);

		}
		
		//ALERT MESSAGES
		public String alertMsgCoachInvitedSuccessfully = "Coach invite Successfully";
	
		
		//======START======PAGE OBJECT FOR ADD CLASS AND ACTOIN METHODS==========//
		//BUTTON INVITE COACH
  		@FindBy(xpath = "(//span[normalize-space()='Invite Coach'])[1]")
  		@CacheLookup
  		public WebElement btnInviteCoach;
  		public void clickOnBtnInviteCoach() throws InterruptedException {
  			btnInviteCoach.click();
  			logger.info("Clicked on the btn btnInviteCoach");
  			Thread.sleep(1000);
  		}
  		
  		//BUTTON INVITE COACH
  		@FindBy(xpath = "(//span[normalize-space()='Invite Coach'])[3]")
  		@CacheLookup
  		public WebElement btnInviteCoachSubmit;
  		public void clickOnBtnInviteCoachSubmit() throws InterruptedException {
  			btnInviteCoachSubmit.click();
  			logger.info("Clicked on the btn btnInviteCoachSubmit");
  			Thread.sleep(1000);
  		}
  		
		
  		
  		//TEXT FIELD FIRST NAME
  		@FindBy(xpath = "//input[contains(@name,'firstName')]")
  		@CacheLookup
  		public WebElement fieldFirstName;
  		public void setFisrtName(String firstName) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldFirstName));
  			fieldFirstName.sendKeys(Keys.CONTROL,"a");
  			fieldFirstName.sendKeys(Keys.DELETE);
  			fieldFirstName.sendKeys(firstName);
  			logger.info("Entered the fieldFirstName: "+firstName);
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD LAST NAME
  		@FindBy(xpath = "//input[contains(@name,'lastName')]")
  		@CacheLookup
  		public WebElement fieldLastName;
  		public void setLastName(String lastName) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldFirstName));
  			fieldLastName.sendKeys(Keys.CONTROL,"a");
  			fieldLastName.sendKeys(Keys.DELETE);
  			fieldLastName.sendKeys(lastName);
  			logger.info("Entered the fieldLastName: "+lastName);
  			Thread.sleep(300);
  		}
  		
  		
  		//TEXT FIELD EMAIL
  		@FindBy(xpath = "//input[contains(@name,'email')]")
  		@CacheLookup
  		public WebElement fieldEmail;
  		public void setEmail(String email) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldFirstName));
  			fieldEmail.sendKeys(Keys.CONTROL,"a");
  			fieldEmail.sendKeys(Keys.DELETE);
  			fieldEmail.sendKeys(email);
  			logger.info("Entered the fieldEmail: "+email);
  			Thread.sleep(300);
  		}
  		
  	
  		//TO SELECT THE LOCATION
  		public void selectCoachLocation(String coachLocation) throws InterruptedException {
  			//ruae.clickOnDropdown_3_RU();
  			driver.findElement(By.xpath("(//button[@title='Open']//*[name()='svg'])[2]")).click();
  			//Will avoid the stale element reference
  			Thread.sleep(500);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,coachLocation);
  			Thread.sleep(500);
  		}
  		
  		
  		
  		//======END======PAGE OBJECT FOR ADD CLASS AND CLASS SHEDULE ACTOIN METHODS==========//
  				
  				
  				
  		//TO INVITE COACH
  		public PO_Main_HomePage inviteCoach(String firstName,String lastName, String email, String coachLocation) throws InterruptedException
  		{
  			clickOnBtnInviteCoach();
  			setFisrtName(firstName);
  			setLastName(lastName);
  			setEmail(email);
  			selectCoachLocation(coachLocation);
  			clickOnBtnInviteCoachSubmit();
			if(isRequiredOrInvalidMessageDisplayed_RU()) {
				clickOnCancelButton_1_RU();
			}else {
				Thread.sleep(100);
  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  				if(alertMsg.equals(alertMsgCoachInvitedSuccessfully)) {
  					Assert.assertEquals(alertMsg, alertMsgCoachInvitedSuccessfully,"Checks Coach Invited successfully");
  				}else {
  					Assert.assertTrue(false,"Coach not invited successfully");
  				}
			}
  			
  			return new PO_Main_HomePage(driver);
  		}
  		
}
