/**
 * 
 */
package com.acuity.guftgu.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author amit.verma
 *
 */
public class ReadCommandResponse implements CommandResponse{

    /**
     * 
     */
    private static final long serialVersionUID = 3845114690526066860L;
    
    private Map<String, List<String>> readResponse = new HashMap<String, List<String>>();

    
    public ReadCommandResponse(Map<String, List<String>> readResponse) {
        super();
        this.readResponse = readResponse;
    }


    @Override
    public void printResponse() {
        // TODO Auto-generated method stub
        for(String userName : readResponse.keySet()) {
            System.out.println(PROMPT + userName);
            List<String> messages = readResponse.get(userName);
            for(String message : messages) {
                System.out.println(message);
            }
        }
    }


    public Map<String, List<String>> getReadResponse() {
        return readResponse;
    }
    
    
}
