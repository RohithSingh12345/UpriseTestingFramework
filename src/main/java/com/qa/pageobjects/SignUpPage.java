package com.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	WebDriver driver;

	public SignUpPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);//intialize the elements available in this page
	}
     @FindBy(xpath="//span[text()='Sign up']")
     private WebElement SignUpButton;
     
     @FindBy(xpath = "//a[text()='Sign up']")
     private WebElement SignUpLink;
     
     @FindBy(xpath="//input[@id='name']")
     private WebElement NameInputField;
     
     @FindBy(xpath="//button[@id='downshift-0-toggle-button']")
     private WebElement CountryCodeIcon;
     
     @FindBy(xpath="//p[text()='India']")
     private WebElement CountryCodeText;
     
     @FindBy(xpath="//input[@id='phone']")
     private WebElement Phone;
     
     @FindBy(xpath = "//*[text()='+91']")
     private WebElement CountryCode;
     
    
     @FindBy(xpath= "//input[@id='accessCode']")
     private WebElement AccessCode;
     
     @FindBy(xpath= "//div[@type='error']")
     private WebElement AlreadyRegisteredEmailErrorMessage;
     //password and email from loginpage
     
     //actions
     
     public SignUpPage SignUpLink() {
    	 SignUpLink.click();
    	 return new SignUpPage(driver);
     }
     public String GetErrorMessageText() {
    	 String ErrorMessage = AlreadyRegisteredEmailErrorMessage.getText();
    	 return ErrorMessage;
     }
     
     public String GetCountryCode() {
    	String countrycode=  CountryCode.getText();
    	return countrycode;
     }
     
     public void NameInput(String name) {
    	 NameInputField.sendKeys(name);
     }
     public void SignUpButton() {
    	 SignUpButton.click();
     }
     
     public void CountryCodeIcon() {
    	 CountryCodeIcon.click();
     }
     public void CountryCodeText() {
    	 CountryCodeText.click();
     }
     public void phoneNumber(String phone) {
    	 Phone.sendKeys(phone);
     }
     public void AccessCode(String accesscode) {
    	 AccessCode.sendKeys(accesscode);
     }
     
     

}

