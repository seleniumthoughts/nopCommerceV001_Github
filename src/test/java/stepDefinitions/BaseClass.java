package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import org.apache.log4j.PropertyConfigurator;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCust;
	public SearchCustomerPage searchCustomer;
   // public static Logger logger;// log4j.properties file logger
	public Properties prop;
	
	
	
	
	//This method is to generate Random string for Unique Email
	public static String randomString()
	{
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return generatedString1;
	}
}
