package com.htmlProject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exceldata {

	public static String getData(int i, int x) throws IOException
	{
		File file = new File("C:\\Users\\Lalit\\eclipse-workspace\\Framework\\excelsheet\\excel sheet.xlsx");
		FileInputStream inputstream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = wb.getSheet("sheet1");
		XSSFRow row = sheet.getRow(i);
		XSSFCell column = row.getCell(x);
		String data = column.getStringCellValue();
		return data;
	}
	
	
	
	
}
