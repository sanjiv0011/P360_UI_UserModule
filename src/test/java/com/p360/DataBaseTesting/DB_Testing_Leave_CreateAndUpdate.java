package com.p360.DataBaseTesting;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.p360.dataBase.DatabaseConnectionAndQuery_GenericMethods;

public class DB_Testing_Leave_CreateAndUpdate {
	public WebDriver driver;
	public static final Logger logger = LogManager.getLogger(DB_Testing_Leave_CreateAndUpdate.class);
		
		//CROSS VERIFY DATABASE ONCE NEW LEAVE CREATED
		public void test_DB_CreateLeave(String leaveTypeName, String leaveDuration, String leaveStartDate, String leaveEndDate, String reason, String orgName) throws SQLException, InterruptedException
		{		Thread.sleep(2000); //WAITNG TO AVOID DATA INCONSISTANCY PROBLEM
			
				//For DataBase Testing
				//TO GET THE SPECIFIC ORGANIZATION ID
				String querryOrg = "select * from public.organizations order by asc";
				ResultSet resultsetOrg = DatabaseConnectionAndQuery_GenericMethods.dataBaseCollectionAndQuerry(querryOrg);
				String orgId=null;
				while(resultsetOrg.next()) {
					if(orgName.equals(resultsetOrg.getString("name"))){
						orgId = resultsetOrg.getString("id");
						logger.info("Selected orgId from the database baseed on orgName: "+orgId);
						logger.info("Selected name from the database: "+resultsetOrg.getString("name"));
						break;
					}
				}
				
				//TO GET THE LEAVE NAME AND ID BASED ON THE SPECIFIC ORGANIZATION
				String querryLeaveType = "select * from public.leave_types where organization_id="+orgId;
				ResultSet resultsetLeaveType = DatabaseConnectionAndQuery_GenericMethods.dataBaseCollectionAndQuerry(querryLeaveType);
				String leaveTypeId=null;
				while(resultsetLeaveType.next()) {
					if(leaveTypeName.equals(resultsetLeaveType.getString("name"))){
						logger.info("Selected leave types from the database: "+resultsetLeaveType.getString("name"));
						leaveTypeId = resultsetLeaveType.getString("id");
						logger.info("Selected leave types id from based on given leaveTypeName"+leaveTypeId);
						break;
					}
				}
				
				//String querryLeaveRequest = "select * from public.leave_requests order by updated_at desc limit 1";
				String querryLeaveRequest = "select * from public.leave_requests order by updated_at desc limit 1";
				ResultSet resultsetLeaveRequest = DatabaseConnectionAndQuery_GenericMethods.dataBaseCollectionAndQuerry(querryLeaveRequest);
		
				int count =0;
				while(resultsetLeaveRequest.next())
				{	
					if(leaveTypeId.equals(resultsetLeaveRequest.getString("leave_type_id")) && orgId.equals(resultsetLeaveRequest.getString("organization_id")))
					{	count++;
						logger.info("Select querry runs and  filter data at the top of the list and row count: "+count);
						
						//DATA FROM THE DATABASE
						String db_leaveDuration = resultsetLeaveRequest.getString("leave_duration");
						String db_leaveStartDate = resultsetLeaveRequest.getString("start_date");
						String db_leaveEndDate = resultsetLeaveRequest.getString("end_date");
						String db_reason = resultsetLeaveRequest.getString("reason");
	
						//CROSS VERIFICATIONS(IT WILL MATCH USER INPUT DATA WITH DATABASE ENTRY)
						Assert.assertEquals(leaveDuration, db_leaveDuration, "To match leaveDuration");
						Assert.assertEquals(leaveStartDate, db_leaveStartDate, "To match leaveEndDate");
						Assert.assertEquals(leaveEndDate, db_leaveEndDate, "To match orgAddressLine1");
						Assert.assertEquals(reason, db_reason, "To match reason");
						
						logger.info("===>>> test_DB_CreateLeave: DataBase Data Cross Verification matched");
						
						break;
				}
			}

		}
		
}
