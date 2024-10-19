package com.demo.orangehrmlive.assertions;

import org.openqa.selenium.WebDriver;

public class Comparison {
	
	public static boolean validatePageUrl(WebDriver driver, String ExpUrl)
	{
		boolean blnflag = false;
		
		if(driver.getCurrentUrl().equalsIgnoreCase(ExpUrl)) {
			
			blnflag = true;
		}
		
		return blnflag;
	}
	
	
	public static boolean validatePageTitle(WebDriver driver, String ExpTitle)
	{
		boolean blnflag = false;
		
		if(driver.getTitle().equalsIgnoreCase(ExpTitle)) {
			
			blnflag = true;
		}
		
		return blnflag;
	}

}
