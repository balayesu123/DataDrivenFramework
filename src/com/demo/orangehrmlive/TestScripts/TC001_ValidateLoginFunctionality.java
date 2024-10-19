package com.demo.orangehrmlive.TestScripts;

import org.testng.annotations.Test;

import com.demo.orangehrmlive.base.DriverInstance;
import com.demo.orangehrmlive.functions.LoginPage;

public class TC001_ValidateLoginFunctionality extends DriverInstance{
	
	@Test
	public void loginFunctionality() throws Exception
	{
		
		LoginPage login = new LoginPage(driver);
		
		boolean flage = login.loginApplication("Admin", "admin123");	
		if(flage)
		{
			System.out.println("Login SuccessFully");
		}
		else
		{
			System.out.println("Failed due to Invalid credentials");
		}
		
	}

}
