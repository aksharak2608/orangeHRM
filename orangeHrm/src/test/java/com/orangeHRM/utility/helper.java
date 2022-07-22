package com.orangeHRM.utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class helper {
	static WebDriver driver;
	public static void WaitForWebElementAndType(By by, WebDriver driver, String text)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(text);
	}
	public static String timeStamp()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");  
	
	   LocalDateTime now = LocalDateTime.now();        
	  String d= dtf.format(now);
	  return d;
	}

	
	public static String TakeScreenshot(WebDriver driver) 
	{
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");  
		   LocalDateTime now = LocalDateTime.now();        
		  String d= dtf.format(now);
	try {
		File dest =new File(System.getProperty("user.dir")+"\\screenshots\\"+d+".png");
		FileHandler.copy(src, dest);
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	
		return System.getProperty("user.dir")+"/Screenshot/selenium"+d+".png";
	}
	public static WebDriver waitForButtonAndClick(WebDriver d, WebElement e)
	{
		/*WebDriverWait w= new WebDriverWait(d, Duration.ofSeconds(5));
		w.until(ExpectedConditions.elementToBeClickable(e));
		e.click(); */
		new WebDriverWait(d, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(e));
		e.click();

		return d;
	}
	public static WebDriver waitForAlert(WebDriver d)
	{
		/*WebDriverWait w= new WebDriverWait(d, Duration.ofSeconds(5));
		w.until(ExpectedConditions.elementToBeClickable(e));
		e.click(); */
		new WebDriverWait(d, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());

		return d;
	}
	public static WebDriver waitForTextfield(WebDriver d,By e)
	{
		
		new WebDriverWait(d, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(e));

		return d;
	}


	

}
