package com.acuity.guftgu.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acuity.guftgu.entities.Person;
import com.acuity.guftgu.entities.Timeline;
import com.acuity.guftgu.repositories.PersonRepository;
import com.acuity.guftgu.response.CommandResponse;
import com.acuity.guftgu.response.ReadCommandResponse;
import com.acuity.guftgu.utils.DateTimeUtils;

public class ReadCommandProcessor implements CommandProcessor {

    private PersonRepository personRepository = 
            PersonRepository.getInstance();

    @Override
    public CommandResponse processCommand(String input) {
        int indexOf = input.indexOf(":");
        String userName = input.substring(indexOf + 1, input.length()).trim();
        Person person = personRepository.getPerson(userName);
        Map<String, List<String>> responses = new HashMap<String, List<String>>();
        List<String> messages = new ArrayList<String>();
        
        if(person != null) {
            for(Person following : person.getFollowings()) {
                messages = new ArrayList<String>();
                Person followingPerson = personRepository.getPerson(following.getName());
                for(Timeline followingTimeline : followingPerson.getTimelines()) {
                    messages.add(followingTimeline.getMessage() 
                            + DateTimeUtils.getTimeDifference(
                                    followingTimeline.getTime()));
                }       
                responses.put(following.getName(), messages);
            }
            
            messages = new ArrayList<String>();
            for(Timeline userTimeline : person.getTimelines()) {
                messages.add(userTimeline.getMessage() + DateTimeUtils.getTimeDifference(
                        userTimeline.getTime()) );
            }            
            responses.put(person.getName(), messages);
        }
        CommandResponse response = new ReadCommandResponse(responses);

        return response;
    }

}
