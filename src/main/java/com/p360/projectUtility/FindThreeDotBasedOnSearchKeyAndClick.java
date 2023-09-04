package com.p360.projectUtility;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindThreeDotBasedOnSearchKeyAndClick {
	
		public static final Logger logger = LogManager.getLogger(FindThreeDotBasedOnSearchKeyAndClick.class);
		
		public static void findThreedActionButtonAndClick(List<WebElement> listName,String btnThreeDot,WebDriver driver, String searchKey) throws InterruptedException {
		logger.info("findThreedActionButtonAndClick method called");
		
		Thread.sleep(500);
		boolean flag = false;
	
			for(WebElement element : listName)
			{	
				String[] text = element.getText().split("\\n");
				String formatText = "";
				int count = 0;
				for(String st : text)
				{
					count++;
					if(count == 4) 
					{
						formatText = st;
						
						logger.info("formatText: "+formatText.trim());
		    			
						if(formatText.trim().equals(searchKey)){
							flag = true;
							Thread.sleep(300);
							WebElement btnDot = element.findElement(By.xpath(btnThreeDot));
							logger.info("Given DateAndTime : "+searchKey);
							logger.info("Given dateAndTime matched with the list value: "+formatText.trim());
							btnDot.click();
							Thread.sleep(300);
		        			break;
		        		}
						Thread.sleep(100);
					}
				}
				if(flag) {
					break;
				}else {
					logger.info("Given DateAndTime not matched: "+searchKey);
				}
			}
			
		Thread.sleep(1000);
	}
	
}
