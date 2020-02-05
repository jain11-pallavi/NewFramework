/**
 * 
 */
package com.ATT.TestCases;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.ATT.pages.BaseClass;
import com.ATT.pages.LoginPage;

public class LoginATT extends BaseClass{
	

	@Test
	public void loginIntoApp() {
	    
		logger = report.createTest("loginIntoApp");
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Application loaded");
     	loginpage.loginIntoApplication(excel.getStringData(0,1,0),excel.getStringData(0,1,1));
     	logger.pass("Login Successfull");
		
	}
}
