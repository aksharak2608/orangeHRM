package com.orangeHRM.Factories;


public class dataProvider {
	public static excelDataProvider ExcelDataprovidergetdata()
	{
		excelDataProvider excel= new excelDataProvider();
		return excel;
	}
	
	public static ConfigDataProvider getConfigData()
	{
		ConfigDataProvider obj= new ConfigDataProvider();
		return obj;
	}

}
