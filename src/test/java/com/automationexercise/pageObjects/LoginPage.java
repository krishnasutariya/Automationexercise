package com.automationexercise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='login-form']/h2")
	WebElement loginPageHeading;

	@FindBy(xpath = "//*[@class='login-form']/form/input[2]")
	WebElement loginUserEmail;

	@FindBy(xpath = "//*[@class='login-form']/form/input[3]")
	WebElement loginUserPassword;

	@FindBy(xpath = "//*[@class='login-form']/form/button")
	WebElement loginPageButton;

	@FindBy(xpath = "//div[@class='shop-menu pull-right']/ul/li[10]/a/b")
	WebElement loggedinname;

	@FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
	WebElement loginIncorrectMessage;

	@FindBy(xpath = "//a[@href='/logout']")
	WebElement logout;

	@FindBy(xpath = "//a[@href='/login']")
	WebElement loginPageLink;

	public void clickloginPageLink() {
		loginPageLink.click();
	}

	public String verifyloginPageHeading() {
		String loginheadingtext = loginPageHeading.getText();
		return loginheadingtext;
	}

	public void enterloginUserEmail(String username) {
		loginUserEmail.sendKeys(username);
	}

	public void enterloginUserPassword(String password) {
		loginUserPassword.sendKeys(password);
	}
	
	public void enterloginInvalidUserEmail(String invalidusername) {
		loginUserEmail.sendKeys(invalidusername);
	}

	public void enterloginInvalidUserPassword(String invalidpassword) {
		loginUserPassword.sendKeys(invalidpassword);
	}

	public void clickloginPageButton() {
		loginPageButton.click();
	}
	
	public String getIncorrectMessage() {
		String incorrectMessage = loginIncorrectMessage.getText();
		return incorrectMessage;
	}
	
	public void clickLogout() {
		logout.click();
	}
}
