package com.p360.Main.pageObject;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.p360.ReUseAble.PageObject.ReUseAbleElement;
import com.p360.pageObject.PO_HomePage;
import com.p360.pageObject.PO_LoginPage;


public class PO_Main_Home extends ReUseAbleElement{
	
	//CONSTRUCTOR DECLARATION
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public PO_LoginPage lp;
	public Actions action;
	//HOMEPAGE CONSTRUCTOR CREATION
	public PO_Main_Home(WebDriver driver) {	
		super(driver);
	    this.driver = driver;
	    jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(45));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);

	}
	
	//=========START========HOME PAGE OBJECTS=============//
	
	@FindBy(xpath = "(//div[contains(@class, \"MuiList-root\")])[7]")
	@CacheLookup
	WebElement tabUsers;
	
	@FindBy(xpath = "(//div[contains(@class, \"MuiList-root\")])[6]")
	@CacheLookup
	WebElement tabPackages;
	
	
	@FindBy(xpath = "(//div[contains(@class,\"MuiList-root\")][contains(.,'Locations')])[2]")
	@CacheLookup
	WebElement tabLocations;
	
	@FindBy(xpath = "(//div[contains(@class,\"MuiList-root\")][contains(.,'Dashboard')])[2]")
	@CacheLookup
	WebElement tabDashboard;
	
	@FindBy(xpath = "(//div[contains(@class,\"MuiList-root\")][contains(.,'This Week')])[2]")
	@CacheLookup
	WebElement tabThisWeek;
	
	@FindBy(xpath = "(//div[contains(@class,\"MuiList-root\")][contains(.,'Trials')])[2]")
	@CacheLookup
	WebElement tabTrials;
	
	@FindBy(xpath = "(//div[contains(@class,\"MuiList-root\")][contains(.,'Classes')])[2]")
	@CacheLookup
	WebElement tabClasses;
	
	
	@FindBy(xpath = "(//div[contains(@class,\"MuiList-root\")][contains(.,'Coaches')])[2]")
	@CacheLookup
	WebElement tabCoaches;
	
	@FindBy(xpath = "(//div[contains(@class,\"MuiList-root\")][contains(.,'Workouts')])[2]")
	@CacheLookup
	WebElement tabWorkouts;
	
	@FindBy(xpath = "(//div[contains(@class,\"MuiList-root\")][contains(.,'Movement')])[2]")
	@CacheLookup
	WebElement tabMovement;
	
	@FindBy(xpath = "(//div[contains(@class,\"MuiList-root\")][contains(.,'Promo Codes')])[2]")
	@CacheLookup
	WebElement tabPromoCodes;
	
	@FindBy(xpath = "(//div[contains(@class,\"MuiList-root\")][contains(.,'Payments')])[2]")
	@CacheLookup
	public WebElement tabPayments;
	
	@FindBy(xpath = "(//div[contains(@class,\"MuiList-root\")][contains(.,'Documents')])[2]")
	@CacheLookup
	public WebElement tabDocuments;
	
	@FindBy(xpath = "(//div[contains(@class,\"MuiList-root\")][contains(.,'User Labels')])[2]")
	@CacheLookup
	public WebElement tabUserLabels;
	
	@FindBy(xpath = "(//div[contains(@class,\"MuiList-root\")][contains(.,'Links')])[2]")
	@CacheLookup
	public WebElement tabLinks;

	//=========END========HOME PAGE OBJECTS=============//
	
	
	//=========START========ACTION METHODS FOR HOME PAGE OBJECTS=============//
	
	public void clickOnTabUsers() throws InterruptedException {
		tabUsers.click();
		Thread.sleep(3000);
		logger.info("clickOnTabUsers");
	}
	
	public void clickOntabPackages() throws InterruptedException {
		tabPackages.click();
		Thread.sleep(3000);
		logger.info("clickOntabPackages ");
	}
	
	public void clickOntabLocations() throws InterruptedException {
		tabLocations.click();
		Thread.sleep(3000);
		logger.info(" clickOntabLocations");
	}
	
	//NORMAL USE
	public void clickOntabDashboard() throws InterruptedException {
		tabDashboard.click();
		Thread.sleep(3000);
		logger.info("clickOntabDashboard ");
	}
	
	//USE THIS WEHEN WANT TO TAKE ACTION ON MAIN P360 WEBSITE, IT WILL RETURN THE MAIN_HOMEPAGE
	public PO_Main_Home clickOntabDashboardReturn_Main_HomePage() throws InterruptedException {
		tabDashboard.click();
		Thread.sleep(3000);
		logger.info("clickOntabDashboard ");
		return new PO_Main_Home(driver);
	}
	
	//USE THIS WEHEN WANT TO TAKE ACTION ON MAIN P360 WEBSITE, IT WILL RETURN THE MAIN_HOMEPAGE
	public PO_HomePage clickOntabDashboardReturn_HomePage() throws InterruptedException {
		tabDashboard.click();
		Thread.sleep(3000);
		logger.info("clickOntabDashboard ");
		return new PO_HomePage(driver);
	}
	
	public void clickOntabThisWeek() throws InterruptedException {
		tabThisWeek.click();
		Thread.sleep(3000);
		logger.info("tabThisWeek ");
	}
	
	public void clickOntabTrials() throws InterruptedException {
		tabTrials.click();
		Thread.sleep(3000);
		logger.info("tabTrials ");
	}
	public void clickOntabClasses() throws InterruptedException {
		tabClasses.click();
		Thread.sleep(3000);
		logger.info("clickOntabClasses ");
	}
	
	public void clickOntabCoaches() throws InterruptedException {
		tabCoaches.click();
		Thread.sleep(3000);
		logger.info("tabCoaches");
	}
	
	public void clickOntabWorkouts() throws InterruptedException {
		tabWorkouts.click();
		Thread.sleep(3000);
		logger.info("clickOntabWorkouts ");
	}
	
	public void clickOntabMovement() throws InterruptedException {
		tabMovement.click();
		Thread.sleep(3000);
		logger.info("clickOntabMovement ");
	}
	public void clickOntabPromoCodes() throws InterruptedException {
		tabPromoCodes.click();
		Thread.sleep(3000);
		logger.info("clickOntabPromoCodes ");
	}
	public void clickOntabPayments() throws InterruptedException {
		tabPayments.click();
		Thread.sleep(3000);
		logger.info("clickOntabPayments ");
	}
	
	public void clickOntabDocuments() throws InterruptedException {
		tabDocuments.click();
		Thread.sleep(3000);
		logger.info("clickOntabDocuments ");
	}
	
	public void clickOntabUserLabels() throws InterruptedException {
		tabUserLabels.click();
		Thread.sleep(3000);
		logger.info("clickOntabUserLabels ");
	}
	
	public void clickOntabLinks() throws InterruptedException {
		tabLinks.click();
		Thread.sleep(3000);
		logger.info("clickOntabLinks ");
	}
	
	//MAIN HOME PAGE TABE TESTING
	public PO_HomePage mainHomePageTesting() throws InterruptedException {
		
		clickOntabLocations();
		clickOntabPackages();
		clickOnTabUsers();
		clickOntabTrials();
		clickOntabClasses();
		clickOntabCoaches();
		clickOntabWorkouts();
		clickOntabMovement();
		clickOntabPromoCodes();
		clickOntabPayments();
		clickOntabUserLabels();
		clickOntabDocuments();
		clickOntabLinks();
		clickOntabThisWeek();
		clickOntabDashboard();
		return new PO_HomePage(driver);
		
	}
}
