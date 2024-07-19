package Generic_Utility;

import java.util.Date;
import java.util.Random;

public class Java_Utility {
	
	public int getRannum() {
		/** This method is used remove duplicates
		 * @return
		 * @author Dell
		 */
		Random ran = new Random();
		int rannum = ran.nextInt(1000);
		return rannum;
			
	}

/**
 * This method is used to get system date and time 
 * @return
 * @author Dell
 */

public  String getsystemdateandtime() {
	
	Date date = new Date();
	String dateandtime = date.toString();
	System.out.println(dateandtime);
	return dateandtime;
}
	/** This method is used to get system date and time with format
	 * 
	 * @return
	 * @author Dell
	 */
	public String getsystemdateandtimeformate() {
		Date date = new Date();
		String dateandtime = date.toString();
		System.out.println(dateandtime);
		String yyyy = dateandtime.split(" ")[5];
		String dd = dateandtime.split(" ")[2];
		int mm = date.getMonth();
		
		String finalformat = yyyy+("-")+mm+("-")+dd;
		System.out.println(finalformat);
		
		return finalformat;
		
	}
	
	
	
	

}
