package utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SysDate {
	public String todayDate()
	{
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis); 
	   String dateString = null;
	   SimpleDateFormat sdfr = new SimpleDateFormat("yyyy-MM-dd");
	   
	   try{
		dateString = sdfr.format( date );
	   }catch (Exception ex ){
		System.out.println(ex);
	   }
	   return dateString;
	}
	
	public static String getDateFormatAsDb(String user_date){

		String dd1="", mm="", yyyy="";
		try{
			dd1 = user_date.substring(0, 2);
			mm = user_date.substring(3, 5);
			yyyy = user_date.substring(6, 10);
		}catch(Exception ex){return null;}
		return (yyyy + "-" + mm + "-" + dd1);
	}
	
public String currentTime(){
		
		String sdft=new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		return sdft;
	}
}
