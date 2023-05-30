package com.automationexercise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	WebDriver driver;

	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/contact_us']")
	WebElement contactPageLink;

	@FindBy(xpath = "//div[@id='contact-page']/div/div/div/h2")
	WebElement contactPageHeading;

	@FindBy(xpath = "//div[@class='contact-form']/div")
	WebElement contactPageNote;

	@FindBy(xpath = "//*[@id='contact-us-form']/div[1]/input")
	WebElement contactPageName;

	@FindBy(xpath = "//*[@id='contact-us-form']/div[2]/input")
	WebElement contactPageEmail;

	@FindBy(xpath = "//*[@id='contact-us-form']/div[3]/input")
	WebElement contactPageSubject;

	@FindBy(xpath = "//*[@id='contact-us-form']/div[4]/textarea")
	WebElement contactPageMessage;

	@FindBy(xpath = "//*[@id='contact-us-form']/div[5]/input")
	WebElement contactPageFileUpload;

	@FindBy(xpath = "//*[@id='contact-us-form']/div[6]/input")
	WebElement contactPageSubmit;
	
	@FindBy(xpath = "//div[@class='status alert alert-success']")
	WebElement contactPagesuccessMessage;
	
	@FindBy(xpath = "//div[@id='form-section']")
	WebElement homeLink;

	public void clickcontactPageLink() {
		contactPageLink.click();
	}

	public String verifycontactPageHeading() {
		String contactHeading = contactPageHeading.getText();
		return contactHeading;
	}
	
	public String verifycontactPageNote() {
		String note = contactPageNote.getText();
		return note;
	}

	public void entercontactPageName(String name) {
		contactPageName.sendKeys(name);
	}

	public void entercontactPageEmail(String username) {
		contactPageEmail.sendKeys(username);
	}
	
	public void entercontactPageSubject(String subject) {
		contactPageSubject.sendKeys(subject);
	}

	public void entercontactPageMessage(String message) {
		contactPageMessage.sendKeys(message);
	}

	public void clickcontactPageFileUpload(String file) {
		contactPageFileUpload.sendKeys(file);
	}
	
	public void clickcontactPageSubmit() {
		contactPageSubmit.click();
	}
	
	public String getSuccessMessage() {
		String contactAlert = contactPagesuccessMessage.getText();
		return contactAlert;
	}
	
	public void clickHomeLink() {
		homeLink.click();
	}
}
