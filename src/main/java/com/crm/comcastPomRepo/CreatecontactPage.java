package com.crm.comcastPomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatecontactPage {
 WebDriver driver;
	
	@FindBy(name="lastname")
	private WebElement lastNameTF;
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;

	public WebElement getlastNameTF() {
		return lastNameTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getContactLink() {
		return contactLink;
	}

	public CreatecontactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void Createcontact() {
		saveButton.click();
	}

}
