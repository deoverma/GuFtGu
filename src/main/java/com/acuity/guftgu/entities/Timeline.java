/**
 * 
 */
package com.acuity.guftgu.entities;

import java.io.Serializable;
import java.util.Calendar;

/**
 * @author amit.verma
 *
 */
public class Timeline implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 4862150277684294260L;

    private String message;
    
    private Calendar time;
    
    public Timeline(String message, Calendar time) {
        super();
        this.message = message;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }
    
}
