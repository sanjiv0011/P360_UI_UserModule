package com.p360.User.pageObject;

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

import com.p360.ReUseAble.PageObject.ReUseAbleElement;
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
			wait = new WebDriverWait (driver, Duration.ofSeconds(45));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);
		}
		
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
		
		//TO SELLECT THE MONTH AND DATE
		@FindBy(xpath = "//div[@class='slick-slide slick-active']")
		@CacheLookup
		public List <WebElement> listMonthDate;
		public void selectMonthAndDate(String monthAndDate) throws InterruptedException {
		
		}
		
		//MONTH DATE NEXT BUTTON
		@FindBy(xpath = "(//div[contains(@class,'slick-arrow')])[2]")
		@CacheLookup
		public WebElement btnNext;
		public void clickOnMonthAndDateNextButton() throws InterruptedException {
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(btnNext));
			
			btnNext.click();
			logger.info("Clicked on the next button");
			Thread.sleep(2000);
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
		
		//CLASS LIST ON SPECIFIC DATE
		@FindBy(xpath = "//tr[contains(@class,\"MuiTableRow-root\")]")
		@CacheLookup
		public List <WebElement> listClassOnSpecificTime;
		public void selectClassOnSpecificTime(String time) throws InterruptedException {
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfAllElements(listClassOnSpecificTime));
			
			Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listClassOnSpecificTime,time);
			Thread.sleep(1000);
		}
		
		//TEXT PREFERED REGION
		@FindBy(xpath = "//div[text()='Please choose your preferred region:']")
		@CacheLookup
		public WebElement textSelectPreferedRegion;
		public boolean isPreferedRegionPresetnt() throws InterruptedException {
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfAllElements(textSelectPreferedRegion));
			
			boolean flag = textSelectPreferedRegion.isDisplayed();
			logger.info("Preferd region is diplayed: "+flag);
			Thread.sleep(2000);
			return flag;
		}
		
		//TEXT PREFERE LOCATOIN
		@FindBy(xpath = "//div[text()='Please choose your preferred location:']")
		@CacheLookup
		public WebElement textSelectPreferedLocation;
		public boolean isPreferedLocationPresetnt() throws InterruptedException {
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfAllElements(textSelectPreferedLocation));
			
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
			wait.until(ExpectedConditions.invisibilityOfAllElements(listRegion));
			
			Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listRegion,regionName);
			Thread.sleep(1000);
		}
		
		//LIST LOCATION
		@FindBy(xpath = "//div[contains(@class,\"grid\")]//div")
		@CacheLookup
		public List <WebElement> listLocation;
		public void selectLocation(String locationName) throws InterruptedException {
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfAllElements(listLocation));
			
			Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listLocation,locationName);
			Thread.sleep(1000);
		}
		//=========END========CLASSES PAGE OBJECTS AND ACTION METHODS=============//
		
		
		//TO SELECT THE CLASS
		public PO_HomePage registerClass(String time,String monthAndDate,String locationName,String regionName,String instructorName) throws InterruptedException {
			clickOnBtnRegisterForClass();
			clickOnBtnChangeLocation();
			jsExecutor.executeScript("window.scrollBy(0, 300);");
			Thread.sleep(1000);
			action.scrollByAmount(0, 300).build().perform();
			Thread.sleep(2000);
			ruae.clickOnBtnBack_1_RU();
			isPreferedRegionPresetnt();
			selectRegion(regionName);
			selectLocation(locationName);
			clickOnBtnInstructor();
			selectinstructor(instructorName);
			selectMonthAndDate(monthAndDate);
			selectClassOnSpecificTime(time);
			return new PO_HomePage(driver);
		}
		

}
