package com.automationexercise.testCases;
import com.automationexercise.pageObjects.*;

import junit.framework.Assert;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class TC_RegisterUser_011 extends BaseClass{

	@Test
	public void registerExistingUserTest() {
		
		RegisterPage register = new RegisterPage(driver);
		register.clickSignUpPageLink();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Clicked on Signup link");

		
		logger.info("Verify Signup Page heading!!" + " " + register.verifySignupPageHeading());

		register.enterSignupName(name);
		logger.info("Entered name" + " " + name);
		
		register.enterSignupEmail(username);
		logger.info("Entered email" + " " + username);
		
		register.clickSignUpPageButton();
		logger.info("Clicked on signup button");
		
		logger.info("Incorrect Message" + " " + register.getIncorrectMessage());
		

	}
}
