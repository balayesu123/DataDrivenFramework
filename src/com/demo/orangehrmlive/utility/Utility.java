package com.demo.orangehrmlive.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Utility {
	
	public static Object fetchProprtyValue(String key) throws Exception
	{
		FileInputStream file = new FileInputStream(IAutoConstants.configPropertiesPath);
		Properties property = new Properties();
		property.load(file);
		return property.get(key);
	}

	public static String fetchElementLocatorValue(String path,String key) throws Exception
	{
		FileInputStream file = new FileInputStream(path);
		Properties property = new Properties();
		property.load(file);
		return property.get(key).toString();
	}
}
