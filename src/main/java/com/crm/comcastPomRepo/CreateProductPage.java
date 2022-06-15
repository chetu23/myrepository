package com.crm.comcastPomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GeneralLibraries.WebdriverUtility;

public class CreateProductPage extends WebdriverUtility {
WebDriver driver;
	
	@FindBy(name="productname")
	private WebElement productNameTF;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement plusIcon;
	
	@FindBy(id="search_txt")
	private WebElement searchTF;
	
	@FindBy(name="search")
	private WebElement SearchButton;
	
	@FindBy(id="1")
	private WebElement clickOnVendorName;
	
	@FindBy(name="button")
	private WebElement saveButton;

	public WebElement getproductNameTF() {
		return productNameTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	public WebElement getProductNameTF() {
		return productNameTF;
	}

	public WebElement getPlusIcon() {
		return plusIcon;
	}

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchButton() {
		return SearchButton;
	}

	public WebElement getClickOnVendorName() {
		return clickOnVendorName;
	}

	public CreateProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void Createorg() {
		saveButton.click();
	}
	
	public void swtichto() {
		switchToWindow(driver, "Vendors");
	}
	
	public void Switchback() {
		switchToWindow(driver, "Products");
	}

}
