package com.demo.orangehrmlive.TestScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.orangehrmlive.base.DriverInstance;
import com.demo.orangehrmlive.functions.LoginPage;

public class TC002_ValidateLoginFunctionalityWithDataProvider extends DriverInstance{
	
	
	@Test(dataProvider="Static")
	public void loginFunctionality(String username, String password) throws Exception
	{
		
		LoginPage login = new LoginPage(driver);
		
		boolean flage = login.loginApplication(username, password);	
		if(flage)
		{
			System.out.println("Login SuccessFully");
		}
		else
		{
			System.out.println("Failed due to Invalid credentials");
		}
		
	}
	
	
	@DataProvider(name="Static")
	public Object[][] dataGenarator()
	{
		Object[][] data = {{"Admin", "admin123"},{"Admin1", "Admin124"},{"Admin2", "Admin125"}};
		
		return data;
	}

}
