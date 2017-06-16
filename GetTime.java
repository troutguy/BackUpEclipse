package com.nerkait.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetTime {
	
	
	protected String getTime(){
		
		String timeToUse="";
		
		Calendar cal = Calendar.getInstance();
		
        //SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MMMMM_dd_HH_mm_ss");    
        
        timeToUse=sdf.format(cal.getTime());
        
        System.out.println("GetTime.getTime...new folder name is: " + timeToUse);
        
        return timeToUse;
		
	}

}
