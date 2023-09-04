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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.p360.ReUseAble.PageObject.ReUseAbleElement;
import com.p360.pageObject.PO_LoginPage;
import com.p360.projectUtility.DatePicker;
import com.p360.projectUtility.Generic_Method_ToSelect_Boostrape_Dropdown;

public class PO_Main_Packages extends ReUseAbleElement {
		
		//CONSTRUCTOR DECLARATION
		public WebDriver driver;
		public Logger logger = LogManager.getLogger(getClass());
		public JavascriptExecutor jsExecutor;
		public ReUseAbleElement ruae;
		public WebDriverWait wait;
		public PO_LoginPage lp;
		public Actions action;
		
		//HOMEPAGE CONSTRUCTOR CREATION
		public PO_Main_Packages(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(45));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);

		}
		
//		//ALERT MESSAGES
//		public String alertMsgMemberhsipPurchagedSuccessfully = "Membership purchased successfully";
//		public String alertMsgYourCardNumberIncomplete = "Your card number is incomplete.";
//		public String alertMsgAcceptTermCondition = "Please accept term and conditions.";
		
		//TEXT FIELD FIRST NAME
  		@FindBy(xpath = "//input[@placeholder='Enter First Name']")
  		@CacheLookup
  		public WebElement filedFirstName;
  		public void setFirstName(String firstName) throws InterruptedException {
  			filedFirstName.sendKeys(Keys.CONTROL,"a");
  			filedFirstName.sendKeys(Keys.DELETE);
  			filedFirstName.sendKeys(firstName);;
  			logger.info("Clicked on the field first name");
  			Thread.sleep(300);
  		}
		
  		//BUTTON ADD PACKAGES
  		@FindBy(xpath = "//span[normalize-space()='Add Package']")
  		@CacheLookup
  		public WebElement btnAddPackages;
  		public void clickOnBtnAddPackages() throws InterruptedException {
  			btnAddPackages.click();
  			logger.info("Clicked on the btn btnAddPackages");
  			Thread.sleep(1000);
  		}
  		
  		//BUTTON PACKAGES CATEGORY
  		@FindBy(xpath = "//span[normalize-space()='Package Categories']")
  		@CacheLookup
  		public WebElement btnPackagesCategory;
  		public void clickOnBtnPackagesCategory() throws InterruptedException {
  			btnPackagesCategory.click();
  			logger.info("Clicked on the btn btnPackagesCategory");
  			Thread.sleep(1000);
  		}
  		
  		
  		//BUTTON ADD CATEGORY
  		@FindBy(xpath = "//span[normalize-space()='Add Category']")
  		@CacheLookup
  		public WebElement btnAddCategory;
  		public void clickOnBtnAddCategory() throws InterruptedException {
  			btnPackagesCategory.click();
  			logger.info("Clicked on the btn btnAddCategory");
  			Thread.sleep(1000);
  		}
  	
  		//BUTTON ADD CATEGORY
  		@FindBy(xpath = "//span[normalize-space()='Reorder Categories']")
  		@CacheLookup
  		public WebElement btnReOrderCategory;
  		public void clickOnBtnReOrderCategory() throws InterruptedException {
  			btnReOrderCategory.click();
  			logger.info("Clicked on the btn btnReOrderCategory");
  			Thread.sleep(1000);
  		}
  		
  		//TEXT FIELD CATEGORY TITLE
  		@FindBy(xpath = "//input[@placeholder='title']")
  		@CacheLookup
  		public WebElement fieldCategoryTitle;
  		public void setCategoryTitles(String categoryTitle) throws InterruptedException {
  			fieldCategoryTitle.sendKeys(Keys.CONTROL,"a");
  			fieldCategoryTitle.sendKeys(Keys.DELETE);
  			fieldCategoryTitle.sendKeys(categoryTitle);;
  			logger.info("Enered the field category title");
  			Thread.sleep(300);
  		}
  		
  		
  		//TEXT FIELD CATEGORY INTERAL TITLE
  		@FindBy(xpath = "//input[@placeholder='internal title']")
  		@CacheLookup
  		public WebElement fieldCategoryInternalTitle;
  		public void setCategoryInternalTitle(String categoryInternalTitle) throws InterruptedException {
  			fieldCategoryInternalTitle.sendKeys(Keys.CONTROL,"a");
  			fieldCategoryInternalTitle.sendKeys(Keys.DELETE);
  			fieldCategoryInternalTitle.sendKeys(categoryInternalTitle);;
  			logger.info("Entered the field categoryInternalTitle");
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD CATEGORY DESCRITPION
  		@FindBy(xpath = "//textarea[@placeholder='Description']")
  		@CacheLookup
  		public WebElement filedCategoryDescription;
  		public void setCategoryDescription(String categoryDescription) throws InterruptedException {
  			filedCategoryDescription.sendKeys(Keys.CONTROL,"a");
  			filedCategoryDescription.sendKeys(Keys.DELETE);
  			filedCategoryDescription.sendKeys(categoryDescription);;
  			logger.info("Entered the field filedCategoryDescription");
  			Thread.sleep(300);
  		}
  		
  		
  		//TEXT FIELD PACKAGE TITLE
  		@FindBy(xpath = "//input[@placeholder='e.g. 3x/Week']")
  		@CacheLookup
  		public WebElement fieldPackageTitle;
  		public void setPackageTitile(String packageTitle) throws InterruptedException {
  			fieldPackageTitle.sendKeys(Keys.CONTROL,"a");
  			fieldPackageTitle.sendKeys(Keys.DELETE);
  			fieldPackageTitle.sendKeys(packageTitle);;
  			logger.info("Entered the field fieldPackageTitle");
  			Thread.sleep(300);
  		}
  	
  		//TEXT PACKAGE DESCRIPTION
  		@FindBy(xpath = "//textarea[@placeholder='Enter package description']")
  		@CacheLookup
  		public WebElement fieldDescription;
  		public void setEmail(String packageDescriptoin) throws InterruptedException {
  			fieldDescription.sendKeys(Keys.CONTROL,"a");
  			fieldDescription.sendKeys(Keys.DELETE);
  			fieldDescription.sendKeys(packageDescriptoin);;
  			logger.info("Entered the field fieldDescription");
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD NUMBER OF CLASSES
  		@FindBy(xpath = "//input[@name='numberOfClass']")
  		@CacheLookup
  		public WebElement fieldNumberOfClasses;
  		public void setPhoneNumber(String numberOfClasses) throws InterruptedException {
  			fieldNumberOfClasses.sendKeys(Keys.CONTROL,"a");
  			fieldNumberOfClasses.sendKeys(Keys.DELETE);
  			fieldNumberOfClasses.sendKeys(numberOfClasses);
  			logger.info("Enetered the field fieldNumberOfClasses");
  			Thread.sleep(300);
  		}
		
  		//TEXT FIELD MINIMUM DURATION(CLASSES)
  		@FindBy(xpath = "//input[@name='minimumDurationMonths']")
  		@CacheLookup
  		public WebElement feildMinimumDurationS;
  		public void setMinimumDuration(String minimumDuration) throws InterruptedException {
  			feildMinimumDurationS.sendKeys(Keys.CONTROL,"a");
  			feildMinimumDurationS.sendKeys(Keys.DELETE);
  			feildMinimumDurationS.sendKeys(minimumDuration);
  			logger.info("Enetered the field feildMinimumDurationS");
  			Thread.sleep(300);
  		}
  		
  		
  		//TEXT FIELD REGULAR PRICE
  		@FindBy(xpath = "//input[@name='regularPrice']")
  		@CacheLookup
  		public WebElement fieldRegularPrice;
  		public void setRegularPrice(String regularPrice) throws InterruptedException {
  			fieldRegularPrice.sendKeys(Keys.CONTROL,"a");
  			fieldRegularPrice.sendKeys(Keys.DELETE);
  			fieldRegularPrice.sendKeys(regularPrice);
  			logger.info("Enetered the field fieldRegularPrice");
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD DESCLAIMERS
  		@FindBy(xpath = "//div[@class='ql-editor ql-blank']")
  		@CacheLookup
  		public WebElement fieldDisclaimers;
  		public void setDesclaimers(String desclaimers) throws InterruptedException {
  			fieldDisclaimers.sendKeys(Keys.CONTROL,"a");
  			fieldDisclaimers.sendKeys(Keys.DELETE);
  			fieldDisclaimers.sendKeys(desclaimers);
  			logger.info("Enetered the field fieldDisclaimers");
  			Thread.sleep(300);
  		}
  		
  		
}
