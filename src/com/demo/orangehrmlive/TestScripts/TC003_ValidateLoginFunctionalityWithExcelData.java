package com.demo.orangehrmlive.TestScripts;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.orangehrmlive.base.DriverInstance;
import com.demo.orangehrmlive.functions.LoginPage;

public class TC003_ValidateLoginFunctionalityWithExcelData extends DriverInstance{
	
	@Test(dataProvider="Excel")
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
	
	
	@DataProvider(name="Excel")
	public Object[][] dataGenarator() throws Exception
	{
		FileInputStream file = new FileInputStream("./TestData/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet loginSheet = workbook.getSheet("LoginData");
		int totlNumberOfRows = loginSheet.getPhysicalNumberOfRows();
		
		Object[][] exceldata = new Object[totlNumberOfRows][2];
		
		for(int i=0 ; i < totlNumberOfRows ; i++)
		{
			XSSFRow row = loginSheet.getRow(i);
			XSSFCell username = row.getCell(0);
			XSSFCell password = row.getCell(1);
			exceldata[i][0]	= username.getStringCellValue();
			exceldata[i][1]	= password.getStringCellValue();
		}
		
		return exceldata;
	}

}
