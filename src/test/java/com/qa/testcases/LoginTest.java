package com.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pageobjects.LoginPage;

public class LoginTest extends BaseTest{

	public WebDriver driver;
	LoginPage loginpage;
	public LoginTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		driver = initializeBrowser(prop.getProperty("browser"));
	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void LoginWithValidCreds() {
		
		loginpage = new LoginPage(driver);
	    loginpage.Login(prop.getProperty("Email"), prop.getProperty("Password"));
		Assert.assertTrue(loginpage.Homepage(),"Error");
	}
	
	
	
	@Test
	public void LoginWithInvalidCreds() {
	   
		loginpage= new LoginPage(driver);
	    loginpage.Login(testDataprop.getProperty("invalidEmail"), testDataprop.getProperty("invalidPassword"));
		String errorMessage= loginpage.ErrorMessageText();
		String ActualError= testDataprop.getProperty("invalidEmailErrorMessage");
		Assert.assertTrue(errorMessage.contains(ActualError),"error");
		
	}
	
	
}
