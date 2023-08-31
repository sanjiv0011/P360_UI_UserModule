package com.p360.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;

public class DataBaseConnection {

    public static void main(String[] args) throws SQLException {
        Connection con = null;
        Statement stm = null;

        try {
            // Step 1: Define database URL, username, and password
            String url = "jdbc:postgresql://localhost:5432/hrms"; // Note the correct URL format
            String username = "postgres";
            String password = "Qwer4321!";
            
            // Step 2: Establish database connection
            con = DriverManager.getConnection(url, username, password);
            // check connection is done or not
 			if(!con.isClosed()) {
 				System.out.println("Connection is successfull...");
 			}else {
 				System.out.println("Connection is failed!!!");
 			}
            
            // Step 3: Create a statement
            stm = con.createStatement();
            
            // Step 4: Execute a query
            String s = "SELECT * FROM public.users";
            
            
            // Step4
 			ResultSet rs = stm.executeQuery(s);
 			// You can process the ResultSet here if needed
 			while(rs.next())
 			{
 				//System.out.println(rs);
 				String user_name = rs.getString("user_name");
 				String email= rs.getString("email_address");
 				System.out.println("User name: "+user_name+" Password: "+" Email: "+email);
 			}
 			
        } catch(Exception e){
			e.getCause();
			//e.getMessage();
			//e.getStackTrace();
		} finally {
			//Step5
			con.close();
			if(con.isClosed()) {
				System.out.println("Connection closed successfully...");
			}else {
				System.out.println("Connection not closed!!!");
			}
		}
        
        System.out.println("Program is exited");
    }
}
