package com.orangeHRM.uniittest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.orangeHRM.Factories.excelDataProvider;


public class demoexcel {
	WebDriver driver;
	By username = By.xpath("//input[@id='txtUsername']");
	By password = By.id("txtPassword");
	By loginButton = By.xpath("//input[@id='btnLogin']");
	@Test
	public void login() {
		for (int i = 0; i < 5; i++) {


		}
	}

}
