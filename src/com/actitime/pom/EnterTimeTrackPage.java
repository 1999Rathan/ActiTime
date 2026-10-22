package com.actitime.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackPage {
	
	@FindBy(xpath = "//div[text()='TASKS']")
	private WebElement tasks;
	
	@FindBy(id = "logoutLink")
	private WebElement lgBtn;

	public EnterTimeTrackPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setTasks() {
		tasks.click();
	}
	
	public void setLogOut() {
		lgBtn.click();
	}

}
