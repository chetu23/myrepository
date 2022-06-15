package GeneralLibraries;

import java.util.Date;
import java.util.Random;
/**
 * @author chetan
 *This method is used to get unique number 
 */

public class JavaUtility {

	
		public int getRandomNum() {
			Random random = new Random();
			int ranNum = random.nextInt(1000);
			return ranNum;
		}
		
		/**
		 *  its used to get the current system date based on YYYY-MM-DD formate
		 * @return
		 */
		public String  getSystemDate() {
			Date date = new Date();
			String currentDate = date.toString();
			System.out.println(currentDate);
			String[] arr = currentDate.split(" ");
			
			String yyyy = arr[5];
			String dd = arr[2];
			int mm = date.getMonth()+1;
		
				String formate = yyyy+"-"+mm+"-"+dd;
				return formate;
		}
		/**
		 *  its used to get the current system date based on DD-MM-YYYY format 
		 * @return
		 */
		public String  getSystemDateInIST() {
			Date date = new Date();
			String currentDate = date.toString();
			System.out.println(currentDate);
			String[] arr = currentDate.split(" ");
			
			String yyyy = arr[5];
			String dd = arr[2];
			int mm = date.getMonth()+1;
		
				String formate = dd+"-"+mm+"-"+yyyy;
				return formate;
		}
		


	}

	


