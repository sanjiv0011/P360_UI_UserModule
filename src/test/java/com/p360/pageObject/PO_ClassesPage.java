package com.p360.pageObject;

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

import com.p360.ReUseAble.PageObject.ReUseAbleElement;
import com.p360.projectUtility.FindThreeDotBasedOnSearchKeyAndClick;
import com.p360.projectUtility.Generic_Method_ToSelect_Boostrape_Dropdown;

public class PO_ClassesPage extends ReUseAbleElement{

		//CONSTRUCTOR DECLARATION
		public WebDriver driver;
		public Logger logger = LogManager.getLogger(getClass());
		public JavascriptExecutor jsExecutor;
		public ReUseAbleElement ruae;
		public WebDriverWait wait;
		public PO_LoginPage lp;
		public Actions action;
		
		//HOMEPAGE CONSTRUCTOR CREATION
		public PO_ClassesPage(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(30));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);
		}
		
		//VARIABLES 
		public String alertMsgAlreadyClassRegistered = "User registration already exists for this class";
		public String alertMsgClassCanceled = "Class Canceled.";
		
		//=========START========CLASSES PAGE OBJECT AND ACTION METHODSS=============//
		
		//BUTTON REGISTER FOR CLASS
		@FindBy(xpath = "//span[normalize-space()='Register for new class']")
		@CacheLookup
		public WebElement btnRegisterForClass;
		public void clickOnBtnRegisterForClass() throws InterruptedException {
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(btnRegisterForClass));
			Thread.sleep(1000);
			btnRegisterForClass.click();
			logger.info("Clicked on the Button register for the class");
			Thread.sleep(2000);
		}
		
		//TEXT NO CLASS FOUND
		@FindBy(xpath = "//span[normalize-space()='No Classes Found']")
		@CacheLookup
		public WebElement textNoClassFound;
		public boolean isNoClassFoundTextPresent() throws InterruptedException {
			Thread.sleep(5000);
			wait.until(ExpectedConditions.invisibilityOf(textNoClassFound));
			Thread.sleep(5000);
			boolean flag = textNoClassFound.isDisplayed();
			logger.info("Checking is no class found text present: "+flag);
			Thread.sleep(2000);
			return flag;
		}
		
		//BUTTON GO TO DASHBAORD
		@FindBy(xpath = "//span[normalize-space()='Go to dashboard']")
		@CacheLookup
		public WebElement btnGoToDashBoard;
		public void clickOnBtnGoToDashBoard() throws InterruptedException {
			Thread.sleep(1000);
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
		
		//LIST INSTRUCTOR
		@FindBy(xpath = "//ul[@role='listbox']//li")
		@CacheLookup
		public List <WebElement> listInstructor;
		public void selectinstructor(String instructorName) throws InterruptedException {
			clickOnBtnInstructor();
			Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listInstructor,instructorName);
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
					logger.info("formatText: "+formatText.trim());
	    			//String formatText = text[0]+" "+text[1]+" "+text[2];
	    			
    				if(formatText.trim().equals(monthAndDate)){
    					flag = true;
    					element.click();
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
		
		
		//CLASS LIST ON SPECIFIC DATE
		@FindBy(xpath = "//tr[contains(@class,'MuiTableRow-root')]")
		@CacheLookup
		public List <WebElement> listClassOnSpecificTime;
		public void selectClassOnSpecificTime(String time) throws InterruptedException {
			boolean flag = false;
			while(true) 
			{
				for(WebElement element : listClassOnSpecificTime)
				{	
					logger.info("Class Time: "+element.getText());
					
					if(element.getText() != null && element.getText() != "") {
						String[] text = element.getText().split("\\n");
						String formatText = "";
						for(String st : text) {
							//logger.info(st);
							formatText = formatText+st+" ";
						}
						logger.info("formatText: "+formatText.trim());
		    			String formatTextTimeAndAmPm = text[0]+" "+text[1]; //	TO TAKE ONLY TIME AND AM/PM FROM THE LIST OF THE CLASS 
		    			
	    				if(formatTextTimeAndAmPm.trim().equals(time)){
	    					jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);"); //TO SCROLL TILL END
	    					Thread.sleep(1000);
	    					flag = true;
	    					element.click();
	    					Thread.sleep(400);
	            			break;
	            		}
	    				Thread.sleep(100);
					}
					
    			}
    			if(flag) {
    				break;
    			}
    			clickOnMonthAndDateNextButton(driver);
			}
			Thread.sleep(1000);
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
		
		//TO SELECT REGION
		@FindBy(xpath = "//div[contains(@class,\"grid\")]//div")
		@CacheLookup
		public List <WebElement> listRegion;
	    public void selectRegion(String regionName) throws InterruptedException {
			//wait.until(ExpectedConditions.invisibilityOfAllElements(listRegion));
			Thread.sleep(2000);
			Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listRegion,regionName);
			Thread.sleep(1000);
		}
		
		//LIST LOCATION
		@FindBy(xpath = "//div[contains(@class,\"grid\")]//div")
		@CacheLookup
		public List <WebElement> listLocation;
		public void selectLocation(String locationName) throws InterruptedException {
			Thread.sleep(2000);
			//wait.until(ExpectedConditions.invisibilityOfAllElements(listLocation));
			Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listLocation,locationName);
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
		public void clickOnBtnConfirmClassRegistration() throws InterruptedException {
			if(isThanksYouDisplayed()) {
				Thread.sleep(500);
				if(btnConfirmClassRegistration.isDisplayed()) {
					btnConfirmClassRegistration.click();
					logger.info("Clicked on the Confirm class registration button");

				}else {
					logger.info("Class not registered");
				}
			}else {
				clickOnBtnCross_RU();
				Thread.sleep(1000);
			}
			
		}
		
		//LIST MY CLASSES/ ALREADY REGISTRED CLASS
		@FindBy(xpath = "//div[contains(@class,'p-4 flex gap-2 flex-row')]")
		@CacheLookup
		public List <WebElement> listMyRegisteredClass;
		public int findMyRegisteredClassAndonThreeDotOption(String dateTime,WebDriver driver) throws InterruptedException {
			Thread.sleep(2000);
			int listRowCount = FindThreeDotBasedOnSearchKeyAndClick.findThreedActionButtonAndClick(listMyRegisteredClass,driver, dateTime);
			return listRowCount;
		}
		
		
		//=========END========CLASSES PAGE OBJECTS AND ACTION METHODS=============//
		
		
		
		
		//TO SELECT THE CLASS
		public PO_HomePage registerClass(String time,String monthAndDate,String locationName,String regionName,String instructorName) throws InterruptedException {
			
			clickOnBtnRegisterForClass();
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
			selectClassOnSpecificTime(time);
			clickOnBtnRegister();
			clickOnBtnConfirmClassRegistration();
			clickOnBtnGoToDashBoard();
			return new PO_HomePage(driver);
		}
		
		
		//TO CANCEL THE CLASS
		public PO_HomePage cancelRegisteredClass(String dateAndTime,WebDriver driver) throws InterruptedException {
			int listRowCount = findMyRegisteredClassAndonThreeDotOption(dateAndTime,driver);
			boolean flag = clickOnBtnCancelClass_RU(driver,listRowCount);
			if(flag) {
				clickOnYesButton_RU();
				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
	  			if(alertMsg.equals(alertMsgClassCanceled)) {
	  				Assert.assertEquals(alertMsg,alertMsgClassCanceled,"Check class canceled successfully");
	  				logger.info("===>>> "+alertMsg);
	  			}else {
	  				logger.info("Alert Message displayed: "+alertMsg);
	  			}
			}
			
			return new PO_HomePage(driver);
		}
		

}
