package com.crm.genericfileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Fileutility_ExcelVtiger {
	public String getdataFromExcel(String Sheetname, int rownum, int celnum) throws Exception {
		FileInputStream fis = new FileInputStream("./Excell/Vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet("mobile_brands").getRow(rownum).getCell(celnum).getStringCellValue();
		return data;

	}
 
	public int getRowcount(String sheetname) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("./Excell/Vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet("mobile_brands").getLastRowNum();
		return rowcount;

	}
	public String getdataFromExcel1(String Sheetname, int rownum, int celnum) throws Exception {
		FileInputStream fis = new FileInputStream("./Excell/Vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet("iphone").getRow(rownum).getCell(celnum).getStringCellValue();
		return data;

	}
	public int getRowcount1(String sheetname) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("./Excell/Vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet("iphone").getLastRowNum();
		return rowcount;

	}

	public void setDataintoExcel(String Sheetname, int rownum, int celnum, String data) throws Exception {
		FileInputStream fis = new FileInputStream("./Excell/Vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet("mobile_brands").getRow(rownum).createCell(celnum);
		FileOutputStream fos=new FileOutputStream ("./Excell/Vtiger.xlsx");
		wb.write(fos);
		wb.close();

	}

}
