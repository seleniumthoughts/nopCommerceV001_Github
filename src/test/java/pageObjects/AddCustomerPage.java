package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	public WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	
	By lnkCustomers_menu=By.xpath("//ul/li/a[@href='#'] //p[contains(text(),'Customers')]");
	By lnkCustomers_menuItem=By.xpath("//a[@href='/Admin/Customer/List']");
	By btnAddNeww=By.xpath("//a[@class='btn btn-primary']");
	By txtEmail=By.id("Email");
	By txtPassword=By.id("Password");
	By txtFirstname=By.id("FirstName");
	By txtLastname=By.id("LastName");
	By txtMGender=By.id("Gender_Male");
	By txtFGender=By.id("Gender_Female");
	By txtDateOfBirth=By.id("DateOfBirth");
	By txtCompanyname=By.id("Company");

	By txtNewsLetter=By.xpath("//*[@id='SelectedNewsletterSubscriptionStoreIds']");
//	By txtYourStoreName=By.xpath("//ul[@class='k-list k-reset']/li[contains(text(),'Your store name')]");
//	By txtTestStore=By.xpath("//ul[@class='k-list k-reset']/li[contains(text(),'Test store 2')");
	By txtCustomerRole=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	
	By txtAdministrator=By.xpath("//li[contains(text(),'Administrators')]");
	By txtGuest=By.xpath("//li[contains(text(),'Guests')]");
	By txtRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By txtVendors=By.xpath("//li[contains(text(),'Vendors')]");
	By txtMOfVender=By.xpath("//*[@id='VendorId']");
	By txtAdminContent=By.id("AdminComment");
	By btnSave=By.xpath("//button[@name='save']");
	
	// User method to get Title of the Page
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}
	public void clickOnCustomers_menu()
	{
		ldriver.findElement(lnkCustomers_menu).click();;
	}
	public void clickOnlnkCustomers_menuItem()
	{
		ldriver.findElement(lnkCustomers_menuItem).click();
	}
	public void clickOnAddNew()
	{
		ldriver.findElement(btnAddNeww).click();
	}
	public void enterEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	public void enterPassword(String pwd)
	{
		ldriver.findElement(txtPassword).sendKeys(pwd);
	}
	public void enterFirstname(String fname)
	{
		ldriver.findElement(txtFirstname).sendKeys(fname);
	}
	
	public void enterLastname(String lname)
	{
		ldriver.findElement(txtLastname).sendKeys(lname);
	}
	
	public void selectGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(txtMGender).click();
		}
		else if(gender.equals("Female"))
		{
			ldriver.findElement(txtFGender).click();
		}
		else
		{
			ldriver.findElement(txtMGender).click();
		}
	}
	
	public void txtDateOfBirth(String dob)
	{
		ldriver.findElement(txtDateOfBirth).sendKeys(dob);
	}
	
	public void enterCompanyName(String cname)
	{
		ldriver.findElement(txtCompanyname).sendKeys(cname);
	}

	public void setCustomerRole(String role) throws InterruptedException
	{
		ldriver.findElement(txtVendors).sendKeys(role);;
		//WebElement listitem=null;
//		if(!role.equals("Vendors"))
//		{
//			ldriver.findElement(By.xpath("//span[@class='k-icon.k-i-close']")).click();
//		}
//		ldriver.findElement(txtCustomerRole).sendKeys(role);
//		
//		Thread.sleep(3000);
//		if(role.equals("Administrators"))
//		{
//			listitem=ldriver.findElement(txtAdministrator);
//		}
//		else if(role.equals("Registered"))
//		{
//			listitem=ldriver.findElement(txtRegistered);
//		}
//		else if(role.equals("Guests"))
//		{
//			listitem=ldriver.findElement(txtGuest);
//		}
//		else if(role.equals("Vendors"))
//		{
//			listitem=ldriver.findElement(txtVendors);
//		}
//		else
//		{
//			listitem=ldriver.findElement(txtGuest);
//		}
//		//listitem.click();
//		JavascriptExecutor js=(JavascriptExecutor)ldriver;
//		js.executeScript("arguments[0].click();", listitem);
//		
	}
	
	
	public void enterMOfVender(String vendor)
    {
//		Select drp=new Select(ldriver.findElement(txtMOfVender));	
//		drp.deselectByVisibleText(vendor);
		ldriver.findElement(txtMOfVender).sendKeys(vendor);
	}
	public void enterNewsLetter(String newsLetter)
    {
//		Select drp=new Select(ldriver.findElement(txtNewsLetter));	
//		drp.deselectByVisibleText(newsLetter);
		ldriver.findElement(txtNewsLetter).sendKeys(newsLetter);
	}
	public void enterAdminContent(String aContent)
	{
		ldriver.findElement(txtAdminContent).sendKeys(aContent);
	}
	public void clickOnSave()
	{
		ldriver.findElement(btnSave).click();
	}
}
