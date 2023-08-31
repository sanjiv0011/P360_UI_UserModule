package com.p360.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFiles {
	
	Properties pro;
	
	
	public ReadConfigFiles()
	{
		File src = new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch (Exception e)
		{
			System.out.println("ReadConfigFiles Exception: "+e.getMessage());
		}
	}
	
	public String getApplicationUrl()
	{
		String url =  pro.getProperty("baseUrl");
		return url;
	}
	
	public String getEmail()
	{
		String email = pro.getProperty("email");
		return email;
	}
	
	public String getPassword()
	{
		String pwd = pro.getProperty("password");
		return pwd;
	}
	
	public String getChromePath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFireFoxPath()
	{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getMsEdgePath()
	{
		String msedgepath = pro.getProperty("msedgepath");
		return msedgepath;
	}	
}
