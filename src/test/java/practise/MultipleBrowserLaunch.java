package practise;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleBrowserLaunch {

	public static void main(String[] args) throws Exception {
		String filePath="./CommonData/configure.properties";
		FileInputStream fis = new FileInputStream(filePath);
		Properties properties = new Properties();
		properties.load(fis);
		String browser = properties.getProperty("browser");
		WebDriver driver;
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browser.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver(); 
		}else {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}

	}

}
