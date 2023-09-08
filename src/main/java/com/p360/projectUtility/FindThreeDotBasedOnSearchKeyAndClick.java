package com.p360.projectUtility;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindThreeDotBasedOnSearchKeyAndClick {
	
		public static final Logger logger = LogManager.getLogger(FindThreeDotBasedOnSearchKeyAndClick.class);
		
		public static int findThreedActionButtonAndClick(List<WebElement> listName,WebDriver driver, String searchKey,int searchKeyColumnIndex, boolean wantToClickOnThreeDot) throws InterruptedException {
		
			StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
	    	String callerMethodName = stackTraceElements[2].getMethodName();
			logger.info("findThreedActionButtonAndClick method called and Caller method name: "+callerMethodName);
			logger.info("wantToClickOnThreeDot: "+wantToClickOnThreeDot);
		String searchKeyFormat[] = searchKey.split(" ");
		String newSearchKey = null;
		if (Integer.parseInt(searchKeyFormat[1].replace(",", "")) < 10) {
		    searchKeyFormat[1] = String.valueOf(Math.abs(Integer.parseInt(searchKeyFormat[1].replace(",", ""))));
		    
			StringBuilder builder = new StringBuilder();
	        for (int i = 0; i < searchKeyFormat.length; i++) {
	            builder.append(searchKeyFormat[i]);
	            if (i == 1) {
	                builder.append(",");
	            }
	            if (i < searchKeyFormat.length - 1) {
	                builder.append(" ");
	            }
	        }
	        newSearchKey = builder.toString();
	        searchKey = newSearchKey;
	       // logger.info("New searchKey: "+searchKey);
		}
		
		
		Thread.sleep(500);
		boolean flag = false;
		int listRowCount = 0;
			for(WebElement element : listName)
			{	listRowCount++;
				String[] text = element.getText().split("\\n");
				String formatText = "";
				int columnIndexCount = 0;
				for(String st : text)
				{	columnIndexCount++;
					if(columnIndexCount == searchKeyColumnIndex) 
					{
						formatText = st;
						
						//logger.info("formatText: "+formatText.trim());
		    			
						if(formatText.trim().equals(searchKey)){
							String btnActionAddress = "(//div[@class='pointer'])["+listRowCount+"]";
							flag = true;
							Thread.sleep(300);
							WebElement btnThreeDot = element.findElement(By.xpath(btnActionAddress));
							//logger.info("Given DateAndTime : "+searchKey);
							logger.info("Given dateAndTime matched with the list value: "+formatText.trim());
							if(wantToClickOnThreeDot) {
								btnThreeDot.click();
								logger.info("Clicked on the three dot option button");
							}else {
								logger.info("Text present at given column index: "+formatText.trim());
							}
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
