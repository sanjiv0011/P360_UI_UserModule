package com.p360.Actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.p360.ReUseAble.PageObject.ReUseAbleElement;

public class Action_Archive {
	
	public static final Logger logger = LogManager.getLogger(Action_Archive.class);
	public static ReUseAbleElement ruae;
	public static SoftAssert softAssert = new SoftAssert();
	
	public static boolean archive(WebDriver driver, String message) throws InterruptedException
	{	boolean flag = false;
		ruae = new ReUseAbleElement(driver);
		try {
			ruae.clickOnArchiveAction_RU();
			ruae.clickOnYesButton_RU();
	    	//CHECK THE ARCHIVED CONFIRMATIONS MESSAGES
	    	String alretMsg = ruae.snakeAlertMessagesDisplayedContent_RU();
	    	if(alretMsg.equals(message)) {
	    		logger.info("===>>> "+message);
	    		flag = true;
	    	}else {
	    		logger.info("Alert message content: "+alretMsg);
	    	}
	    	softAssert.assertEquals(message, alretMsg,"ARCHIVED successfully");
		}catch(Exception e) {
			logger.info("Exeption from Action_Archive: "+e.getMessage());
			softAssert.assertTrue(false, "You want archive but, this button not present");
		}
    	softAssert.assertAll();
    	return flag;
	}
	
}
