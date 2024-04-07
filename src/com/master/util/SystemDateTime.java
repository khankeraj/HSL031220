package com.master.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemDateTime {
	
	public static String CurrentDateTime()throws Exception
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
	String datetime=dateFormat.format(date);
	return 	datetime;
	}
	
	
	public static String CurrentDate()throws Exception
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
	String datetime=dateFormat.format(date);
	return 	datetime;
	}
	
	
	
	
	public static String From_yyyy_mm_dd_HH_mm_ss_to_dd_mm_yyyy_HH_mm_ss(String datestring)throws Exception
	{
		     SimpleDateFormat sdfSource1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    
		     //create SimpleDateFormat object with desired date format
		     SimpleDateFormat sdfDestination1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		    
		     //parse the date into another format
		     datestring = sdfDestination1.format(sdfSource1.parse(datestring));
		    
		return datestring;
	}
	public static String From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(String datestring)throws Exception
	{
		  	 SimpleDateFormat sdfSource1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		    
		     //create SimpleDateFormat object with desired date format
		     SimpleDateFormat sdfDestination1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    
		     //parse the date into another format
		     datestring = sdfDestination1.format(sdfSource1.parse(datestring));
		    
		     return datestring;
	}

}
