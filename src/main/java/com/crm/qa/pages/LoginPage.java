package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory ---- OR:
	
	@FindBy(xpath=".//span[text()='Log In']")
	WebElement loginBtnMain;
	
	@FindBy(name="email")
	WebElement name;
	
	@FindBy(name="password")
	WebElement pwd;
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath=".//span[text()=' sign up']")
	WebElement signUp;
	
	
	//Initializing page object
	//created constructor of LoginPage
	//this is pointing current class ie Loginpage
	//So using PageFactory.initElements, we are initilize the all variable
	
	public LoginPage() {
		
	PageFactory.initElements(driver,this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
		
	}
	public HomePage login(String un,String passwd) {
	loginBtnMain.click();	
	name.sendKeys(un);
	pwd.sendKeys(passwd);
	loginBtn.click();
	return new HomePage();

	}
}
