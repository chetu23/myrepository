package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import GeneralLibraries.ExcelUtility;
import GeneralLibraries.FileUtility;
import GeneralLibraries.JavaUtility;
import GeneralLibraries.WebdriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase65 {

	public static void main(String[] args) throws Throwable {
		 FileUtility pro=new FileUtility();
		 String url= pro.getKeyAndValue("url");
		 String username=pro.getKeyAndValue("username");
		 String password= pro.getKeyAndValue("password");
		  
		JavaUtility java=new JavaUtility();
		int rn = java.getRandomNum();
		 
		 ExcelUtility excel=new ExcelUtility();
		 String cellValue = excel.getCellValue("practise", 1, 6)+ rn;
		 String cellValue1 = excel.getCellValue("practise", 1, 7);
		 String cellValue2 = excel.getCellValue("practise", 1, 8);
		 
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver= new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.get(url);
		 driver.findElement(By.name("user_name")).sendKeys(username);
		 driver.findElement(By.name("user_password")).sendKeys(password);
		 driver.findElement(By.id("submitButton")).click();
		 //adding vendor
		 WebElement element = driver.findElement(By.cssSelector("img[src='themes/softed/images/menuDnArrow.gif']"));
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
		
		 driver.findElement(By.id("search_txt")).sendKeys("tyss");
		 driver.findElement(By.name("search")).click();
		 driver.findElement(By.linkText("tyss")).click();
		 
		 WebdriverUtility wLib1=new WebdriverUtility();
		 wLib1.switchToWindow(driver, "Purchase Order");

	     driver.findElement(By.cssSelector("textarea[name=\"bill_street\"]")).sendKeys(cellValue);
		 driver.findElement(By.name("ship_street")).sendKeys(cellValue);
		 driver.findElement(By.id("searchIcon1")).click();
		 WebdriverUtility wLib11=new WebdriverUtility();
		 wLib11.switchToWindow(driver, "Products");
				
		driver.findElement(By.id("search_txt")).sendKeys(cellValue1);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("lap")).click();
				 
		 WebdriverUtility wLib111=new WebdriverUtility();
		 wLib111.switchToWindow(driver, "Purchase Order");
		 driver.findElement(By.id("qty1")).sendKeys(cellValue2);
		 driver.findElement((By.xpath("//input[@title='Save [Alt+S]']"))).click();
		 
		//adding document		 
		driver.findElement(By.linkText("More Information")).click();
		driver.findElement(By.id("show_PurchaseOrder_Documents")).click();
		driver.findElement(By.name("button")).click();
		driver.findElement(By.name("notes_title")).sendKeys(cellValue);
		
	 driver.findElement(By.id("filename_I__")).sendKeys("D:\\Java\\challan.pdf");
	 driver.findElement(By.name("button")).click();
		
		 WebElement element11 = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		 Actions actions1=new Actions(driver);
		 actions1.moveToElement(element11).perform();
		 driver.findElement(By.linkText("Sign Out")).click();
		 driver.quit();

	}
		

	}
/* WebElement button = driver.findElement(By.id("filename_I__"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", button );
		driver.findElement(By.name("button")).click();
		//Runtime.getRuntime().exec("C://autofiles/uploadfile"+" "+"D:\\Java\\labour challan.pdf");
		/*Robot rb=new Robot();
		
		StringSelection ss=new StringSelection("D:\\Java\\labour challan.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);*/
		
		
		/*String actualSucessfulmessage =driver.findElement(By.className("lvtHeaderText")).getText();
		 if(actualSucessfulmessage.contains(cellValue)) {
			 System.out.println("purchase order is created:pass");
		 }else {
			 System.out.println("purchase order is not created:fail");
		 }*/

