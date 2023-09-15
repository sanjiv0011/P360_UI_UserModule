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

import com.p360.ReUseAble.PageObject.ReUseAbleElement;
import com.p360.pageObject.PO_LoginPage;
import com.p360.projectUtility.DatePicker;
import com.p360.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;

public class PO_Main_ClassesPage extends ReUseAbleElement {
		
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
		public PO_Main_ClassesPage(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(30));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);

		}
		
		//ALERT MESSAGES
		public String alertMsgRegionCreatedSuccessfully = "Class Created Successfully";

		
		
		//======START======PAGE OBJECT FOR ADD CLASS AND ACTOIN METHODS==========//
		//BUTTON ADD CLASS
  		@FindBy(xpath = "(//span[normalize-space()='Add Class'])[1]")
  		@CacheLookup
  		public WebElement btnAddClass;
  		public void clickOnBtnAddClass() throws InterruptedException {
  			btnAddClass.click();
  			logger.info("Clicked on the btn btnAddClass");
  			Thread.sleep(1000);
  		}
		
  		
  		//TEXT FIELD CLASS NAME
  		@FindBy(xpath = "//input[@placeholder='Enter Class Name']")
  		@CacheLookup
  		public WebElement fieldClassName;
  		public void setClassName(String className) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldClassName));
  			fieldClassName.sendKeys(Keys.CONTROL,"a");
  			fieldClassName.sendKeys(Keys.DELETE);
  			fieldClassName.sendKeys(className);
  			logger.info("Entered the fieldClassName: "+className);
  			Thread.sleep(300);
  		}
  		
  		
  		//TEXT FIELD CLASS CAPACITY
  		@FindBy(xpath = "//input[contains(@name,'capacity')]")
  		@CacheLookup
  		public WebElement fieldClassCapacity;
  		public void setClassCapacity(String classCapacity) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldClassCapacity));
  			fieldClassCapacity.sendKeys(Keys.CONTROL,"a");
  			fieldClassCapacity.sendKeys(Keys.DELETE);
  			fieldClassCapacity.sendKeys(classCapacity);
  			logger.info("Entered the fieldClassCapacity: "+classCapacity);
  			Thread.sleep(300);
  		}
  	
  		//TO SELECT THE LOCATION
  		public void selectLocation(String classLocation) throws InterruptedException {
  			//ruae.clickOnDropdown_3_RU();
  			driver.findElement(By.xpath("(//button[@title='Open']//*[name()='svg'])[3]")).click();
  			//Will avoid the stale element reference
  			Thread.sleep(500);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,classLocation);
  			Thread.sleep(500);
  		}
  		
  		
  		//TO SELECT THE INITIAL COACH
  		public void selectCoach(String caochName) throws InterruptedException {
  			//ruae.clickOnDropdown_3_RU();
  			driver.findElement(By.xpath("(//button[@title='Open']//*[name()='svg'])[4]")).click();
  			//Will avoid the stale element reference
  			Thread.sleep(500);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,caochName);
  			Thread.sleep(500);
  		}
  		
  		//TEXT FIELD CANCELATION CUTOFF TIME
  		@FindBy(xpath = "//input[@placeholder='Cancellation Cut-Off Time']")
  		@CacheLookup
  		public WebElement fieldCancelationCutOffTime;
  		public void setCancelationCutoffTime(String cancelationCutOffTime) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldCancelationCutOffTime));
  			fieldCancelationCutOffTime.sendKeys(Keys.CONTROL,"a");
  			fieldCancelationCutOffTime.sendKeys(Keys.DELETE);
  			fieldCancelationCutOffTime.sendKeys(cancelationCutOffTime);
  			logger.info("Entered fieldCancelationCutOffTime: "+cancelationCutOffTime);
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD CANCELATION CUTOFF TIME
  		@FindBy(xpath = "//input[contains(@name,'waitListSpots')]")
  		@CacheLookup
  		public WebElement fieldWaitLisSpot;
  		public void setWaitListSpot(String waitListSpot) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldCancelationCutOffTime));
  			fieldWaitLisSpot.sendKeys(Keys.CONTROL,"a");
  			fieldWaitLisSpot.sendKeys(Keys.DELETE);
  			fieldWaitLisSpot.sendKeys(waitListSpot);
  			logger.info("Entered fieldWaitLisSpot: "+waitListSpot);
  			Thread.sleep(300);
  		}
  		
  		//TEXT CREATE CLASS SCHEDULE
  		@FindBy(xpath = "//div[text()=\"Create a Class Schedule \"]")
  		@CacheLookup
  		public WebElement textCreatClassShedule;
  		public boolean isTextCreateClassShedulePresent() throws InterruptedException {
  			boolean flag = false;
  			try {
  				if(textCreatClassShedule.isDisplayed()){
  					flag = true;
  					logger.info("TextCreatClassShedule is displayed: "+flag);
  	  	  			Thread.sleep(300);
  				}else {
  					
  				}
  			}catch(Exception e) {
  				logger.info("Exception from : "+e.getMessage());
  			}
  			return flag;
  		}
  		

  	
  		//TO SELECT THE CLASS START DATE
  		public void setClassStartDate(String classStartDate,int dateIconNumber) throws InterruptedException {
  			//clickOnChangeDateIcon_1_RU();
  			DatePicker.setDateByDirectSendingDateVauleInTheTextBox(driver,classStartDate,dateIconNumber);
  		    Thread.sleep(1000);
  		}
  		
  		
  		//TO SELECT THE CLASS END DATE
  		public void setClassEndDate(String classEndDate, int dateIconNumber) throws InterruptedException {
  			//clickOnChangeDateIcon_2_RU();
  			DatePicker.setDateByDirectSendingDateVauleInTheTextBox(driver,classEndDate,dateIconNumber);
  		    Thread.sleep(1000);
  		}
  		
  		//TO SELECT CLASS DAYS
  		public void selectClassDays(String dayName) throws InterruptedException {
  			ruae.clickOnDropdownBoxAddress_1_RU();
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,dayName);
  			Thread.sleep(500);
  		}
  		
  		//TO SELECT CLASS TIME
  		public void selectClassTime(WebDriver driver, String hours,String minutes, String AmPm) throws InterruptedException {
  			setTimeWithoutUsingTimePicker_RU(driver, hours, minutes, AmPm);
  			Thread.sleep(500);
  		}
  		
  		
  		//BUTTON ADD
  		@FindBy(xpath = "(//span[normalize-space()='Add'])[1]")
  		@CacheLookup
  		public WebElement btnAdd;
  		public void clickOnBtnAdd() throws InterruptedException {
  			btnAdd.click();
  			logger.info("Clicked on the btn btnAdd");
  			Thread.sleep(1000);
  		}
  		//======END======PAGE OBJECT FOR ADD CLASS AND CLASS SHEDULE ACTOIN METHODS==========//
  				
  				
  				
  		//TO ADD CLASS
  		public PO_Main_HomePage addClass(String className,String classLocation, String caochName, String classCapacity,String cancelationCutOffTime, String waitListSpot, String description, String classStartDate,String classEndDate,String dayName,String hours,String minutes,String AmPm) throws InterruptedException
  		{
  			clickOnBtnAddClass();
  			setClassName(className);
  			selectLocation(classLocation);
  			selectCoach(caochName);
  			setClassCapacity(classCapacity);
  			setCancelationCutoffTime(cancelationCutOffTime);
  			if(clickOnCheckBox_1_RU()) {
  				setWaitListSpot(waitListSpot);
  			}
  			setDescription_RU(description);
  			if(clickOnBtnNext_1_RU()) {
  				
  				if(isRequiredOrInvalidMessageDisplayed_RU()) {
  					clickOnCancelButton_1_RU();
  				}else {
  					Thread.sleep(2000);
  		  			if(isTextCreateClassShedulePresent()) {
  		  				setClassStartDate(classStartDate,1);
  		  				setClassEndDate(classEndDate,2);
  		  				selectClassDays(dayName);
  		  				selectClassTime(driver, hours, minutes, AmPm);
  		  				clickOnBtnAdd();
  		  			}
  				}
  			}
  			
  			
  			if(clickOnBtnSave_1_RU()) 
  			{
  				if(isRequiredOrInvalidMessageDisplayed_RU()) {
  	  				Thread.sleep(1000);
  	  				clickOnCancelButton_1_RU();
  	  				softAssert.assertTrue(false,"Required or Invalid Message Displayed");
  				}else {
  					Thread.sleep(100);
  	  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  	  				if(alertMsg.equals(alertMsgRegionCreatedSuccessfully)) {
  	  					softAssert.assertEquals(alertMsg, alertMsgRegionCreatedSuccessfully,"Checks class created successfully");
  	  				}
  	  			}
  			}
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
}
