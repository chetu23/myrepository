package com.crm.comcastPomRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	WebDriver driver;
	
	@FindBy(name="accountname")
	private WebElement orgNameTF;
	
	@FindBy(name="button")
	private WebElement saveButton;

	public WebElement getOrgNameTF() {
		return orgNameTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public CreateOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void Createorg() {
		saveButton.click();
	}
	

}
