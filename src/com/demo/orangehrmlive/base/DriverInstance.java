package com.demo.orangehrmlive.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.demo.orangehrmlive.utility.Utility;

public class DriverInstance {

	public WebDriver driver ;
	

	@BeforeMethod
	public void initiateDriverInstance() throws Exception
	{
		if(Utility.fetchProprtyValue("browserName").toString().equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Utility.fetchProprtyValue("browserName").toString().equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(Utility.fetchProprtyValue("browserName").toString().equalsIgnoreCase("edge")) 
		{
			System.setProperty("webdriver.Edge.driver", "./Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();			
		}

		driver.get(Utility.fetchProprtyValue("applicationURL").toString());
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
	}
	

	@AfterMethod
	public void closeDriverInstance()
	{
		driver.quit();
	}

}
