package com.crm.comcast.contactTest;

import org.testng.annotations.Test;

import com.crm.comcastPomRepo.ContactInformationPage;
import com.crm.comcastPomRepo.ContactPage;
import com.crm.comcastPomRepo.CreatecontactPage;
import com.crm.comcastPomRepo.HomePage;

import GeneralLibraries.BaseClass;

public class CreateContactTest extends BaseClass{
	
		@Test(groups="smokeTest")
         public  void CreateContact() throws Throwable {
        	
     		  
     		int rn = jLib.getRandomNum();
     		
     		String cellValue = eLib.getCellValue("practise", 1, 5)+rn;
     		
            HomePage hp= new HomePage(driver);
            hp.getContactLink().click();
            
            ContactPage cp=new ContactPage(driver);
            cp.contactImg();
            
            CreatecontactPage ccp=new CreatecontactPage(driver);
            ccp.getlastNameTF().sendKeys(cellValue);
            ccp.Createcontact();
             
            ContactInformationPage cip= new ContactInformationPage(driver);
            
            String actualSucessfulmessage =cip.getsucessfulMsg().getText();
   		    if(actualSucessfulmessage.contains(cellValue)) {
   			   System.out.println("contact Last Name is Created:pass");
   		   }  else {
   			 System.out.println("contact Last Name is not Created:fail");
   		      }
            
   		  
     		 		
	}

}
/* driver.findElement(By.name("user_name")).sendKeys(username);
 driver.findElement(By.name("user_password")).sendKeys(password);
 driver.findElement(By.id("submitButton")).click();
 driver.findElement(By.linkText("Contacts")).click();
 driver.findElement(By.cssSelector("img[alt=\"Create Contact...\"]")).click();
 driver.findElement(By.name("lastname")).sendKeys(cellValue);
 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
String actualSucessfulmessage =driver.findElement(By.className("dvHeaderText")).getText();
if(actualSucessfulmessage.contains(cellValue)) {
	 System.out.println("contact Last Name is Created:pass");
}else {
	 System.out.println("contact Last Name is not Created:fail");
}
WebElement element = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
Actions action=new Actions(driver);
action.moveToElement(element).perform();
driver.findElement(By.linkText("Sign Out")).click();
driver.quit();*/
