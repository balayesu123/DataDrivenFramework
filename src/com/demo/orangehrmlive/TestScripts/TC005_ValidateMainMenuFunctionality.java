package com.demo.orangehrmlive.TestScripts;

import org.testng.annotations.Test;

import com.demo.orangehrmlive.DataGenerator.DataGenerator;
import com.demo.orangehrmlive.base.DriverInstance;
import com.demo.orangehrmlive.functions.LoginPage;
import com.demo.orangehrmlive.functions.MainMenuSelectRequiredOption;

public class TC005_ValidateMainMenuFunctionality extends DriverInstance{
	
	@Test(dataProvider="MainMenuItem", dataProviderClass=DataGenerator.class)
	public void orangehrmMailMenuTest(String linkName) throws Exception
	{
		boolean flage = false;
		
		LoginPage login = new LoginPage(driver);
		
		 flage = login.loginApplication("Admin", "admin123");	
		if(flage)
		{
			System.out.println("Login SuccessFully");
		}
		else
		{
			System.out.println("Failed due to Invalid credentials");
		}
		
		MainMenuSelectRequiredOption mainMenu = new MainMenuSelectRequiredOption(driver);
		
		flage = mainMenu.mainMenuSelectLink(linkName);
		if(flage)
		{
			System.out.println("Clicked On Valid Link");
		}
		else
		{
			System.out.println("Clicked On InValid Link");
		}
		
	}

}
