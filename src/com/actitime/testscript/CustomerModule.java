package com.actitime.testscript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.EnterTimeTrackPage;
import com.actitime.pom.TaskListPage;

import graphql.ThreadSafe;

@Listeners(com.actitime.generic.ListenerImpl.class)
public class CustomerModule extends BaseClass {
	
	EnterTimeTrackPage timeTrackPage;
	TaskListPage listPage;
	
	@BeforeMethod
	public void initilizePages() {
		timeTrackPage = new EnterTimeTrackPage(driver);
		listPage = new TaskListPage(driver);
	}
	
	@Test(invocationCount = 0)
	public void testCreateCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("create customer", true);
		String expectedCustomerName = FileLib.getExcelData("TestCreateCustomer", 1, 3);
		String bankDesr = FileLib.getExcelData("TestCreateCustomer", 1, 4);
		timeTrackPage.setTasks();

		listPage.getAddNewBtn().click();
		listPage.getAddNewCustomerBtn().click();

		listPage.getCustomerNameTbx().sendKeys(expectedCustomerName);
		listPage.getDescriptionTbx().sendKeys(bankDesr);

		listPage.getProjectDesrCheckBox().click();
		listPage.getTasksDesrCheckBox().click();

		listPage.getCreateCustbtn().click();

		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
		waits.until(ExpectedConditions.textToBePresentInElement(listPage.getActualCustomerName(), expectedCustomerName));
		
		String actualCustomerName = listPage.getActualCustomerName().getText();
		Assert.assertEquals(actualCustomerName, expectedCustomerName);
	}
	
	@Test(dependsOnMethods = "testCreateCustomer",invocationCount = 0)
	public void testModifyCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		
		Reporter.log("Modify Cutomer",true);
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(15));
		timeTrackPage.setTasks();
		
		String oldCustomerName = FileLib.getExcelData("TestModifyCustomer", 1, 3);
		WebElement customer = driver.findElement(By.xpath("//div[contains(text(),'"+oldCustomerName+"')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(customer).perform();
		driver.findElement(By.xpath("//div[contains(text(),'"+oldCustomerName+"')]/../div[@class='editButton available']")).click();
		
		
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='customerNamePlaceHolder']//div[@class='nameLabel']")));
		driver.findElement(By.xpath("//div[@class='customerNamePlaceHolder']//div[@class='nameLabel']")).click();
		
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nameInput']//input[@placeholder='Enter Customer Name']")));
		WebElement modifyTbx = driver.findElement(By.xpath("//div[@class='nameInput']//input[@placeholder='Enter Customer Name']"));
		modifyTbx.sendKeys(Keys.CONTROL,"a");
		
		String newModifyCustomerName = FileLib.getExcelData("TestModifyCustomer", 1, 4);
		modifyTbx.sendKeys(newModifyCustomerName+Keys.ENTER);
		
		driver.findElement(By.xpath("//div[@class='edit_customer_sliding_panel sliding_panel']//div[@class='closeButton']")).click();
		
		
		
		String locatorCustName = newModifyCustomerName+" ";
		By expecLocator = By.xpath("//div[text()='"+locatorCustName+"']");
		
		waits.until(ExpectedConditions.presenceOfElementLocated(expecLocator));
		String actualCustName = driver.findElement(expecLocator).getText();
		
		Assert.assertEquals(actualCustName, newModifyCustomerName);
		
	}
	
	@Test
	public void testDeleteCustomer() throws EncryptedDocumentException, IOException {
		
		Reporter.log("Delete Cutomer",true);
		
		timeTrackPage.setTasks();
		
		String delCustomerName = FileLib.getExcelData("TestDeleteCustomer", 1, 3);
		WebElement customer = driver.findElement(By.xpath("//div[contains(text(),'"+delCustomerName+"')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(customer).perform();
		driver.findElement(By.xpath("//div[contains(text(),'"+delCustomerName+"')]/../div[@class='editButton available']")).click();
		
		
	}

}
