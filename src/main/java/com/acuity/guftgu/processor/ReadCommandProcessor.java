package com.acuity.guftgu.processor;

public class ReadCommandProcessor implements CommandProcessor {

    @Override
    public void processCommand(String inputs) {
        System.out.println("Command sent is " + Command.READ.getCommand());
    }

}
