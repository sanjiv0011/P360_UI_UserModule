package com.p360.projectUtility;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action_DeActivate {
	
	public static final Logger logger = LogManager.getLogger(Action_DeActivate.class);
	public static WebDriverWait wait; 
	
	public static void deactivate(String searchKey, WebElement searchBox, WebElement label, WebElement btnAction, WebElement actionDeactivate, WebElement btnYes, WebDriver driver ) throws InterruptedException
	{
		wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		searchBox.sendKeys(searchKey,Keys.ENTER);
		logger.info("searchKey searched");
		wait.until(ExpectedConditions.elementToBeClickable(btnAction));
		Thread.sleep(300);
    	
    	try{
    		logger.info("Try block");
    		if(label.getText().equals("ACTIVE")) {
    			btnAction.click();
        		logger.info("Click on the btnAction");
            	Thread.sleep(500);
            	
            	actionDeactivate.click();
            	logger.info("Click on the actionDeactivate");
            	Thread.sleep(500);
            	
            	btnYes.click();
            	logger.info("Click on the btnYes");
        	    Thread.sleep(300);
    		}
    	}catch(Exception e) {
    		logger.info("Catch block");
    		if(e.getMessage() != null){
    			logger.info(e.getMessage());
    			logger.info("Already Deactivated");
    		}
    	}
	}

}
