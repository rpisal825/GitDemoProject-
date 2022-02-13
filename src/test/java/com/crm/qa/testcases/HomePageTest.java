package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	
	public HomePageTest() {
		super();
	}
	
//test cases should be separated- independant with each other
//before each test case----launch browser and login
//@Test----execute test cases
//after each test case execution- -browser should get closed	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		 loginPage=new LoginPage();
		 contactPage=new ContactsPage();  
		 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	
	public void verifyHomePageTitleTest() {
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"Cogmento CRM","Home page title is not matched");
		
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		contactPage=homePage.clickOnContactsLink();
		
	}
	
	
		
	@AfterMethod
	public void tearDown() {
		driver.quit();	
	}
	
}
