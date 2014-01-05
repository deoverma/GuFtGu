/**
 * 
 */
package com.acuity.guftgu.response;


/**
 * @author amit.verma
 *
 */
public class FollowCommandResponse implements CommandResponse {

    /**
     * 
     */
    private static final long serialVersionUID = 478479080868701838L;

    private String userName;
    
    private String following;
    
    
    public FollowCommandResponse(String userName, String follower) {
        super();
        this.userName = userName;
        this.following = follower;
    }

    /* (non-Javadoc)
     * @see com.acuity.guftgu.response.CommandResponse#printResponse()
     */
    @Override
    public void printResponse() {

        System.out.println(userName  + " is now following " + following);
    }

    public String getUserName() {
        return userName;
    }
    
    public String getFollowing() {
        return following;
    }
    
    

}
