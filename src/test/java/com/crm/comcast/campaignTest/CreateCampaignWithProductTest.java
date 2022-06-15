package com.crm.comcast.campaignTest;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.comcastPomRepo.CampaignPage;
import com.crm.comcastPomRepo.CreateCampaignInfoPage;
import com.crm.comcastPomRepo.CreateCampaignPage;
import com.crm.comcastPomRepo.HomePage;

import GeneralLibraries.BaseClass;

public class CreateCampaignWithProductTest extends BaseClass {
	@Parameters("browser")
     @Test(groups="RegressionTest")
	public  void CreateCampaignProduct(@Optional("firefox") String browser) throws Throwable {
		
		 
		int rn = jLib.getRandomNum();
		
		String cellValue = eLib.getCellValue("practise", 1, 5)+rn;
		String cellValue1 = eLib.getCellValue("practise", 1, 7);
		 
		
		 HomePage hp=new HomePage(driver);
		 hp.moreLink();
		 hp.getCampaignLink().click();
		 
		 CampaignPage cp=new CampaignPage(driver);
		 cp.campaignImg();
		 
		 CreateCampaignPage ccp=new CreateCampaignPage(driver);
		 ccp.getcampaignNameTF().sendKeys(cellValue);
		 ccp.getplusImg().click();
		 ccp.switchto();
		 ccp.getSearchTF().sendKeys(cellValue1);
		 ccp.getSearchButton().click();
		 ccp.getLaplink().click();
		 ccp.switchback();
		 ccp.getSaveButton().click();
		 
		 CreateCampaignInfoPage ccip=new CreateCampaignInfoPage(driver);
		 
		 String actualSucessfulmessage =ccip.getsucessfulMsg().getText();
		 Assert.assertEquals(actualSucessfulmessage.contains(cellValue), true);
		 /*if(actualSucessfulmessage.contains(cellValue)) {
			 System.out.println("campaign is created:pass");
		 }else {
			 System.out.println("campaign is not created:fail");
		 }*/
		
		// TODO Auto-generated method stub

	}

}
/*driver.findElement(By.name("user_name")).sendKeys(username);
driver.findElement(By.name("user_password")).sendKeys(password);
driver.findElement(By.id("submitButton")).click();
//adding product
driver.findElement(By.linkText("Products")).click();
driver.findElement(By.cssSelector("img[src=\"themes/softed/images/btnL3Add.gif\"]")).click();
driver.findElement(By.name("productname")).sendKeys(cellValue);
driver.findElement((By.xpath("//input[@title='Save [Alt+S]']"))).click();

//navigating to campaign
WebElement element = driver.findElement(By.cssSelector("img[src='themes/softed/images/menuDnArrow.gif']"));
Actions action=new Actions(driver);
action.moveToElement(element).perform();
driver.findElement(By.linkText("Campaigns")).click();
driver.findElement(By.cssSelector("img[src=\"themes/softed/images/btnL3Add.gif\"]")).click();
driver.findElement(By.name("campaignname")).sendKeys(cellValue);
driver.findElement(By.cssSelector("img[language=\"javascript\"]")).click();
Set<String> handles = driver.getWindowHandles();
Iterator<String> ids = handles.iterator();
String parentid = ids.next();
String childid=ids.next();
driver.switchTo().window(childid);

driver.findElement(By.id("search_txt")).sendKeys(cellValue1);
driver.findElement(By.name("search")).click();
driver.findElement(By.linkText("lap")).click();
driver.switchTo().window(parentid);

driver.findElement((By.xpath("//input[@title='Save [Alt+S]']"))).click();*/
