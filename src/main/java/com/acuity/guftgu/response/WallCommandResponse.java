/**
 * 
 */
package com.acuity.guftgu.response;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amit.verma
 *
 */
public class WallCommandResponse implements CommandResponse {

    /**
     * 
     */
    private static final long serialVersionUID = 5426702609067894390L;
    
    List<String> wallResponses = new ArrayList<String>();
    
    /* (non-Javadoc)
     * @see com.acuity.guftgu.response.CommandResponse#printResponse()
     */
    
    @Override
    public void printResponse() {
        for(String response : wallResponses) {
            System.out.println(response);
        }
    }
    
    public WallCommandResponse(List<String> wallResponses) {
        super();
        this.wallResponses = wallResponses;
    }
    
    public List<String> getWallResponses() {
        return wallResponses;
    }

    
}
