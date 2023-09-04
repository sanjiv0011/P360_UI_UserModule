package com.p360.ReUseAble.PageObject;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.p360.projectUtility.TimePicker;


public class ReUseAbleElement {
	
	//CONSTRUCTOR INITIALIZATIONS
	public WebDriver driver=null;
	public static final Logger logger = LogManager.getLogger(ReUseAbleElement.class);
	public static WebDriverWait wait,waitAlert = null;
	protected static Actions action;
	
	//CREATE PAGE FACTORY METHODS WITH DRIVERS
	public ReUseAbleElement(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		waitAlert = new WebDriverWait(driver, Duration.ofSeconds(2), Duration.ofMillis(100));
		action = new Actions(driver);
	}
	
	
	
	//========START=======Actions Elements===========TO USE ANY ONE OF THIS FIRST SEARCH IT SO THAT IT COMES AT TOP=========//
	
		//CONTINUE BUTTON P360
		@FindBy(xpath = "(//span[normalize-space()='Continue'])[1]")
		@CacheLookup
		public WebElement btnContinue_RU;
		public void clickONBtnContinue_RU() throws InterruptedException {
			btnContinue_RU.click();
			Thread.sleep(1000);
			logger.info("Clicked on the Continue button");
			
		}
	
		//CONTINUE BUTTON P360 , TO AVOID THE STALE ELEMENT REFERENCE
		public String btnContinueAvoidStaleElementReference_RU ="(//span[normalize-space()='Continue'])[1]";
		public void clickONBtnContinueAvoidStaleElemenetRefernce_RU(WebDriver driver) throws InterruptedException {
			driver.findElement(By.xpath(btnContinueAvoidStaleElementReference_RU)).click();
			Thread.sleep(1000);
			logger.info("Clicked on the Continue button");
			
		}
	
	
		@FindBy(xpath = "//span[normalize-space()='Dashboard']")
		@CacheLookup
		public WebElement menuDashBoard_RU;
		public void clickMenuDashBoard_RU() throws InterruptedException {
			menuDashBoard_RU.click();
			Thread.sleep(3000);
			logger.info("Clicked on the Menu Dashboard");
			
		}
		//SEARCH BOX P360
		@FindBy(xpath = "//input[@placeholder='Search here...']")
		@CacheLookup
		public  WebElement searchBox_RU;
		public void searchBox_RU(String SearchKey) throws InterruptedException
		{	Thread.sleep(200);
			searchBox_RU.sendKeys(SearchKey,Keys.ENTER);
			logger.info("Searched the search keys in the search box: "+SearchKey);
			Thread.sleep(4000);
		}
	
		//SEARCH KEY NOT FOUND
	  	public String searchKeyMessage_RU = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]";
	  	String searchKeyMessageNotFound_RU;
	  	public boolean isSearchKeysNotFound_RU() {
	  		boolean flag = false;
	  		try {
	  			Thread.sleep(1000);
	  			WebElement searchKey = driver.findElement(By.xpath(searchKeyMessage_RU));
	  			if(searchKey.isDisplayed()) {
	  				flag = true;
	  				logger.info("Searched keys is not found: "+searchKey.isDisplayed());
	  			}	
	  		}catch(Exception e) {
	  			logger.info("Searched key not found exception: "+e.getMessage());
	  		}
	  		return flag;
	  	}
	  	
		//ACTION BUTTON THREE DOTS, P360
		@FindBy(xpath = "//*[name()='svg'][contains(@title,'Options')]")		////*[name()='svg'][contains(@title,'Options')]
		@CacheLookup									////div[@class='pointer']
		public WebElement btnOptions_RU;
		public String btnThreeDot_RU =  "//div[@class='pointer']";
		// Action method to click the Action button
	    public void clickOnActionButton_RU() throws InterruptedException {
	    	//BEFORE CLICK ON THE THREE DOTS IT WILL CONFIRM FIST WHERE IT IS PRESENT OR NOT
	    	btnOptions_RU.click();
	        logger.info("Clicked on the Three dot Options button");
	        Thread.sleep(500);
	    }
	    
	   
//	    //CANCEL THE CLASS, P360
//  		@FindBy(xpath = "//div[text()='Cancel Class']")
//  		@CacheLookup
//  		public WebElement btnCancelClass_RU;
    	public boolean clickOnBtnCancelClass_RU(WebDriver driver, int listRowCount) throws InterruptedException {
  	    	//BEFORE CLICK ON THE THREE DOTS IT WILL CONFIRM FIST WHERE IT IS PRESENT OR NOT
  	    	int rowCount = listRowCount;
  	    	String cancelClass_address = "(//div[contains(text(),'Cancel Class')])["+rowCount+"]";
  	    	boolean flag = false;
  	    	try {
  	    		WebElement btnCancelClass = driver.findElement(By.xpath(cancelClass_address));
  	    		if(btnCancelClass.isDisplayed()) {
  	    			btnCancelClass.click();
  	    			flag = true;
  	    			logger.info("Clicked on the button Cancel Class");
  	    		}
  	    	}catch(Exception e) {
  	    		logger.info("Is Cancel Class button displayed: "+flag);
  	    		logger.info("Exception from clickOnBtnCancelClass_RU: "+e.getMessage());
  	    	}
  	        Thread.sleep(500);
  	        return flag;
    	}
  
  
	    //===========START=======ACTIVATE AND DEACTIVATE==================//
	    
		//ACTIVATE Action => To use this first search list item so that it comes at first position
		@FindBy(xpath = "(//div[contains(text(),'Acti')])[1]")
		@CacheLookup
		public WebElement actionActivate;
		// Action method to click the Archive action
	    public void clickOnActivateAction_RU() throws InterruptedException {
	        actionActivate.click();
	        logger.info("Clicked on the Action_Activate button");
	        Thread.sleep(300);
	    }
		
		//DEACTIVATE Action => To use this first search list item so that it comes at first position
		@FindBy(xpath = "(//div[contains(text(),'Deacti')])[1]")
		@CacheLookup
		public WebElement actionDeactivate;
		 // Action method to click the Restore action
	    public void clickOnDeactivateAction_RU() throws InterruptedException {
	        actionDeactivate.click();
	        logger.info("Clicked on the Action_Deactivated button");
	        Thread.sleep(300);
	    }
 		
 	    //TO CHECK LABLE INACTIVE
 	    @FindBy(xpath="//span[normalize-space()='InActive']")
 	    @CacheLookup
 	    public WebElement inactiveLabel;
 	    public boolean isAlreadyInActiveDisplayed_RU() throws InterruptedException {
 	        boolean flag = false;
 	        if (inactiveLabel.isDisplayed()) {
 	            flag = true;
 	           logger.info("InActive label present: "+flag);
 	        }
 	        Thread.sleep(300);
 	        return flag;
 	    }
 	    
 	    //TO CHECK LABLE ACTIVE 
 	    @FindBy(xpath="//span[normalize-space()='Active']")
 	    @CacheLookup
 	    public WebElement activeLabel;
 	    public boolean isAlreadyActiveDisplayed_RU() throws InterruptedException {
 	        boolean flag = false;
 	        if (activeLabel.isDisplayed()) {
 	            flag = true;
 	           logger.info("InActive label present: "+flag);
 	        }
 	        Thread.sleep(300);
 	        return flag;
 	    }
	 	    
	 	//===========END=======ACTIVATE AND DEACTIVATE==================//
	    
	 	    
	    //===========START=======ARCHIVE AND RESTORE==================//
	    
	    //Archive Action => To use this first search list item so that it comes at first position
  		@FindBy(xpath = "(//div[contains(text(),'Archive')])[1]")
  		@CacheLookup
  		public WebElement actionArchive;
  		// Action method to click the Archive action
  	    public void clickOnArchiveAction_RU() throws InterruptedException {
  	        actionArchive.click();
  	        logger.info("Clicked on the Action_Archive button");
  	        Thread.sleep(300);
  	    }
  		
  		//Restore Action => To use this first search list item so that it comes at first position
  		@FindBy(xpath = "(//div[contains(text(),'Restore')])[1]")
  		@CacheLookup
  		public WebElement actionRestore;
  		 // Action method to click the Restore action
  	    public void clickOnRestoreAction_RU() throws InterruptedException{
  	        actionRestore.click();
  	        logger.info("Clicked on the Action_Restore button");
  	        Thread.sleep(300);
  	    }
		
	    //TO CHECK ALLREADY ARCHIVED
	    @FindBy(xpath="//span[text()='Archived']")
	    @CacheLookup
	    public WebElement archivedLabel;
	    public boolean isAlreadyArchivedDisplayed_RU() throws InterruptedException {
	        boolean flag = false;
	        try {
	        	if (archivedLabel.isDisplayed()) {
		            flag = true;
		            logger.info("Confirmation message is already archived: "+flag);
		        }
	        }catch(Exception e) {
	        	logger.info("Archived Exception: "+e.getMessage());
	        }
	        Thread.sleep(300);
	        return flag;
	    }
	  //===========END=======ARCHIVE AND RESTORE==================//
	    
	    
		//Edit Action => To use this first search list item so that it comes at first position
		@FindBy(xpath = "(//div[contains(text(),'Edit')])[1]")
		@CacheLookup
		public WebElement actionEdit_RU;
		// Action method to click the Edit action
	    public void clickOnEditAction_RU() throws InterruptedException {
	    	actionEdit_RU.click();
	        logger.info("Clicked on the Action_Edit button");
	        Thread.sleep(300);
	    }
		
	    
	    //===========START=======FOR THE BUTTON YES, NO, SAVE CHANGES, CROSS BUTTON, SAVE & GO TO HOME, AND DELETE, PROFILE ICON, EYE ICON===================//
	    
	    
		// DATE ICON 1, P360
	    @FindBy(xpath = "(//button[contains(@aria-label,\"Choose date\")])[1]")
		@CacheLookup
		public WebElement iconDate_1_RU;
		public void clickOnDateIcon_1_RU() throws InterruptedException{
			iconDate_1_RU.click();
		   logger.info("Clicked on the date icon 1");
		   Thread.sleep(1000);
		}
	    		
	    		
	    
	    //TO CLICK ON THE USER PROFILE ICON FOR ICON UPLOAD
	    // PROFILE ICON 1
	    @FindBy(xpath = "(//div[contains(@class,'MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault')])[1]")
		@CacheLookup
		public WebElement iconUserProfileImage_1_RU;
		public void clickOnUserProfileIcon_1_RU() throws InterruptedException{
			iconUserProfileImage_1_RU.click();
		   logger.info("Clicked on the icon to upload the user profile image 1");
		   Thread.sleep(1000);
		}
		
		// PROFILE ICON 2
		@FindBy(xpath = "(//div[contains(@class,'MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault')])[2]")
		@CacheLookup
		public WebElement iconUserProfileImage_2_RU;
		public void clickOnUserProfileIcon_2_RU() throws InterruptedException{
			iconUserProfileImage_2_RU.click();
		   logger.info("Clicked on the icon to upload the user profile image 2");
		   Thread.sleep(1000);
		}
		
		
	    //PASSWORD VISIBILITY EYE ICON 1
	    @FindBy(xpath = "(//button[@aria-label='toggle password visibility']//*[name()='svg'])[1]")
		@CacheLookup
		public WebElement iconPasswordVisibility_1_RU;
		public void clickOnEyeIconPasswordView_1_RU() throws InterruptedException{
			iconPasswordVisibility_1_RU.click();
		   logger.info("Clicked on the eye icon to view the password");
		   Thread.sleep(1000);
		}
		
		//PASSWORD VISIBILITY EYE ICON 2
	    @FindBy(xpath = "(//button[@aria-label='toggle password visibility']//*[name()='svg'])[2]")
		@CacheLookup
		public WebElement iconPasswordVisibility_2_RU;
		public void clickOnEyeIconPasswordView_2_RU() throws InterruptedException{
			iconPasswordVisibility_2_RU.click();
		   logger.info("Clicked on the eye icon to view the password");
		   Thread.sleep(1000);
		}
		
		//PASSWORD VISIBILITY EYE ICON 3
		@FindBy(xpath = "(//button[@aria-label='toggle password visibility']//*[name()='svg'])[3]")
		@CacheLookup
		public WebElement iconPasswordVisibility_3_RU;
		public void clickOnEyeIconPasswordView_3_RU() throws InterruptedException{
			iconPasswordVisibility_3_RU.click();
		   logger.info("Clicked on the eye icon to view the password");
		   Thread.sleep(1000);
		}
		
		//CHECK BOX 1,P360
		@FindBy(xpath = "(//input[@type='checkbox'])[1]")
		@CacheLookup
		WebElement checkBox_1_RU;
		public void clickOnCheckBox_1_RU() throws InterruptedException{
			checkBox_1_RU.click();
			Thread.sleep(400);
		   logger.info("Clicked on the Checkbox 1");
		}
		
		//CHECK BOX 2 ,P360
		@FindBy(xpath = "(//input[@type='checkbox'])[2]")
		@CacheLookup
		WebElement checkBox_2_RU;
		public void clickOnCheckBox_2_RU() throws InterruptedException{
			checkBox_2_RU.click();
			Thread.sleep(400);
		   logger.info("Clicked on the Checkbox 2");
		}

		//BUTTON ADD MEMBER, P360
		@FindBy(xpath = "//span[normalize-space()='Add Member']")
  		@CacheLookup
  		public WebElement btnAddMember_RU;
  		public void clickOnAddMember_RU() throws InterruptedException {
  			boolean flag = false;
  			try {
  				wait.until(ExpectedConditions.elementToBeClickable(btnAddMember_RU));
  			}catch(Exception e) {}
  			flag = btnAddMember_RU.isDisplayed();
  			btnAddMember_RU.click();
  			logger.info("Is Displeyed and Clicked on the button add member: "+flag);
  			Thread.sleep(1000);
  		}
		  		
  		//BUTTON ADD MEMBER, P360 , AVOID STALE ELEMENT REFERENCE
		String btnAddMemberAvoidStaleElementReference_RU = "(//span[normalize-space()='Add Member'])[1]";
		public void clickOnAddMemberAvoidStaleElementReference_1_RU(WebDriver driver) throws InterruptedException {
			boolean flag = false;
			WebElement ele =null;
			try {
				ele = driver.findElement(By.xpath(btnAddMemberAvoidStaleElementReference_RU));
			}catch(Exception e) {}
			flag = ele.isDisplayed();
			//logger.info("Is Displeyed: "+flag);
			ele.click();
			logger.info("Clicked on the button add member");
			Thread.sleep(1000);
		}
  	  		
		//BUTTON CANCEL 1,P360
		@FindBy(xpath = "(//span[normalize-space()='Cancel'])[1]")
		@CacheLookup
		public WebElement btnCancel_l_RU;
		public void clickOnCancelButton_1_RU() throws InterruptedException {
			try {
				if(btnCancel_l_RU.isDisplayed()) {
					btnCancel_l_RU.click();
						logger.info("Clicked on the cancel button");
				} else {
					logger.info("Cancel button and HomeIcon button both not found");
				}
					
			}catch(Exception e) {
				logger.info("Cancel button Exception: "+e.getMessage());
			}
		}
	    
		// Yes button before confirm the action, P360
		@FindBy(xpath = "//span[normalize-space()='Yes']")
		@CacheLookup
		public WebElement btnYes_RU;
		 // Action method to click the Yes button
	    public void clickOnYesButton_RU() throws InterruptedException {
	    	btnYes_RU.click();
	        logger.info("Clicked on the Yes button");
	        Thread.sleep(300);
	    }
		
		// No button before confirm the action, P360
		@FindBy(xpath = "//p[normalize-space()='No']")
		@CacheLookup
		public WebElement btnNo_RU;
		// Action method to click the No button
	    public void clickOnNoButton_RU() throws InterruptedException {
	    	btnNo_RU.click();
	        logger.info("Clicked on the No button");
	        Thread.sleep(300);
	    }
	    
	    //DELETE BUTTON
	    @FindBy(xpath = "(//div[contains(text(),'Delete')])[1]")
	    @CacheLookup
	    public WebElement btnDelete;
	    public void clickOnBtnDelete_RU() throws InterruptedException {
	    	btnDelete.click();
	    	logger.info("Clicked on the delete button");
	    	Thread.sleep(300);
	    }
	    
	    //SAVE CHANGES BUTTON
	    @FindBy(xpath = "//p[normalize-space()='Save Changes']")
		@CacheLookup
		public WebElement btnSaveChanges_RU;
	    public void clickOnBtnSaveChanges_RU() throws InterruptedException {
	    	btnSaveChanges_RU.click();
			logger.info("Clicked on the save changes button");
			Thread.sleep(300);
		}
	    
	    //CROSS BUTTON, P360
	    @FindBy(xpath = "//button[@title='Close']")
		@CacheLookup
		public WebElement btnCross;
	    public void clickOnBtnCross_RU() throws InterruptedException {
	    	btnCross.click();
	    	logger.info("Clicked on the cross button icon");
			Thread.sleep(300);
		}
	    
	    //SAVE AND GO TO HOME BUTTON 1
	    @FindBy(xpath = "(//p[text()='Save & Go To Home'])[1]")
		@CacheLookup
		public WebElement btnSaveAndGoToHome_1_RU;
	    public void clickOnBtnSaveAndGoToHome_1_RU() throws InterruptedException {
	    	btnSaveAndGoToHome_1_RU.click();
	    	logger.info("Clicked on the save and go to home button");
			Thread.sleep(300);
		}
	    
	    //SAVE AND GO TO HOME BUTTON 2 
	    @FindBy(xpath = "(//p[text()='Save & Go To Home'])[2]")
		@CacheLookup
		public WebElement btnSaveAndGoToHome_2_RU;
	    public void clickOnBtnSaveAndGoToHome_2_RU() throws InterruptedException {
	    	btnSaveAndGoToHome_2_RU.click();
	    	logger.info("Clicked on the save and go to home button");
			Thread.sleep(300);
		}
	    
	    //BACK BUTTON WITH SPAN TAG
	    @FindBy(xpath = "//span[normalize-space()='Back']")
		@CacheLookup
		public WebElement btnBack;
	    public void clickOnBtnBack_1_RU() throws InterruptedException {
	    	btnBack.click();
	    	logger.info("Clicked on the back button");
			Thread.sleep(300);
		}
	    
	    //NEXT BUTTON 1
	    @FindBy(xpath = "//span[normalize-space()='Next']")
		@CacheLookup
		public WebElement btnNext_RU;
	    public void clickOnBtnNext_1_RU() throws InterruptedException {
	    	btnNext_RU.click();
	    	logger.info("Clicked on the nextbutton");
			Thread.sleep(300);
		}
	 
	    
	    		
		
  		//DROPDOWN BOX ADDRESS 1, P360
  		@FindBy(xpath = "(//div[@role='button'])[1]")
  		@CacheLookup
  		public WebElement dropdownBoxAddress_1_RU;
  		public void clickOnDropdownBoxAddress_1_RU() throws InterruptedException {
  			dropdownBoxAddress_1_RU.click();
  			logger.info("Clicked on the dropdown box address 1 to open drop list");
  			Thread.sleep(1000);
  		}
  		
  		
  		//DROPDOWN BOX ADDRESS 2,  P360
  		@FindBy(xpath = "(//div[@role='button'])[2]")
  		@CacheLookup
  		public WebElement dropdownBoxAddress_2_RU;
  		public void clickOnDropdownBoxAddress_2_RU() throws InterruptedException {
  			dropdownBoxAddress_2_RU.click();
  			logger.info("Clicked on the dropdown box address 2 to open drop list");
  			Thread.sleep(1000);
  		}
  		
  		
	   
	    //DROPDOWN ICON 1, P360
  		@FindBy(xpath = "(//button[@title='Open']//*[name()='svg'])[1]")
  		@CacheLookup
  		public WebElement iconDropdown_1_RU;
  		public void clickOnDropdown_1_RU() throws InterruptedException {
  			iconDropdown_1_RU.click();
  			logger.info("Clicked on the icon dropdown 1");
  			Thread.sleep(1000);
  		} 		
  		
  		
  		//DROPDOWN ADDRESS 2, P360
  		@FindBy(xpath = "(//button[@title='Open']//*[name()='svg'])[2]")
  		@CacheLookup
  		public WebElement iconDropdown_2_RU;
  		public void clickOnDropdown_2_RU() throws InterruptedException {
  			iconDropdown_2_RU.click();
  			logger.info("Clicked on the icon dropdown 1");
  			Thread.sleep(1000);
  		}
  		
  		//DROPDOWN ADDRESS 3
  		@FindBy(xpath = "(//button[@title='Open']//*[name()='svg'])[3]")
  		@CacheLookup
  		public WebElement iconDropdown_3_RU;
  		public void clickOnDropdown_3_RU() throws InterruptedException {
  			iconDropdown_3_RU.click();
  			logger.info("Clicked on the icon dropdown 3 ");
  			Thread.sleep(1000);
  		}
  		
  		//DROPDOWN ADDRESS 4
  		@FindBy(xpath = "(//button[@title='Open']//*[name()='svg'])[4]")
  		@CacheLookup
  		public WebElement iconDropdown_4_RU;
  		public void clickOnDropdown_4_RU() throws InterruptedException {
  			iconDropdown_4_RU.click();
  			logger.info("Clicked on the icon dropdown 4");
  			Thread.sleep(1000);
  		}
	   	
  		//SAVE BUTTON 1, P360
  		@FindBy(xpath = "(//span[normalize-space()='Save'])[1]")
  		@CacheLookup
  		public WebElement btnSave_1_RU;
  		public void clickOnBtnSave_1_RU() throws InterruptedException {
  			btnSave_1_RU.click();
  			logger.info("Clicked on the button save");
  			Thread.sleep(300);
  		}
  		
  
  		//DROPDWON LIST P360
  		@FindBy(xpath = "//ul[@role='listbox']//li")
  		@CacheLookup
  		public List <WebElement>  listOption_RU;
  		
  		//BELOW LINE IS USED TO AVOID THE STALE ELEMENT REFERENCE
  		public String listOptionAvoidStaleElementReference_RU = "//ul[@role='listbox']//li";
  	
  		
  		//CONFIRM BUTTON ADDRESS AND ACTION METHODS
  		@FindBy(xpath = "//span[normalize-space()='Confirm']")
  		@CacheLookup
  		public WebElement  btnConfirm_RU;
  		public void clickOnBtnConfirm_RU() throws InterruptedException{
  			btnConfirm_RU.click();
  			logger.info("Clicked on the confirm button");
  			Thread.sleep(300);
  		}
	  //===========END=======FOR THE BUTTON YES, NO, SAVE CHANGES, CROSS BUTTON, SAVE & GO TO HOME, DORPDOWN ICON AND DELETE==================//
	//========START=======Actions Elements=========TO USER ANY ONE OF THIS FIRST SEARCH IT SO THAT IT COMES AT TOP===========//
	    

		
  //===========START======ACTIVATE AND DEACTIVATE ONLY FOR USER PAGE OBJECT AND ITE ACTION METHODS===========//
		//ACTIVATE Action => To use this first search list item so that it comes at first position
		@FindBy(xpath = "(//div[normalize-space()='Activate'])[1]")
		@CacheLookup
		public WebElement actionActivateUser;
		// Action method to click the Archive action
	    public void clickOnActivateAction_RU_User() throws InterruptedException {
	    	actionActivateUser.click();
	        logger.info("Clicked on the Action_Activate button");
	        Thread.sleep(300);
	    }
		
		//DEACTIVATE Action => To use this first search list item so that it comes at first position
		@FindBy(xpath = "(//div[contains(text(),'Deactivate')])[1]")
		@CacheLookup
		public WebElement actionDeactivateUser;
		 // Action method to click the Restore action
	    public void clickOnDeactivateAction_RU_User() throws InterruptedException {
	    	actionDeactivateUser.click();
	        logger.info("Clicked on the Action_Deactivated button");
	        Thread.sleep(300);
	    }
	    
	
  //===========END======ACTIVATE AND DEACTIVATE ONLY FOR USER PAGE OBJECT AND ITE ACTION METHODS===========//	
	    
 
  //==========START==========TIME SELECTION PAGE OBJECTS AND ITS ACTION METHODS=====USE THIS METHODS IF AND ONLY IF TIME PICKRE FAILED TO PICK THE TIME======//
	  //START AND END TIME REQUIRED MESSAGES ADDRESS
	  		String endTimeRequired_RU = "//p[contains(.,'End time is required')]";
	  		String startTimeRequired_RU = "//p[contains(.,'Start time is required')]";
	  		
	  		//START AND END TIME PLACE HOLDER ADDRESS
	  		String textTimePlaceHolder_1_RU = "(//input[@placeholder='hh:mm aa'])[1]";
	  		String textTimePlaceHolder_2_RU = "(//input[@placeholder='hh:mm aa'])[2]";
	  		
	  		//TO CONFFIRM THE END TIME REQUIRED MESSAGE
	  		public boolean isDisplayedEndTimeRequired_RU() {
	  			WebElement endTimeMsg = driver.findElement(By.xpath(endTimeRequired_RU));
	  			return endTimeMsg.isDisplayed();
	  		}
	  		
	  		//TO CONFFIRM THE START TIME REQUIRED MESSAGE
	  		public boolean isDisplayedStartTimeRequired_RU() {
	  			WebElement startTimeMsg = driver.findElement(By.xpath(startTimeRequired_RU));
	  			return startTimeMsg.isDisplayed();
	  		}
	  		
	  		//TO SET END TIME WITHOUT USING END TIME PICKER
	  		public void setEndTimeWithoutUsingTimePicker_RU(WebDriver driver, String hours, String minutes, String AmPm) throws InterruptedException
	  		{
	  			WebElement endTimePlaceHolder = driver.findElement(By.xpath(textTimePlaceHolder_2_RU));
	  			endTimePlaceHolder.sendKeys(Keys.CONTROL, "a");      // Select all text
	  			endTimePlaceHolder.sendKeys(Keys.CONTROL, "DELETE"); // Delete selected text

	  			logger.info("hours: "+hours);
	  			endTimePlaceHolder.sendKeys(hours);
	  			Thread.sleep(300);
	  			endTimePlaceHolder.sendKeys(minutes);
	  			logger.info("minutes: "+minutes);
	  			Thread.sleep(300);
	  			endTimePlaceHolder.sendKeys(AmPm);
	  			logger.info("AmPm: "+AmPm);
	  			Thread.sleep(300);
	  			logger.info("Entered end time");
	  		}
	  		
	  		//TO SET START TIME WITHOUT USING TIME PICKER
	  		public void setStartTimeWithoutUsingTimePicker_RU(WebDriver driver, String hours, String minutes, String AmPm) throws InterruptedException
	  		{
	  			WebElement endTimePlaceHolder = driver.findElement(By.xpath(textTimePlaceHolder_2_RU));
	  			endTimePlaceHolder.sendKeys(Keys.CONTROL, "a");      // Select all text
	  			endTimePlaceHolder.sendKeys(Keys.CONTROL, "DELETE"); // Delete selected text

	  			logger.info("hours: "+hours);
	  			endTimePlaceHolder.sendKeys(hours);
	  			Thread.sleep(300);
	  			endTimePlaceHolder.sendKeys(minutes);
	  			logger.info("minutes: "+minutes);
	  			Thread.sleep(300);
	  			endTimePlaceHolder.sendKeys(AmPm);
	  			logger.info("AmPm: "+AmPm);
	  			Thread.sleep(300);
	  			logger.info("Entered end time");
	  		}

	  	  //==========END==========TIME SELECTION PAGE OBJECTS AND ITS ACTION METHODS=====USE THIS METHODS IF AND ONLY IF TIME PICKRE FAILED TO PICK THE TIME======//
  		
	  		
	  	
  
	
	  		
	  	//ALARTS ADDRESS AND ACTIONS METHODS
	  	public String alertAddress_RU = "//div[@role=\"alert\"]";
	  	String alertMessageContent_RU;
	  	public String snakeAlertMessagesDisplayedContent_RU() throws InterruptedException {
	  			//logger.info("Alert - Try");
	  			WebElement alertSnakeMessage = null;
	  			int t = 1;
	  			String exception = null;
	  			boolean flag = false;
	  			while(t <= 1500)
	  			{
	  				try {
	  					alertSnakeMessage = driver.findElement(By.xpath(alertAddress_RU));
	  					flag = alertSnakeMessage.isDisplayed();
		  					if(flag) {
		  						logger.info("Checking alert after every 100 miliseconds durations: "+t);
		  						logger.info("Alert message is displayed: "+flag);
		  			  			alertMessageContent_RU = alertSnakeMessage.getText();
		  					}else {
		  						Thread.sleep(150);
		  						t++;
		  					}
	  				}catch(Exception e) {
	  					exception = e.getMessage();
	  					t++;
	  				}
	  				
	  				if(flag) {
	  					Thread.sleep(500);
	  					break;
	  				}
	  				if(t == 1499 || t==1500 ) {
	  					logger.info("Checking alert after every 150 miliseconds durations: "+t);
	  				}
	  			}
	  		
	  		logger.info("Alert not cought exception: "+exception);
	  		Thread.sleep(2000);
	  		return alertMessageContent_RU;
	  	}
	  	
	  	//REQUIRED FIELD MESSAGES
	  	public String requiredMessage_RU = "//p[contains(@class,'MuiFormHelperText-contained')]";
	  	String requiredMessageContent_RU;
	  	public boolean isRequiredMessageDisplayed_RU() {
	  		boolean flag = false;
	  		try {
	  			WebElement requiredMessage = driver.findElement(By.xpath(requiredMessage_RU));
	  			if(requiredMessage.isDisplayed()) {
	  				flag = true;
	  				Thread.sleep(500);
	  				logger.info("Required message is present: "+requiredMessage.isDisplayed());
	  			}	
	  		}catch(Exception e) {
	  			logger.info("Required Exception: "+e.getMessage());
	  		}
	  		return flag;
	  	}
	  	
	 	
	  
}

