package com.master.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CoreData {

	public static String getDateFormatAsDb(String user_date){

		String dd1="", mm="", yyyy="";
		try{
			dd1 = user_date.substring(0, 2);
			mm = user_date.substring(3, 5);
			yyyy = user_date.substring(6, 10);
		}catch(Exception ex){return null;}
		return (yyyy + "-" + mm + "-" + dd1);
	}
	public static String getDateFormatAsUser(String user_date){

		String dd1="", mm="", yyyy="";
		try{
		yyyy = user_date.substring(0, 4);
		mm = user_date.substring(5, 7);
		dd1 = user_date.substring(8, 10);
		}catch(Exception ex){return null;}
		return (dd1 + "/" + mm + "/" + yyyy);
	}
	public static String getMonthFromUserDate(String user_date){

		String dd1="", mm="", yyyy="";
		try{
			dd1 = user_date.substring(0, 2);
			mm = user_date.substring(3, 5);
			yyyy = user_date.substring(6, 10);
		}catch(Exception ex){return null;}
		return  mm;
	}
	public static String getYeanFromUserDate(String user_date){

		String dd1="", mm="", yyyy="";
		try{
			dd1 = user_date.substring(0, 2);
			mm = user_date.substring(3, 5);
			yyyy = user_date.substring(6, 10);
		}catch(Exception ex){return null;}
		return  yyyy;
	}
	//sanjeev
	public static String displayDateFrmDbUserFormat(String db_date){
		String dd="", mm="", yy="";
		try {
			 yy=db_date.substring(0, 4);
			 mm=db_date.substring(5, 7);
			 dd=db_date.substring(8, 10);
			//String user_date=dd+"/"+mm+"/"+yy;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return (dd+"/"+mm+"/"+yy);
	}
	
	public static String getCurrentTime() {
		   
		String tt="";
		
		try{
		Calendar cal = Calendar.getInstance();
	   
	    Date date=cal.getTime();
	    
	    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	   
	    String formattedDate=dateFormat.format(date);
	   
	    tt=formattedDate;
		}
		catch(Exception e){
			
			
		}
	   // System.out.println("Current time of the day using Calendar - 24 hour format: "+ formattedDate);
		
	    
	    return tt;
	}
	
	
	public static void main(String[] args) {

	}
}

