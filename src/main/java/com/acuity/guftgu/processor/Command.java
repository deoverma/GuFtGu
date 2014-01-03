package com.acuity.guftgu.processor;

public enum Command {

    POST("posting", "posting: <text>"), 
    READ("reading", "reading: <user>"), 
    FOLLOW("following", "following: <user>"), 
    WALL("wall", "wall: <user>");

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
