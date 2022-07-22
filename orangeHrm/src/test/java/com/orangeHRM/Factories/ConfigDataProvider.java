package com.orangeHRM.Factories;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigDataProvider {
	static Properties pro;
	public  ConfigDataProvider()
	{
		try {
		File src= new File(System.getProperty("user.dir")+"\\TestData\\config.properties");
		FileInputStream fis= new FileInputStream(src);
		 pro= new Properties();
		pro.load(fis);	
	}
	catch(Exception e) {
		System.out.println(e);
	}
	}
	public String getProperty(String key)
	{
		return pro.getProperty(key);
	}
}
