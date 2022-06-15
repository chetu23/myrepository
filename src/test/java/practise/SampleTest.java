package practise;

import org.testng.annotations.Test;

public class SampleTest{
     @Test(priority=-1)
	public void CreateContctTest() {
	     // File file = new File("./data");
		System.out.println("contact created");
		

	}
     @Test(dependsOnMethods="CreateContctTest")
     public void ModifyContctTest() {
    		
 		System.out.println("contact modified");
 		

 	}
     
     @Test(invocationCount=3)
     public void DeleteContctTest() {
    		
 		System.out.println("contact deleted");
 		

 	}
     
     
     
}

