package com.p360.projectUtility;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Action_Restore {
	
	public static final Logger logger = LogManager.getLogger(Action_Restore.class);
	public static WebDriverWait wait; 

	public static void restore(String searchKey, WebElement searchBox, WebElement archivedLabel,  WebElement btnAction, WebElement actionRestore, WebElement btnYes, WebDriver driver) throws InterruptedException 
	{
		wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		searchBox.sendKeys(searchKey, Keys.ENTER);
		logger.info("searchKey searched");
		wait.until(ExpectedConditions.elementToBeClickable(btnAction));
		Thread.sleep(300);
		
    	try {
    		if(archivedLabel.isDisplayed()) {
    			logger.info(archivedLabel.isDisplayed());
    			btnAction.click();
        		logger.info("Click on the btnAction");
            	Thread.sleep(2000);
            	
            	logger.info("Before actionRestore.click line");
            	actionRestore.click();
            	logger.info("Click on the actionRestore");
            	Thread.sleep(1000);
            	
            	btnYes.click();
            	logger.info("Click on the btnYes");
            	Thread.sleep(200);
    		}
    			
    	} catch(Exception e) {
    			if(e.getMessage() != null){
    				logger.info("Already Restored");
    			}
    	}
	}
}
