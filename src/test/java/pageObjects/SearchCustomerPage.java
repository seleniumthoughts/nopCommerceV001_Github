package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import utilities.WaitHelper;

public class SearchCustomerPage {

	public WebDriver driver;
	 WaitHelper waithelper;

	public SearchCustomerPage(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(driver, this);
		waithelper=new WaitHelper(driver);
	}
	
	@FindBy(how=How.ID,using="SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how=How.ID,using="SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	@FindBy(how=How.ID,using="SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how=How.ID,using="SearchMonthOfBirth")
	@CacheLookup
	WebElement drpdobMonth;
	
	@FindBy(how=How.ID,using="SearchDayOfBirth")
	@CacheLookup
	WebElement drpdobDay;
	
	@FindBy(how=How.ID,using="SearchCompany")
	@CacheLookup
	WebElement txtCompany;
	

	
	
	
	@FindBy(how=How.ID,using="search-customers")
	@CacheLookup
	WebElement txtSearchCustomersbtnSearch;
	
	@FindBy(how=How.XPATH,using="//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResults;
	
	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;
	
	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumns;
	
	public void setEmail(String email)
	{
		waithelper.WaitForElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	public void setFirstName(String fName)
	{
		waithelper.WaitForElement(txtFirstName, 30);
		txtFirstName.clear();
		txtFirstName.sendKeys(fName);
	}
	public void setLastName(String lName)
	{
		waithelper.WaitForElement(txtLastName, 30);
		txtLastName.clear();
		txtLastName.sendKeys(lName);
	}
	public void clickSearch()
	{
		waithelper.WaitForElement(txtSearchCustomersbtnSearch, 30);
		txtSearchCustomersbtnSearch.click();
		
	}
	public int getNoOfRows()
	{
		return tableRows.size();
	}
	public int getNoOfColumns()
	{
		return tableColumns.size();
	}
	public boolean searchCustomerByEmail(String email)
	{
		boolean flag=false;
		for(int i=1;i<=getNoOfRows();i++)
		{
			String emailId=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailId);
			if(emailId.equals(email))
			{
				flag=true;
			}
		}
		return flag;
	}
	
	public boolean searchCustomerByName(String Cname)
	{
		boolean flag=false;
		for(int i=1;i<=getNoOfRows();i++)
		{
			String name=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
		     String names[]=name.split(" ");
		     
		     //String names1[]=Cname.split(" ");
		     // System.out.println(names1[0]+" "+names1[1]);
		     //System.out.println(names[0]+" "+names[1]);
			if(names[0].equals("Victoria")&&names[1].equals("Terces"))
			{
				flag=true;
			}
		}
		return flag;
	}
	
	
	
	
	
	
	
}
