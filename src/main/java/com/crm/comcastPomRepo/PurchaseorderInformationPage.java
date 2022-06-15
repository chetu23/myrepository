package com.crm.comcastPomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseorderInformationPage {
WebDriver driver;
	
	@FindBy(name="Delete")
	private WebElement deleteButton;
	
	@FindBy(name="Edit")
	private WebElement editButton;
	
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement sucessfulMsg;

	public WebElement getdeleteButton() {
		return deleteButton;
	}

	public WebElement getSaveButton() {
		return editButton;
	}
	
	public PurchaseorderInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void ClickDelete() {
		deleteButton.click();
	}
	
	public void ClickEdit() {
		deleteButton.click();
	}
	
	public WebElement getsucessfulMsg() {
		return sucessfulMsg;
	}


}
