package com.p360.projectUtility;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePicker{
	
	public static final Logger logger = LogManager.getLogger(DatePicker.class);
	public static Actions action;
	public static WebDriverWait wait;
	
	//DATE PLACE HOLDER ADDRESS THIS IS USED CLEAR ALREADY PRESENT DATE
	public static String textDatePlaceHolder_1_RU = "(//input[@placeholder='MM/DD/YYYY'])[1]";
	public static String textDatePlaceHolder_2_RU = "(//input[@placeholder='MM/DD/YYYY'])[2]";
	public static String textDatePlaceHolder_3_RU = "(//input[@placeholder='MM/DD/YYYY'])[3]";
			
	//DATE ICON ADDRESS
    public static String iconDate_1_RU = "(//button[@aria-label='Choose date'])[1]";
	public static String iconDate_2_RU = "(//button[@aria-label='Choose date'])[2]";
	public static String iconDate_3_RU = "(//button[@aria-label='Choose date'])[3]";
	
	//DATE TOGGLE BUTTON, YEAR LIST, DATE LIST, NEXT BUTTON, PREVIOUS BUTTON, CURRENT MONTH YEAR DISPLAYED ADDRESS
	public static String toggleBtnYearAndDate = "//button[@aria-label=\"calendar view is open, switch to year view\"]";
	public static String selectYear = "//div[contains(@class, 'MuiYearCalendar-root')]//div";
	public static String arrowNextMonth = "//button[@title=\"Next month\"]";
	public static String arrowPreviousMonth = "//button[@title=\"Previous month\"]";
	public static String selectDate = "//div[@role='row']//button";
	public static String elementCurrentMonthYearDisplayed  = "(//div[contains(@class,'MuiPickersFadeTransitionGroup-root')])[1]";
	

	// WAY 3
	//======================= this is used when month and year are in the grid format==================//
			public static void DatePicker_GenericMethod_WhenYearAndDateListPresent(WebDriver driver, String yourDate, int x) throws InterruptedException
			{	
		    	StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		    	String callerMethodName = stackTraceElements[2].getMethodName();
		    	action = new Actions(driver);
		    	wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		    	logger.info("Enter inside method DatePicker class and caller methods name: "+callerMethodName);	
			    
		    	// my date setting
		        String myDate[] = yourDate.split("[\\s\\-\\.]");
		        String year = myDate[2];
		        String month = myDate[1];
		        String date = myDate[0];
		        logger.info("User given Date: "+date+" Month: "+month+" year: " + year);
		        
		        //========START=========TO SELECT DATE PICKER ICON 1,2,3=============//
		        if(x == 1) 
		        {
		        	WebElement datePlaceholder1 = driver.findElement(By.xpath(textDatePlaceHolder_1_RU));
		        	datePlaceholder1.sendKeys(Keys.CONTROL,"a");
		        	Thread.sleep(500);
		        	datePlaceholder1.sendKeys(Keys.DELETE);
		        	Thread.sleep(500);
		        	driver.findElement(By.xpath(iconDate_1_RU)).click();
		        	Thread.sleep(1000);
		        	logger.info("Clicked on the date picker icon: "+ x);
		        }else if(x == 2){
		        	WebElement datePlaceholder2 = driver.findElement(By.xpath(textDatePlaceHolder_2_RU));
		        	datePlaceholder2.sendKeys(Keys.CONTROL,"a");
		        	Thread.sleep(500);
		        	datePlaceholder2.sendKeys(Keys.DELETE);
		        	Thread.sleep(500);
		        	driver.findElement(By.xpath(iconDate_2_RU)).click();
		        	Thread.sleep(1000);
		        	logger.info("Clicked on the date picker icon: "+ x);
		        }else if(x == 3) {
		        	WebElement datePlaceholder3 = driver.findElement(By.xpath(textDatePlaceHolder_3_RU));
		        	datePlaceholder3.sendKeys(Keys.CONTROL,"a");
		        	Thread.sleep(500);
		        	datePlaceholder3.sendKeys(Keys.DELETE);
		        	Thread.sleep(500);
		        	driver.findElement(By.xpath(iconDate_3_RU)).click();
		        	Thread.sleep(1000);
		        	logger.info("Clicked on the date picker icon: "+ x);
		        }
		        //========END=========TO SELECT DATE PICKER ICON 1,2,3=============//
		        
		        
		        // to click on the toggle button for year and date selection
		        Thread.sleep(1000);
		        driver.findElement(By.xpath(toggleBtnYearAndDate)).click();
		        logger.info("Clicked on the toggle button for date and year selection");
		        Thread.sleep(2000);

		        //TO MATCH AND PICK THE YEAR
		        List<WebElement> yearGrid = driver.findElements(By.xpath(selectYear));
		        boolean flag = false;
		        for (WebElement yearElement : yearGrid) {
		            String yr = yearElement.getText();
		            if (yr.equals(year)) {
		                Thread.sleep(500);
		                logger.info("Selected year: " + yr);
		                yearElement.click();
		                Thread.sleep(1000);
		                flag = true;
		                break;
		            }
		        }
		        if (flag != true) {
		        	logger.info("Year not selected");
		        }

		        //=========START======TO SELECT THE  MONTH=============//
		        // to match month find already present month "path_currentMonthYearDisplayed"
		        Thread.sleep(500);
		        String monthyear = driver.findElement(By.xpath(elementCurrentMonthYearDisplayed)).getText();
		        String arr[] = monthyear.split(" ");
		        String mon = arr[0];
		        logger.info("Displayed month and year: " + monthyear);
		        String monthArray[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

		        int displayedMonth = 0;
		        int inputMonth = 0;
		        for (int i = 1; i < monthArray.length; i++) {
		            if (mon.equalsIgnoreCase(monthArray[i])) {
		                displayedMonth = i;
		            }
		            if (month.equalsIgnoreCase(monthArray[i])) {
		                inputMonth = i;
		            }
		        }
		        while (displayedMonth > inputMonth) {
		            displayedMonth = displayedMonth - 1;
		            driver.findElement(By.xpath(arrowPreviousMonth)).click();
		            Thread.sleep(2000);
		        }
		        while (displayedMonth < inputMonth) {
		            displayedMonth = displayedMonth + 1;
		            driver.findElement(By.xpath(arrowNextMonth)).click();
		            Thread.sleep(2000);
		            
		        }
		        if (displayedMonth == inputMonth) {
		            logger.info("selected month name is: " + monthArray[inputMonth]);
		        } else {
		            logger.info("Month not selected");
		        }
		        //=========END======TO SELECT THE  MONTH=============//
		        
		        
		        //TO MATCH AND SELECT THE DATE
		        List<WebElement> allDates = driver.findElements(By.xpath(selectDate));
		        Thread.sleep(1000);
		        boolean flag2 = false;
		        for (WebElement dateElement : allDates) {
		            String dt = dateElement.getText();
		            if (dt.equals(date)) {
		                try {
		                	Thread.sleep(500);
			                flag2 = true;
			                logger.info("Selected date: " + dt);
			                if(dateElement.isEnabled()) {
			                	dateElement.click();
			                }
			                Thread.sleep(1000);
			                break;
		                }catch(Exception e) {
		                	logger.info("Exception from DatePicker_GenericMethod_WhenYearAndDateListPresent: "+e.getMessage());
		                }
		            }
		        }
		        if (flag2 != true) {
		        	logger.info("Date not selected");
		        }
		    	Thread.sleep(1000);
			}
			

	
/*
	//WAY 2
	//======================= this is used when there is no dropdown for the month and year ==================//
	public static void DatePicker_GenericMethod_WithoutDropDown(
		
	        WebElement path_YearDateToggleBtn,
	        WebElement selectMonth,
	        WebElement iconNextMonth,
	        WebElement iconPreviousMonth,
	        List<WebElement> path_dateGrid,
	        List<WebElement> path_yearGrid,
	        String yourDate) throws InterruptedException {
	    
	    // Split the given date
	    String myDate[] = yourDate.split(" ");
	    String year = myDate[2];
	    int int_year = Integer.parseInt(year);
	    String month = myDate[1];
	    String date = myDate[0];
	    String usergiven_month_year = month+" "+year;
	    logger.info("User given year: " + year + " Month: " + month + " Date: " + date);
	    
	    // to match month find already present month "path_currentMonthYearDisplayed"
        Thread.sleep(500);
        String monthyear = selectMonth.getText();
        //logger.info(monthyear);
        String arr[] = monthyear.split(" ");
        String mon = arr[0];
        String yr = arr[1];
        logger.info("Displayed month name: " + mon+" Displayed year: "+yr);
        int int_yr = Integer.parseInt(yr);
        String monthArray[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        
        //TO MATCH YEAR
        while(true)
        {	Thread.sleep(500);
        	String currentmonthyear = selectMonth.getText();
        	String log = ("Displayed month year: "+currentmonthyear+" User month year: "+usergiven_month_year);
 
        	
        	if(currentmonthyear.equals(usergiven_month_year)) {
        		log = ("Displayed month year: "+currentmonthyear+" User month year: "+usergiven_month_year+" Matched");
        		logger.info(log);
        		Thread.sleep(1000);
        		break;
        	}else {
        		if(int_year == int_yr)
        		{	logger.info("Year matched");
        			 int displayedMonth = 0;
        		        int inputMonth = 0;
        		        for (int i = 1; i < monthArray.length; i++) {
        		            if (mon.equalsIgnoreCase(monthArray[i])) {
        		                displayedMonth = i;
        		            }
        		            if (month.equalsIgnoreCase(monthArray[i])) {
        		                inputMonth = i;
        		            }
        		        }
        		        while (displayedMonth > inputMonth) {
        		            displayedMonth = displayedMonth - 1;
        		            iconPreviousMonth.click();
        		            Thread.sleep(1000);
        		        }
        		        while (displayedMonth < inputMonth) {
        		            displayedMonth = displayedMonth + 1;
        		            iconNextMonth.click();
        		            Thread.sleep(1000);
        		            
        		        }
        		        if (displayedMonth == inputMonth) {
        		            logger.info("Month is selected and name is: " + monthArray[inputMonth]);
        		        } else {
        		            logger.info("Month not selected");
        		        }
        		        
        		} else if(int_year > int_yr) 
	        		{
	        			iconNextMonth.click();
	                    Thread.sleep(500);
	        		} else if(int_year < int_yr)
		        		{
		        			iconPreviousMonth.click();
		                    Thread.sleep(500);
		        		}
        		
        	}
        }
	    
        
	    //TO MATCH DATE
	    for (WebElement dateElement : path_dateGrid) {
	        String dt = dateElement.getText();
	        if (dt.equals(date)) {
	            dateElement.click();
	            System.out.println("User date: "+dt+" Matched");
	            Thread.sleep(1000);
	            break;
	        }
	    }
	    
	}

	
*/

		
//		//WAY 4
//		//======================= used when drop down present for month and year==================//
//	
//	public static void DatePicker_GenericMethod_WithDropDown()
//	{
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver= new ChromeDriver();
//		
//		// path for date picker "path_DatePicker"
//		driver.findElement(By.xpath("")).click();
//		
//		// use it  if drop come under select tab"path_monthDropDown"
//		Select month_drp = new Select(driver.findElement(By.xpath("")));
//		month_drp.selectByVisibleText("July");
//		
//		// use it  if drop come under select tab"path_yearDropDown"
//		Select year_drp = new Select(driver.findElement(By.xpath("")));
//		year_drp.selectByVisibleText("2023");
//		
//		
//		
//	}

		// WAY 1
		//SELECT THE DATE WHEN DATE IS IN GRID FORMAT ONLY AND MONTH YEAR IN BETWEEN NEXT AND PRIVIOUS BUTTON
		public static void DatePicker_GenericMethod_WhenDateGridOnlyPresent(WebDriver driver, String yourDate ) throws InterruptedException
		{	
			StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
	    	String callerMethodName = stackTraceElements[2].getMethodName();
	    	action = new Actions(driver);
	    	wait = new WebDriverWait (driver, Duration.ofSeconds(10));
	    	logger.info("Enter inside method DatePicker class and caller methods name: "+callerMethodName);	
			
	    	String monthYear_address = "//div[contains(@class,'MuiPickersCalendarHeader-transitionContainer')]";
			String previousButton_address = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton'])[1]";
			String nextButton_address = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton'])[2]";
			String dateList_address = "//div[@class='MuiPickersCalendar-week']//div[@role='presentation']";
			
		    // my date setting
	        String myDate[] = yourDate.split(" ");
	        String year = myDate[2];
	        String month = myDate[1];
	        String date = myDate[0];
	        logger.info("User given year: " + year+" Month: "+month+" Date: "+date);

	        // to match month find already present month "path_currentMonthYearDisplayed"
	        Thread.sleep(500);
	        String monthyear = driver.findElement(By.xpath(monthYear_address)).getText();
	        logger.info(monthyear);
	        String arr[] = monthyear.split(" ");
	        String yr = arr[1];
	        String mon = arr[0];
	        logger.info("Displayed month name: " + mon+" and year is: "+ yr);
	        String monthArray[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

	       
	        //TO SELECT THE YEAR
        	while(Integer.parseInt(year)>Integer.parseInt(yr)) {
        		driver.findElement(By.xpath(nextButton_address)).click();
        		Thread.sleep(500);
        	}
        	while(Integer.parseInt(year)<Integer.parseInt(yr)) {
        		driver.findElement(By.xpath(previousButton_address)).click();
        		Thread.sleep(500);	        	
        	}
        	
        	//TO SELECT THE MONTH
        	int displayedMonth = 0;
	        int inputMonth = 0;
	        for (int i = 1; i < monthArray.length; i++) {
	        	if (mon.equalsIgnoreCase(monthArray[i])) {
	                displayedMonth = i; //IT WILL SELECT THE DISPLAYED MONTH POSITION
	            }
	            if (month.equalsIgnoreCase(monthArray[i])) {
	                inputMonth = i;	// IT WILL GIVE THE GIVEN MONTH POSITION
	            }
	        }
	        while (displayedMonth > inputMonth) {
	            displayedMonth = displayedMonth - 1;
	            driver.findElement(By.xpath(previousButton_address)).click();
	            Thread.sleep(1000);
	        }
	        while (displayedMonth < inputMonth) {
	            displayedMonth = displayedMonth + 1;
	            driver.findElement(By.xpath(nextButton_address)).click();
	            Thread.sleep(1000);
	            
	        }
	        if (displayedMonth == inputMonth) {
	            logger.info("selected month name is: " + monthArray[inputMonth]);
	        } else {
	            logger.info("Month not selected");
	        }

	        //TO SELECT DATE
	        List<WebElement> allDates = driver.findElements(By.xpath(dateList_address));
	        Thread.sleep(1000);
	        boolean flag2 = false;
	        for (WebElement dateElement : allDates) {
	            String dt = dateElement.getText();
	            if (dt.equals(date)) 
	            {
	                try {
	                	if(dateElement.isEnabled()) {
	                		wait.until(ExpectedConditions.elementToBeClickable(dateElement));
	                		Thread.sleep(500);
	    	                flag2 = true;
	    	                logger.info("Selected date: " + dt);
	    	                dateElement.click();
	    	                Thread.sleep(1000);
	    	                break;
	                	}else {
	                		logger.info("Is element is enabled: "+flag2);
	                	}
	                }catch(Exception e) {
	                	logger.info("Excepton from DatePicker_GenericMethod_WhenDateGridOnlyPresent: "+e.getMessage());
	                }
	            }
	        }
	        if (flag2 != true) {
	        	logger.info("Date not selected");
	        }
	    }
		
		
		
		//WAY 5
		//TO SELECT THE DATE BY DIRECT SENDING DATA IN THE TEXT BOX
  		public static void setDateByDirectSendingDateVauleInTheTextBox(WebDriver driver,String leaveEndDate, int y) throws InterruptedException {
  			//TO SELECT DATE FIRST DATE WITHOUT USING DATE PICKER 
  			StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
	    	String callerMethodName = stackTraceElements[2].getMethodName();
	    	action = new Actions(driver);
	    	wait = new WebDriverWait (driver, Duration.ofSeconds(10));
	    	logger.info("Enter inside method DatePicker class and caller methods name: "+callerMethodName);	
			
	    	
	  		String firstDateHolder_RU = "(//input[contains(@class,'MuiInput-inputMarginDense')])[1]";
	  		//TO SELECT DATE SECONDS DATE WITHOUT USING DATE PICKER 
	  		String SecondsDateHolder_RU = "(//input[contains(@class,'MuiInput-inputMarginDense')])[2]";
	  		String thirdDateHolder_RU = "(//input[contains(@placeholder,'MM/DD/YYYY')])[3]";
	  		WebElement dateHolder = null;
  			if(y == 1) {
  				dateHolder = driver.findElement(By.xpath(firstDateHolder_RU));
  			}else if(y == 2){
  				dateHolder = driver.findElement(By.xpath(SecondsDateHolder_RU));
  			}else if(y == 3) {
  				dateHolder = driver.findElement(By.xpath(thirdDateHolder_RU));
  			}
  			
  			dateHolder.sendKeys(Keys.CONTROL,"a");
  			dateHolder.sendKeys(Keys.DELETE);
  			String[] date = leaveEndDate.split("[\\s\\-\\.]");
  			String dt = date[0];
  			String mt = date[1];
  			String yr = date[2];
  			System.out.println("Input date: "+dt+" month: "+mt+" year: "+yr);
  			int x = 0;
  			String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
  			for(String mon : months)
  			{	x++;
  				if(mon.equals(mt)){
  					break;
  				}
  			}
  			String z = null;
  			if(x<10) {
  				z = "0"+x;
  			}else {
  				z = String.valueOf(x);
  			}
  			String xAsString = String.valueOf(z);
  			dateHolder.sendKeys(xAsString);
  			Thread.sleep(300);
  			dateHolder.sendKeys(dt);
  			Thread.sleep(300);
  			dateHolder.sendKeys(yr);
  			Thread.sleep(300);

  		}
}
