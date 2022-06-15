package com.crm.comcastPomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	@FindBy(name="user_name")
	private WebElement UserNameTF;
	
	@FindBy(name="user_password")
	private WebElement PasswordTF;
	
	@FindBy(id="submitButton")
	private WebElement Button;

	
	

	public WebElement getUserNameTF() {
		return UserNameTF;
	}

	public WebElement getPasswordTF() {
		return PasswordTF;
	}

	public WebElement getButton() {
		return Button;
	}
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	public void loginToApp(String username,String password) {
		UserNameTF.sendKeys(username);
		PasswordTF.sendKeys(password);
		Button.click();
		
	}
	
	
	

}
