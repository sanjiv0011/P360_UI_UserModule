package com.p360.pageObject;

import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.p360.projectUtility.FindThreeDotBasedOnSearchKeyAndClick;
import com.p360.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;

public class PO_ClassesPage extends ReUseAbleElement{

		//CONSTRUCTOR DECLARATION
		public WebDriver driver;
		public Logger logger = LogManager.getLogger(getClass());
		public JavascriptExecutor jsExecutor;
		public ReUseAbleElement ruae;
		public WebDriverWait wait;
		public PO_LoginPage lp;
		public Actions action;
		public PO_HomePage hp;
		public SoftAssert softAssert = new SoftAssert();
		
		
		//HOMEPAGE CONSTRUCTOR CREATION
		public PO_ClassesPage(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(30));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);
			hp = new PO_HomePage(driver);
		}
		
		//IN THIS VARAIBLES VALUES ASSGINED FROM THE DATA BASE TESTING ONCE DATABASE TESTING COMPLETED(WHILE CLASS REGISTRATIN), IT WILL BE REUSE TO CANCEL THE SAME REGISTRED CLASS
		public String dateTimePresentInRegisteredClassList;
		//VARIABLES 
		public String alertMsgAlreadyClassRegistered = "User registration already exists for this class";
		public String alertMsgClassCanceled = "Class Canceled.";
		public String alertMsgNoCreditAvailabe = "No credits available to make this purchase";
		
		//=========START========CLASSES PAGE OBJECT AND ACTION METHODSS=============//
		
		//BUTTON REGISTER FOR CLASS
		@FindBy(xpath = "//span[normalize-space()='Register for new class']")
		@CacheLookup
		public WebElement btnRegisterForClass;
		public boolean clickOnBtnRegisterForClass() throws InterruptedException {
			boolean flag = false;
			try {
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(btnRegisterForClass));
				if(btnRegisterForClass.isDisplayed()) {
					Thread.sleep(1000);
					btnRegisterForClass.click();
					logger.info("Clicked on the Button register for the class");
					Thread.sleep(2000);
					flag = true;
				}
			}catch(Exception e) {
				logger.info("Exception from clickOnBtnRegisterForClass: "+e.getMessage());
				logger.info("Register class button not present");
			}
			return flag;
		}
		
		//TEXT NO CLASS FOUND
		@FindBy(xpath = "//span[normalize-space()='No Classes Found']")
		@CacheLookup
		public WebElement textNoClassFound;
		public boolean isNoClassFoundTextPresent() throws InterruptedException {
			boolean flag = false;
			try {
				Thread.sleep(5000);
				flag = wait.until(ExpectedConditions.textToBePresentInElement(textNoClassFound, "No Classes Found"));
				logger.info("Checking is no class found text present: "+flag);
				Thread.sleep(2000);
				
			}catch(Exception e) {
				logger.info("Exception from isNoClassFoundTextPresent: "+e.getCause());
			}
			return flag;
		}
		
		//BUTTON GO TO DASHBAORD
		@FindBy(xpath = "//span[normalize-space()='Go to dashboard']")
		@CacheLookup
		public WebElement btnGoToDashBoard;
		public void clickOnBtnGoToDashBoard() throws InterruptedException {
			Thread.sleep(5000);
			try {
				wait.until(ExpectedConditions.elementToBeClickable(btnGoToDashBoard));
			}catch(Exception e) {}
			wait.until(ExpectedConditions.elementToBeClickable(btnGoToDashBoard));
			btnGoToDashBoard.click();
			logger.info("Clicked on the Button Go to dashboard");
			Thread.sleep(2000);
		}
		
		//LINK CHANGE LOCATION
		@FindBy(xpath = "(//a[normalize-space()='Change Location'])[1]")
		@CacheLookup
		public WebElement linkChangeLocation;
		public void clickOnBtnChangeLocation() throws InterruptedException {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(linkChangeLocation));
			linkChangeLocation.click();
			logger.info("Clicked on the Button Change locations");
			Thread.sleep(2000);
		}
		
		//DROPDOWN SELECT INSTRUCTOR
		@FindBy(xpath = "//div[contains(@aria-haspopup,'listbox')]")
		@CacheLookup
		public WebElement btnDrpSelectInstructor;
		public void clickOnBtnInstructor() throws InterruptedException {
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(btnDrpSelectInstructor));
			Thread.sleep(200);
			btnDrpSelectInstructor.click();
			logger.info("Clicked on the dropdown instructor");
			Thread.sleep(2000);
		}
		
//		//LIST INSTRUCTOR
//		@FindBy(xpath = "//ul[@role='listbox']//li")
//		@CacheLookup
//		public List <WebElement> listInstructor;
		public String listInstructor = "//ul[@role='listbox']//li";
		public void selectinstructor(String instructorName) throws InterruptedException {
			clickOnBtnInstructor();
			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,listInstructor,instructorName);
			Thread.sleep(1000);
		}
		
		//TEXT NO CLASSSES TO THE CURRENT FILTER
		@FindBy(xpath = "//div[contains(text(),'No Classes Matches Current Filter')]")
		@CacheLookup
		public WebElement textNoClassesMatchedToTheCurrentFilter;
		public boolean textNoClassesMatchedToTheCurrentFilter() throws InterruptedException {
			boolean flag = false;
			try {
				Thread.sleep(2000);
				flag = textNoClassesMatchedToTheCurrentFilter.isDisplayed();
			}catch(Exception e) {
				logger.info("Exception from textNoClassesMatchedToTheCurrentFilter: "+e.getMessage());
			}
			
			if(flag) {
				logger.info("Is No classes matched with the applied filters: "+flag);
			}else {
				logger.info("Classes present with current applied filter");
			}
			return flag;
		}
		
		
//		//TO SELLECT THE MONTH AND DATE
//		@FindBy(xpath = "//div[@class='slick-slide slick-active']")
//		@CacheLookup
//		public List <WebElement> listMonthDate;
		String address_listMonthDate = "//div[@class='slick-slide slick-active slick-current' or @class='slick-slide slick-active']";	 //div[@class='slick-slide slick-active']
		
		public void selectMonthAndDate(String address_listMonthDate, String monthAndDate, WebDriver driver) throws InterruptedException {			
			
			boolean flag = false;
			while(true) 
			{	
				Thread.sleep(1000);
				List <WebElement> listMonthDate = driver.findElements(By.xpath(address_listMonthDate));
				Thread.sleep(1000);
				for(WebElement element : listMonthDate)
				{	
					String[] text = element.getText().split("\\n");
					String formatText="";
					for(String st : text) {
						formatText = formatText+st+" ";
					}
					//logger.info("formatText: "+formatText.trim());
	    			//String formatText = text[0]+" "+text[1]+" "+text[2];
	    			
    				if(formatText.trim().equals(monthAndDate)){
    					flag = true;
    					element.click();
    					logger.info("===>>> Month and Date Macthced: "+formatText.trim());
            			break;
            		}
    				Thread.sleep(500);
    			}
    			if(flag) {
    				break;
    			}	
    			clickOnMonthAndDateNextButton(driver);
			}
			
			Thread.sleep(1000);
		}
		
//		//MONTH DATE NEXT BUTTON
//		@FindBy(xpath = "(//div[contains(@class,'slick-arrow')])[2]")
//		@CacheLookup
//		public WebElement btnNext;// = driver.findElement(By.xpath("(//div[contains(@class,'slick-arrow')])[2]"));
		public void clickOnMonthAndDateNextButton(WebDriver driver) throws InterruptedException {
			Thread.sleep(2000);
			WebElement btnNext = driver.findElement(By.xpath("(//div[contains(@class,'slick-arrow')])[2]"));
			btnNext.click();
			logger.info("Clicked on the next button");
		}
		
		//MONTH DATE BACK BUTTON
		@FindBy(xpath = "(//div[contains(@class,'slick-arrow')])[1]")
		@CacheLookup
		public WebElement btnPrevious;
		public void clickOnMonthAndDatePreviousButton() throws InterruptedException {
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(btnPrevious));
			
			btnPrevious.click();
			logger.info("Clicked on the previous button");
			Thread.sleep(2000);
		}
		
		//TEXT NO CLASSES HAS BEEN SCHEDULED
		@FindBy(xpath = "//div[text()='No classes have been scheduled for this date']")
		@CacheLookup
		public WebElement textNoClassPresentOnGivenDate;
		public boolean isNoClassesHasBeenScheduledPresetnt() throws InterruptedException {
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfAllElements(textNoClassPresentOnGivenDate));
			
			boolean flag = textNoClassPresentOnGivenDate.isDisplayed();
			logger.info("No classes have been scheduled for this date: "+flag);
			Thread.sleep(2000);
			return flag;
		}
		
		//REGISTER BUTTON FOR THE CLASS
		@FindBy(xpath = "//span[contains(text(),'Register')]")
		@CacheLookup
		public WebElement btnRegister;
		public void clickOnBtnRegister() throws InterruptedException {
			Thread.sleep(300);
			try {
				if(btnRegister.isDisplayed()) {
					btnRegister.click();
					logger.info("clicked on the Register button");
				}else {
					logger.info("clicked on the Register button not present");
					ruae.clickOnBtnCross_RU();
				}
			}catch(Exception e) {
				logger.info("Exception from the Register button: "+e.getMessage());
			}
			
		}
		
		
//		//CLASS LIST ON SPECIFIC DATE
//		@FindBy(xpath = "//tr[contains(@class,'MuiTableRow-root')]")
//		@CacheLookup
//		public List <WebElement> listClassOnSpecificTime;
		public String listClassOnSpecificTime_address = "//tr[contains(@class,'MuiTableRow-root')]"; //TO AVOID STALE ELEMENT REFERENCE
		public void selectClassOnSpecificTime(WebDriver driver,String time) throws InterruptedException
		{
			List<WebElement> listClassOnSpecificTime = driver.findElements(By.xpath(listClassOnSpecificTime_address));
				
			boolean flag = false;
			
			for(WebElement element : listClassOnSpecificTime)
			{	
				//logger.info("Class Time: "+element.getText());
				String[] text1 = element.getText().split("\\n");
				
				if(element.getText() != null && element.getText() != "") 
				{
	//						String[] text = element.getText().split("\\n");
	//						String formatText = "";
	//						for(String st : text) {
	//							//logger.info(st);
	//							formatText = formatText+st+" ";
	//						}
	//						logger.info("formatText: "+formatText.trim());
	//		    			String formatTextTimeAndAmPm = text[0]+" "+text[1]; //	TO TAKE ONLY TIME AND AM/PM FROM THE LIST OF THE CLASS 
					String formatText1 = text1[0]+" "+text1[1];
					//logger.info("Available class timing: "+formatText1);
					if(formatText1.trim().equals(time))
					{
						jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);"); //TO SCROLL TILL END
						Thread.sleep(1000);
						flag = true;
						//driver.findElement(By.partialLinkText(formatTextTime)).click();
						element.click();
						logger.info("Class Time Matched: "+formatText1.trim());
						Thread.sleep(400);
	        			break;
	        		}
					Thread.sleep(100);
				}
			}
			if(flag == false) {
				logger.info("Given class timing not matched the available date: "+time);
			}
		}
			
		
		//TEXT PREFERED REGION
		@FindBy(xpath = "//div[text()='Please choose your preferred region:']")
		@CacheLookup
		public WebElement textSelectPreferedRegion;
		public boolean isPreferedRegionPresetnt() throws InterruptedException {
			Thread.sleep(3000);
			boolean flag = textSelectPreferedRegion.isDisplayed();
			logger.info("Preferd region is diplayed: "+flag);
			Thread.sleep(2000);
			return flag;
		}
		
		//TEXT PREFERE LOCATOIN
		@FindBy(xpath = "//div[text()='Please choose your preferred location:']")
		@CacheLookup
		public WebElement textSelectPreferedLocation;
		public boolean isPreferedLocationPresent() throws InterruptedException {
			Thread.sleep(3000);
			boolean flag = textSelectPreferedLocation.isDisplayed();
			logger.info("Preferd location is diplayed: "+flag);
			Thread.sleep(2000);
			return flag;
		}
		
//		//TO SELECT REGION
//		@FindBy(xpath = "//div[contains(@class,\"grid\")]//div")
//		@CacheLookup
//		public List <WebElement> listRegion;
		public String listRegion = "//div[contains(@class,\"grid\")]//div";
	    public void selectRegion(String regionName) throws InterruptedException {
			//wait.until(ExpectedConditions.invisibilityOfAllElements(listRegion));
			Thread.sleep(2000);
			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,listRegion,regionName);
			Thread.sleep(1000);
		}
		
//		//LIST LOCATION
//		@FindBy(xpath = "//div[contains(@class,\"grid\")]//div")
//		@CacheLookup
//		public List <WebElement> listLocation;
	    public String listLocation = "//div[contains(@class,\"grid\")]//div";
		public void selectLocation(String locationName) throws InterruptedException {
			Thread.sleep(2000);
			//wait.until(ExpectedConditions.invisibilityOfAllElements(listLocation));
			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,listLocation,locationName);
			Thread.sleep(1000);
		}
		
		
		//THANKS YOU TEXT AFTER CLASS REGISTRATION
		@FindBy(xpath="//div[contains(text(),'Now, Confirm Your Class Registration')]")
		@CacheLookup
		WebElement textThankYou;
		public boolean isThanksYouDisplayed() throws InterruptedException {
			boolean flag = false;
			Thread.sleep(500);
			try {
				if(textThankYou.isDisplayed()) {
					logger.info("Thanks you present after clicking on the button Regiser class");
					flag = true;
				}else {
					logger.info("Thanks page not present");
				}
			}catch(Exception e) {
				flag = false;
				logger.info("Exception from isThanksYouDisplayed: "+e.getMessage());
			}
			return flag;
		}
		
		//CONFIRM CLASS REGISTRATION
		@FindBy(xpath="//span[normalize-space()='CONFIRM CLASS REGISTRATION']")
		@CacheLookup
		WebElement btnConfirmClassRegistration;
		public boolean  clickOnBtnConfirmClassRegistration() throws InterruptedException {
			boolean flag = false;
			if(isThanksYouDisplayed()) {
				Thread.sleep(500);
				try {
						if(btnConfirmClassRegistration.isDisplayed()) {
							btnConfirmClassRegistration.click();
							flag = true;
							logger.info("Clicked on the Confirm class registration button");
	
						}else {
							logger.info("Class not registered");
						}
					}catch(Exception e){
						logger.info("Exception from clickOnBtnConfirmClassRegistration: "+e.getMessage());
					}
			}else {
				clickOnBtnCross_RU();
				Thread.sleep(1000);
			}
			return flag;
			
		}
		
		//TO FIND SPECIFIC CLASS AND CLICK ON THE THREE DOTS ACTION BUTTON
		public int findMyRegisteredClassAndonThreeDotOption(String dateTime,WebDriver driver,int searchKeyColumnIndex,boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException {
			Thread.sleep(2000);
			int listRowCount = FindThreeDotBasedOnSearchKeyAndClick.findThreedActionButtonAndClick(ruae.listData_RU,driver, dateTime,searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
			return listRowCount;
		}
		
		
		//=========END========CLASSES PAGE OBJECTS AND ACTION METHODS=============//
		
		
		//TO REGISTER THE CLASS
		public PO_HomePage registerClass(String time,String monthAndDate,String locationName,String regionName,String instructorName,String userEmailAddress) throws InterruptedException, SQLException {
			logger.info("Method called: registerClass");
			try {
				boolean bol = clickOnBtnRegisterForClass();
				if(bol) {
					clickOnBtnChangeLocation();
					//jsExecutor.executeScript("window.scrollBy(0, 300);"); //HORIZONTAL SCROLL BY 300PIXEL
					Thread.sleep(1000);
					//action.scrollByAmount(0, 300).build().perform();
					isPreferedLocationPresent();
					jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);"); //TO SCROLL TILL END
					logger.info("Location Page scroll down");
					Thread.sleep(2000);
					ruae.clickOnBtnBack_1_RU();
					isPreferedRegionPresetnt();
					jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);"); //TO SCROLL TILL END
					logger.info("Region page scroll down");
					selectRegion(regionName);
					Thread.sleep(1000);
					//isPreferedLocationPresent();
					action.scrollByAmount(0, 300).build().perform();
					logger.info("Location page scroll down");
					selectLocation(locationName);
					Thread.sleep(1000);
					selectinstructor(instructorName);
					selectMonthAndDate(address_listMonthDate,monthAndDate,driver);
					if(textNoClassesMatchedToTheCurrentFilter()) {
						clickOnBtnGoToDashBoard();
						return new PO_HomePage(driver);
					}
					selectClassOnSpecificTime(driver,time);
					jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);"); //TO SCROLL TILL END
					clickOnBtnRegister();
					Boolean flag = clickOnBtnConfirmClassRegistration();
					if(flag) {
						String alertMsg = snakeAlertMessagesDisplayedContent_RU();
						if(alertMsg != null && alertMsg.equals(alertMsgNoCreditAvailabe)) {
							logger.info("===>>> Class not registered");
							softAssert.assertTrue(false,"Check Credit availabe or not");
						}else 
						{
							dateTimePresentInRegisteredClassList = DBT_User_Classes.test_DBT_RegisterClass(time,monthAndDate,userEmailAddress);
							hp.clickMenuMyClasses();
							int listRowCount = findMyRegisteredClassAndonThreeDotOption(dateTimePresentInRegisteredClassList,driver,4,false,false);
							if(listRowCount != 0) {
								logger.info("===>>> Class registered successfully");
								softAssert.assertTrue(true,"To check class registered successfully or not");
							}
							return new PO_HomePage(driver);
						}
						
					}else {
						softAssert.assertTrue(false,"To check the class registeration");
					}
					clickOnBtnGoToDashBoard();
				}else if(!bol && (monthAndDate != null || monthAndDate != "")) {
					softAssert.assertTrue(false,"You want to register a class but Register Class Button not present");
				}
				
			}catch(Exception e) {}

			logger.info("Method called DONE: registerClass");
			softAssert.assertAll();
			return new PO_HomePage(driver);
		}
		
		
		//TO CANCEL THE CLASS
		public PO_HomePage cancelRegisteredClass(String dateAndTime,WebDriver driver,String userEmailAddress) throws InterruptedException, SQLException {
			logger.info("Method called: cancelRegisteredClass");
			Thread.sleep(2000);
			
			try {
				if(isNoClassFoundTextPresent() && dateAndTime != "" || isNoClassFoundTextPresent() && dateAndTime != null) {
					logger.info("The class you want to cancel is not present: "+dateAndTime);
					softAssert.assertTrue(false,"The class you want to cancel is not present: ");
					return new PO_HomePage(driver);
				}
				else 
				{
					int listRowCount = findMyRegisteredClassAndonThreeDotOption(dateAndTime,driver,4,true,false);
					logger.info("listRowCount:  "+listRowCount);
					if(listRowCount != -1) 
					{	
						boolean flag = clickOnBtnCancelClass_RU(driver,listRowCount);
						if(flag) {
							clickOnBtnYes_RU(driver);
							String alertMsg = snakeAlertMessagesDisplayedContent_RU();
				  			if(alertMsg.equals(alertMsgClassCanceled)) {
				  				softAssert.assertEquals(alertMsg,alertMsgClassCanceled,"Check class canceled successfully");
				  				DBT_User_Classes.test_DBT_CancelRegisteredClass(dateAndTime,userEmailAddress);
				  			}
						}
					}
					else {
						softAssert.assertTrue(false,"You want to cancel the registered class but action button not present");
					}
				}
		
			}catch(Exception e) {}
			
			logger.info("Method called DONE: cancelRegisteredClass");
			softAssert.assertAll();
			return new PO_HomePage(driver);
		}
		

}
