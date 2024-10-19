package com.demo.orangehrmlive.TestScripts;

import org.testng.annotations.Test;

import com.demo.orangehrmlive.DataGenerator.DataGenerator;
import com.demo.orangehrmlive.base.DriverInstance;
import com.demo.orangehrmlive.functions.LoginPage;

public class TC004_ValidateLoginFunctionalityWithExcelDataProviderInSeperateClass extends DriverInstance{
	
	@Test(dataProvider="Excel", dataProviderClass=DataGenerator.class)
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
	

}
