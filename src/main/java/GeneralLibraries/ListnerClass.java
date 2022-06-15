package GeneralLibraries;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerClass implements ITestListener {

	public void onTestFailure(ITestResult result) {
		
		JavaUtility jLib= new JavaUtility();
		String testName = result.getMethod().getMethodName();
		
        EventFiringWebDriver eDriver= new EventFiringWebDriver(BaseClass.sdriver) ;
        File srcFile= eDriver.getScreenshotAs(OutputType.FILE);
        File destFile= new File("./src/test/resources/errorshots/"+testName+"_"+jLib.getSystemDate()+".png");
        try {
        	FileUtils.copyFile(srcFile, destFile);
        }catch(Exception e) {
        	e.printStackTrace();
        }
		
	}
	

}
