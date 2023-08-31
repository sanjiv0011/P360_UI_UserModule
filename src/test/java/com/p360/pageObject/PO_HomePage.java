package com.p360.pageObject;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.p360.ReUseAble.PageObject.ReUseAbleElement;


public class PO_HomePage extends ReUseAbleElement{
	
	//CONSTRUCTOR DECLARATION
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public PO_LoginPage lp;
	//HOMEPAGE CONSTRUCTOR CREATION
	public PO_HomePage(WebDriver driver) {	
		super(driver);
	    this.driver = driver;
	    jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		lp = new PO_LoginPage(driver);

	}
	
	//=========START========HOME PAGE OBJECTS=============//
	@FindBy(xpath = "//span[normalize-space()='Dashboard']")
	@CacheLookup
	WebElement menuDashBoard;
	
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
	//=========END========HOME PAGE OBJECTS=============//
	
	
	//=========START========ACTION METHODS FOR HOME PAGE OBJECTS=============//
	public void clickMenuDashBoard() throws InterruptedException
	{
		menuDashBoard.click();
		Thread.sleep(2000);
		logger.info("Clicked on the Menu Dashboard");
		
	}
	
	public void clickMenuMembership() throws InterruptedException
	{
		menuMembership.click();
		Thread.sleep(2000);
		logger.info("Clicked on the Menu membership");
	}
	
	public void clickMenuMyClasses() throws InterruptedException
	{
		menuMyClasses.click();
		Thread.sleep(2000);
		logger.info("Clicked on the Menu my classes");
	}
	
	public boolean verifyDashboard() throws InterruptedException
	{
		boolean bol = textDashboard.isDisplayed();
		Thread.sleep(2000);
		logger.info("Checked is Dashboard displayed: "+bol);
		return bol;
		
		
	}
	
	public void clickManageMyMembership() throws InterruptedException
	{
		linkManageMyMembership.click();
		Thread.sleep(2000);
		logger.info("Clicked on the Manage my membership ");
	}
	
	public void clickNextClass() throws InterruptedException
	{
		linkNextClass.click();
		Thread.sleep(2000);
		logger.info("Clicked on the Next class ");
	}
	
	public void clickAppStore() throws InterruptedException
	{
		linkAppStore.click();
		Thread.sleep(2000);
		logger.info("Clicked on the Appstore ");
	}
	
	public void clickGooglePlayStore() throws InterruptedException
	{
		linkGooglePlayStore.click();
		Thread.sleep(2000);
		logger.info("Clicked on the Google playstore ");
	}
	
	public void clickOnUserNameButton() throws InterruptedException
	{
		btnUserName.click();
		Thread.sleep(300);
		logger.info("Clicked on the User name text ");
	}
	
	public void clickOnLogoutButton() throws InterruptedException
	{
		btnLogout.click();
		Thread.sleep(300);
		logger.info("Clicked on the Logout button ");
	}
	//=========END========ACTION METHODS FOR HOME PAGE OBJECTS=============//
	
		
	// TO LOGOUT
	public PO_LoginPage Logout() throws InterruptedException
	{	
		clickMenuDashBoard();
		clickOnUserNameButton();
		clickOnLogoutButton();
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(lp.btnLogin));
			if(driver.getPageSource().equals("Performance360")){
				Assert.assertTrue(true);
				logger.info("... LOGOUT DONE ...");
			}else{
				Assert.assertTrue(false);
				logger.info("!!! LOGOUT FAILEED !!!");
			}
		}catch(Exception e) {
			logger.info("Logout Exception: "+e.getMessage());
		}
		return new PO_LoginPage(driver);
	}
	
}
