package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[text()='Contacts']")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//a[@href='/contacts/new']//button[@class='ui linkedin button']")
	WebElement createNewContact;

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastName;  
	
	@FindBy(xpath="//label[text()='Category']//parent::div[1]//div[@role='listbox']")
	WebElement categoryDrpDwn;

	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveBtn;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	public void createNewContact(String ftName, String ltName, String catgory) {
		

		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		
		Actions action = new Actions(driver);
		action.moveToElement(categoryDrpDwn).build().perform();
		categoryDrpDwn.click();
		driver.findElement(By.xpath("//span[text()='"+catgory+"']")).click();
		saveBtn.click();

	}

}
