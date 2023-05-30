package com.automationexercise.testCases;
import com.automationexercise.pageObjects.*;

import junit.framework.Assert;

import org.testng.annotations.Test;

public class TC_CorrectLogin_002 extends BaseClass{

	@Test
	public void correctLoginTest() {
		
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

		login.enterloginUserEmail(username);
		logger.info("User entered email" + username);
		login.enterloginUserPassword(password);
		logger.info("User entered password" + password);
		login.clickloginPageButton();
		logger.info("Clicked on login button");
		login.clickLogout();
		logger.info("Clicked on logout button");
	}
}
