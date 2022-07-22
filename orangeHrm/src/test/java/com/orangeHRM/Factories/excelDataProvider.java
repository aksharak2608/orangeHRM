package com.orangeHRM.Factories;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class excelDataProvider {
	 static XSSFWorkbook wb;
	
	public  excelDataProvider()
	{
		try {
			File src= new File(System.getProperty("user.dir")+"\\TestData\\exceldata.xlsx");
		FileInputStream fis= new FileInputStream(src);
		 wb= new XSSFWorkbook(fis);

	}
	catch(Exception e) {
		System.out.println(e);
	}
	}
	
	
	public String readData(int row, int coll)
	{
	String sheetname="Sheet1";
	 return wb.getSheet(sheetname).getRow(0).getCell(0).getStringCellValue();
	}
}
	
