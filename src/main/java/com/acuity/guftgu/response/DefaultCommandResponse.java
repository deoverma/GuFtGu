package com.acuity.guftgu.response;

import com.acuity.guftgu.processor.Command;

public class DefaultCommandResponse implements CommandResponse {

    /**
     * 
     */
    private static final long serialVersionUID = -3463701687612375475L;

    @Override
    public void printResponse() {
        System.out.println(
                "Little help; please use one of the following commands !!");
        for (Command command : Command.values()) {
            System.out.println(command.getUsage());
        }

    }

}
