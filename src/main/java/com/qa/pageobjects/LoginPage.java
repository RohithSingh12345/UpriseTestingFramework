package com.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	WebDriver driver;
	
	//objects
	@FindBy(xpath = "//input[@id='email']")
	private WebElement EmailInputField;
	
	@FindBy(xpath= "//input[@id='password']")
    private	WebElement PasswordInputField;
	
	@FindBy(xpath="//span[text()='Sign in']")
	private WebElement SignInButton;
	
	@FindBy(xpath="//label[@for='email' and @class='sc-csuQGl eMEOUq']")
	private WebElement ErrorMessage;
	
	@FindBy(xpath= "//h2[text()='Home']")
	private WebElement HomePage;

	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);//intialize the elements available in this page
	}
	
	//actions- to perform some action
	public void EnterDataInEmail(String email){
		EmailInputField.sendKeys(email);
		
	}
	public void EnterDataInPassword(String password) {
		PasswordInputField.sendKeys(password);
	}
	public void ClickOnSignInButton() {
		SignInButton.click();
	}
	public String ErrorMessageText() {
		String error = ErrorMessage.getText();
		return error;
	}
	public void Login(String email, String password) {
		EmailInputField.sendKeys(email);
		PasswordInputField.sendKeys(password);
		SignInButton.click();
	}
	public boolean Homepage() {
		boolean home = HomePage.isDisplayed();
	return home;
	}

}
