package GeneralLibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.comcastPomRepo.HomePage;
import com.crm.comcastPomRepo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public FileUtility fLib=new FileUtility();
	public WebdriverUtility wLib=new WebdriverUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups= {"smokeTest","RegressionTest"})
	public void bs() {
		System.out.println("database connection");
	}
	
	@BeforeTest(groups= {"smokeTest","RegressionTest"})
	public void bt() {
		System.out.println("execute script in parallel mode");
	}
	
	@BeforeClass(groups= {"smokeTest","RegressionTest"})
	public void bc() throws Throwable {
		 String browser = fLib.getKeyAndValue("browser");
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
	 String url = fLib.getKeyAndValue("url");
	 driver.manage().window().maximize();
	 wLib.waitForElementInDom(driver);
	 driver.get(url);
	 sdriver = driver;
}
	
	@BeforeMethod(groups= {"smokeTest","RegressionTest"})
	public void bm() throws Throwable {
		 String username= fLib.getKeyAndValue("username");
		 String password= fLib.getKeyAndValue("password");
		 LoginPage lp= new LoginPage(driver);
		 lp.loginToApp(username, password);
	}
	@AfterMethod(groups= {"smokeTest","RegressionTest"})
	public void am() {
		 HomePage hp=new HomePage(driver);
		 hp.Logout();
	}
	@AfterClass(groups= {"smokeTest","RegressionTest"})
	public void ac() {
		driver.quit();
	}
	@AfterTest(groups= {"smokeTest","RegressionTest"})
	public void at() {
		System.out.println("parallel execution is completed");
	}
	@AfterSuite(groups= {"smokeTest","RegressionTest"})
	public void as() {
		System.out.println("close the database connection");
	}
	
}