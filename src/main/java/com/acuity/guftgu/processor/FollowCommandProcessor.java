package com.acuity.guftgu.processor;

public class FollowCommandProcessor implements CommandProcessor {

    @Override
    public void processCommand(String inputs) {
        System.out.println("Command sent is " + Command.FOLLOW.getCommand());

    }

}
