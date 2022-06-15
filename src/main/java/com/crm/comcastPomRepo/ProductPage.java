package com.crm.comcastPomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
WebDriver driver;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement plusIconImg;

	public WebElement getPlusIconImg() {
		return plusIconImg;
	}

	public  ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	public void productImg() {
		plusIconImg.click();
	}

}
