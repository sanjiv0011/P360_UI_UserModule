package com.p360.pageObject;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

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

import com.p360.DataBaseTesting.DBT_User_Membership;
import com.p360.ReUseAble.PageObject.ReUseAbleElement;


public class PO_HomePage extends ReUseAbleElement{
	
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
	public PO_HomePage(WebDriver driver) {	
		super(driver);
	    this.driver = driver;
	    jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(30));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);

	}
	
	
	//ALERT MESSAGES
	public String alertMsgCardAddedSuccesfully = "Card Added Successfully.";
	
	//=========START========HOME PAGE OBJECTS=============//
	
	@FindBy(xpath = "//span[normalize-space()='Membership']")
	@CacheLookup
	WebElement menuMembership;
	
	@FindBy(xpath = "//span[normalize-space()='My Classes']")
	@CacheLookup
	WebElement menuMyClasses;
	
	
	@FindBy(xpath = "//p[normalize-space()='Dashboard']")
	@CacheLookup
	WebElement textDashboard;
	
	@FindBy(xpath = "//span[normalize-space()='Manage My Membership']")
	@CacheLookup
	WebElement linkManageMyMembership;
	
	@FindBy(xpath = "//div[@class='gap-3 flex flex-col items-center cursor-pointer']")
	@CacheLookup
	WebElement linkNextClass;
	
	@FindBy(xpath = "//div[normalize-space()='App Store']")
	@CacheLookup
	WebElement linkAppStore;
	
	@FindBy(xpath = "//div[normalize-space()='Google Play']")
	@CacheLookup
	WebElement linkGooglePlayStore;
	
	
	@FindBy(xpath = "//p[@class='MuiTypography-root text-base font-semibold MuiTypography-body1']")
	@CacheLookup
	WebElement btnUserName;
	
	@FindBy(xpath = "//div[@class='ml-2']")
	@CacheLookup
	WebElement btnLogout;
	
//	@FindBy(xpath = "//span[normalize-space()='Change']")
//	@CacheLookup
//	WebElement btnChange;
	String btnChange = "//span[normalize-space()='Change']";
	
	@FindBy(xpath = "//input[@name='holderName']")
	@CacheLookup
	WebElement textCardHolderName;
	
	@FindBy(xpath = "//div[@class='w-full p-5']")
	@CacheLookup
	public WebElement btnNextClasses;
	
	@FindBy(xpath = "(//div[contains(normalize-space(),'No Upcoming Classes')])[11]")
	@CacheLookup
	public WebElement textNoUpComingClasses;

	//=========END========HOME PAGE OBJECTS=============//
	
	
	//=========START========ACTION METHODS FOR HOME PAGE OBJECTS=============//
	
	public void clickMenuMembership() throws InterruptedException {
		menuMembership.click();
		Thread.sleep(2000);
		logger.info("Clicked on the Menu membership");
	}
	
	public void clickMenuMyClasses() throws InterruptedException {
		menuMyClasses.click();
		Thread.sleep(2000);
		logger.info("Clicked on the Menu my classes");
	}
	
	public boolean verifyDashboard() throws InterruptedException {
		boolean bol = textDashboard.isDisplayed();
		Thread.sleep(2000);
		logger.info("Checked is Dashboard displayed: "+bol);
		return bol;	
	}
	
	public void clickManageMyMembership() throws InterruptedException {
		linkManageMyMembership.click();
		Thread.sleep(2000);
		logger.info("Clicked on the Manage my membership ");
	}
	
	public void clickNextClass() throws InterruptedException {
		linkNextClass.click();
		Thread.sleep(2000);
		logger.info("Clicked on the Next class ");
	}
	
	public void clickAppStore() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(linkAppStore));
		Thread.sleep(500);
		linkAppStore.click();
		Thread.sleep(4000);
		logger.info("Clicked on the Appstore ");
	}
	
	public void clickGooglePlayStore() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(linkGooglePlayStore));
		Thread.sleep(500);
		linkGooglePlayStore.click();
		Thread.sleep(4000);
		logger.info("Clicked on the Google playstore ");
	}
	
	public void clickOnUserNameButton() throws InterruptedException {
		btnUserName.click();
		Thread.sleep(500);
		logger.info("Clicked on the User name text ");
	}
	
	public void clickOnLogoutButton() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(btnLogout));
		Thread.sleep(300);
		btnLogout.click();
		Thread.sleep(2000);
		logger.info("Clicked on the Logout button ");
	}
	
	public void clickOnChangeButton() throws InterruptedException {
		driver.findElement(By.xpath(btnChange)).click();
		logger.info("Clicked on the button card change");
		Thread.sleep(2000);
	}
	
	public void setCardHoldName(String cardName) throws InterruptedException {
		textCardHolderName.sendKeys(cardName);
		logger.info("Entered card name");
		Thread.sleep(500);
	}
	
	
	public boolean clickOnNextClasses() throws InterruptedException {
		boolean flag = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnNextClasses));
			Thread.sleep(500);
			if(btnNextClasses.isDisplayed()) {
				btnNextClasses.click();
				logger.info("Clicked on the next classes");
				flag = true;
				Thread.sleep(1000);
				driver.navigate().back();
				Thread.sleep(2000);
			}
		}catch(Exception e) {
			logger.info("Exceptin form clickOnNextClasses: "+e.getMessage());		
			}
		return flag;
	}
	
	public boolean textNoUpcomingClasses() {
		boolean flag = false;
		try {
			if(textNoUpComingClasses.isDisplayed()) {
				flag = true;
				logger.info("Is No up coming classes text present: "+flag);
			}
		}catch(Exception e){
			logger.info("Exceptino from textNoUpcomingClasses: "+e.getMessage());
		}
		return flag;
	}
	
	//=========END========ACTION METHODS FOR HOME PAGE OBJECTS=============//
	
		
	// TO LOGOUT
	public PO_LoginPage UserLogout() throws InterruptedException
	{	logger.info("Method called: Logout");
		try {
			ruae.clickMenuDashBoard_RU();
			clickOnUserNameButton();
			clickOnLogoutButton();
			wait.until(ExpectedConditions.elementToBeClickable(lp.btnLogin));
			Thread.sleep(500);
			if(driver.getPageSource().contains("Performance360")){
				softAssert.assertTrue(true);
				logger.info("... LOGOUT DONE ...");
			}else{
				softAssert.assertTrue(false);
				logger.info("!!! LOGOUT FAILEED !!!");
			}
		}catch(Exception e) {
			logger.info("Logout Exception: "+e.getMessage());
			softAssert.assertTrue(false,"After logout it lookin for [Performance360] text");
		}
		softAssert.assertAll();
		return new PO_LoginPage(driver);
		
	}
	
	//TO CHECK THE HOME PAGE ELEMENT
	public void checkClickActionOnHomePageElement() throws InterruptedException {
		try {
			ruae.clickMenuDashBoard_RU();
			clickMenuMembership();
			clickMenuMyClasses();
			ruae.clickMenuDashBoard_RU();
			verifyDashboard();
			clickManageMyMembership();
			driver.navigate().back();
			
			//TO HANDELS NEW TAB OR WINDOWS
			Set<String> handles = driver.getWindowHandles();
			// it takes care of tab iterations
			Iterator itr  = handles.iterator();	
			String parenttab = (String) itr.next(); // it is on parent tab
			
			clickAppStore(); //ON THIS ACTION CREATE NEW TAB
			Thread.sleep(2000);
			jsExecutor.executeScript("window.scrollBy(0, 300);");
			Thread.sleep(2000);
			jsExecutor.executeScript("window.scrollBy(0, -300);");
			Thread.sleep(2000);
	
			driver.switchTo().window(parenttab);
			Thread.sleep(2000);
			
			clickGooglePlayStore();
			Thread.sleep(2000);
			driver.switchTo().window(parenttab);
			Thread.sleep(4000);
			
			clickOnChangeButton();
			clickOnCancelButton_1_RU();
			if(!textNoUpcomingClasses()) {
				clickOnNextClasses();
			}else {
				logger.info("No upcoming class present");
			}
			
			logger.info("...HOME PAGE ELEMENT TESTING DONE...");
		}catch(Exception e) {}
		softAssert.assertAll();
	}
	
	//TO CHENGE THE CARD DETAILS
	public void changeCardDetails(String cardHolderName,String cardNumber,String expirayAndCode,String zipCode) throws InterruptedException
	{
		try {
			Thread.sleep(5000);
			clickOnChangeButton();
			setCardHoldName(cardHolderName);
			logger.info("Waiting for 15 seconds to enter the card number, expiray , code and zip code manualy");
			Thread.sleep(15000);
			String alertMsgContent=null;
			boolean flag = ruae.clickOnBtnSave_1_RU();
			if(flag) 
			{	alertMsgContent = snakeAlertMessagesDisplayedContent_RU();
				if(alertMsgContent != null && alertMsgContent.equals(alertMsgCardAddedSuccesfully)) {
					logger.info("===>>> User card details changed successfully");
					softAssert.assertEquals(alertMsgContent,alertMsgCardAddedSuccesfully ,"To check  card details changed or not");
				}else {
					driver.navigate().back();
					softAssert.assertTrue(false,"To check  card details changed or not");
				}
			}else{
				clickOnCancelButton_1_RU();
				softAssert.assertTrue(false,"To check  card details changed or not");
			}
		}catch(Exception e) {
			logger.info("Exceptin from changeCardDetails: "+e.getMessage());
			softAssert.assertTrue(false,"changeCardDetails");
		}
		logger.info("...CHANGE CARD DETAILS TESTING DONE...");
		softAssert.assertAll();
	}

	
}
