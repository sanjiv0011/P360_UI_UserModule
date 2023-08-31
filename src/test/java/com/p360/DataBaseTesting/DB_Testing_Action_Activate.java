package com.p360.DataBaseTesting;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.p360.dataBase.DatabaseConnectionAndQuery_GenericMethods;

public class DB_Testing_Action_Activate {
	
		public WebDriver driver;
		public static final Logger logger = LogManager.getLogger(DB_Testing_Action_Activate.class);

		//CROSS VERIFY DATABASE ONCE ACTIVATED 
		public void test_DB_Activate(String searchKey, String querry,String searchString_DB_ColumnName) throws SQLException, InterruptedException
		{		Thread.sleep(2000); //WAITNG TO AVOID DATA INCONSISTANCY PROBLEM

				//For DataBase Testing
				ResultSet resultset = DatabaseConnectionAndQuery_GenericMethods.dataBaseCollectionAndQuerry(querry);
	
				int count =0;
				while(resultset.next())
				{	
					if(searchKey.equals(resultset.getString(searchString_DB_ColumnName)))
					{	count++;
						//DATA FROM THE DATABASE
						boolean db_active = resultset.getBoolean("active");
						logger.info("Active status from data base: "+db_active);
						Assert.assertEquals(db_active,true,  "To match Restore status");
						logger.info("===>>> DataBase Activate and UI Activate status matched");
						break;
					}
				}
				if(count == 1) {
					logger.info("Select querry runs and  filter data at the top of the list");
				}
		}
}
