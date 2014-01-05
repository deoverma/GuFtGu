package com.acuity.guftgu.processor;

import static com.acuity.guftgu.processor.CommandFactory.getInstance;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.acuity.guftgu.entities.Person;
import com.acuity.guftgu.entities.Timeline;
import com.acuity.guftgu.entitybuilder.PersonBuilder;
import com.acuity.guftgu.entitybuilder.TimelineBuilder;
import com.acuity.guftgu.repositories.PersonRepository;
import com.acuity.guftgu.response.WallCommandResponse;

public class WallCommandProcessorTest {

    private static CommandProcessor wallCommandProcessor;
    private static PersonRepository personRepository;
    
    @BeforeClass
    public static void setUpBeforeClass() {
        wallCommandProcessor = 
                getInstance().getCommandProcessor("wall");
        
        personRepository = PersonRepository.getInstance();
    }

    @Test
    public final void wallCommandDisplaysTimelineMessage() {
        
        Timeline userATimeline1 = TimelineBuilder.build()
                .withMessage("I am happy.").aTimeline();
        Timeline userATimeline2 = TimelineBuilder.build()
                .withMessage("I am sad.").aTimeline();
        Timeline userATimeline3 = TimelineBuilder.build()
                .withMessage("I am grumpy.").aTimeline();
        Person userA = PersonBuilder.build().withName("UserA")
                .withTimeLine(userATimeline1)
                .withTimeLine(userATimeline2)
                .withTimeLine(userATimeline3)
                .aPerson();
              
        personRepository.savePerson(userA);
        
        
        WallCommandResponse response = (WallCommandResponse)
                wallCommandProcessor.processCommand("wall: UserA wall");
        
        assertTrue(response.getWallResponses().get(0).startsWith("UserA - I am happy"));
        assertTrue(response.getWallResponses().get(1).startsWith("UserA - I am sad."));
        assertTrue(response.getWallResponses().get(2).startsWith("UserA - I am grumpy."));
    }
}
