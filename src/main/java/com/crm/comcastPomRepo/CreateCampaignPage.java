package com.crm.comcastPomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GeneralLibraries.WebdriverUtility;

public class CreateCampaignPage extends WebdriverUtility{
WebDriver driver;
	
	@FindBy(name="campaignname")
	private WebElement campaignNameTF;
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement plusImg;
	
	@FindBy(id="search_txt")
	private WebElement searchTF;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	@FindBy(linkText ="lap")
	private WebElement laplink;

	public WebElement getcampaignNameTF() {
		return campaignNameTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getplusImg() {
		return plusImg;
	}
	

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getLaplink() {
		return laplink;
	}

	public CreateCampaignPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void Createorg() {
		saveButton.click();
	}
	
	public void switchto() {
		switchToWindow(driver, "Products");
	}
	public void switchback() {
		switchToWindow(driver, "Campaigns");
	}

}
