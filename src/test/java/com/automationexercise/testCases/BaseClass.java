package com.automationexercise.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automationexercise.utilities.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ConfigurationReader ConfigurationReader = new ConfigurationReader();

	public String baseURL = ConfigurationReader.getApplicationURL();
	public String name = ConfigurationReader.getApplicationName();
	public String username = ConfigurationReader.getApplicationUsername();
	public String password = ConfigurationReader.getApplicationPassword();
	public String invalidusername = ConfigurationReader.getApplicationOnvalidUsername();
	public String invalidpassword = ConfigurationReader.getApplicationInvalidPassword();
	public String browser = ConfigurationReader.getApplicationBrowser();
	public String subject = ConfigurationReader.getApplicationSubject();
	public String message = ConfigurationReader.getApplicationMessage();
	public String contactalertmessage = ConfigurationReader.getApplicationContactAlertMessage();
	public String productname = ConfigurationReader.getApplicationProductName();

	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(@Optional("chrome") String br) {

		logger = Logger.getLogger("eAutomation");
		String log4jConfPath = "./log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
		if (br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
            throw new IllegalArgumentException("Invalid browser name: " + br);
		}

		driver.get(baseURL);
		logger.info("URL is opened"+ baseURL);
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
