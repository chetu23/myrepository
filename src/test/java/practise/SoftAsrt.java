package practise;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAsrt {

	
		@Test
			public  void createcontact() {
				System.out.println("12");
			SoftAssert soft = new SoftAssert();
				soft.assertEquals("a", "b");
				
				System.out.println("23");
				soft.assertAll();

			}
		@Test
		public  void deletecontact() {
			System.out.println("12");
			System.out.println("23");
			
			

		}

}

