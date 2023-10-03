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

import com.p360.Actions.Action_Activate;
import com.p360.Actions.Action_Change;
import com.p360.Actions.Action_Deactivate;
import com.p360.ReUseAble.PageObject.ReUseAbleElement;
import com.p360.pageObject.PO_LoginPage;
import com.p360.projectUtility.DatePicker;
import com.p360.projectUtility.FindDateInCalendar;
import com.p360.projectUtility.FindDeleteBoxFromListAndClick;
import com.p360.projectUtility.FindThreeDotAndClick;
import com.p360.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;
import com.p360.projectUtility.MyCalendarPicker;

public class PO_Main_PromoCodesPage extends ReUseAbleElement {
		
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
		public PO_Main_PromoCodesPage(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(30));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);

		}
		
		//ALERT MESSAGES
		public String alertMsgMovementAdded = "Movement Added successfully";
		public String alertMsgMovementDeActivated = "Status Changed Successfully.";
		public String alertMsgMovementActivated = "Status Changed Successfully.";
		public String alertMsgMovementUpdated = "Movement Updated Successfully";
		
		public String alertMsgMovementAssigned = "Movement assigned";
		public String alertMsgMovementRemoved = "Movement removed";
	
		
		//======START======PAGE OBJECT FOR MOVEMENT AND ACTOIN METHODS==========//
		//BUTTON MOVEMENT LISTING
  		@FindBy(xpath = "//span[contains(normalize-space(),'Add Promo code')]")
  		@CacheLookup
  		public WebElement btnMovementListing;
  		public void clickOnBtnMovementListing() throws InterruptedException {
  			btnMovementListing.click();
  			logger.info("Clicked on the btnMovementListing");
  			Thread.sleep(1000);
  		}
  		
  		//TEXT FIELD CODES NAME
  		@FindBy(xpath = "//input[@placeholder='Enter Code']")
  		@CacheLookup
  		public WebElement fieldCodeName;
  		public void setMovementName(String codeName) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldCodeName));
  			fieldCodeName.sendKeys(Keys.CONTROL,"a");
  			fieldCodeName.sendKeys(Keys.DELETE);
  			fieldCodeName.sendKeys(codeName);
  			logger.info("Entered the fieldFirstName: "+codeName);
  			Thread.sleep(300);
  		}
  		
  		//BUTTON DISCOUNT TYPE PERCENT 
  		@FindBy(xpath = "(//div[@class='w-full text-center font-bold text-xl'])[1]")
  		@CacheLookup
  		public WebElement btnDiscountInPercent;
  		public void clickOnBtnDiscountInPercent() throws InterruptedException {
  			btnDiscountInPercent.click();
  			logger.info("Clicked on the btnDiscountInPercent");
  			Thread.sleep(1000);
  		}
  		
  		//BUTTON DISCOUNT TYPE DOLLER 
  		@FindBy(xpath = "(//div[contains(@class,'font-bold text-xl')][normalize-space()='$'])[1]")
  		@CacheLookup
  		public WebElement btnDiscountInDollar;
  		public void clickOnBtnDiscountInDollar() throws InterruptedException {
  			btnDiscountInDollar.click();
  			logger.info("Clicked on the btnDiscountInDollar");
  			Thread.sleep(1000);
  		}
  		
  		
  		//TEXT FIELD DISCOUNT VALUE
  		@FindBy(xpath = "//input[contains(@placeholder,'Enter Discount Value')]")
  		@CacheLookup
  		public WebElement fielDiscountValue;
  		public void setDiscountValue(String discountValue) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fielDiscountValue));
  			fielDiscountValue.sendKeys(Keys.CONTROL,"a");
  			fielDiscountValue.sendKeys(Keys.DELETE);
  			fielDiscountValue.sendKeys(discountValue);
  			logger.info("Entered the fieldFirstName: "+discountValue);
  			Thread.sleep(300);
  		}
  		
  		
  		//TO SELECT THE PROMO CODE START DATE
  		public void setPromoCodeStartDate(String promoCodeStartDate) throws Throwable {
  			clickOnChangeDateIcon_1_RU();
  			DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,promoCodeStartDate);
  		    Thread.sleep(500);
  		}
  		
  		//TO SELECT THE PROMO CODE END DATE
  		public void setPromoCodeEndDate(String promoCodeEndDate) throws Throwable {
  			clickOnChangeDateIcon_2_RU();
  			DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,promoCodeEndDate);
  		    Thread.sleep(500);
  		}
  		
  		//CHECKBOX ALLOW  FOR ALL LOCATIONS
  		public void checkboxAllowForAllLocations() throws InterruptedException {
  			ruae.clickOnCheckBox_1_RU();
  		}
  		
  		//TO SELECT THE LOCATIONS
  		public void selectLocations(String locationName) throws InterruptedException {
  			ruae.clickOnDropdown_1_RU(driver);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,locationName);
  			logger.info("Selected Locations from the list: "+locationName);
  			Thread.sleep(500);
  		}
  		
  		
  		//CHECKBOX ALLOW FOR ALL USERS
  		public void checkboxAllowForAllUsers() throws InterruptedException {
  			ruae.clickOnCheckBox_2_RU();
  		}
  		
  		//TEXT FIELD MAX NUMBER OF USERS
  		@FindBy(xpath = "//input[@placeholder='Enter Max Number Of Users']")
  		@CacheLookup
  		public WebElement fielMaxNumberOfUsers;
  		public void setMaxNumberOfUsers(String maxNumberOfUsers) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fielMaxNumberOfUsers));
  			fielMaxNumberOfUsers.sendKeys(Keys.CONTROL,"a");
  			fielMaxNumberOfUsers.sendKeys(Keys.DELETE);
  			fielMaxNumberOfUsers.sendKeys(maxNumberOfUsers);
  			logger.info("Entered the fielMaxNumberOfUsers: "+maxNumberOfUsers);
  			Thread.sleep(300);
  		}
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
//  		
//  		//SAVE AND CLOSE BUTTON
//  		@FindBy(xpath = "//span[normalize-space()='Save & close']")
//  		@CacheLookup
//  		public WebElement btnSaveAndClose;
//  		public boolean clickOnBtnSaveAndClose() throws InterruptedException {
//  			boolean flag = false;
//  			try {
//  				btnSaveAndClose.click();
//  				flag = true;
//  	  			logger.info("Clicked on the btnSaveAndClose");
//  	  			Thread.sleep(1000);
//  			}catch(Exception e) {
//  				logger.info("Exception from: "+e.getMessage());
//  			}
//  			
//  			return flag;
//  		}
//  	
//  		
//  		
//  		
//  		
//  		//TEXT NO MOVEMENT MATCHED TO CURRENT APPLIED FILTER
//  		@FindBy(xpath = "//*[.='No Movements Matches Current Filter")
//  		@CacheLookup
//  		public WebElement noMovementMatchedWithApplieddFilter;
//  		public boolean  isNoMovementMatchedDisplayed() throws InterruptedException {
//  			boolean flag = false;
//  			try {
//  				if(noMovementMatchedWithApplieddFilter.isDisplayed()) {
//  					flag = true;
//  					logger.info("Searched key not present");
//  					softAssert.assertTrue(flag,"Movement you are searching is not found");
//  					clickOnP360Logo_RU();
//  				}
//  			}catch(Exception e) {
//  				flag = false;
//  				logger.info("Searched Movement is matched with the applied fileter");
//  				logger.info("Exception from : "+e.getMessage());
//  			}
//  			softAssert.assertAll();
//  			return flag;
//  		}
//  		
//  		
//  		//MOVEMENT LIST 
//  		@FindBy(xpath = "(//div[contains(@class,'w-full flex')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]")
//  		@CacheLookup
//  		List<WebElement> movementList;
//  		//MOVEMENT ROW LIST ADDRESS AND ACTION METHODS
//  		public String movementList_address = "(//div[contains(@class,'w-full flex')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]";
//  		public int findMovementFromRowListAndClickOnThreeDot(String movementName, int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException {
//  			int listRowCount = 0; 
//			try {
//				Thread.sleep(2000);
//				listRowCount = FindThreeDotAndClick.findThreedActionButtonAndClick(movementList_address,movementList,driver, movementName, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
//				
//			}catch(Exception e) {
//				logger.info("Exception from findMovementFromRowListAndClickOnThreeDot: "+e.getMessage());
//				softAssert.assertTrue(false,"not click on the three dot action button");
//			}
//			return listRowCount;
//  		}
//  		
//  		
//  		
//  		//TO CLICK ON THE CALENDAR DATE BOX
//  		@FindBy(xpath = "//div[@role='cell']//a")
//  		@CacheLookup
//  		public List <WebElement> calendarDateList;
//  		//CALENDAR MONTH YAER ADDRESS
//  		public String monthYearAddress = "//span[@class='rbc-toolbar-label']";
//  		
//  		//TO SELECT THE MOVEMENT
//  		public void selectMovement(String movementName) throws InterruptedException {
//  			ruae.clickOnDropdown_1_RU(driver);
//  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,movementName);
//  			logger.info("Selected Movement from the list: "+movementName);
//  			Thread.sleep(500);
//  		}
//  		
//  		//ASSIGNED MOVEMENT LIST ADDRESS AND ACTION BUTTON
//  		@FindBy(xpath = "//div[contains(@class,'flex flex-col mt-5 gap-3')]//div[contains(@class,'bg-red')]")
//  		@CacheLookup
//  		public List <WebElement> assignedMovementList;
//  		public String assignedMovementListAddress = "//div[contains(@class,'flex flex-col mt-5 gap-3')]//div[contains(@class,'bg-red')]";
//  		
//  		//DELETE BOX ADDRESS
//  		public String deleteBox_address = "//*[name()='svg'][@class='MuiSvgIcon-root cursor-pointer']";
//  		
//  		//======END======PAGE OBJECT FOR ADD MOVEMENT ACTOIN METHODS==========//
//  				
//  				
  				
  		//TO ADD PROMOCODES
  		public PO_Main_HomePage addOrChangePromoCodes(String promoCodeName,String discountTypes,String  discountValue, String promoCodeStartDate,String promoCodeEndDate,boolean wantToAllowForAllLocations,boolean wantToAllowForAllUsers,String locationName,String maxNumberOfUsers) throws Throwable
  		{
  			StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
  			String callerMethodName = stackTraceElement[2].getMethodName();
  			logger.info("addOrChangeWorkout caller method name: "+callerMethodName);
  			
  			
  			
//  			if(flag) {
//  				if(isRequiredOrInvalidMessageDisplayed_RU()) {
//  					clickOnCancelButton_1_RU();
//  				}else {
//  					Thread.sleep(100);
//  	  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
//  	  				if(alertMsg.equals(alertMsgMovementAdded)) {
//  	  					logger.info("Movement added");
//  	  					softAssert.assertEquals(alertMsg, alertMsgMovementAdded,"movement added successfully");
//  	  				}else if(alertMsg.equals(alertMsgMovementUpdated)){
//  	  					logger.info("Workout updated");
//  	  					softAssert.assertEquals(alertMsg, alertMsgMovementUpdated,"Movement updated successfully");
//  	  				}else {
//  	  					softAssert.assertTrue(false,"Movement neither added nor updated successfully.");
//  	  				}
//  				}
//  			}else {
//  				logger.info("Not clicked on the save button");
//  				softAssert.assertTrue(false,"You want to add Movement or update, but not clicked on the save button");
//  			}
			
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
//  		//FIND MOVEMENT FROM THE LIST AND CLICK ON THE THREE DOT BUTTON
//  		public void findMovementFromListAndClickOnThreeDotButton(String searchKey,String movementName,boolean wantToClickOnThreeDot,int searchKeyColumnIndex, boolean wantToClickOnSearchKey) throws InterruptedException
//  		{
//  			clickOnBtnMovementListing();
//  			Thread.sleep(1000);
//  			searchBox_1_RU(driver, searchKey);
//  			Thread.sleep(5000);
//  			boolean flag = isNoMovementMatchedDisplayed();
//  			if(!flag) {
//  	  			findMovementFromRowListAndClickOnThreeDot(movementName, searchKeyColumnIndex, wantToClickOnThreeDot, wantToClickOnSearchKey);
//  	  		
//  			}else {
//  				softAssert.assertTrue(false,"Movement you are searching is not present");
//  			}
//  			softAssert.assertAll();
//  		}
//  		
//  		
//  		//TO ACTIVATE THE MOVEMENT
//  		public PO_Main_HomePage activateMovement() throws InterruptedException
//  		{
//  			Action_Activate.activate(driver, alertMsgMovementActivated);
//  			softAssert.assertAll();
//  			return new PO_Main_HomePage(driver);
//  		}
//  		
//  		//TO DEACTIVATE THE MOVEMENT
//  		public PO_Main_HomePage deactivateMovement() throws InterruptedException
//  		{
//  			Action_Deactivate.deactivate(driver, alertMsgMovementDeActivated);
//  			softAssert.assertAll();
//  			return new PO_Main_HomePage(driver);
//  		}
//  		
//  		//TO ASSIGN MOVEMENT TO DATE
//  		public PO_Main_HomePage assignMovementToDate(String dateValue,String wantToClickOnDateOrDateBox,String movementName) throws InterruptedException 
//  		{
//  			boolean bol = FindDateInCalendar.findDateInCallendar(driver, dateValue, monthYearAddress,address_BackStarTag_1_RU,address_NextStarTag_1_RU, calendarDateList,wantToClickOnDateOrDateBox);
//  			if(bol) 
//  			{
//  				selectMovement(movementName);
//  				if(clickOnAdd_RU())
//  				{
//  					String alertMsg = snakeAlertMessagesDisplayedContent_RU();
//  	  				if(alertMsg.equals(alertMsgMovementAssigned)) {
//  	  					logger.info("Workout assigened");
//  	  					softAssert.assertEquals(alertMsg, alertMsgMovementAssigned,"Movement assigend successfully");
//  	  				}else {
//  	  					softAssert.assertTrue(false,"Movement not assigned");
//  	  				}
//  				}
//  				clickOnBtnCross_1_RU();
//  			}
//  			
//  			softAssert.assertAll();
//  			return new PO_Main_HomePage(driver);
//  		}
//  		
//  		
//  		//TO REMOVED ASSIGN MOVEMENT FROM THE DATE
//  		public PO_Main_HomePage removeMovementFromDate(String dateValue,String wantToClickOnDateOrDateBox,String movementName,String searchKey,int searchKeyColumnIndex, boolean wantToClickOnDeleteBox, boolean wantToclickOnFindSearckKey) throws InterruptedException 
//  		{
//  			boolean bol = FindDateInCalendar.findDateInCallendar(driver,dateValue, monthYearAddress,address_BackStarTag_1_RU,address_NextStarTag_1_RU, calendarDateList,wantToClickOnDateOrDateBox);
//  			if(bol) 
//  			{
//  				FindDeleteBoxFromListAndClick.findDeleteBoxButtonAndClick(assignedMovementListAddress, assignedMovementList, driver, searchKey,searchKeyColumnIndex, wantToClickOnDeleteBox, wantToclickOnFindSearckKey);
//  				if(clickOnBtnYes_RU(driver))
//  				{
//  					String alertMsg = snakeAlertMessagesDisplayedContent_RU();
//  	  				if(alertMsg.equals(alertMsgMovementRemoved)) {
//  	  					logger.info("Movement assigened");
//  	  					softAssert.assertEquals(alertMsg, alertMsgMovementRemoved,"Movement removed from the assigned date successfully");
//  	  				}else {
//  	  					softAssert.assertTrue(false,"Movement not removed from the assigned date successfully.");
//  	  				}
//  				}
//  				clickOnBtnCross_1_RU();
//  			}
//  			
//  			softAssert.assertAll();
//  			return new PO_Main_HomePage(driver);
//  		}
//  		
//  		
  		
  	

}
