package com.acuity.guftgu.processor;

import java.util.ArrayList;
import java.util.List;

import com.acuity.guftgu.entities.Person;
import com.acuity.guftgu.entities.Timeline;
import com.acuity.guftgu.repositories.PersonRepository;
import com.acuity.guftgu.response.CommandResponse;
import com.acuity.guftgu.response.WallCommandResponse;
import com.acuity.guftgu.utils.DateTimeUtils;

public class WallCommandProcessor implements CommandProcessor {

    private PersonRepository personRepository = 
            PersonRepository.getInstance();

    @Override
    public CommandResponse processCommand(String input) {
        int indexOf = input.indexOf(":");
        int indexOfWall = input.lastIndexOf("wall");
        String userName = input.substring(indexOf + 1, indexOfWall).trim();
        Person person = personRepository.getPerson(userName);
        List<String> responses = new ArrayList<String>();

        if(person != null) {
            if (person.getFollowings() != null) {
                for (Person following : person.getFollowings()) {
                    Person followingPerson = 
                            personRepository.getPerson(following.getName());
                    for (Timeline followingTimeline : followingPerson.getTimelines()) {
                        responses.add(following.getName() + " - " + 
                                followingTimeline.getMessage()  + DateTimeUtils.getTimeDifference(
                                        followingTimeline.getTime()));
                    }
                }
            }
    
            for (Timeline userTimeline : person.getTimelines()) {
                responses.add(person.getName() + " - " + userTimeline.getMessage()
                        + DateTimeUtils.getTimeDifference(
                                userTimeline.getTime()));
            }
        }
        CommandResponse response = new WallCommandResponse(responses);
        
        return response;
    }

}
