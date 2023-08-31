package com.p360.DataBaseTesting;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.p360.dataBase.DatabaseConnectionAndQuery_GenericMethods;

public class DB_Testing_Organization_CreateAndUpdate {
	public WebDriver driver;
	public static final Logger logger = LogManager.getLogger(DB_Testing_Organization_CreateAndUpdate.class);
		
		//CROSS VERIFY DATABASE ONCE NEW ORGANIZATION CREATED
		public void test_DB_CreateOrganization(String orgName, String orgCode, String orgEmail, String orgPhoneNumber, String orgAddress, String orgArea, String orgCity, String orgState, String orgPostalCode, String orgCountry, String orgTimeZone) throws SQLException, InterruptedException
		{		Thread.sleep(2000); //WAITNG TO AVOID DATA INCONSISTANCY PROBLEM
				String timezone[] = orgTimeZone.split(" ");
				String querry = "select * from public.organizations order by updated_at desc limit 1";
				//For DataBase Testing
				ResultSet resultset = DatabaseConnectionAndQuery_GenericMethods.dataBaseCollectionAndQuerry(querry);
		
				int count =0;
				while(resultset.next())
				{	
					if(orgName.equals(resultset.getString("name")))
					{	count++;
						logger.info("Select querry runs and  filter data at the top of the list and row count: "+count);
						
						//DATA FROM THE DATABASE
						String db_ogName = resultset.getString("name");
						String db_orgCode = resultset.getString("code");
						String db_orgEmail = resultset.getString("email_address");
						String db_orgPhoneNumber = resultset.getString("phone_number");
						String db_orgTimeZone = resultset.getString("timeZone");
						
						String db_Address = resultset.getString("address");
		                // Parse the address JSON BACAUSE ADDRESS IN DATA BASE PRESENT IN THE JSON FORMAT
		                JSONObject addressJSON = new JSONObject(db_Address);
	
		                // Extract fields from the JSON
		                String db_addressLine1 = addressJSON.getString("addressLine1");
		                String db_addressLine2 = addressJSON.getString("addressLine2");
		                String db_city = addressJSON.getString("city");
		                String db_state = addressJSON.getString("state");
		                String db_country = addressJSON.getString("country");
		                String db_postalCode = addressJSON.getString("postalCode");
						
						//CROSS VERIFICATIONS(IT WILL MATCH USER INPUT DATA WITH DATABASE ENTRY)
						Assert.assertEquals(orgCode, db_orgCode, "To match orgCode");
						Assert.assertEquals(orgEmail, db_orgEmail, "To match orgEmail");
						Assert.assertEquals(orgPhoneNumber, db_orgPhoneNumber, "To match orgPhoneNumber");
						Assert.assertEquals(orgAddress, db_addressLine1, "To match orgAddressLine1");
						Assert.assertEquals(orgArea, db_addressLine2, "To match orgAddressLine2");
						Assert.assertEquals(orgCity, db_city, "To match orgCity");
						Assert.assertEquals(orgState, db_state, "To match orgState");
						Assert.assertEquals(orgPostalCode, db_postalCode, "To match orgPostalCode");
						Assert.assertEquals(orgCountry, db_country, "To match orgCountry");
						Assert.assertEquals(timezone[2], db_orgTimeZone, "To match orgTimeZone");
						logger.info("===>>> test_DB_CreateOrganization: DataBase Data Cross Verification matched");
						
						break;
				}
			}

		}
		
}
