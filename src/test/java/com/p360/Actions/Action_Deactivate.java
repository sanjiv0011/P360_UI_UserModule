package com.p360.Actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.p360.ReUseAble.PageObject.ReUseAbleElement;


public class Action_Deactivate {
	
	public static final Logger logger = LogManager.getLogger(Action_Deactivate.class);
	public static ReUseAbleElement ruae;
	public static SoftAssert softAssert = new SoftAssert();
	
	public static boolean  deactivate(WebDriver driver, String message) throws InterruptedException
	{
		StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
		String callerMethodName = stackTraceElement[2].getMethodName();
		logger.info("Action_Deactivate caller method name: "+callerMethodName);
		
		boolean flag = false;
		ruae = new ReUseAbleElement(driver);
		
		try {
			clickOnDeactivateAction_RU(driver);;
			ruae.clickOnYesButton_RU();
	    	
	    	//CHECK THE DEACTIVATE CONFIRMATIONS MESSAGES
	    	String alretMsg = ruae.snakeAlertMessagesDisplayedContent_RU();
	    	if(alretMsg.equals(message)) {
	    		
	    		logger.info("===>>> "+message);
	    		flag = true;
	    	}else {
	    		logger.info("Alert message content: "+alretMsg);
	    	}
			
	    	softAssert.assertEquals(message, alretMsg,"DEACTIVATED successfully");
	    	
		}catch(Exception e) {
			logger.info("Exception from Action_Deactivate: "+e.getMessage());
			softAssert.assertTrue(false,"You want to Deactivate but deacitvate button not present");
		}
		softAssert.assertAll();
    	return flag;
	}
	
	//DEACTIVATE Action P360 => To use this first search list item so that it comes at first position
	public static String actionDeactivate_address = "//*[normalize-space(text()) = 'Deactivate']";
    public static void clickOnDeactivateAction_RU(WebDriver driver) throws InterruptedException {
    	int count = 0;
    	while(true) 
       {
    	   try {
    		   WebElement actionDeactivate = driver.findElement(By.xpath(actionDeactivate_address));
	    	   if(actionDeactivate.isDisplayed() && actionDeactivate.isEnabled()) {
		    	   	actionDeactivate.click();
			        logger.info("Clicked on the Action_Deactivated button");
			        Thread.sleep(300);
			        break;
		       }
	       }catch(Exception e) {
	    	   count++;
	    	   logger.info("count: "+count);
	    	   logger.info("Exception from : "+e.getMessage());
	       }  
    	   if(count>10) {
    		   logger.info("Search Loop Count: "+count);
        		break;
        	}
       }
    }
	
}
