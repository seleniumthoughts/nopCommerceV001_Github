package stepDefinitions;

//import org.apache.logging.log4j.*;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;




public class Steps extends BaseClass{
	
	private static Logger logger=LogManager.getLogger(BaseClass.class);
	@Before
	public void setUp() throws Exception
	{
		//logger=Logger.getLogger("nopCommerce");
		//PropertyConfigurator.configure("Log4j.properties");
		//Reading Properties file
		prop=new Properties();
		FileInputStream fs=new FileInputStream("config.properties");
		prop.load(fs);
		String browser=prop.getProperty("browser");
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
			   driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxpath"));
			   driver=new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", prop.getProperty("edgepath"));
			   driver=new EdgeDriver();
		}
		
		
		
		 logger.info("-----Launching URL-----");
       
	  
	}
	

	
	//login.feature-------------
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {

		
	  lp=new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		logger.info("-----Opening URL-----");
	    driver.get(url);
	    driver.manage().window().maximize();
	}

	@When("User Enters Email as {string} and Password as {string}")
	public void user_Enters_Email_as_and_Password_as(String email, String password) {
		logger.info("-----Providing Login Details-----");
	  lp.setUserName(email);
	  lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_Login() throws Exception {
	   lp.clickLogin();
	   Thread.sleep(3000);
		logger.info("-----Opening URL-----");
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) {
	    if(driver.getPageSource().contains("Login was unsuccessful."))
	    {
	    	logger.info("-----logIn Passed-----");
	    	driver.close();
	    	Assert.assertTrue(false);
	    }
	    else
	    {
	    	logger.info("-----logIn Failed-----");
	    	Assert.assertEquals(title, driver.getTitle());
	    }
	}

	@When("User click on Log out Link")
	public void user_click_on_Log_out_Link() throws Exception {
		logger.info("-----Click on Logout Link-----");
	   lp.lnkLogout();
	   Thread.sleep(3000);
	}


	@Then("Close browser")
	public void close_browser() {
		logger.info("-----Closing Browser -----");
	   driver.close();
	}
	
	//customer.feature---------------------------------------
	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() {
	   addCust=new AddCustomerPage(driver);
	   Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
	}

	@When("User Click on customers Menu")
	public void user_Click_on_customers_Menu() throws InterruptedException {
		Thread.sleep(3000);
	   addCust.clickOnCustomers_menu();
	}

	@When("Click on customers Menu Item")
	public void click_on_customers_Menu_Item() throws InterruptedException {
		Thread.sleep(2000);
	   addCust.clickOnlnkCustomers_menuItem();
	}

	@When("Click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException {
	  addCust.clickOnAddNew();
		Thread.sleep(2000);
	}

	@Then("User can view Add New Cuctomer Page")
	public void user_can_view_Add_New_Cuctomer_Page() {
	  Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User enter Customer info")
	public void user_enter_Customer_info() throws InterruptedException {
		logger.info("-----Adding New Customer-----");
		logger.info("-----Providing Customer Details-----");
	   String email=randomString()+"@gmail.com";
	   addCust.enterEmail(email);
	   addCust.enterPassword("abcd");
	   addCust.enterFirstname("Anil");
	   addCust.enterLastname("Patil");
	   addCust.selectGender("Male");
	   addCust.txtDateOfBirth("7/05/1988"); //Format- D/MM/YYYY
	   addCust.enterCompanyName("bustQA");
	   addCust.enterAdminContent("This is for testing.......");
	   addCust.enterMOfVender("Vendor 2");
	 
	   Thread.sleep(3000);
	   addCust.enterNewsLetter("Test store 2");
	   //Registered -Default
	   //The Customer cannot be in both "Guests" and "Registered" customer roles
	   //Add customer to "Guests" or "Registered" customer role
	   addCust.setCustomerRole("Guests");
	 
	}

	@When("click on Save button")
	public void click_on_Save_button() throws InterruptedException {
		logger.info("-----Saving Customer Data-----");
	    addCust.clickOnSave();
	    Thread.sleep(2000);
	}

	@Then("User can view confirm message {string}")
	public void user_can_view_confirm_message(String msg) {
	    
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains(msg));
	}
// Search Customer By Email--------------
	@When("Enter Customer Email")
	public void enter_Customer_Email() {
		searchCustomer=new SearchCustomerPage(driver);
		searchCustomer.setEmail("victoria_victoria@nopCommerce.com");
		
	}

	@When("User Click on Search button")
	public void user_Click_on_Search_button() throws InterruptedException {
		searchCustomer.clickSearch();
		Thread.sleep(3000);
	}

	@Then("User Should found Email in the Search Table")
	public void user_Should_found_Email_in_the_Search_Table() {
		logger.info("-----Searching Customer By Email ID-----");
		boolean status=searchCustomer.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}

	// Search By First Name&Last Name---------------------------
	@When("Enter Customer FirstName")
	public void enter_Customer_FirstName() {
		logger.info("-----Searching Customer By Name-----");
		searchCustomer=new SearchCustomerPage(driver);
		searchCustomer.setFirstName("Victoria");
	}

	@When("Enter Customer LastName")
	public void enter_Customer_LastName() {
		searchCustomer.setLastName("Terces");
	}

	@Then("User Should found Name in the Search Table")
	public void user_Should_found_Name_in_the_Search_Table() {
		boolean status=searchCustomer.searchCustomerByName("victoria Terces");
		Assert.assertEquals(true, status);
	}



}
