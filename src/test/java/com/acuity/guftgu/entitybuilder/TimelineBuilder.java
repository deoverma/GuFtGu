/**
 * 
 */
package com.acuity.guftgu.entitybuilder;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.acuity.guftgu.entities.Timeline;

/**
 * @author amit.verma
 *
 */
public class TimelineBuilder {

    private String message = "Hello";
    
    private Calendar time = new GregorianCalendar();
    
    private TimelineBuilder() {
        
    }
    
    public static TimelineBuilder build() {
        return new TimelineBuilder();
    }
    
    public TimelineBuilder withMessage(String message) {
        this.message = message;
        return this;
    }
    
    public TimelineBuilder withTime(Calendar time) {
        this.time = time;
        return this;
    }
    
    public Timeline aTimeline() {
        return new Timeline(message, time);
    }
}
