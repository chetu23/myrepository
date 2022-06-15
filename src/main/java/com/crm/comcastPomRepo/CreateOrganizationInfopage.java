package com.crm.comcastPomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationInfopage {
WebDriver driver;
	
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement sucessfulMsg;
	
	@FindBy(name="Edit")
	private WebElement editButton;
	
	public CreateOrganizationInfopage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getsucessfulMsg() {
		return sucessfulMsg;
	}

}
