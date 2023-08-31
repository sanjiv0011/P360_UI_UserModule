package com.p360.projectUtility;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action_Archive {
	
	public static final Logger logger = LogManager.getLogger(Action_Archive.class);
	public static WebDriverWait wait; 
	
	public static void archive(String searchKey, WebElement searchBox, WebElement archivedLabel, WebElement btnAction, WebElement actionArchive, WebElement btnYes, WebDriver driver) throws InterruptedException
	{
		wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		searchBox.sendKeys(searchKey,Keys.ENTER);
		logger.info("searchKey searched");
		wait.until(ExpectedConditions.elementToBeClickable(btnAction));
		Thread.sleep(300);
    	try{
    		if(archivedLabel.isDisplayed()) {
        		logger.info("Already archived");
    		}
    	}catch(Exception e) {
    		if(e.getMessage() != null){
    			logger.info(e.getMessage());
    			
    			btnAction.click();
        		logger.info("Click on the btnAction");
            	Thread.sleep(1000);
            	
            	actionArchive.click();
            	logger.info("Click on the actionArchive");
            	Thread.sleep(1000);
            	
            	btnYes.click();
            	logger.info("Click on the btnYes");
        	    Thread.sleep(100);
    		}
    	}
    	
//   	 String msg = getArchivedMessage();
//   	 try {
//   		 wait.until(ExpectedConditions.invisibilityOf(msgCreated));
//   		 if(msg.contains("Leave Balance Archived Successfully")) {
//	    		 Assert.assertTrue(true);
//	    		 logger.info("Leave balance archived passed...");
//	    	 }else {
//	    		 Assert.assertTrue(false);
//	    		 logger.info("Leave balance archived failed!!!");
//	    	 }
//   	 }catch(Exception e)
//   	 {
//   		 e.getCause();
//   	 }
	}

}
