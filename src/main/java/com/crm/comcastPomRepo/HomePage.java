package com.crm.comcastPomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GeneralLibraries.WebdriverUtility;

public class HomePage extends WebdriverUtility{
	
	
   WebDriver driver;
   
	@FindBy(linkText="Campaigns")
	private WebElement CampaignLink;
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactLink;
	 
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;
	
	@FindBy(linkText="More")
	private WebElement MoreLink;
	
	@FindBy(linkText="Purchase Order")
	private WebElement PurchaseOrderLink;
	

	@FindBy(linkText="Vendors")
	private WebElement VendorLink;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement administrationImg;
	

	public WebElement getCampaignLink() {
		return CampaignLink;
	}

	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}

	public WebElement getContactLink() {
		return ContactLink;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}

	public WebElement getMoreLink() {
		return MoreLink;
	}

	public WebElement getPurchaseOrderLink() {
		return PurchaseOrderLink;
	}

	public WebElement getVendorLink() {
		return VendorLink;
	}
	
	public WebElement getAdministrationImg() {
		return administrationImg;
	}
	
	public WebElement getproductLink() {
		return productLink;
	}
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		}
	
	 public void Logout() {
		 mouseOverOnElement(driver, administrationImg);
		 SignOutLink.click(); 
		 
	 }
	 
	 public void moreLink() {
		 mouseOverOnElement(driver, MoreLink);
	 }
	
	

}
