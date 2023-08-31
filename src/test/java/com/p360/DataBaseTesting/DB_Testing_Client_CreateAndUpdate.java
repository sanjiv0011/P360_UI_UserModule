package com.p360.DataBaseTesting;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.p360.dataBase.DatabaseConnectionAndQuery_GenericMethods;

public class DB_Testing_Client_CreateAndUpdate {
	public WebDriver driver;
	public static final Logger logger = LogManager.getLogger(DB_Testing_Client_CreateAndUpdate.class);
		
		//CROSS VERIFY DATABASE ONCE NEW CLIENT CREATED
		public void test_DB_CreateClient(String clientName, String clientDescription) throws SQLException, InterruptedException
		{		Thread.sleep(2000); //WAITNG TO AVOID DATA INCONSISTANCY PROBLEM

				String querry = "select * from public.client order by updated_at desc limit 1";
				//For DataBase Testing
				ResultSet resultset = DatabaseConnectionAndQuery_GenericMethods.dataBaseCollectionAndQuerry(querry);
		
				int count =0;
				while(resultset.next())
				{	
					if(clientName.equals(resultset.getString("client_name")))
					{	count++;
						logger.info("Select querry runs and  filter data at the top of the list and row count: "+count);
						
						//DATA FROM THE DATABASE
						String db_clientName = resultset.getString("client_name");
						String db_description = resultset.getString("description");
						
						//CROSS VERIFICATIONS(IT WILL MATCH USER INPUT DATA WITH DATABASE ENTRY)
						Assert.assertEquals(clientName, db_clientName, "To match clientName");
						Assert.assertEquals(clientDescription, db_description, "To match clientDescription");
						
						logger.info("===>>> test_DB_CreateUpdateClient: DataBase Data Cross Verification matched");
						
						break;
				}
			}

		}
		
}
