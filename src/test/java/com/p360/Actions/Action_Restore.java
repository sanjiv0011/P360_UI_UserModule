package com.p360.Actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.p360.ReUseAble.PageObject.ReUseAbleElement;


public class Action_Restore {
	
	public static final Logger logger = LogManager.getLogger(Action_Restore.class);
	public static ReUseAbleElement ruae;
	public static SoftAssert softAssert = new SoftAssert();
	
	public static boolean restore(WebDriver driver, String message) throws InterruptedException
	{
		boolean flag = false;
		try {
			ruae = new ReUseAbleElement(driver);
			ruae.clickOnRestoreAction_RU();
			ruae.clickOnYesButton_RU();
	    	//CHECK THE ACTIVATE CONFIRMATIONS MESSAGES
	    	String alretMsg = ruae.snakeAlertMessagesDisplayedContent_RU();
	    	if(alretMsg.equals(message)) {
	    		logger.info("===>>> "+message);
	    		flag = true;
	    	}else {
	    		logger.info("Alert message content: "+alretMsg);
	    	}
	    	softAssert.assertEquals(message, alretMsg,"RESTORED successfully");
			
		}catch(Exception e) {
			logger.info("Exception from Action_Restore: "+e.getMessage());
			softAssert.assertTrue(false,"You want Restore, but restore button not present");
		}
    	softAssert.assertAll();
    	return flag;
	}
	
}
