package com.p360.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.p360.pageObject.PO_HomePage;
import com.p360.pageObject.PO_LoginPage;
import com.p360.utilities.ReadConfigFiles;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	public static WebDriver driver;
	public PO_HomePage hp;
	public PO_LoginPage lp;

	
	//TO LOG THE MESSAGES ON THE CONSOLE AND LOG FILES BOTH
	public Logger logger = LogManager.getLogger(this.getClass());
	
	
	//TO READ THE FILE FROM THE utilities.ReadConfigFiles
	public ReadConfigFiles rcf = new ReadConfigFiles();
	public String baseUrl = rcf.getApplicationUrl();
	
	//WHILE COMMENTING THIS TWO LINE ENSURES FIRST, THIS TWO PARAMETER PASS THROUGH DATA PROVIDES METHODS FOR THAT WHERE IT USING PASS THERE @DATAPROVIDER NAME
	public String userEmail = rcf.getUserEmail();
	public String userPassword = rcf.getUserPassword();
	public String adminEmail = rcf.getAdminEmail();
	public String adminPassword = rcf.getAdminPassword();
	
	
	//FAKER LIBRARY TO GENERATE RADOM DATA FOR THE TEST 
	public Faker faker = new Faker();
	
	// to select the driver
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException
	{
		logger.info("Base class started...");
		
		if(br.equals("chrome"))
		{
			//USE THIS LINE IF YOU WANT USE DRIVER FROM THE DRIVER FOLDER
			//System.setProperty("webdriver.chromedriver",rcf.getChromePath());
			
			//OTHER WISE USE BELOW LINE IT WILL TAKES DRIVER FROM THE POM.XML FILES
			WebDriverManager.chromedriver().setup();
			 
			//TO INITIALIZE CHROME OPTIONS
			ChromeOptions option = new ChromeOptions();
			
			//FOR HEADER LESS BROWSING
			//option.addArguments("--headless=chrome"); 
			
			//TO OPEN CHROME DIRVER INTO INCOGNITO MODE
	        option.addArguments("--incognito");
	        
	        //TO USE CHOME DRIVER IN DEBUGGER MODE 
			//option.setExperimentalOption("debuggerAddress", "http://localhost:8888");
	        
	        //TO INITIALIZE CHROME DRIVER
			driver = new ChromeDriver(option);
			logger.info("Chrome driver selected");
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.geckodriver",rcf.getFireFoxPath());
			driver = new FirefoxDriver();
			logger.info("Fire fox driver selected");
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.msedgedriver",rcf.getMsEdgePath());
			driver = new EdgeDriver();
			logger.info("Edge driver selected");
		}
		
		//TO START BASE URL
		driver.get(baseUrl);
		logger.info("Login page started");
		
		//TO MAXIMISE WINDOW
		driver.manage().window().maximize();
		logger.info("Maximize the window");
		//Thread.sleep(5000);
		
		System.out.println("Login user Email: "+userEmail+" and Password: "+userPassword);
		
	}
	
		
	//TO CLOSE THE DIRVER
	@AfterClass
	public void teardown()
	{
		driver.quit();
		logger.info("Driver shutdown");
	}
		
	//TO GENERATES RANDOM STRING HAVING LENGTH 6 CHARACTER
	public String randomString(int intLength) {
		String generatedstring = RandomStringUtils.randomAlphabetic(intLength);
		return generatedstring;
	}
	
	
	//TO GENERATES RANDOM STRING NUMBER WITH MIN AND MAX AS PER USER DATA
	public String randomStringNumber(int max, int min) {
		String rdmStringNumber = RandomStringUtils.randomNumeric(min, max);
		return rdmStringNumber;
	}
	
}
