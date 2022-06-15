package GeneralLibraries;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * contains all Reuasble Actions of Webdriver
 * @author chetan
 *
 */

public class WebdriverUtility {
	/**
	 * It's an implicitly wait.Always wait for Element in DOM document& relase all control if element is available
	 * 
	 */

	public void waitForElementInDom(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(IConstants.implicitlyTimeout, TimeUnit.SECONDS);
		}
	/**
	 * it's an explicit wait always wait for page to be loaded & available in GUI
	 * @param driver
	 * @param partialPageUrl
	 * 
	 */
	
	public void waitForPage(WebDriver driver,String partialPageUrl) {
		WebDriverWait wait=new WebDriverWait(driver,IConstants.explicitlyTimeout);
		wait.until(ExpectedConditions.urlContains(partialPageUrl));
		}
	/**
	 * it's an explicit wait always wait for page to be loaded & available in GUI
	 * @param driver
	 * @param element
	 */
	public void waitForElement(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,IConstants.explicitlyTimeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		}
	/**
	 * used to switch to any window based on window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWindowTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String wID=it.next();
			driver.switchTo().window(wID);
			String currentWindowTitle=driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}
/**
 * 
 * used to switch to Alert Window & click on Ok button
 * @param driver
 * @param expectedMsg
 */
public void switchToAlertWindowAndAccept(WebDriver driver,String expectedMsg) {
	Alert alert= driver.switchTo().alert();
	if(alert.getText().trim().equalsIgnoreCase(expectedMsg.trim())) {
		System.out.println("Alert Message is verfied");
	}else {
		System.out.println("Alert Message is not verified");
	}
	alert.accept();
}
/**
 * used to switch to Alert Window & click on cancel button
 * @param driver
 * @param expectedMsg
 */
public void switchToAlertWindowAndCancel(WebDriver driver,String expectedMsg) {
	Alert alert= driver.switchTo().alert();
	if(alert.getText().equals(expectedMsg)) {
		System.out.println("Alert Message is verfied");
	}else {
		System.out.println("Alert Message is not verified");
	}
	alert.dismiss();
}
/**
 * used to Switch to Frame Window based on index
 * @param driver
 * @param index
 */
public void switchToFrame(WebDriver driver,int index) {
	driver.switchTo().frame(index);
}
/**
 *  used to Switch to Frame Window based on id or name attribute
 * @param driver
 * @param id_name_attribute
 */
public void switchToFrame(WebDriver driver,String id_name_attribute) {
	driver.switchTo().frame(id_name_attribute);
}

/**
 * used to select the value from the dropDwon  based on index
 * @param driver
 * @param index
 */
public void select(WebElement element , int index) {
	Select sel = new Select(element);
	sel.selectByIndex(index);
}
/**
 * used to select the value from the dropDwon  based on value / option avlaible in GUI
 * @param element
 * @param value
 */
public void select(WebElement element , String text) {
	Select sel = new Select(element);
	sel.selectByValue(text);
}
/**
 * used to place mouse cursor on specified element
 * @param driver
 * @param elemnet
 */
public void mouseOverOnElement(WebDriver driver , WebElement elemnet)
{
	Actions act = new Actions(driver);
	act.moveToElement(elemnet).perform();
}

/**
 * 	 used to right click  on specified element

 * @param driver
 * @param elemnet
 */

public void rightClickOnElement(WebDriver driver , WebElement elemnet)
{
	Actions act = new Actions(driver);
	act.contextClick(elemnet).perform();
}

/**
 * 
 * @param driver
 * @param javaScript
 */
public void executeJavaScript(WebDriver driver , String javaScript) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript(javaScript, null);
}

   public void waitAndClick(WebElement element) throws InterruptedException
   {
	   int count = 0;
       while(count<20) {
	    	   try {
	    	       element.click();
	    	       break;
	    	   }catch(Throwable e){
	    		   Thread.sleep(1000);
	    		   count++;
	    	   }
       }
   }
   

    
    /**
     * pass enter Key appertain in to Browser
     * @param driver
     */
   public void passEnterKey(WebDriver driver) {
	   Actions act = new Actions(driver);
	   act.sendKeys(Keys.ENTER).perform();
   } 

}

