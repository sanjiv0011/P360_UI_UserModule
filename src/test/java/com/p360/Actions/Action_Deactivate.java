package com.p360.Actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.p360.ReUseAble.PageObject.ReUseAbleElement;


public class Action_Deactivate {
	
	public static final Logger logger = LogManager.getLogger(Action_Deactivate.class);
	public ReUseAbleElement ruae;
	
	public boolean  deactivate(String searchKey,WebDriver driver, String message) throws InterruptedException
	{
		boolean flag = false;
		ruae = new ReUseAbleElement(driver);
		ruae.searchBox_RU(searchKey);
    	if(!ruae.isSearchKeysNotFound_RU()){
    		if(ruae.isAlreadyActiveDisplayed_RU()) {
    			ruae.clickOnActionButton_RU();
    			ruae.clickOnDeactivateAction_RU();;
    			ruae.clickOnYesButton_RU();
    	    	
    	    	//CHECK THE DEACTIVATE CONFIRMATIONS MESSAGES
    	    	String alretMsg = ruae.snakeAlertMessagesDisplayedContent_RU();
    	    	if(alretMsg.equals(message)) {
    	    		Assert.assertEquals(message, alretMsg,"DEACTIVATED successfully");
    	    		logger.info("===>>> "+message);
    	    		flag = true;
    	    	}else {
    	    		logger.info("Alert message content: "+alretMsg);
    	    	}
    		}
    	}
    	return flag;
	}
	
}
