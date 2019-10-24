package com.iLab.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelWrite {
	public static void main(String[] args) throws Exception {

		String testDataPath = "./src/test/resources/testdata/ApplicationDetails.xlsx";
		FileInputStream inputStream = new FileInputStream(testDataPath);
		Workbook workbook=WorkbookFactory.create(inputStream);
		Sheet worksheet=workbook.getSheet("Sheet1");
		Cell job=worksheet.getRow(5).getCell(2);
		job.setCellValue("AutomationEngineer");
		System.out.println(job);
//	save changes
		FileOutputStream outStream=new FileOutputStream(testDataPath);
		workbook.write(outStream);
		outStream.close();
		workbook.close();
		inputStream.close();
		
	}
}
