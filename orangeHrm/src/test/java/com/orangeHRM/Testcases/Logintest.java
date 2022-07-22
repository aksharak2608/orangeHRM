package com.orangeHRM.Testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.orangeHRM.Factories.baseClass;
import com.orangeHRM.Factories.dataProvider;
import com.orangeHRM.pages.loginPage;



public class Logintest extends baseClass {
	loginPage l1;
	
	
	@Test
	void test()
	{
		logger=rep.createTest("l1","loginto crm");
		l1=PageFactory.initElements(driver, loginPage.class);
		

		String username= dataProvider.ExcelDataprovidergetdata().readData(1, 0);
		System.out.println(username);
		String password= dataProvider.ExcelDataprovidergetdata().readData(0,1);
		System.out.println(password);
		l1.enterUsername(username);
		l1.enterpassword(password);
		l1.submit();
	}
	
}
