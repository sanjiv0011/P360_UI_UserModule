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

import com.p360.ReUseAble.PageObject.ReUseAbleElement;
import com.p360.pageObject.PO_LoginPage;
import com.p360.projectUtility.DatePicker;
import com.p360.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;

public class PO_Main_PackagesPage extends ReUseAbleElement {
		
		//CONSTRUCTOR DECLARATION
		public WebDriver driver;
		public Logger logger = LogManager.getLogger(getClass());
		public JavascriptExecutor jsExecutor;
		public ReUseAbleElement ruae;
		public WebDriverWait wait;
		public PO_LoginPage lp;
		public Actions action;
		
		//HOMEPAGE CONSTRUCTOR CREATION
		public PO_Main_PackagesPage(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(30));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);

		}
		
		//ALERT MESSAGES
		public String alertMsgPackageCategoryCreatedSuccessfully = "Category Created successfully";
		public String alertMsgPackageNameIsRequired = "Package name is required";
		public String alertMsgPackageCategoryIsRequired = "Package category is required";
		public String alertMsgPackageDescriptionIsRequired = "Package Description is required";
		public String alertMsgPackageRegularPriceIsRequired = "Package regular Price is required";
		public String alertMsgTotalClassIsRequired = "Total Classes is required";
		public String alertMsgPackageCreatedSuccessfully = "Package created successfully";
		
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
  		@FindBy(xpath = "//span[normalize-space()='Add Regions']")
  		@CacheLookup
  		public WebElement btnRegions;
  		public void clickOnBtnAddPackages() throws InterruptedException {
  			btnRegions.click();
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
  			btnAddCategory.click();
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
  		
  		//TEXT FIELD PACKAGE CATEGORY TITLE
  		@FindBy(xpath = "//input[@placeholder='title']")
  		@CacheLookup
  		public WebElement fieldPackgeCategoryTitle;
  		public void setPackageCategoryTitles(String packageCategoryTitle) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldPackgeCategoryTitle));
  			fieldPackgeCategoryTitle.sendKeys(Keys.CONTROL,"a");
  			fieldPackgeCategoryTitle.sendKeys(Keys.DELETE);
  			fieldPackgeCategoryTitle.sendKeys(packageCategoryTitle);
  			logger.info("Entered the field package category title: "+packageCategoryTitle);
  			Thread.sleep(300);
  		}
  		
  		
  		//TEXT FIELD PACKAGE CATEGORY INTERAL TITLE
  		@FindBy(xpath = "//input[@placeholder='internal title']")
  		@CacheLookup
  		public WebElement fielPackgeCategoryInternalTitle;
  		public void setPackageCategoryInternalTitle(String packageCategoryInternalTitle) throws InterruptedException {
  			fielPackgeCategoryInternalTitle.sendKeys(Keys.CONTROL,"a");
  			fielPackgeCategoryInternalTitle.sendKeys(Keys.DELETE);
  			fielPackgeCategoryInternalTitle.sendKeys(packageCategoryInternalTitle);;
  			logger.info("Entered the field package categoryInternalTitle");
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD PACKAGE CATEGORY DESCRITPION
  		@FindBy(xpath = "//textarea[@placeholder='Description']")
  		@CacheLookup
  		public WebElement filedPackageCategoryDescription;
  		public void setPackageCategoryDescription(String packageCategoryDescription) throws InterruptedException {
  			filedPackageCategoryDescription.sendKeys(Keys.CONTROL,"a");
  			filedPackageCategoryDescription.sendKeys(Keys.DELETE);
  			filedPackageCategoryDescription.sendKeys(packageCategoryDescription);;
  			logger.info("Entered the  filedPackageCategoryDescription");
  			Thread.sleep(300);
  		}
  		
  		
  		//TEXT FIELD PACKAGE TITLE/NAME
  		@FindBy(xpath = "//input[@placeholder='e.g. 3x/Week']")
  		@CacheLookup
  		public WebElement fieldPackageTitle;
  		public void setPackageTitile(String packageTitle) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldPackageTitle));
  			fieldPackageTitle.sendKeys(Keys.CONTROL,"a");
  			fieldPackageTitle.sendKeys(Keys.DELETE);
  			fieldPackageTitle.sendKeys(packageTitle);;
  			logger.info("Entered the field fieldPackageTitle: "+packageTitle);
  			Thread.sleep(300);
  		}
  	
  		//TEXT PACKAGE DESCRIPTION
  		@FindBy(xpath = "//textarea[@placeholder='Enter package description']")
  		@CacheLookup
  		public WebElement fieldpackageDescription;
  		public void setPackageDescriptoin(String packageDescriptoin) throws InterruptedException {
  			fieldpackageDescription.sendKeys(Keys.CONTROL,"a");
  			fieldpackageDescription.sendKeys(Keys.DELETE);
  			fieldpackageDescription.sendKeys(packageDescriptoin);;
  			logger.info("Entered the fieldpackageDescription");
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD TOTAL CLASSES
  		@FindBy(xpath = "//input[@name='numberOfClass']")
  		@CacheLookup
  		public WebElement fieldTotalClasses;
  		public void setTotalClasses(String numberOfClasses) throws InterruptedException {
  			fieldTotalClasses.sendKeys(Keys.CONTROL,"a");
  			fieldTotalClasses.sendKeys(Keys.DELETE);
  			fieldTotalClasses.sendKeys(numberOfClasses);
  			logger.info("Enetered the fieldTotalClasses");
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
  		
  		//TO SELECT THE CATEGORY LOCATIONS
  		public void selectCategoryLocation(String categoryLocation) throws InterruptedException {
  			ruae.clickOnDropdown_2_RU();
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,categoryLocation);
  			logger.info("Category location: "+categoryLocation);
  			Thread.sleep(500);
  		}
  		
  		//TO SELECT THE PACKAGE LOCATIONS
  		public void selectPackageLocation(String packageLocation) throws InterruptedException {
  			ruae.clickOnDropdown_1_RU();
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,packageLocation);
  			logger.info("Package location: "+packageLocation);
  			Thread.sleep(500);
  		}
  		
  		
  		//TO SELECT THE CATEGORY
  		public void selectPackageCategory(String packageCategory) throws InterruptedException {
  			ruae.clickOnDropdownBoxAddress_1_RU();
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,packageCategory);
  			logger.info("Package category Name: "+packageCategory);
  			Thread.sleep(500);
  		}
  		
  		
  		//TO SELECT THE CATEGORY
  		public void selectChargeInterval(String chargeInterval) throws InterruptedException {
  			ruae.clickOnDropdownBoxAddress_2_RU();
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,chargeInterval);
  			Thread.sleep(500);
  		}
  		
  	
  		
  		
  		//TO ADD PACKAGE CATEGORY
  		public PO_Main_HomePage addPackageCategory(String packageCategoryTitle,String packageCategoryInternalTitle,String packageCategoryDescription,String categoryLocation,String wantToMarkCategoryHidden) throws InterruptedException
  		{
  			clickOnBtnPackagesCategory();
  			Thread.sleep(3000);
  			clickOnBtnAddCategory();
  			Thread.sleep(3000);
  			setPackageCategoryTitles(packageCategoryTitle);
  			setPackageCategoryInternalTitle(packageCategoryInternalTitle);
  			setPackageCategoryDescription(packageCategoryDescription);
  			selectCategoryLocation(categoryLocation);
  			if(wantToMarkCategoryHidden.equalsIgnoreCase("Yes")) {
  				clickOnCheckBox_1_RU();
  				logger.info("Category marked as hidden by selecting check box");
  			}else {
  				logger.info("Category is visible to users");
  			}
  			boolean flag = ruae.clickOnBtnSave_1_RU();
  			if(flag) {
  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  				if(alertMsg.equals(alertMsgPackageCategoryCreatedSuccessfully)) {
  					Assert.assertEquals(alertMsg, alertMsgPackageCategoryCreatedSuccessfully,"Checks Package category created successfully");
  				}else if(alertMsg.contains("required") || alertMsg.contains("Required")){
  	  				logger.info("===>>> PackageCategory not created, some required field missing");
  	  				ruae.clickOnCancelButton_1_RU();
  	  			}
  			}
  			
  			return new PO_Main_HomePage(driver);
  		}
  		
  		
  		//TO ADD PACKAGE
  		public PO_Main_HomePage addPackage(String packageName,String packageLocation,String packageCategory,String packgeDescription,String wantToInternalUseOnly,String chargeInterval,String totalClasses,String miniumDurationInMonth,String regularPrice,String packagedisclaimers ) throws InterruptedException {
  			clickOnBtnAddPackages();
  			Thread.sleep(3000);
  			setPackageTitile(packageName);
  			selectPackageLocation(packageLocation);
  			selectPackageCategory(packageCategory);
  			setPackageDescriptoin(packgeDescription);
  			if(wantToInternalUseOnly.equalsIgnoreCase("Yes")) {
  				clickOnCheckBox_1_RU();
  				logger.info("Internal Use Only check box selected");
  			}else {
  				logger.info("Internal Use Only check box not selected");
  			}
  			selectChargeInterval(chargeInterval);
  			setTotalClasses(totalClasses);
  			setMinimumDuration(miniumDurationInMonth);
  			setRegularPrice(regularPrice);
  			setDesclaimers(packagedisclaimers);
  			boolean flag = ruae.clickOnBtnSave_1_RU();
  			if(flag) {
  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  				if(alertMsg.equals(alertMsgPackageCreatedSuccessfully)) {
  					Assert.assertEquals(alertMsg, alertMsgPackageCreatedSuccessfully,"Checks Package created successfully");
  				}else if(alertMsg.contains("required") || alertMsg.contains("Required")) {
  					logger.info("===>>> Package not created, some required field missing");
  	  				ruae.clickOnCancelButton_1_RU();
  				}
  			}
  			return new PO_Main_HomePage(driver);
  		}
  		
}
