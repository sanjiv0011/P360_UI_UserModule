package com.p360.projectUtility;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Driver;


public class Generic_Method_ToSelect_Boostrape_Dropdown 
{	
	//VARIABLE AND CONSTRUCTER DECLARATIONS
	public static final Logger logger = LogManager.getLogger(Generic_Method_ToSelect_Boostrape_Dropdown.class);

		
    public static void selectOptionFromDropdown(List<WebElement> options, String value)
    {
    	StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	String callerMethodName = stackTraceElements[2].getMethodName();
    
    	logger.info("Enter inside method selectOptionFromDropdown and caller methods name: "+callerMethodName);
    	boolean flag = false;
    	for(WebElement element : options)
    	{	logger.info("List options: "+element.getText());
    		if(element.getText().equals(value) || (element.getText()).trim().contains(value))
    		{  	logger.info("matched list value: "+element.getText());	
    			try {
    				if(element.isEnabled()) {
        				element.click();
        				logger.info("Click on the element");
        			}else {
        				logger.info("Element is not enabled");
        			}
    			}catch(Exception e) {
    				logger.info("Exception While selectiong list from the dropdown: "+e.getMessage());
    			}
    			flag = true;
    			break;
    		}
    	}
    
    	if(flag == false) {
    		logger.info("Given value not selected from the dropdown: "+value);
    	}
    	
    }
}

