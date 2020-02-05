/**
 * 
 */
package com.ATT.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author pj558w
 *
 */
public class BrowserFactory

{     
	static WebDriver driver;
	
    public static WebDriver startApplication(String browsername, String url)
    {
    	if(browsername.equalsIgnoreCase("Chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
    		driver= new ChromeDriver();  		
    	}
    	else if(browsername.equalsIgnoreCase("firefox"))
    	{
    		System.setProperty("webdriver.firefox.driver","./Drivers/geckodriver.exe");
    		driver= new FirefoxDriver();
    	}
    	else if(browsername.equalsIgnoreCase("IE"))
    	{
    		System.setProperty("webdriver.IE.driver","./Drivers/IEDriverServer.exe");
    		driver= new InternetExplorerDriver();
    	}
    	else
    	{
    		System.out.println(" We do not have this browser");
    	}
    	 	
    	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
    }
    
    public static void quitApplication(WebDriver driver)
    {
    	driver.quit();
   
    }
    
}
