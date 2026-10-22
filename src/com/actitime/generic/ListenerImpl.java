
package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerImpl extends BaseClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String sheetName = result.getName();
		
		try {
			FileInputStream fis = new FileInputStream("./data/TestScriptData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			int cell = wb.getSheet(sheetName).getRow(0).getLastCellNum()-1;
			System.out.println(sheetName);
			System.out.println(cell);
			FileLib.setExcelData(sheetName, 1, cell, "pass");
			
		} catch (EncryptedDocumentException | IOException e) {
			
		}
		
		Reporter.log(result.getName()+" is succusfull ",true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getName();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshot/"+testname+".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
	
	

}
