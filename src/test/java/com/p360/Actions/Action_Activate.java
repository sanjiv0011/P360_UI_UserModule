package com.p360.Actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.p360.ReUseAble.PageObject.ReUseAbleElement;


public class Action_Activate {
	
	public static final Logger logger = LogManager.getLogger(Action_Activate.class);
	public static ReUseAbleElement ruae;
	public static SoftAssert softAssert = new SoftAssert();
	
	public static boolean activate(WebDriver driver, String message) throws InterruptedException
	{
		boolean flag = false;
		ruae = new ReUseAbleElement(driver);
		try {
			ruae.clickOnActivateAction_RU();
			ruae.clickOnYesButton_RU();
	    	
	    	//CHECK THE ACTIVATE CONFIRMATIONS MESSAGES
	    	String alretMsg = ruae.snakeAlertMessagesDisplayedContent_RU();
	    	if(alretMsg.equals(message)) {
	    		logger.info("===>>> "+message);
	    		flag = true;
	    	}else {
	    		logger.info("Alert message content: "+alretMsg);
	    	}
	    	softAssert.assertEquals(alretMsg, message,"ACTIVATED successfully");
	    	
		}catch(Exception e) {
			logger.info("Exception from Action_Activate: "+e.getMessage());
			softAssert.assertTrue(false,"You want Activate, but Activate button not present");
		}
		softAssert.assertAll();
    	return flag;
	}
	
}
