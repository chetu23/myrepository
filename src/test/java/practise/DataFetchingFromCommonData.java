package practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataFetchingFromCommonData {

	public static void main(String[] args) throws IOException   {
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver= new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 String filePath="./CommonData/configure.properties";
		 FileInputStream fis= new FileInputStream(filePath);
		 Properties properties= new Properties();
		 properties.load(fis);
		 String browser= properties.getProperty("browser");
		 String url= properties.getProperty("url");
		 String username= properties.getProperty("username");
		 String password= properties.getProperty("password");
		 System.out.println(browser);
		 System.out.println(url);
		 System.out.println(username);
		 System.out.println(password);
		 driver.get(url);
		 driver.findElement(By.name("user_name")).sendKeys(username);
		 driver.findElement(By.name("user_password")).sendKeys(password);
		 driver.findElement(By.id("submitButton")).click();
		 driver.quit();
		 
	}

}
