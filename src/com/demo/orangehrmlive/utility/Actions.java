package com.demo.orangehrmlive.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Actions {
	
	private WebDriver driver;
	private WebElement element;

    // Constructor
    public Actions(WebDriver driver) {
        this.driver = driver;
      //  this.element = element;  , WebElement element
    }
    
    
 // Method to return a WebElement "id"
    public  Actions findElementId(String locator) {
        try {
            // Locate the element
        	WebElement element = driver.findElement(By.id(locator));
        	this.element = element;
            return this;
        } catch (Exception e) {
            System.out.println("Element not found: " + e.getMessage());
            return null;
        }
    }
    
 // Method to return a WebElement "name"
    public  Actions findElementName(String locator) {
        try {
            // Locate the element
        	WebElement element = driver.findElement(By.name(locator));
        	this.element = element;
            return this;
        } catch (Exception e) {
            System.out.println("Element not found: " + e.getMessage());
            return null;
        }
    }
    
 // Method to return a WebElement "xpath"
    public  Actions findElementXpath(String locator) {
        try {
            // Locate the element
        	WebElement element = driver.findElement(By.xpath(locator));
        	this.element = element;
            return this;
        } catch (Exception e) {
            System.out.println("Element not found: " + e.getMessage());
            return null;
        }
    }

    // Method to perform click action on an element and return true if successful, false otherwise
    public boolean clicks() {
        try {
        	element.click();
            return true; // Click action successful
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Click action failed
        }
    }

    // Method to perform sendKeys action on an element and return true if successful, false otherwise
    public boolean sendText(String key) {
        try {
            element.sendKeys(key);
            return true; // SendKeys action successful
        } catch (Exception e) {
            e.printStackTrace();
            return false; // SendKeys action failed
        }
    }
    

    // Method to get text from an element and return it
    public String getTexts() {
        return element.getText();
    }

    // Method to check if an element is displayed and return true if displayed, false otherwise
    public boolean isDisplayed() {
        try {
            return element.isDisplayed(); // Return true if element is displayed
        } catch (Exception e) {
            return false; // Return false if element is not displayed or not found
        }
    }

}
