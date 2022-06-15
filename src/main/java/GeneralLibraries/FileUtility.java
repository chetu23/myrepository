package GeneralLibraries;

import java.io.FileInputStream;
/**
 * This method is used to get the data from property file
 * @author chetan
 */


import java.util.Properties;

public class FileUtility {

	public String getKeyAndValue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream(IConstants.commonPath);
		Properties property= new Properties();
		property.load(fis);
		String value = property.getProperty(key);
		return value;
		
		
	}

}
