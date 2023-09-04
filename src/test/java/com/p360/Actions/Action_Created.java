package com.p360.Actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.p360.ReUseAble.PageObject.ReUseAbleElement;


public class Action_Created {
	
	public static final Logger logger = LogManager.getLogger(Action_Created.class);
	public ReUseAbleElement ruae;

	public boolean created(WebDriver driver, String messageCreated, String messageAlreadyExist) throws InterruptedException
	{
		ruae = new ReUseAbleElement(driver);
		boolean flag = false;
		//CHECK THE CREATE CONFIRMATIONS MESSAGES
    	if(!ruae.isRequiredMessageDisplayed_RU()){
    		String alretMsg = ruae.snakeAlertMessagesDisplayedContent_RU();
    		if(alretMsg.equals(messageCreated)) {
        		Assert.assertEquals(alretMsg, messageCreated, "CREATED successfully");
        		logger.info("==> "+messageCreated);
        		flag = true;
        	}else if(alretMsg.equals(messageAlreadyExist)){
        		Assert.assertEquals(alretMsg,messageAlreadyExist,"Already Exist");
        		logger.info("===>>> "+messageAlreadyExist);
        		ruae.clickOnCancelButton_1_RU();
        	}else if(alretMsg.contains("error")){
        		Assert.assertTrue(alretMsg.contains("error"),"Error");
        		logger.info("===>>> "+"Error");
        		ruae.clickOnCancelButton_1_RU();
        	}else {
        		logger.info("Alert message content: "+alretMsg);
        	}
    	}else {
    		ruae.clickOnCancelButton_1_RU();
    	}
    	return flag;
	}
	
}
