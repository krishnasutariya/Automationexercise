package com.automationexercise.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;
    private static final String PROPERTY_FILE_PATH = "./Configuration/config.properties";
    
    static {
        loadProperties();
    }

    private static void loadProperties() {
        try {
            FileInputStream input = new FileInputStream(PROPERTY_FILE_PATH);
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public String getApplicationURL() {
    	String url = properties.getProperty("baseURL");
		return url;
    }
    public String getApplicationUsername() {
    	String username = properties.getProperty("username");
		return username;
    }
    public String getApplicationPassword() {
    	String password = properties.getProperty("password");
		return password;
    }
    public String getApplicationOnvalidUsername() {
    	String invalidusername = properties.getProperty("invalidusername");
		return invalidusername;
    }
    public String getApplicationInvalidPassword() {
    	String invalidpassword = properties.getProperty("invalidpassword");
		return invalidpassword;
    }
    public String getApplicationBrowser() {
    	String browser = properties.getProperty("browser");
		return browser;
    }
    public String getApplicationName() {
    	String name = properties.getProperty("name");
		return name;
    }
    public String getApplicationSubject() {
    	String subject = properties.getProperty("subject");
		return subject;
    }
    public String getApplicationMessage() {
    	String message = properties.getProperty("message");
		return message;
    }
    public String getApplicationContactAlertMessage() {
    	String contactalertmessage = properties.getProperty("contactalertmessage");
		return contactalertmessage;
    }
    public String getApplicationProductName() {
    	String productname = properties.getProperty("productname");
		return productname;
    }
}
