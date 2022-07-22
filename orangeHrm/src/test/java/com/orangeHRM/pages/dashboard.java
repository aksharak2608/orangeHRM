package com.orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class dashboard {

	WebDriver driver;
	By adminTab=By.id("menu_admin_viewAdminModule");
	
	public void verifyDashboardpage()
	{
	String curl=driver.getCurrentUrl();
	Assert.assertTrue(curl.contains("dashboard"));
		
	}
	public void clickAdmintab()
	{
		driver.findElement(adminTab).click();
	}
	public dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
}
