package com.demo.orangehrmlive.functions;

import org.openqa.selenium.WebDriver;

import com.demo.orangehrmlive.utility.Actions;
import com.demo.orangehrmlive.utility.IAutoConstants;
import com.demo.orangehrmlive.utility.Utility;

public class MainMenuSelectRequiredOption {

	public WebDriver driver;

	public MainMenuSelectRequiredOption(WebDriver driver)
	{
		this.driver=driver;
	}

	public boolean mainMenuSelectLink(String option) throws Exception 
	{
		boolean blnflag = false;

		Actions action = new Actions(driver);

		if(!blnflag) {		
			blnflag = action.findElementXpath(Utility.fetchElementLocatorValue(IAutoConstants.mainMenuPropertiesPath, "mainMenuSearchBox_xpath")).sendText(option);
		}		
		if(blnflag) {
			blnflag = action.findElementXpath(Utility.fetchElementLocatorValue(IAutoConstants.mainMenuPropertiesPath, "mainMenuFirstLink_xpath")).clicks();
		}	
		Thread.sleep(2000);
		if(blnflag) {
			String value = action.findElementXpath(Utility.fetchElementLocatorValue(IAutoConstants.mainMenuPropertiesPath, "headerTitle_xpath")).getTexts();	
			
			if(value.equalsIgnoreCase(option))
			{
				blnflag = true;
			}
			else
			{
				blnflag = false;
			}

		}

		return blnflag ;
	}

}
