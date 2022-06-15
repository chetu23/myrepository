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

public class CreateCampaignTest extends BaseClass{
	@Parameters("browser")
     @Test(groups="smokeTest")
	public void createCamp(@Optional("firefox") String browser) throws Throwable {
		
		
         int rn = jLib.getRandomNum();
		String cellValue = eLib.getCellValue("practise", 1, 5)+rn;
		 
		 HomePage hp=new HomePage(driver);
		 hp.moreLink();
		 hp.getCampaignLink().click();
		 
		 CampaignPage cp=new CampaignPage(driver);
		 cp.campaignImg();
		 
		 CreateCampaignPage ccp=new CreateCampaignPage(driver);
		 ccp.getcampaignNameTF().sendKeys(cellValue);
		 ccp.Createorg();
		 
		 CreateCampaignInfoPage ccip=new CreateCampaignInfoPage(driver);
		 String actualSucessfulmessage =ccip.getsucessfulMsg().getText();
		 Assert.assertEquals(actualSucessfulmessage.contains(cellValue), true);
		/* if(actualSucessfulmessage.contains(cellValue)) {
			 System.out.println("campaign is created:pass");
		 }else {
			 System.out.println("campaign is not created:fail");
		 }*/
	}
}
		
		

	
	
	


/*driver.findElement(By.name("user_name")).sendKeys(username);
driver.findElement(By.name("user_password")).sendKeys(password);
driver.findElement(By.id("submitButton")).click();

WebElement element = driver.findElement(By.cssSelector("img[src='themes/softed/images/menuDnArrow.gif']"));
Actions action=new Actions(driver);
action.moveToElement(element).perform();
driver.findElement(By.linkText("Campaigns")).click();

driver.findElement(By.cssSelector("img[src=\"themes/softed/images/btnL3Add.gif\"]")).click();
driver.findElement(By.name("campaignname")).sendKeys(cellValue);
driver.findElement((By.xpath("//input[@title='Save [Alt+S]']"))).click();*/
/*FileUtility fLib=new FileUtility();
JavaUtility jLib=new JavaUtility();
WebdriverUtility wLib=new WebdriverUtility();
ExcelUtility eLib=new ExcelUtility();

 String url = fLib.getKeyAndValue("url");
 String username= fLib.getKeyAndValue("username");
 String password= fLib.getKeyAndValue("password");
  
int rn = jLib.getRandomNum();

String cellValue = eLib.getCellValue("pratise", 1, 5)+rn;
 
 WebDriverManager.chromedriver().setup();
 WebDriver driver= new ChromeDriver();
 driver.manage().window().maximize();
 wLib.waitForElementInDom(driver);
 driver.get(url);*/
 
/* LoginPage lp= new LoginPage(driver);
 lp.loginToApp(username, password);*/