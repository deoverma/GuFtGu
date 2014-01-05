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
import com.acuity.guftgu.response.ReadCommandResponse;

public class ReadCommandProcessorTest {

    private static CommandProcessor readCommandProcessor;
    private static PersonRepository personRepository;
    
    @BeforeClass
    public static void setUpBeforeClass() {
        readCommandProcessor = 
                getInstance().getCommandProcessor("reading");
        
        personRepository = PersonRepository.getInstance();
    }

    @Test
    public final void readCommandDisplaysTimelineMessage() {
        
        Timeline userATimeline = TimelineBuilder.build()
                .withMessage("I am happy.").aTimeline();
        Person userA = PersonBuilder.build().withName("UserA")
                .withTimeLine(userATimeline).aPerson();

        
        Timeline userBTimeline = TimelineBuilder.build()
                .withMessage("I am sad.").aTimeline();
        Person userB = PersonBuilder.build()
                .withName("UserB")
                .withFollower(userA)
                .withTimeLine(userBTimeline).aPerson();
        
        userA.getFollowings().add(userB);
        
        personRepository.savePerson(userB);
        personRepository.savePerson(userA);
        
        
        ReadCommandResponse response = (ReadCommandResponse)
                readCommandProcessor.processCommand("reading: UserA");
        
        assertTrue(response.getReadResponse().containsKey("UserA"));
        assertTrue(response.getReadResponse().containsKey("UserB"));        
    }

}
