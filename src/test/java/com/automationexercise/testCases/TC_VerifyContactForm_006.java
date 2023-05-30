package com.automationexercise.testCases;
import com.automationexercise.pageObjects.*;

import junit.framework.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class TC_VerifyContactForm_006 extends BaseClass{
	
	@Test
	public void ContactPageTest() throws InterruptedException {
		ContactPage contact = new ContactPage(driver);
		contact.clickcontactPageLink();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Click on contact page link");
		
		contact.entercontactPageName(name);
		logger.info("Entered Name");
		
		contact.entercontactPageEmail(username);
		logger.info("Entered Email");
		
		contact.entercontactPageSubject(subject);
		logger.info("Entered Subject");
		
		contact.entercontactPageMessage(message);
		logger.info("Entered Message");
		
		contact.clickcontactPageFileUpload("C:\\Users\\harsh\\OneDrive\\Pictures\\Screenshots\\download.jpg");
		logger.info("File Uploaded");
		
		contact.clickcontactPageSubmit();
		logger.info("Click on contact page Submit button");
		
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert(); // switch to alert
		String alertMessage = driver.switchTo().alert().getText(); // capture alert message
		System.out.println(alertMessage); // Print Alert Message
		
		Thread.sleep(5000);
		
		alert.accept();
		
		contact.getSuccessMessage();
		logger.info("get Message" + contact.getSuccessMessage());
		
		contact.clickHomeLink();		
	}		
}
