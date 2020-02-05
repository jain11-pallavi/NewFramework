/**
 * 
 */
package com.ATT.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author pj558w
 *
 */
public class LoginPage 

{  WebDriver driver;

   public LoginPage(WebDriver driver)
   {
	   this.driver= driver;
   }
   
    @FindBy(id="userName") WebElement user;
	@FindBy(how=How.ID,using= "password") WebElement pass;
	@FindBy(how=How.XPATH, using="//tagname[id='loginButton-lgwgLoginButton']") WebElement submit;
	
	
   public void loginIntoApplication(String username, String Password)
   {
	   user.sendKeys(username);
	   pass.sendKeys(Password);
	   submit.click();   
   }
	
	
	
	
	
	
	
	
}
