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


public class Action_Change {

		public static final Logger logger = LogManager.getLogger(Action_Archive.class);
		public static ReUseAbleElement ruae;
		public static SoftAssert softAssert = new SoftAssert();
		public static JavascriptExecutor jsExecutor;
		public static Actions action;
		
		//TO CLICK ON Change ACTION BUTTON FROM THE LIST PRESENT UNDER THE THREE DOT BUTTON
		public static boolean clickOnThreeDotActionBtnChange(WebDriver driver) throws InterruptedException 
		{
			boolean flag = false;
			Thread.sleep(500);
			int rowListCount = 1;
			jsExecutor  = (JavascriptExecutor)driver;
			action = new Actions(driver);
			String btnChange_address = null;
			WebElement btnChange = null;
			
			while(true)
			{
				try {
					btnChange_address = "(//span[contains(text(),'Change')])["+rowListCount+"]";
		  			//logger.info("btnChange_address:- "+btnChange_address);
		  			btnChange = driver.findElement(By.xpath(btnChange_address));
				}catch(Exception e) {
					logger.info("Exception from clickOnThreeDotActionBtnChange: "+e.getMessage());
					softAssert.assertTrue(false,"Action button CHANGE address not present");
				}
	  			
	  			if(btnChange.isDisplayed() && btnChange.isEnabled())
	  			{
	  				logger.info("Is change button displayed and enabled: "+btnChange.isDisplayed());
	  				logger.info("btnChange_address:- "+btnChange_address);
	  				action.moveToElement(btnChange).build().perform();
	  				logger.info("rowListCount: "+rowListCount);
	  	  			Thread.sleep(300);
	  	  			jsExecutor.executeScript("arguments[0].click();", btnChange);
	  	  			//action.moveToElement(btnChange).click().build().perform();
		  	  		logger.info("Clicked on the Change action button present under three dots");
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
