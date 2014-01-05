package com.acuity.guftgu.processor;

public enum Command {

    POST("posting", "posting: <user name> -> <message>"), 
    READ("reading", "reading: <user name>"), 
    FOLLOW("following", "following: <user name> follows <another user>"), 
    WALL("wall", "wall: <user name> wall");

    private String command;

    private String usage;

    Command(String command, String usage) {
        this.command = command;
        this.usage = usage;
    }

    public String getCommand() {
        return command;
    }

    public String getUsage() {
        return usage;
    }
}
