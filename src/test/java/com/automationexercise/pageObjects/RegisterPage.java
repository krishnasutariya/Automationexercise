package com.automationexercise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/login']")
	WebElement signupPageLink;
	
	@FindBy(xpath = "//div[@class='signup-form']/h2")
	WebElement signupPageHeading;
	
	@FindBy(xpath = "//div[@class='signup-form']/form/input[2]")
	WebElement signupPageName;
	
	@FindBy(xpath = "//div[@class='signup-form']/form/input[3]")
	WebElement signupPageEmail;
	
	@FindBy(xpath = "//div[@class='signup-form']/form/button")
	WebElement signupButton;
	
	@FindBy(xpath = "//p[contains(text(),'Email Address already exist!')]")
	WebElement errorMessage;
	
	public void clickSignUpPageLink() {
		signupPageLink.click();
	}

	public String verifySignupPageHeading() {
		String signupHeading = signupPageHeading.getText();
		return signupHeading;
	}

	public void enterSignupName(String name) {
		signupPageName.sendKeys(name);
	}

	public void enterSignupEmail(String username) {
		signupPageEmail.sendKeys(username);
	}
	
	public void clickSignUpPageButton() {
		signupButton.click();
	}
	
	public String getIncorrectMessage() {
		String incorrectMessage = errorMessage.getText();
		return incorrectMessage;
	}
}
