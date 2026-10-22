package com.actitime.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	
	public static String getPropertyData(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./data/commondata.property");
		Properties props = new Properties();
		props.load(fis);
		String data = props.getProperty(key);
		return data;
	}
	
	public static String getExcelData(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./data/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return data;
	}
	
	public static void setExcelData(String sheetName,int rowNo, int cellNo,String cellvalue) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./data/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).setCellValue(cellvalue);
		FileOutputStream fos = new FileOutputStream("./data/TestScriptData.xlsx");
		wb.write(fos);
	}

}
