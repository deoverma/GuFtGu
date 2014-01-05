/**
 * 
 */
package com.acuity.guftgu.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

/**
 * @author amit.verma
 *
 */
public final class DateTimeUtils {

    public static String getTimeDifference(Calendar updateTime) {
        String timeDiff = "( ";
        
        Calendar now = new GregorianCalendar();
        
        long difference = now.getTimeInMillis() - updateTime.getTimeInMillis();
        
        long timeSeconds = TimeUnit.MILLISECONDS.toSeconds(difference);
        if(timeSeconds < 60) {
            timeDiff += timeSeconds + " seconds ago )";
        }else if((timeSeconds > 60 && timeSeconds < 3600)) {
            timeDiff += (timeSeconds / 60) + " minutes ago )";
        }else if((timeSeconds > 3600 )) {
            timeDiff += (timeSeconds /3600) + " hours ago )";
        }
        return timeDiff;
        
    }
}
