package com.p360.Actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.p360.ReUseAble.PageObject.ReUseAbleElement;

public class Action_Details {
	
	public static final Logger logger = LogManager.getLogger(Action_Archive.class);
	public static ReUseAbleElement ruae;
	public static SoftAssert softAssert = new SoftAssert();
	public static JavascriptExecutor jsExecutor;
	public static Actions action;
	
	
  	//TO CLICK ON REGION DETAILS BUTTON FROM THE REGION LIST
	public static boolean clickOnThreeDotActionBtnDetails(WebDriver driver) throws InterruptedException 
	{
		boolean flag = false;
		Thread.sleep(500);
		int rowListCount = 1;
		jsExecutor  = (JavascriptExecutor)driver;
		action = new Actions(driver);
		String btnDetails_address = null;
		WebElement btnDetails = null;
		
		while(true){
			
			try {
				//logger.info("rowListCount: "+rowListCount);
				btnDetails_address = "(//span[contains(text(),'Details')])["+rowListCount+"]";
				//logger.info("btnDetails_address:- "+btnDetails_address);
	  			btnDetails = driver.findElement(By.xpath(btnDetails_address));
			}catch(Exception e) {
				logger.info("Exception from clickOnThreeDotActionBtnDetails: "+e.getMessage());
				softAssert.assertTrue(false,"Action button DETAILS address not present");
			}
			
  			
			if(btnDetails.isDisplayed() && btnDetails.isEnabled()) {
				logger.info("Is Details button displayed and enabled: "+btnDetails.isDisplayed());
				logger.info("btnDetails_address:- "+btnDetails_address);
				logger.info("rowListCount: "+rowListCount);
				action.moveToElement(btnDetails).build().perform();
  	  			Thread.sleep(300);
  	  			jsExecutor.executeScript("arguments[0].click();", btnDetails);
  	  			//action.moveToElement(btnDetails).click().build().perform();
	  	  		logger.info("Clicked on Details action button present under three dot");
	  			flag  = true;
	  			Thread.sleep(1000);
	  			break;
			}else {
				rowListCount++;
			}
		}
		
		
		return flag;
		
	}
  		
}
