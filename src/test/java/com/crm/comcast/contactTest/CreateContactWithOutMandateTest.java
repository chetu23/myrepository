package com.crm.comcast.contactTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcastPomRepo.ContactPage;
import com.crm.comcastPomRepo.CreatecontactPage;
import com.crm.comcastPomRepo.HomePage;

import GeneralLibraries.BaseClass;

@Listeners(GeneralLibraries.ListnerClass.class)
public class CreateContactWithOutMandateTest extends BaseClass {
	
	@Test(groups="smokeTest")
    public  void CreateContact() throws Throwable {
   	
		  
		//int rn = jLib.getRandomNum();
		
       HomePage hp= new HomePage(driver);
       hp.getContactLink().click();
       
       ContactPage cp=new ContactPage(driver);
       cp.contactImg();
       Assert.fail();
       CreatecontactPage ccp=new CreatecontactPage(driver);
       ccp.Createcontact();
       
       wLib.switchToAlertWindowAndAccept(driver, "Last Name cannot be empty");
      
       
      /* String actualSucessfulmessage =ccp.getContactLink().getText();
		    if(actualSucessfulmessage.contains("contact")) {
			   System.out.println("contact Last Name is Created:fail");
		   }  else {
			 System.out.println("contact Last Name is not Created:pass");
		      }*/	 		
	}
}
