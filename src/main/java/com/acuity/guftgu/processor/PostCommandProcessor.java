/**
 * 
 */
package com.acuity.guftgu.processor;

import com.acuity.guftgu.entities.Person;
import com.acuity.guftgu.repositories.PersonRepository;
import com.acuity.guftgu.response.CommandResponse;
import com.acuity.guftgu.response.PostCommandResponse;

/**
 * @author amit.verma
 *
 */
public class PostCommandProcessor implements CommandProcessor {

    private PersonRepository personRepository = 
            PersonRepository.getInstance();

    /* (non-Javadoc)
     * @see com.acuity.guftgu.processor.CommandProcessor#processCommand()
     */
    @Override
    public CommandResponse processCommand(String input) {

        int indexOf = input.indexOf(":");
        int indexOfArrow = input.indexOf(">");
        String userName = input.substring(indexOf + 1, indexOfArrow - 1).trim();
        String message = input.substring(indexOfArrow + 1, input.length()).trim();
        Person person = personRepository.getPerson(userName);
        if(person == null) {
            person = new Person(userName);
            personRepository.savePerson(person);
        }

        personRepository.addTimeline(userName, message);
        CommandResponse response = new PostCommandResponse(userName, message);

         return response;
    }

}
