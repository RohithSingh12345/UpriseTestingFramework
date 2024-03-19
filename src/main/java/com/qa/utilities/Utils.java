package com.qa.utilities;

import java.util.Date;

public class Utils {
	public static final int Implicit_Wait =10; 
	public static final int PageLoad_Timeout =5;
	
	
	public static String generateEmailWithTimestamp() {
		Date date = new Date();
		String timeStamp= date.toString().replace(" ", "_").replace(":", "_");
		String emailWithTimestamp ="Rohith"+timeStamp+"@yopmail.com";
		return emailWithTimestamp;
	}

	
	
}
