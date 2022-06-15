package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.comcastPomRepo.CreatePurchaseOrder;
import com.crm.comcastPomRepo.HomePage;
import com.crm.comcastPomRepo.LoginPage;
import com.crm.comcastPomRepo.ProductPage;
import com.crm.comcastPomRepo.PurchaseorderInformationPage;
import com.crm.comcastPomRepo.PurchaseorderPage;

import GeneralLibraries.ExcelUtility;
import GeneralLibraries.FileUtility;
import GeneralLibraries.JavaUtility;
import GeneralLibraries.WebdriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase48 {

	public static void main(String[] args) throws Throwable {
		 FileUtility pro=new FileUtility();
		 String url= pro.getKeyAndValue("url");
		 String username=pro.getKeyAndValue("username");
		 String password= pro.getKeyAndValue("password");
		 
		 JavaUtility java=new JavaUtility();
		  int rn = java.getRandomNum();
		 
		 ExcelUtility excel=new ExcelUtility();
		 String cellValue = excel.getCellValue("practise", 1, 6)+ rn;
		 String cellvalue1=excel.getCellValue("practise", 1, 10);
	
		 
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver= new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.get(url);
		 
		 LoginPage lp=new LoginPage(driver);
		 lp.loginToApp(username, password);
		 
		 HomePage hp=new HomePage(driver);
		 hp.moreLink();
		 hp.getPurchaseOrderLink().click();
		 
		 PurchaseorderPage pop=new PurchaseorderPage(driver);
		 pop.organizationImg();
		 
		 CreatePurchaseOrder cpo=new CreatePurchaseOrder(driver);
		 cpo.getsubjectTF().sendKeys(cellValue);
		 cpo.getplusiconimg().click();
		 cpo.swtichto();
		 cpo.getSearchTF().sendKeys(cellvalue1);
		 cpo.getSearchButton().click();
		 cpo.getClickOnVendorName().click();
		 cpo.Switchback();
		 cpo.getsubjectTF().sendKeys(cellValue);
		 cpo.getRadioButton().click();
		 cpo.getProductImg().click();
		 cpo.Switchbackto();
		 cpo.getSearchTF().sendKeys(cellValue);
		 cpo.getSearchButton().click();
		 cpo.Switchback();
		 cpo.getQtyTF().sendKeys(cellvalue1);
		 cpo.ClickSave();
		
		 PurchaseorderInformationPage pip=new PurchaseorderInformationPage(driver);
		 
		 String actualSucessfulmessage =pip.getsucessfulMsg().getText();
		 if(actualSucessfulmessage.contains(cellValue)) {
			 System.out.println("purchase order is created:pass");
		 }else {
			 System.out.println("purchase order is not created:fail");
		 }
		hp.Logout();
		 driver.quit();

	}

}
//adding vendor
/*WebElement element = driver.findElement(By.cssSelector("img[src='themes/softed/images/menuDnArrow.gif']"));
Actions action=new Actions(driver);
action.moveToElement(element).perform();
driver.findElement(By.linkText("Vendors")).click();
driver.findElement(By.cssSelector("img[src=\"themes/softed/images/btnL3Add.gif\"]")).click();
driver.findElement(By.name("vendorname")).sendKeys(cellValue);
driver.findElement(By.cssSelector("input[title=\"Save [Alt+S]\"]")).click();

//navigating to purchase order
WebElement element1 = driver.findElement(By.cssSelector("img[src='themes/softed/images/menuDnArrow.gif']"));
Actions actions=new Actions(driver);
actions.moveToElement(element1).perform();
driver.findElement(By.linkText("Purchase Order")).click();
driver.findElement(By.cssSelector("img[src=\"themes/softed/images/btnL3Add.gif\"]")).click();
driver.findElement(By.name("subject")).sendKeys(cellValue);//need to change in excel

driver.findElement(By.xpath("//input[@name=\"vendor_name\"]//..//..//td[2]")).click();

WebdriverUtility wLib=new WebdriverUtility();
wLib.switchToWindow(driver, "Vendors");

driver.findElement(By.id("search_txt")).sendKeys(cellvalue1);
driver.findElement(By.name("search")).click();
driver.findElement(By.linkText("tyss")).click();

WebdriverUtility wLib1=new WebdriverUtility();
	wLib1.switchToWindow(driver, "Purchase Order");

	 driver.findElement(By.cssSelector("textarea[name=\"bill_street\"]")).sendKeys(cellValue);
	 driver.findElement(By.name("ship_street")).sendKeys(cellValue);
	 driver.findElement(By.id("searchIcon1")).click();
	 WebdriverUtility wLib11=new WebdriverUtility();
		wLib11.switchToWindow(driver, "Products");
		
		 driver.findElement(By.id("search_txt")).sendKeys("lap");
		 driver.findElement(By.name("search")).click();
		 driver.findElement(By.linkText("lap")).click();
		 
		 WebdriverUtility wLib111=new WebdriverUtility();
			wLib111.switchToWindow(driver, "Purchase Order");
			driver.findElement(By.id("qty1")).sendKeys("20");
		

driver.findElement((By.xpath("//input[@title='Save [Alt+S]']"))).click();*/
