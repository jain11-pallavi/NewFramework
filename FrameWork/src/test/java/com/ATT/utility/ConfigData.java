package com.ATT.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigData {
      
	Properties pro;
	
	public ConfigData()
	{
		File src = new File("./Config/Config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
		  System.out.println("Found Exception" + e.getMessage());
		}		
	}
	
	public void getDataFromConfig()
	{
		
	}
	
	public String getBrowser()
	{
		 return pro.getProperty("Browser");
	}
	
	public String getURL()
	{
		return pro.getProperty("URL");
		
	}
}
