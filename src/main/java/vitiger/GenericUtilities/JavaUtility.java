package vitiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This class contains all the java specific generic methods
	 * @return
	 */
		public int getRandomNumber()
		{
			Random r=new Random();
			int ran=r.nextInt(1000);
			return ran;
		}
		/**
		 * This method will generate system date and return value 
		 * @return
		 */
		public String getSystemDate()
		{
			Date date=new Date();
			String d=date.toString();
			return d;
		}
		
		public String getSystemDateInFormat()
		{
			Date d=new Date();
			String[] DArr=d.toString().split(" ");
			String date=DArr[2];
			String month=DArr[1];
			String year=DArr[5];
			String time=DArr[3].replace(":", "-");
			String currentdatetime=date+" "+month+" "+year+" "+time;
			return currentdatetime;
			
		}
	

}
