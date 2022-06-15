package com.crm.comcast.contactTest;

import org.testng.annotations.Test;

import com.crm.comcastPomRepo.ContactInformationPage;
import com.crm.comcastPomRepo.ContactPage;
import com.crm.comcastPomRepo.CreatecontactPage;
import com.crm.comcastPomRepo.HomePage;

import GeneralLibraries.BaseClass;

public class DeleteContactTest extends BaseClass {
@Test(groups="smokeTest")
	public void DeleteContact() throws Throwable  {
		
 		  
 		int rn = jLib.getRandomNum();
 		
 		String cellValue = eLib.getCellValue("practise", 1, 5)+rn;
 		  		 
  		 HomePage hp=new HomePage(driver);
  		 hp.getContactLink().click();
  		 
  		 ContactPage cp=new ContactPage(driver);
  		 cp.contactImg();
  		 
  		CreatecontactPage ccp=new CreatecontactPage(driver);
  		ccp.getlastNameTF().sendKeys(cellValue);
  		ccp.Createcontact();
  		
  		ContactInformationPage cip=new ContactInformationPage(driver);
  		cip.ClickDelete();
  		
  		wLib.switchToAlertWindowAndAccept(driver, "Are you sure you want to delete this record?");
  		
  		cp.getSearchTF().sendKeys(cellValue);
  		cp.DropDown();
  		cp.getSearchButton().click();
  		
  		String actualmsg=cp.getSuccesfulmsg().getText();
  		if(actualmsg.contains("No Contact Found")) {
  			System.out.println("contact is deleted:pass");
  		}else {
  			System.out.println("contact is not deleted:fail");
  		}
  		
  		
  		}

}
/*driver.findElement(By.name("user_name")).sendKeys(username);
	 driver.findElement(By.name("user_password")).sendKeys(password);
	 driver.findElement(By.id("submitButton")).click();
	 driver.findElement(By.linkText("Contacts")).click();
	 driver.findElement(By.cssSelector("img[alt=\"Create Contact...\"]")).click();
	 driver.findElement(By.name("lastname")).sendKeys(cellValue);
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 driver.findElement(By.cssSelector("input[title=\"Delete [Alt+D]\"]")).click();
	 driver.switchTo().alert().accept();
	 
	 driver.findElement(By.name("search_text")).sendKeys(cellValue);
	 Select select=new Select(driver.findElement(By.id("bas_searchfield")));
	 select.selectByValue("lastname");
	 driver.findElement(By.name("submit")).click();
	 
	WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'No Contact Found')]"));
	
	if(ele.getText().contains("No Contact Found"))
	{
		System.out.println("contact is deleted:pass");
	}else {
		System.out.println("contact is not deleted:fail");
	}
	
WebElement element = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
 Actions action=new Actions(driver);
 action.moveToElement(element).perform();
 driver.findElement(By.linkText("Sign Out")).click();
 driver.quit();*/
