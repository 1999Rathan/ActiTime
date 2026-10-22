package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id = "username")
	private WebElement unTbx;
	
	@FindBy(name = "pwd")
	private WebElement pwTbx;
	
	@FindBy(id = "loginButton")
	private WebElement lgBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setLogin(String un,String pwd) {
		
		unTbx.sendKeys(un);
		pwTbx.sendKeys(pwd);
		lgBtn.click();
		
	}

}
