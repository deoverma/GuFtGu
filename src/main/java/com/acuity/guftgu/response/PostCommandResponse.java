package com.acuity.guftgu.response;

public class PostCommandResponse implements CommandResponse {

    /**
     * 
     */
    private static final long serialVersionUID = -2351617573836524896L;

    private String userName;
    
    private String message;
    
    
    public PostCommandResponse(String userName, String message) {
        super();
        this.userName = userName;
        this.message = message;
    }


    @Override
    public void printResponse() {
        System.out.println(PROMPT + userName + SEPARATOR + message);
    }


    public String getUserName() {
        return userName;
    }


    public String getMessage() {
        return message;
    }

    
}
