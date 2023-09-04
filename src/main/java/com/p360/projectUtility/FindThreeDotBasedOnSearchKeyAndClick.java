package com.p360.projectUtility;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindThreeDotBasedOnSearchKeyAndClick {
	
		public static final Logger logger = LogManager.getLogger(FindThreeDotBasedOnSearchKeyAndClick.class);
		
		public static int findThreedActionButtonAndClick(List<WebElement> listName,WebDriver driver, String searchKey) throws InterruptedException {
		logger.info("findThreedActionButtonAndClick method called");
		
		Thread.sleep(500);
		boolean flag = false;
		int listRowCount = 0;
			for(WebElement element : listName)
			{	listRowCount++;
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
							String btnActionAddress = "(//div[@class='pointer'])["+listRowCount+"]";
							flag = true;
							Thread.sleep(300);
							WebElement btnThreeDot = element.findElement(By.xpath(btnActionAddress));
							logger.info("Given DateAndTime : "+searchKey);
							logger.info("Given dateAndTime matched with the list value: "+formatText.trim());
							btnThreeDot.click();
							logger.info("Clicked on the three dot option button");
							Thread.sleep(200);
		        			break;
		        		}
					}
				}
				if(flag) {
					break;
				}else {
					logger.info("Given DateAndTime not matched: "+searchKey);
				}
			}
			
		Thread.sleep(200);
		return listRowCount;
	}
	
}
