package com.iLab.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelRead {
	public static void main(String[] args) throws Exception {
		// String filePath=C:/Users/baki/Desktop/ApplicationDetails.xlsx
		String filePath = "C:\\Users\\baki\\Desktop\\ApplicationDetails.xlsx";
		// Open file and convert to a stream data
		FileInputStream inStream = new FileInputStream(filePath);
		// take the stream of data and use it as workbook
		Workbook workbook = WorkbookFactory.create(inStream);
		// get to first worksheet from the workbook
		Sheet worksheet = workbook.getSheetAt(0);
		// go to first row
		Row row = worksheet.getRow(0);
		// goto first cell
		Cell cell = row.getCell(0);
		System.out.println(cell.toString());
		Cell cell1 = workbook.getSheetAt(0).getRow(2).getCell(1);
		System.out.println(cell1);

		// find out how many rowsin excel sheet
		System.out.println("-----");
		// int rowsCount=worksheet.getPhysicalNumberOfRows();
		int rowsCount = worksheet.getLastRowNum();
		System.out.println(rowsCount);

		// print all firstname using a loop
		for (int rowNum = 1; rowNum <= rowsCount; rowNum++) {
			// System.out.println(rowNum+"-"+workbook.getSheetAt(0).getRow(rowNum).getCell(0));
			// or
			row = workbook.getSheetAt(0).getRow(rowNum); // or row=worksheet.getRow(rowNum);
			cell = row.getCell(0);
			System.out.println(rowNum + "-" + cell);
		}
		// print the jobID of John
		for (int rowNum = 1; rowNum <= rowsCount; rowNum++) {
			if (worksheet.getRow(rowNum).getCell(0).toString().equals("John")) {
				System.out.println(worksheet.getRow(rowNum).getCell(2));
				break;
			}
		}
		Cell newJob = workbook.getSheetAt(0).getRow(5).getCell(2);
		newJob.setCellValue("MathTeacher");
		FileOutputStream outStream = new FileOutputStream(filePath);
		workbook.write(outStream);
		outStream.close();
		inStream.close();
		workbook.close();
	}

}
