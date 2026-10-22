package com.actitime.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.EnterTimeTrackPage;
import com.actitime.pom.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	
	@BeforeTest
	public void openBrowser() throws IOException {
		Reporter.log("openBrowser",true);
		
		String url =FileLib.getPropertyData("url");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);

	}
	
	@BeforeMethod
	public void login() throws IOException {
		Reporter.log("login",true);
		String username = FileLib.getPropertyData("username");
		String password = FileLib.getPropertyData("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.setLogin(username, password);
		
	}
	
	@AfterMethod
	public void logout() {
		Reporter.log("logout",true);
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		etp.setLogOut();
	}
	
	@AfterTest
	public void closeBrowser() {
		Reporter.log("closeBrowser",true);
		driver.quit();
	}

}
