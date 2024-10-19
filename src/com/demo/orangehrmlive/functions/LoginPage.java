package com.demo.orangehrmlive.functions;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.demo.orangehrmlive.utility.Actions;
import com.demo.orangehrmlive.utility.IAutoConstants;
import com.demo.orangehrmlive.utility.Utility;

public class LoginPage{  

	public WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public boolean loginApplication(String username, String password) throws Exception
	{
		boolean blnflag = false;

		//		driver.findElement(By.name(Utility.fetchElementLocatorValue(IAutoConstants.loginPropertiesPath, "userName_name"))).sendKeys(username);
		//		driver.findElement(By.name(Utility.fetchElementLocatorValue(IAutoConstants.loginPropertiesPath, "password_name"))).sendKeys(password);
		//		driver.findElement(By.xpath(Utility.fetchElementLocatorValue(IAutoConstants.loginPropertiesPath, "singIn_xpath"))).click();	

		//	    blnflag = ((Actions) action.findByElement(Utility.fetchElementLocatorValue(IAutoConstants.loginPropertiesPath, "singIn_xpath"))).sendText("user");

		Actions action = new Actions(driver);

		if(!blnflag) {
			blnflag = action.findElementName(Utility.fetchElementLocatorValue(IAutoConstants.loginPropertiesPath, "userName_name")).sendText(username);
		}
		if(blnflag) {
			blnflag = action.findElementName(Utility.fetchElementLocatorValue(IAutoConstants.loginPropertiesPath, "password_name")).sendText(password);
		}
		if(blnflag) {
			blnflag = action.findElementXpath(Utility.fetchElementLocatorValue(IAutoConstants.loginPropertiesPath, "singIn_xpath")).clicks();
		}

			Thread.sleep(2000);
			if(blnflag && !driver.getCurrentUrl().equalsIgnoreCase(Utility.fetchProprtyValue("applicationURL").toString())) {
				String value = action.findElementXpath(Utility.fetchElementLocatorValue(IAutoConstants.mainMenuPropertiesPath, "headerTitle_xpath")).getTexts();	

				if(value.equalsIgnoreCase("Dashboard"))
				{
					blnflag = true;
				}
				else
				{
					blnflag = false;
				}

			}
			else
			{
				blnflag = false;
			}

		return blnflag;
	}
}
