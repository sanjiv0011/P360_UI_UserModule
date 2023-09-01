package com.p360.pageObject;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.p360.ReUseAble.PageObject.ReUseAbleElement;

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
			wait = new WebDriverWait (driver, Duration.ofSeconds(10));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);
		}
		
		//=========START========CLASSES PAGE OBJECTS=============//
		@FindBy(xpath = "//span[normalize-space()='Register for new class']")
		@CacheLookup
		public WebElement btnRegisterForClass;
		
		@FindBy(xpath = "//span[normalize-space()='No Classes Found']")
		@CacheLookup
		public WebElement textNoClassFound;
		
		@FindBy(xpath = "//span[normalize-space()='Go to dashboard']")
		@CacheLookup
		public WebElement btnGoToDashBoard;
				
		@FindBy(xpath = "(//a[normalize-space()='Change Location'])[1]")
		@CacheLookup
		public WebElement linkChangeLocation;
		
		@FindBy(xpath = "//div[contains(@aria-haspopup,'listbox')]")
		@CacheLookup
		public WebElement btnDrpSelectInstructor;
		
		@FindBy(xpath = "//ul[@role='listbox']//li")
		@CacheLookup
		public List <WebElement> listInstructor;
		
		@FindBy(xpath = "//div[@class='slick-slide slick-active']")
		@CacheLookup
		public List <WebElement> listMonthDate;
		
		@FindBy(xpath = "(//div[contains(@class,'slick-arrow')])[2]")
		@CacheLookup
		public WebElement btnNext;
		
		@FindBy(xpath = "(//div[contains(@class,'slick-arrow')])[1]")
		@CacheLookup
		public WebElement btnPrevious;

}
