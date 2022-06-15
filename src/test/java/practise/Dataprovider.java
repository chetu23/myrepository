package practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {
@Test(dataProvider="bookTicketDataProvider")
	public  void bookTicket(String src,String dest,int ticket) {
		System.out.println("source is"+src+  "destination is"+dest+  "number of tickets is"+ticket);

	}


@DataProvider
public Object[][] bookTicketDataProvider(){
Object[][] objarr= new Object[1][3];
objarr[0][0]="bengaluru";
objarr[0][1]="ladakh";
objarr[0][2]=1;
return objarr;
}
}