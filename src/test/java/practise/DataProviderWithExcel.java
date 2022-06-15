package practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GeneralLibraries.ExcelUtility;

public class DataProviderWithExcel {
	public class Dataprovider {
		@Test(dataProvider="bookTicketDataProvider")
			public  void bookTicket(String src,String dest,String ticket) {
				System.out.println("source is"+src+  "destination is"+dest+  "number of tickets is"+ticket);

			}


		@DataProvider
		public Object[][] bookTicketDataProvider() throws Throwable  {
			ExcelUtility eLib= new ExcelUtility();
			String src=eLib.getCellValue("practise", 1, 1);
			String dest=eLib.getCellValue("practise", 1, 2);
			String ticket=eLib.getCellValue("practise", 1, 8);
			
		Object[][] objarr= new Object[1][3];
		objarr[0][0]=src;
		objarr[0][1]=dest;
		objarr[0][2]=ticket;
		return objarr;
		}
		}

}
