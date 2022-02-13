package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetName="contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority=1)
	public void verifyContactPageLabel() {

		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts label is missing on page");

	}
	@DataProvider
	public Object[][] getCRMTestData() {
	Object data[][]=TestUtil.getTestData(sheetName);
	return data;
	}
	
//data is passed from test cases ie hard coded value	
//	@Test(priority=2)
//	public void validateCreateNewContact(){
//		homePage.clickOnNewContactLink();
//		contactsPage.createNewContact("Ram","Cena","Affiliate");
//		
//	}	

	//data is passed from excel
	@Test(priority=2, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstname,String lastname,String category){
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(firstname, lastname, category);
	}	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}