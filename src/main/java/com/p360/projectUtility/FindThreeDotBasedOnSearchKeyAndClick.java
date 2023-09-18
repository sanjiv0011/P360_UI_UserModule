package com.p360.projectUtility;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class FindThreeDotBasedOnSearchKeyAndClick {
	
		public static final Logger logger = LogManager.getLogger(FindThreeDotBasedOnSearchKeyAndClick.class);
		public static SoftAssert softAssert = new SoftAssert();
		public static int findThreedActionButtonAndClick(List<WebElement> listName,WebDriver driver, String searchKey,int searchKeyColumnIndex, boolean wantToClickOnThreeDot) throws InterruptedException {
		
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	String callerMethodName = stackTraceElements[2].getMethodName();
		logger.info("findThreedActionButtonAndClick method called and Caller method name: "+callerMethodName);
		logger.info("wantToClickOnThreeDot: "+wantToClickOnThreeDot);
			
		if(callerMethodName.equalsIgnoreCase("findMyRegisteredClassAndonThreeDotOption")) {
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
		}
		
		
		Thread.sleep(500);
		boolean flag = false;
		boolean confirmationGiverValue = false;
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
						formatText = st.trim();
						
						logger.info("formatText: "+formatText);
		    			
						if(formatText.equalsIgnoreCase(searchKey))
						{
							String btnActionAddress = "(//div[@class='pointer'])["+listRowCount+"]";
							flag = true;
							Thread.sleep(300);
							try {
								WebElement btnThreeDot = element.findElement(By.xpath(btnActionAddress));
								if(btnThreeDot.isDisplayed()) {
									//logger.info("Given DateAndTime : "+searchKey);
									logger.info("Given value matched with the list value: "+formatText);
									confirmationGiverValue =  true;
									if(wantToClickOnThreeDot) {
										btnThreeDot.click();
										logger.info("Clicked on the three dot option button");
									}else {
										logger.info("Text present at given column index: "+formatText);
									}
									Thread.sleep(200);
								}
							}catch(Exception e) {
								logger.info("Exception from FindThreeDotBasedOnSearchKeyAndClick: "+e.getMessage());
								softAssert.assertTrue(false,"Three dot Action button not present");
								return -1;
							}
		        			break;
		        		}
					}
				}
				if(flag) {
					break;
				}
			}
			if(!confirmationGiverValue) {
				logger.info("Given confirmationGiverValue not matched: "+searchKey);
			}
			
		Thread.sleep(200);
		return listRowCount;
	}
	
}
