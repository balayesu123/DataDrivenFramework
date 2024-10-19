package com.demo.orangehrmlive.DataGenerator;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataGenerator {
	
	@DataProvider(name="Excel")
	public static Object[][] dataGenarator() throws Exception
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
	
	
	@DataProvider(name="MainMenuItem")
	public static Object[][] selectMainMenuItem() throws Exception
	{
		FileInputStream file = new FileInputStream("./TestData/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet loginSheet = workbook.getSheet("MainMenuLinks");
		int totlNumberOfRows = loginSheet.getPhysicalNumberOfRows();
		
		Object[][] exceldata = new Object[totlNumberOfRows][1];
		
		for(int i=0 ; i < totlNumberOfRows ; i++)
		{
			XSSFRow row = loginSheet.getRow(i);
			XSSFCell link = row.getCell(0);
			exceldata[i][0]	= link.getStringCellValue();
		}
		
		return exceldata;
	}

}
