package com.automationexercise.testCases;
import com.automationexercise.pageObjects.*;

import junit.framework.Assert;

import org.testng.annotations.Test;

public class TC_InCorrectLogin_003 extends BaseClass{

	@Test
	public void inCorrectLoginTest() {
		
		LoginPage login = new LoginPage(driver);
		login.clickloginPageLink();
		logger.info("Clicked on Login link");
		
		
		if(login.verifyloginPageHeading().equals("Login to your account")) {
			Assert.assertTrue(true);
			logger.info("Login Page Test passed" + login.verifyloginPageHeading() );
		}else {
			Assert.assertTrue(false);
			logger.info("Login Page Test Failed");
		}

		login.enterloginInvalidUserEmail(invalidusername);
		logger.info("User entered invalid email" + invalidusername);
		login.enterloginInvalidUserPassword(invalidpassword);
		logger.info("User entered invalid password" + invalidpassword);
		login.clickloginPageButton();
		logger.info("Clicked on login button");
		logger.info("Incorrect Message" + " " + login.getIncorrectMessage());

	}
}
