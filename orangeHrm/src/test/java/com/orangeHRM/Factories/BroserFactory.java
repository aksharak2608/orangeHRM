package com.orangeHRM.Factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BroserFactory {
	static WebDriver driver;
	public static void closeBrowser(WebDriver driver)
	{
		driver.close();
		
	}
	public static WebDriver launchChromeBrowser(String url, String browser)
	{
			if(browser.equalsIgnoreCase("chrome"))  
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Akshara\\Desktop\\selenium setup\\chromedriver.exe");
		 driver = new ChromeDriver();
		}
		  driver.get(url);
		  driver.manage().window().maximize();
		  return driver;
	}
}
