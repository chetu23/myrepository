package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger {

	public static void main(String[] args) throws IOException {
		String filepath="./commonData/configure.properties";
		FileInputStream fis=new FileInputStream(filepath);
		 Properties properties= new Properties();
		 properties.load(fis);
		 String url= properties.getProperty("url");
		 String username= properties.getProperty("username");
		 String password= properties.getProperty("password");
		  
		 Random random=new Random();
		IntStream rn = random.ints(1000);
		 
		 
		 String filePaths="./Excelutil/Fileforpractise.xlsx";
		 FileInputStream fis1 = new FileInputStream(filePaths);
		 Workbook workbook = WorkbookFactory.create(fis1);
		 String cellValue = workbook.getSheet("practise").getRow(1).getCell(5).toString()+rn;
		 
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver= new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.get(url);
		 driver.findElement(By.name("user_name")).sendKeys(username);
		 driver.findElement(By.name("user_password")).sendKeys(password);
		 driver.findElement(By.id("submitButton")).click();
		 driver.findElement(By.linkText("Organizations")).click();
		 driver.findElement(By.linkText("Organization Name")).click();
		 driver.findElement(By.cssSelector("img[title=\"Create Organization...\"]")).click();
		 driver.findElement(By.name("accountname")).sendKeys("cellValue");
		 driver.findElement(By.name("button")).click();
		 driver.findElement(By.cssSelector("img[title=\"Create Organization...\"]")).click();
		 driver.findElement(By.name("accountname")).sendKeys(cellValue);
		 String actualSucessfulmessage =driver.findElement(By.className("dvHeaderText")).getText();
		 if(actualSucessfulmessage.contains(cellValue)) {
			 System.out.println("organization is created:pass");
		 }else {
			 System.out.println("organization is not created:fail");
		 }
		 WebElement element = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		 Actions action=new Actions(driver);
		 action.moveToElement(element).perform();
		 driver.findElement(By.linkText("Sign Out")).click();
		 driver.quit();

	}

}
