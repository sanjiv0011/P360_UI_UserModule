package com.p360.User.pageObject;

import java.time.Duration;

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

public class PO_LoginPage extends ReUseAbleElement {
	
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public Actions action;
	
	public  PO_LoginPage(WebDriver driver)
	{   super(driver);
	    this.driver = driver;
	    jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(30));
		action = new Actions(driver);
	}

	// to find page elements
	@FindBy(xpath = "//span[contains(text(),'Login')]")
	@CacheLookup
	public WebElement btnLogin;
	
	@FindBy(xpath = "//input[@id='signInName']")
	@CacheLookup
	WebElement textemail;
	
	@FindBy(xpath = "//input[@id='password']")
	@CacheLookup
	WebElement textpassword;
	
	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	@CacheLookup
	WebElement btnsubmit;
	
	//TO CLICK ON THE LOGIN BUTTON
	public void clickBtnSignIn() throws InterruptedException {
		btnLogin.click();
		logger.info("clicke on Sign In button");
		Thread.sleep(1000);
	}
	
	//TO SET THE USERNAME/EMAIL AND WAIT TILL IS IS NOT APPERS MAX WAIT TIME(30 SECONDS)
	public void setUserName(String email) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(textemail));
		textemail.sendKeys(Keys.CONTROL,"a");
		textemail.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textemail.sendKeys(email);
		logger.info("Enteterd email");
		Thread.sleep(200);
	}
	
	//TO SET THE PASSWORD
	public void setTextpassword(String password) throws InterruptedException {
		textpassword.sendKeys(Keys.CONTROL,"a");
		textpassword.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textpassword.sendKeys(password);
		logger.info("Entered password");
		Thread.sleep(200);
	}

	//TO CLICK ON THE SUBMIT BUTTON
	public void clickBtnsubmit() throws InterruptedException {
		btnsubmit.click();
		logger.info("clicke on login submit button");
		Thread.sleep(200);
	}
	
	//TO LOGIN
	public PO_HomePage Login(String email,String password) throws InterruptedException {
		logger.info("Method called Login");
		clickBtnSignIn();
		setUserName(email);
		setTextpassword(password);
		clickBtnsubmit();
		
		try {
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "Dashboard"));
			Thread.sleep(500);
			if(driver.getPageSource().contains("Welcome")) {
				//Assert.assertTrue(true);
				logger.info("...LOGIN DONE...");
			} else {
				//Assert.assertTrue(false);
				logger.info("!!!LOGIN FAILED!!!");
			}
		}catch(Exception e) {
			logger.info("Login exception message: "+e.getMessage());
		}
		
		return new PO_HomePage(driver);
	}
	
}
