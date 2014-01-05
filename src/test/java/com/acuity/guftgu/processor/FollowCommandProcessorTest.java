package com.acuity.guftgu.processor;

import static com.acuity.guftgu.response.CommandResponse.SEPARATOR;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.acuity.guftgu.response.FollowCommandResponse;

public class FollowCommandProcessorTest {

    private static CommandProcessor commandProcessor;
    
    @BeforeClass
    public static void setUpBeforeClass() {
        commandProcessor = 
                CommandFactory.getInstance().getCommandProcessor("following");
    }

    @Test
    public final void followCommandAddsTimelineMessage() {
        FollowCommandResponse response = (FollowCommandResponse) commandProcessor.processCommand(
                "following: Alice follows Bob");
        
        assertEquals("Alice -> Bob", 
                response.getUserName() + SEPARATOR + response.getFollowing());
    }

}
