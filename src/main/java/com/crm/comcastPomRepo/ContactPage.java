package com.crm.comcastPomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GeneralLibraries.WebdriverUtility;

public class ContactPage extends WebdriverUtility {
WebDriver driver;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement plusIconImg;
	
	@FindBy(name="search_text")
	private WebElement SearchTF;
	
	@FindBy(name="submit")
	private WebElement SearchButton;
	
	@FindBy(xpath="//span[contains(text(),'No Contact Found')]")
	private WebElement Succesfulmsg;
	
	@FindBy(id="bas_searchfield")
	private WebElement selectdropdown;

	public WebElement getPlusIconImg() {
		return plusIconImg;
	}

	public WebElement getSearchTF() {
		return SearchTF;
	}

	public WebElement getSearchButton() {
		return SearchButton;
	}

	public WebElement getSuccesfulmsg() {
		return Succesfulmsg;
	}

	public WebElement getSelectdropdown() {
		return selectdropdown;
	}

	public  ContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	public void contactImg() {
		plusIconImg.click();
	}
	public void DropDown() {
		select(selectdropdown, "lastname");
	}

}
