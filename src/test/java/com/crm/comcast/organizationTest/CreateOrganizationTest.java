package com.crm.comcast.organizationTest;

import org.testng.annotations.Test;

import com.crm.comcastPomRepo.CreateOrganizationInfopage;
import com.crm.comcastPomRepo.CreateOrganizationPage;
import com.crm.comcastPomRepo.HomePage;
import com.crm.comcastPomRepo.OrganizationPage;

import GeneralLibraries.BaseClass;

public class CreateOrganizationTest extends BaseClass {
     @Test(groups="RegressionTest")
	public  void CreateOrganization() throws Throwable {
		
		  
		int rn = jLib.getRandomNum();
		
		String cellValue = eLib.getCellValue("practise", 1, 5)+rn;
		 
		
		 
		 HomePage hp=new HomePage(driver);
		 hp.getOrganizationLink().click();
		 
		 OrganizationPage op=new OrganizationPage(driver);
		 op.organizationImg();
		 
		 CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		 cop.getOrgNameTF().sendKeys(cellValue);
		 cop.Createorg();
				 
		 CreateOrganizationInfopage coip=new CreateOrganizationInfopage(driver);
		 String actualSucessfulmessage =coip.getsucessfulMsg().getText();
		 if(actualSucessfulmessage.contains(cellValue)) {
			 System.out.println("organization is created:pass");
		 }else {
			 System.out.println("organization is not created:fail");
		 }
		
		

	}

}
/*driver.findElement(By.name("user_name")).sendKeys(username);
driver.findElement(By.name("user_password")).sendKeys(password);
driver.findElement(By.id("submitButton")).click();
driver.findElement(By.linkText("Organizations")).click();
driver.findElement(By.cssSelector("img[title=\"Create Organization...\"]")).click();
driver.findElement(By.name("accountname")).sendKeys(cellValue);
driver.findElement((By.xpath("//input[@title='Save [Alt+S]']"))).click();*/
