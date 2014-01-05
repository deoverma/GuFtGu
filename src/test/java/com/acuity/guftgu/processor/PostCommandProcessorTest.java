package com.acuity.guftgu.processor;

import static com.acuity.guftgu.response.CommandResponse.SEPARATOR;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.acuity.guftgu.response.PostCommandResponse;

public class PostCommandProcessorTest {

    private static CommandProcessor commandProcessor;
    
    @BeforeClass
    public static void setUpBeforeClass() {
        commandProcessor = 
                CommandFactory.getInstance().getCommandProcessor("posting");
    }

    @Test
    public final void postCommandAddsTimelineMessage() {
        PostCommandResponse response = (PostCommandResponse) commandProcessor.processCommand(
                "posting: Alice -> I love the weather today");
        
        assertEquals("Alice -> I love the weather today", 
                response.getUserName() + SEPARATOR + response.getMessage());
    }
    

}
