package com.acuity.guftgu.processor;

import static com.acuity.guftgu.processor.Command.FOLLOW;
import static com.acuity.guftgu.processor.Command.POST;
import static com.acuity.guftgu.processor.Command.READ;
import static com.acuity.guftgu.processor.Command.WALL;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author amit.verma
 * 
 */
public final class CommandFactory {

    private volatile static CommandFactory instance;

    private static Map<String, CommandProcessor> processors = new HashMap<String, CommandProcessor>();

    private CommandFactory() {

    }

    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
            processors.put(POST.getCommand(), new PostCommandProcessor());
            processors.put(READ.getCommand(), new ReadCommandProcessor());
            processors.put(FOLLOW.getCommand(),
                    new FollowCommandProcessor());
            processors.put(WALL.getCommand(), new WallCommandProcessor());

        }
        return instance;
    }

    public CommandProcessor getCommandProcessor(String command) {
        CommandProcessor commandProcessor = processors.get(command);
        if (commandProcessor == null) {
            commandProcessor = new DefaultCommandProcessor();
        }
        return commandProcessor;
    }
}
