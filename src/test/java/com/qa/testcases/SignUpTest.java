package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pageobjects.LoginPage;
import com.qa.pageobjects.SignUpPage;
import com.qa.utilities.Utils;

public class SignUpTest extends BaseTest {
	public WebDriver driver;
	SignUpPage signupPage;
	public SignUpTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		driver = initializeBrowser(prop.getProperty("browser"));
		SignUpPage signup = new SignUpPage(driver);
		 signupPage = signup.SignUpLink();
	    //driver.findElement(By.xpath("//a[text()='Sign up']")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 3)
	public void ValidSignUp() {
		
		
		LoginPage login = new LoginPage(driver);
		signupPage.NameInput(testDataprop.getProperty("name"));
		login.EnterDataInEmail(Utils.generateEmailWithTimestamp());
		login.EnterDataInPassword(prop.getProperty("Password"));
		signupPage.CountryCodeIcon();
		signupPage.CountryCodeText();
		String CountryCode= signupPage.GetCountryCode();//driver.findElement(By.xpath("//*[text()='+91']")).getText();
		Assert.assertEquals(CountryCode, "+91");
		signupPage.phoneNumber(testDataprop.getProperty("phoneNumber"));
		signupPage.AccessCode(testDataprop.getProperty("accessCode"));
		signupPage.SignUpButton();
		

		
		
	}
	
	@Test(priority = 2)
	public void InvalidSignUpWithAlreadyRegisteredUser() {
		
		
		
		LoginPage login = new LoginPage(driver);
		signupPage.NameInput(testDataprop.getProperty("name"));
		login.EnterDataInEmail(prop.getProperty("Email"));
		login.EnterDataInPassword(prop.getProperty("Password"));
		signupPage.CountryCodeIcon();
		signupPage.CountryCodeText();
		String CountryCode= signupPage.GetCountryCode();
		Assert.assertEquals(CountryCode, "+91");
		signupPage.phoneNumber(testDataprop.getProperty("phoneNumber"));
		signupPage.AccessCode(testDataprop.getProperty("accessCode"));
		signupPage.SignUpButton();
		String errorMessage= signupPage.GetErrorMessageText();//driver.findElement(By.xpath("//div[@type='error']")).getText();
		Assert.assertEquals(errorMessage, testDataprop.getProperty("alreadyRegisteredEmailErrorMessage"),"error message is incorrect");
		

	}
	
	@Test(priority=1)
	public void SignUpWithoutEnteringDetails() {
		SignUpPage signup = new SignUpPage(driver);
		signup.SignUpButton();
		//driver.findElement(By.xpath("//span[text()='Sign up']")).click();
		//String errorName = driver.findElement(By.xpath("//label[@for='name'][2]")).getText();
		String errorName = driver.findElement(By.xpath("//lab[@for='name'][2]")).getText();
	    Assert.assertEquals(errorName, testDataprop.getProperty("errorName"));
	    String errorEmail = driver.findElement(By.xpath("//label[@for='email'][2]")).getText();
	    Assert.assertEquals(errorEmail, testDataprop.getProperty("errorEmail"));
	    String errorPassword = driver.findElement(By.xpath("//label[@for='password'][2]")).getText();
	    Assert.assertEquals(errorPassword, testDataprop.getProperty("errorPassword"));
	    String errorPhone = driver.findElement(By.xpath("//label[@for='phone'][2]")).getText();
	    Assert.assertEquals(errorPhone, testDataprop.getProperty("errorNumber"));
	    String errorAccessCode = driver.findElement(By.xpath("//label[@for='accessCode'][2]")).getText();
	    Assert.assertEquals(errorAccessCode, testDataprop.getProperty("errorAccessCode"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
