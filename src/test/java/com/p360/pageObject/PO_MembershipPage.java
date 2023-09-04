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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.p360.projectUtility.DatePicker;
import com.p360.projectUtility.Generic_Method_ToSelect_Boostrape_Dropdown;
import com.p360.ReUseAble.PageObject.ReUseAbleElement;


public class PO_MembershipPage extends ReUseAbleElement{
	
	//CONSTRUCTOR DECLARATION
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public PO_LoginPage lp;
	public Actions action;
	
	//HOMEPAGE CONSTRUCTOR CREATION
	public PO_MembershipPage(WebDriver driver) {	
		super(driver);
	    this.driver = driver;
	    jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(45));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);
		

	}
	
	String alertMsgResumeMembership = "Your membership has been resumed successfully";
	String alertMsgPauseMembershipMoreThenOneTimeInAQuarter = "Memberships can only be paused once in a quarter";
	String alertMsgPauseMembership = "Your membership has been paused successfully";
	String alertMsgSelectMemberhsipPackage = "Please select membership package.";
	String alertMsgChangeMembership = "Membership Package Changed.";
	String alertMsgNoActiveSubscription = "No active subscription found matching the user";
	
	//=========START========MEMBERSHIP PAGE OBJECTS=============//
	@FindBy(xpath = "//span[normalize-space()='Manage Membership']")
	@CacheLookup
	public WebElement btnManageMembership;
	
	@FindBy(xpath = "//div[contains(@class,\"MuiInputBase-fullWidth\")]")
	@CacheLookup
	public WebElement btnDrpSelctCategory;
	
	
	// it is give the list of category present under this dropdown
	@FindBy(xpath = "//div[@class='text-red text-base capitalize']")
	@CacheLookup
	public List <WebElement> listPackageName;
			
	@FindBy(xpath = "//span[contains(text(), 'Change Membership')]")
	@CacheLookup
	public WebElement btnChangeMembership;
	
	@FindBy(xpath = "//div[@id='notistack-snackbar']")
	@CacheLookup
	public WebElement slidebarConfirmation;
	
	@FindBy(xpath = "//span[normalize-space()='Agreed Terms']")
	@CacheLookup
	public WebElement btnAgreeTerm;
	
	@FindBy(xpath = "(//span[contains(@class,'MuiIconButton-label')])[3]")
	@CacheLookup
	public WebElement RadioBtn_3;
	
	@FindBy(xpath = "(//span[contains(@class,'MuiIconButton-label')])[4]")
	@CacheLookup
	public WebElement RadioBtn_4;
	
	@FindBy(xpath = "(//span[contains(@class,'MuiIconButton-label')])[5]")
	@CacheLookup
	public WebElement RadioBtn_5;
	
	@FindBy(xpath = "//span[normalize-space()='Pause Membership']")
	@CacheLookup
	public WebElement btnPauseMembership;
	
	@FindBy(xpath = "//span[normalize-space()='Resume Membership']")
	@CacheLookup
	public WebElement btnResumeMembership;
	
	@FindBy(xpath = "//label[contains(text(),'Select a reason')]")
	@CacheLookup
	public WebElement btnDrpSelectReason;
	
	@FindBy(xpath = "(//span[contains(normalize-space(),'Pause My Membership')])[2]")
	@CacheLookup
	public WebElement btnPauseMyMembership;
	
	@FindBy(xpath = "(//span[normalize-space()='Resume My Membership'])[2]")
	@CacheLookup
	public WebElement btnResumeMyMembership;
	
	
	@FindBy(xpath = "(//span[contains(@class,'MuiIconButton-label')])[6]")
	@CacheLookup
	public WebElement iconDateNewSubscriptionDate;
	
	@FindBy(xpath = "(//span[contains(@class,'MuiIconButton-label')])[3]")
	@CacheLookup
	public WebElement iconStartDatePauseMembership;
	
	@FindBy(xpath = "(//span[contains(@class,'MuiIconButton-label')])[4]")
	@CacheLookup
	public WebElement iconEndDatePauseMembership;
	
	
	
	//=========END========MEMBERSHIP PAGE OBJECTS=============//
	
	
	//=========START========ACTION METHODS FOR MEMBERSHIP PAGE OBJECTS=============//
	//TO MANAGE MEMBERSHIP BUTTON
	public void clickOnBtnManageMembership() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(btnManageMembership));
		Thread.sleep(500);
		btnManageMembership.click();
		logger.info("Clicked on the manage membership button");
		Thread.sleep(500);
	}
	
	//TO CLICK THE CATEGORY LIST
	public void clickOnDrpCategory() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(btnDrpSelctCategory));
		Thread.sleep(300);
		btnDrpSelctCategory.click();
		logger.info("Clicked on the category field to open the list");
		Thread.sleep(500);
	}
	
	//TO SELECT THE CATEGORY THE FROM THE LIST
	public void selectCategory(String categoryName) throws InterruptedException{	
		clickOnDrpCategory();
		Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(ruae.listOption_RU,categoryName);
		Thread.sleep(1000);
	}
	
	//TO SELECT THE PACKAGE
	public void selectPackage(String packageName) throws InterruptedException{	
		logger.info("SelectPackage methods called");
		Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listPackageName,packageName);
		Thread.sleep(1000);
	}
	
	//TO CLICK ON THE CHANGE MEMBERSHIP BUTTON
	public void clickOnBtnChangeMembership() throws InterruptedException {
		btnChangeMembership.click();
		logger.info("Clicked on the Change membership button");
		Thread.sleep(500);
	}
	
	//TO SELECT THE RADIO BUTTON
	public void selectRadioBtn(String radioButtonName) throws InterruptedException{	
		if(radioButtonName.equals("Effective Immediately")) {
			RadioBtn_3.click();
			logger.info("Selected radio button: Effective Immediately");
			Thread.sleep(500);
		}else if(radioButtonName.equals("The end of the current period")) {
			RadioBtn_4.click();
			logger.info("Selected radio button: The end of the current period");
			Thread.sleep(500);
		}else if(radioButtonName.equals("Custom Date")) {
			RadioBtn_5.click();
			logger.info("Selected radio button: Custom Date");
			Thread.sleep(500);
		}else {
			logger.info("Given radio button name not matched");
		}
			
		Thread.sleep(1000);
	}
	
	public void clickOnIconDateNewSubscription() throws InterruptedException {
		iconDateNewSubscriptionDate.click();
		logger.info("Clicked on the custome date selector icon");
		Thread.sleep(500);
	}
	//TO SELECT THE CUSTOME DATE
	public void setNewSubsriptionDate(String Customdate) throws InterruptedException {
		clickOnIconDateNewSubscription();
		DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,Customdate);
		logger.info("Custom date, month and year entered");
	    Thread.sleep(500);
	}
	
	//TO SELECT THE CHECK BOX
	public void clickOnCheckBoxAgreePricingOption() throws InterruptedException {
		ruae.clickOnCheckBox_1_RU();
	}
	
	//TO CLICK BUTTON AGREED TERMS
	public void clickOnBtnAgreedTerm() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(btnAgreeTerm));
		Thread.sleep(500);
		btnAgreeTerm.click();
		logger.info("Clicked on the agreed terms");
		Thread.sleep(2000);
	}
	
	//TO CLICK ON PAUSE MEMBERSHIP BUTTON
	public void clickOnPauseMembership() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(btnPauseMembership));
		Thread.sleep(500);
		btnPauseMembership.click();
		logger.info("Clicked on the pause member ship button");
		Thread.sleep(1000);
	}
	
	//TO CLICK ON PAUSE MEMBERSHIP BUTTON
	public void clickOnResumeMembership() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(btnResumeMembership));
		Thread.sleep(500);
		btnPauseMembership.click();
		logger.info("Clicked on the pause member ship button");
		Thread.sleep(1000);
	}
	
	//TO CLICK ON DROPDWON BUTTON SELECT REASON
	public void clickOnDrpReason() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(btnDrpSelectReason));
		Thread.sleep(300);
		//btnDrpSelectReason.click();
		action.click(btnDrpSelectReason).build().perform();
		logger.info("Clicked on the dropdown reason while puase membership");
		Thread.sleep(500);
	}
	
	public void selectReason(String reason) throws InterruptedException {
		clickOnDrpReason();
		Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(ruae.listOption_RU,reason);
		Thread.sleep(1000);
		logger.info("Pause membership reason selected");
	}
	

	public void clickOnBtnPauseMyMembership() throws InterruptedException {
		btnPauseMyMembership.click();
		logger.info("Clicked on the pause my membership");
		Thread.sleep(300);
	}
	
	public void clickOnBtnResumeMyMembership() throws InterruptedException {
		btnResumeMyMembership.click();
		logger.info("Clicked on the resume my membership");
		Thread.sleep(300);
	}
	
	
	//TO SELECT THE PUASE MEMBESHIP START DATE
	public void setPauseMembershipStartDate(String startDate) throws InterruptedException {
		clickOnIconStartDatePauseMembership();
		DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,startDate);
		logger.info("Entered Pause membership start date");
	    Thread.sleep(1000);
	}
	
	
	//TO SELECT THE PUASE MEMBESHIP END DATE
	public void setPauseMembershipEndDate(String endDate) throws InterruptedException {
		clickOnIconEndDatePauseMembership();
		DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,endDate);
		logger.info("Entered pause membership end date");
	    Thread.sleep(1000);
	}
	
	//TO CLICK ON THE PAUSE MEMBERSHIP START DATE
	public void clickOnIconStartDatePauseMembership() throws InterruptedException {
		iconStartDatePauseMembership.click();
		logger.info("Clicked on the pause membership start date icon");
		Thread.sleep(500);
	}
	
	//TO CLICK ON THE PAUSE MEMBERSHIP END DATE
	public void clickOnIconEndDatePauseMembership() throws InterruptedException {
		iconEndDatePauseMembership.click();
		logger.info("Clicked on the pause membership end date icon");
		Thread.sleep(500);
	}

	//=========START========ACTION METHODS FOR MEMBERSHIP PAGE OBJECTS=============//
	
	
	
	
	
	//TO CHANGE THE MEMBERSHIP
	public PO_HomePage changeMembership(String categoryName,String packageName,String radioButtonName,String membershipDate ) throws InterruptedException {
		logger.info("Method called: changeMembership");
		clickOnBtnManageMembership();
		selectCategory(categoryName);
		Thread.sleep(500);
		selectRadioBtn(radioButtonName);
		if(radioButtonName.equals("Custom Date")) {
			logger.info("Start filling custom date");
			setNewSubsriptionDate(membershipDate);
			logger.info("Custom date radio button selected and membership date entered");
		}else {
			logger.info("Selected radio button is not Custom Date");
		}
		selectPackage(packageName);
		ruae.clickOnCheckBox_1_RU();
		clickOnBtnChangeMembership();
		if(snakeAlertMessagesDisplayedContent_RU().equals(alertMsgChangeMembership)) {
			logger.info("===>>> Membership Changed Successfully");
		} else if(snakeAlertMessagesDisplayedContent_RU().equals(alertMsgSelectMemberhsipPackage)) {
			logger.info("===>>> Membership package not selected");
			ruae.clickOnCancelButton_1_RU();
		}else {
			logger.info("Alert Message Content is: "+snakeAlertMessagesDisplayedContent_RU());
			ruae.clickOnCancelButton_1_RU();
		}
		logger.info("Method call done: changeMembership ");
		return new PO_HomePage(driver);
	}
	
	//TO CHECK AGREED TERMS
	public PO_HomePage checkAgreedTerm() throws InterruptedException {
		logger.info("Method called: checkAgreedTerm");
		clickOnBtnAgreedTerm();
		ruae.clickOnCancelButton_1_RU();
		logger.info("Method call done: checkAgreedTerm");
		return new PO_HomePage(driver);
	}
	
	//TO PAUSE THE MEMBERSHIP
	public PO_HomePage pasueMembership(String pauseStartDate, String pauseEndDate, String pauseReason) throws InterruptedException {
		logger.info("Method called: pasueMembership");
		clickOnPauseMembership();
		selectReason(pauseReason);
		setPauseMembershipStartDate(pauseStartDate);
		setPauseMembershipEndDate(pauseEndDate);
		clickOnBtnPauseMyMembership();
		clickOnBtnConfirm_RU();
		if(snakeAlertMessagesDisplayedContent_RU().equals(alertMsgPauseMembership)) {
			logger.info("===>>> Membership Paused Successfully");
		} else if(snakeAlertMessagesDisplayedContent_RU().equals(alertMsgPauseMembershipMoreThenOneTimeInAQuarter)) {
			logger.info("===>>> Membership not paused");
			ruae.clickOnCancelButton_1_RU();
		}else if(snakeAlertMessagesDisplayedContent_RU().equals(alertMsgNoActiveSubscription)) {
			logger.info("===>>> Membership not paused");
			ruae.clickOnCancelButton_1_RU();
		}else {
			logger.info("Alert Message Content is: "+snakeAlertMessagesDisplayedContent_RU());
			ruae.clickOnCancelButton_1_RU();
		}
		logger.info("Method call done: pasueMembership");
		return new PO_HomePage(driver);	
	}
	
	//TO RERSUME THE MEMBERSHIP
	public PO_HomePage resumeMembership() throws InterruptedException {
		logger.info("Method called: resumeMembership");
		clickOnResumeMembership();
		clickOnBtnResumeMyMembership();
		clickOnBtnConfirm_RU();
		if(snakeAlertMessagesDisplayedContent_RU().equals(alertMsgResumeMembership)) {
			logger.info("===>>> Membership Resumed Successfully");
		}else {
			logger.info("Alert Message Content is: "+snakeAlertMessagesDisplayedContent_RU());
			ruae.clickOnCancelButton_1_RU();
		}
		logger.info("Method call done: pasueMembership");
		return new PO_HomePage(driver);	
	}
	
}
