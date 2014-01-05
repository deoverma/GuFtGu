package com.acuity.guftgu.processor;

import com.acuity.guftgu.repositories.PersonRepository;
import com.acuity.guftgu.response.CommandResponse;
import com.acuity.guftgu.response.FollowCommandResponse;

public class FollowCommandProcessor implements CommandProcessor {

    private PersonRepository personRepository = 
            PersonRepository.getInstance();

    @Override
    public CommandResponse processCommand(String input) {
        int indexOf = input.indexOf(":");
        int indexOfFollows= input.indexOf("follows");
        String user = input.substring(indexOf + 1, indexOfFollows ).trim();
        String following = input.substring(indexOfFollows + "follows".length()
                , input.length()).trim();
        personRepository.addFollowings(user, following);
        CommandResponse response = new FollowCommandResponse(user, following);

        return response;
    }

}
