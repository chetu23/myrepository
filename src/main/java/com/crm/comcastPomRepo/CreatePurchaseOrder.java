package com.crm.comcastPomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GeneralLibraries.WebdriverUtility;

public class CreatePurchaseOrder extends WebdriverUtility {
WebDriver driver;
	
	@FindBy(name="subject")
	private WebElement subjectTF;
	
	@FindBy(xpath="//input[@name=\\\"vendor_name\\\"]//..//..//td[2]")
	private WebElement plusiconimg;
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	@FindBy(id="search_txt")
	private WebElement searchTF;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	@FindBy(id="1")
	private WebElement clickOnVendorName;
	
	@FindBy(name="bill_street")
	private WebElement BillingTF;
	
	@FindBy(name="cpy")
	private WebElement RadioButton;
	
	@FindBy(id="searchIcon1")
	private WebElement productImg;
	
	@FindBy(id="qty1")
	private WebElement QtyTF;
	
	@FindBy(id="popup_product_16")
	private WebElement productLink;

	public WebElement getsubjectTF() {
		return subjectTF;
	}

	public WebElement getplusiconimg() {
		return plusiconimg;
	}
	
	public WebElement getsaveButton() {
		return saveButton;
	}
	
	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getClickOnVendorName() {
		return clickOnVendorName;
	}

	public WebElement getBillingTF() {
		return BillingTF;
	}

	public WebElement getRadioButton() {
		return RadioButton;
	}

	public WebElement getProductImg() {
		return productImg;
	}

	public WebElement getQtyTF() {
		return QtyTF;
	}

	public WebElement getProductLink() {
		return productLink;
	}

    public CreatePurchaseOrder(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	
	public WebElement getSubjectTF() {
		return subjectTF;
	}

	public void ClickSave() {
		saveButton.click();
	}
	
	public void swtichto() {
		switchToWindow(driver, "Vendors");
	}
	
	public void Switchback() {
		switchToWindow(driver, "Purchase Order");
	}
    
	public void Switchbackto() {
		switchToWindow(driver, "Products");
	}

}
