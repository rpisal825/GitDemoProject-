package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	// Page Factory ---- OR:

	@FindBy(xpath = "//span[contains(text(),'Rohit Pisal')]")
	WebElement userNameLable;

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//div[3]/button/i[@class='plus inverted icon']")
	WebElement newContactLink;

	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement tasksLink;

	// Initializing page object
	// created constructor of HomePage
	// this is pointing current class ie HomePage
	// So using PageFactory.initElements, we are initilize the all variable

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyCorrectUserName() {
		return userNameLable.isDisplayed();

	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();

	}

	public DealsPage clickOnDealssLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTaskssLink() {
		tasksLink.click();
		return new TasksPage();
	}

}
