package com.acuity.guftgu.processor;

public class WallCommandProcessor implements CommandProcessor {


    @Override
    public void processCommand(String inputs) {
        System.out.println("Command sent is " + Command.WALL.getCommand());
    }

}
