package com.waptech.utility;

import java.io.File;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;

	public ExcelDataProvider() {
		try {
			File src = new File("./TestData/DataSheet.xlsx");
			wb = new XSSFWorkbook(src);
		} catch (Exception e) {
			System.out.println("Unable to read data from Test data sheet >> " + e.getMessage());
		}
	}

	public String getStringData(int sheetIndex, int row, int col) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
	}

	public String getStringData(String sheetIndex,int row,int col) {
		return wb.getSheet(sheetIndex).getRow(row).getCell(col).getStringCellValue();
	}

	public double getNumericData(String sheetIndex, int row, int col) {
		return wb.getSheet(sheetIndex).getRow(row).getCell(col).getNumericCellValue();
	}

}
