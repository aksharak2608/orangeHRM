package com.orangeHRM.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangeHRM.Factories.dataProvider;
import com.orangeHRM.utility.helper;

public class loginPage {
	WebDriver driver;
	By username=By.xpath("//input[@id='txtUsername']");
	By password=By.id("txtPassword");
	By loginButton= By.xpath("//input[@id='btnLogin']");
	
	public void enterUsername(String user)
	{			
		helper.WaitForWebElementAndType(username, driver, user);
	}
	public void enterpassword(String pass)
	{
		helper.WaitForWebElementAndType(password, driver, pass);
	}
	public void submit()
	{
		driver.findElement(loginButton).click();
	}
	
	public void login(int count)
	{for(int i=0;i<count;i++)
	{
		String user1=dataProvider.ExcelDataprovidergetdata().readData(i, 0);
		String passcode=dataProvider.ExcelDataprovidergetdata().readData(i, 1);
	    helper.WaitForWebElementAndType(username, driver, user1);
		helper.WaitForWebElementAndType(password, driver, passcode);
		driver.findElement(loginButton).click();
		}
	
	}
public loginPage(WebDriver driver)
{
	this.driver=driver;
}
}
